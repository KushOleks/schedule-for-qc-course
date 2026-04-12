const axios = require('axios');
const { Pool } = require('pg');
require('dotenv').config();

const { BASE_URL, getAuthHeaders } = require('./auth');

let api;

const pool = new Pool({
  connectionString:
    process.env.DATABASE_URL || 'postgresql://postgres:postgres@localhost:5433/appdb',
});

describe('Room API', () => {
  let createdRoomId;
  let createdRoomName;
  let originalRoomTypeId = 1;

  beforeAll(async () => {
    const headers = await getAuthHeaders();

    api = axios.create({
      baseURL: BASE_URL,
      timeout: 5000,
      headers,
    });

    const response = await api.get('/rooms');
    if (Array.isArray(response.data) && response.data.length > 0) {
      if (response.data[0].type && response.data[0].type.id) {
        originalRoomTypeId = response.data[0].type.id;
      }
    }
  });

  afterAll(async () => {
    if (createdRoomId) {
      try {
        await api.delete(`/rooms/${createdRoomId}`);
      } catch (e) {
      }
    }

    await pool.end();
  });

  describe('GET /rooms', () => {
    it('should return list of rooms', async () => {
      const response = await api.get('/rooms');

      expect(response.status).toBe(200);
      expect(Array.isArray(response.data)).toBe(true);
    });

    it('should return rooms with required fields', async () => {
      const response = await api.get('/rooms');

      expect(response.status).toBe(200);

      if (response.data.length > 0) {
        expect(response.data[0]).toHaveProperty('id');
        expect(response.data[0]).toHaveProperty('name');
        expect(response.data[0]).toHaveProperty('disable');
        expect(response.data[0]).toHaveProperty('type');
      }
    });
  });

  describe('POST /rooms', () => {
    it('should create a new room', async () => {
      createdRoomName = `ROOM_${Date.now()}`;

      const newRoom = {
        name: createdRoomName,
        disable: false,
        type: {
          id: originalRoomTypeId,
        },
      };

      const response = await api.post('/rooms', newRoom);

      expect(response.status).toBe(201);
      expect(response.data).toHaveProperty('id');
      expect(response.data.name).toBe(createdRoomName);

      createdRoomId = response.data.id;
    });

    it('should save created room in database', async () => {
      const result = await pool.query(
        'SELECT id, name FROM rooms WHERE id = $1',
        [createdRoomId]
      );

      expect(result.rows.length).toBe(1);
      expect(result.rows[0].name).toBe(createdRoomName);
    });

    it('should return 400 for invalid room data', async () => {
      const invalidRoom = {
        name: '',
        disable: false,
        type: {
          id: originalRoomTypeId,
        },
      };

      await expect(api.post('/rooms', invalidRoom)).rejects.toMatchObject({
        response: { status: 400 },
      });
    });
  });

  describe('GET /rooms/:id', () => {
    it('should return room by id', async () => {
      const response = await api.get(`/rooms/${createdRoomId}`);

      expect(response.status).toBe(200);
      expect(response.data.id).toBe(createdRoomId);
    });

    it('should return 404 for non-existing room', async () => {
      await expect(api.get('/rooms/999999')).rejects.toMatchObject({
        response: { status: 404 },
      });
    });
  });

  describe('PUT /rooms', () => {
    it('should update room', async () => {
      const updatedRoomName = `R${Date.now().toString().slice(-6)}`;

      const updatedRoom = {
        id: createdRoomId,
        name: updatedRoomName,
        disable: false,
        type: {
          id: originalRoomTypeId,
        },
      };

      const response = await api.put('/rooms', updatedRoom);

      expect(response.status).toBe(200);
      expect(response.data.id).toBe(createdRoomId);
      expect(response.data.name).toBe(updatedRoomName);

      createdRoomName = updatedRoomName;
    });

    it('should return 400 for invalid update data', async () => {
      const invalidUpdate = {
        id: createdRoomId,
        name: '',
        disable: false,
        type: {
          id: originalRoomTypeId,
        },
      };

      await expect(api.put('/rooms', invalidUpdate)).rejects.toMatchObject({
        response: { status: 400 },
      });
    });
  });

  describe('DELETE /rooms/:id', () => {
    it('should delete room', async () => {
      const response = await api.delete(`/rooms/${createdRoomId}`);

      expect([200, 204]).toContain(response.status);
    });

    it('should return 404 after deletion', async () => {
      await expect(api.get(`/rooms/${createdRoomId}`)).rejects.toMatchObject({
        response: { status: 404 },
      });

      createdRoomId = null;
    });
  });
});