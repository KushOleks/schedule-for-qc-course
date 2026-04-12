require('dotenv').config();
const axios = require('axios');

const BASE_URL = process.env.BASE_URL || 'http://localhost:8080';

async function getToken() {
    const response = await axios.post(`${BASE_URL}/auth/sign-in`, {
        email: 'manager@gmail.com',
        password: 'Qwerty!123',
    });

    return response.data.token;
}

async function getAuthHeaders() {
    const token = await getToken();

    return {
        Authorization: `Bearer_${token}`,
        'Content-Type': 'application/json',
    };
}

module.exports = {
    BASE_URL,
    getToken,
    getAuthHeaders,
};