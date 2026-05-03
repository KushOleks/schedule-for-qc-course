import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';

test('successful login as manager', async ({ page }) => {
  const loginPage = new LoginPage(page);

  await loginPage.open();
  await loginPage.login('manager@gmail.com', 'Qwerty!123');

  await expect(page).not.toHaveURL(/\/login$/);
});

test('failed login with invalid password', async ({ page }) => {
  const loginPage = new LoginPage(page);

  await loginPage.open();
  await loginPage.login('manager@gmail.com', 'WrongPassword123');

  await expect(page).toHaveURL(/\/login$/);
  await expect(page.getByRole('button', { name: 'Login' })).toBeVisible();
});