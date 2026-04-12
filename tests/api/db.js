const pool = new Pool({
    host: process.env.DB_HOST || 'localhost',
    port: Number(process.env.DB_PORT || 5432),
    database: process.env.DB_NAME || 'appdb',
    user: process.env.DB_USER || 'postgres',
    password: process.env.DB_PASSWORD || 'postgres',
});

async function query(text, params = []) {
    const result = await pool.query(text, params);
    return result.rows;
}

async function closeDb() {
    await pool.end();
}

module.exports = {
    query,
    closeDb,
};