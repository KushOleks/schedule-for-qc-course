const axios = require('axios');
require('dotenv').config();

const { BASE_URL, getAuthHeaders } = require('./auth');

let api;

describe('Schedule API', () => {
  let scheduleId;

  beforeAll(async () => {
    const headers = await getAuthHeaders();

    api = axios.create({
      baseURL: BASE_URL,
      timeout: 5000,
      headers,
    });
  });

  describe('GET /lessons', () => {
    it('should return list of lessons', async () => {
      const response = await api.get('/lessons');

      expect(response.status).toBe(200);
      expect(Array.isArray(response.data)).toBe(true);
    });

    it('should return lessons with required fields', async () => {
      const response = await api.get('/lessons');

      expect(response.status).toBe(200);

      if (response.data.length > 0) {
        expect(response.data[0]).toHaveProperty('id');
      }
    });
  });

  describe('GET /classes', () => {
    it('should return list of classes', async () => {
      const response = await api.get('/classes');

      expect(response.status).toBe(200);
      expect(Array.isArray(response.data)).toBe(true);
    });

    it('should return classes with required fields', async () => {
      const response = await api.get('/classes');

      expect(response.status).toBe(200);

      if (response.data.length > 0) {
        expect(response.data[0]).toHaveProperty('id');
      }
    });
  });

  describe('GET /schedules', () => {
    it('should return list of schedules', async () => {
      const response = await api.get('/schedules');

      expect(response.status).toBe(200);
      expect(Array.isArray(response.data)).toBe(true);

      if (response.data.length > 0) {
        scheduleId = response.data[0].id;
      }
    });

    it('should return schedules with required fields', async () => {
      const response = await api.get('/schedules');

      expect(response.status).toBe(200);

      if (response.data.length > 0) {
        expect(response.data[0]).toHaveProperty('id');
        expect(response.data[0]).toHaveProperty('lesson');
        expect(response.data[0]).toHaveProperty('period');
      }
    });
  });

  describe('GET /schedules/:id', () => {
    it('should return 405 for schedule by id endpoint', async () => {
      await expect(api.get(`/schedules/${scheduleId || 1}`)).rejects.toMatchObject({
        response: { status: 405 },
      });
    });

    it('should return 405 for non-existing schedule id endpoint', async () => {
      await expect(api.get('/schedules/999999')).rejects.toMatchObject({
        response: { status: 405 },
      });
    });
  });

  describe('POST /schedules duplicate', () => {
    it('should return 404 for duplicate schedule scenario', async () => {
      const payload = {
        periodId: 1,
        lessonId: 1,
        roomId: 1,
        dayOfWeek: 'MONDAY',
        evenOdd: 'EVEN',
      };

      await expect(api.post('/schedules', payload)).rejects.toMatchObject({
        response: { status: 400 },
      });
    });
  });
});