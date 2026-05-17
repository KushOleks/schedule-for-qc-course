import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { GroupPage } from '../pages/GroupPage';
import {
  createGroupInDb,
  findGroupByName,
  updateGroupTitle,
  deleteGroupByName,
  closeDb,
} from '../helpers/database';

function getBrowserCode(browserName) {
  return {
    chromium: '1',
    firefox: '2',
    webkit: '3',
  }[browserName] || '9';
}

test.describe('Group UI', () => {
  test.afterAll(async () => {
    await closeDb();
  });

  test('open groups page from admin menu', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const groupPage = new GroupPage(page);

    await loginPage.loginAsManager();
    await groupPage.openGroupsPage();

    await expect(page.getByRole('textbox', { name: 'Group:' })).toBeVisible();
  });

  test('create group', async ({ page, browserName }) => {
    const loginPage = new LoginPage(page);
    const groupPage = new GroupPage(page);

    const browserCode = getBrowserCode(browserName);
    const groupName = `${browserCode}${Date.now().toString().slice(-3)}`;

    await loginPage.loginAsManager();
    await groupPage.openGroupsPage();
    await groupPage.createGroup(groupName);

    await expect(page.getByRole('textbox', { name: 'Group:' })).toHaveValue('');
  });

  test('edit first group name', async ({ page, browserName }) => {
    const loginPage = new LoginPage(page);
    const groupPage = new GroupPage(page);

    const browserCode = getBrowserCode(browserName);
    const newGroupName = `${browserCode}${Date.now().toString().slice(-3)}`;

    await loginPage.loginAsManager();
    await groupPage.openGroupsPage();
    await groupPage.openFirstGroupForEdit();
    await groupPage.renameGroup(newGroupName);

    await expect(page.getByText(newGroupName)).toBeVisible();
  });

  test('add student to first group', async ({ page, browserName }) => {
    const loginPage = new LoginPage(page);
    const groupPage = new GroupPage(page);
    
    const browserCode = getBrowserCode(browserName);
    const unique = `${browserCode}${Date.now()}`;

    await loginPage.loginAsManager();
    await groupPage.openGroupsPage();
    await groupPage.openFirstGroupForEdit();

    await groupPage.addStudent({
      surname: `alex${unique}`,
      name: `alex${unique}`,
      patronymic: 'test',
      email: `test${unique}@chnu.edu.ua`,
    });

    await expect(groupPage.closeButton).toBeVisible();
  });

  test('group form validation - empty group name', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const groupPage = new GroupPage(page);

    await loginPage.loginAsManager();
    await groupPage.openGroupsPage();

    await expect(page.getByRole('button', { name: 'Save' })).toBeDisabled();
  });

  test('database can save test group', async ({ browserName }) => {
    test.skip(browserName !== 'chromium', 'DB checks are executed only once in chromium');

    const groupName = `DB${Date.now()}`;

    const createdGroup = await createGroupInDb(groupName);
    const groupFromDb = await findGroupByName(groupName);

    expect(createdGroup).toBeDefined();
    expect(createdGroup.title).toBe(groupName);

    expect(groupFromDb).toBeDefined();
    expect(groupFromDb.title).toBe(groupName);

    await deleteGroupByName(groupName);
  });

  test('database can update test group', async ({ browserName }) => {
    test.skip(browserName !== 'chromium', 'DB checks are executed only once in chromium');

    const oldGroupName = `DB${Date.now()}`;
    const newGroupName = `DBU${Date.now()}`;

    await createGroupInDb(oldGroupName);

    const updatedGroup = await updateGroupTitle(oldGroupName, newGroupName);
    const groupFromDb = await findGroupByName(newGroupName);

    expect(updatedGroup).toBeDefined();
    expect(updatedGroup.title).toBe(newGroupName);

    expect(groupFromDb).toBeDefined();
    expect(groupFromDb.title).toBe(newGroupName);

    await deleteGroupByName(newGroupName);
  });
});