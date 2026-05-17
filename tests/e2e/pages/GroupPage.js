import { expect } from '@playwright/test';

export class GroupPage {
  constructor(page) {
    this.page = page;

    this.userMenuButton = page.getByRole('button', { name: 'manager@gmail.com' });
    this.adminLink = page.getByRole('link', { name: 'Admin' });
    this.moreButton = page.getByRole('button', { name: 'More' });
    this.groupsOption = page.getByRole('option', { name: 'Groups' });

    this.groupNameInput = page.getByRole('textbox', { name: 'Group:' });

    this.groupSaveButton = page.locator(
      'xpath=//*[@id="root"]/div/div[2]/div[1]/aside/div[2]/form/div[3]/button[1]'
    );

    this.saveButton = page.getByRole('button', { name: 'Save' });

    this.addStudentLink = page.getByRole('link', { name: 'Add student' }).first();
    this.surnameInput = page.getByRole('textbox', { name: 'Surname' });
    this.studentNameInput = page.getByRole('textbox', { name: 'Name', exact: true });
    this.patronymicInput = page.getByRole('textbox', { name: 'Patronymic' });
    this.studentEmailInput = page.getByRole('textbox', { name: 'Email' });

    this.closeButton = page.getByRole('button', { name: 'Close' });
  }

  async openGroupsPage() {
    await this.userMenuButton.click();
    await this.adminLink.click();
    await this.moreButton.click();
    await this.groupsOption.click();
  }

  async createGroup(name) {
    await this.groupNameInput.click();

    await this.groupNameInput.pressSequentially(name, {
      delay: 100,
    });

    await expect(this.groupSaveButton).toBeEnabled();
    await this.groupSaveButton.click();
  }

  async openFirstGroupForEdit() {
    await this.page.getByRole('img', { name: 'Edit' }).first().click();
  }

  async renameGroup(newName) {
    await this.groupNameInput.click();
    await this.groupNameInput.fill(newName);
    await this.saveButton.click();
  }

  async addStudent({ surname, name, patronymic, email }) {
    await this.addStudentLink.click();
    await this.surnameInput.fill(surname);
    await this.studentNameInput.fill(name);
    await this.patronymicInput.fill(patronymic);
    await this.studentEmailInput.fill(email);
    await this.saveButton.click();
  }
}