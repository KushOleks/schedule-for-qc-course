import { test, expect } from '@playwright/test';

test.describe('Schedule page', () => {
  test('schedule page is displayed', async ({ page }) => {
    await page.goto('/schedule?semester=1');

    await expect(page).toHaveURL(/schedule/);
    await expect(page.getByRole('link', { name: 'Login' })).toBeVisible();
  });

  test('schedule page has main elements', async ({ page }) => {
    await page.goto('/schedule?semester=1');

    await expect(page.getByRole('link', { name: 'Login' })).toBeVisible();
    await expect(page.locator('body')).toBeVisible();
  });
});