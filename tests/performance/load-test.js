import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '20s', target: 100 },
    { duration: '1m', target: 100 },
    { duration: '20s', target: 0 },
  ],

  thresholds: {
    http_req_duration: ['p(99)<5000'],
    http_req_failed: ['rate<0.10'],
  },
};

const BASE_URL =
  'https://schedule-latest-pz3d.onrender.com';

export default function () {

  const commonSchedule = http.get(
    `${BASE_URL}/schedule?semester=1`
  );

  check(commonSchedule, {
    'common schedule status 200': (r) => r.status === 200,

    'common schedule < 3s': (r) =>
      r.timings.duration < 3000,

    'common schedule has html': (r) =>
      r.body.includes('<html'),
  });

  const groupSchedule = http.get(
    `${BASE_URL}/schedule?semester=1&group=1`
  );

  check(groupSchedule, {
    'group schedule status 200': (r) => r.status === 200,

    'group schedule < 3s': (r) =>
      r.timings.duration < 3000,

    'group schedule has html': (r) =>
      r.body.includes('<html'),
  });

  sleep(2);
}