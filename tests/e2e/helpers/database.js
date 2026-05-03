import pg from 'pg';

const { Pool } = pg;

export const pool = new Pool({
  connectionString:
    process.env.DATABASE_URL || 'postgresql://postgres:postgres@localhost:5433/appdb',
});

export async function createGroupInDb(title) {
  const result = await pool.query(
    'INSERT INTO groups (title, disable) VALUES ($1, false) RETURNING id, title',
    [title]
  );

  return result.rows[0];
}

export async function findGroupByName(title) {
  const result = await pool.query(
    'SELECT id, title FROM groups WHERE title = $1',
    [title]
  );

  return result.rows[0];
}

export async function updateGroupTitle(oldTitle, newTitle) {
  const result = await pool.query(
    'UPDATE groups SET title = $1 WHERE title = $2 RETURNING id, title',
    [newTitle, oldTitle]
  );

  return result.rows[0];
}

export async function deleteGroupByName(title) {
  await pool.query(
    'DELETE FROM groups WHERE title = $1',
    [title]
  );
}

export async function closeDb() {
  await pool.end();
}