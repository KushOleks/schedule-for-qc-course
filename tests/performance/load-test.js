import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '10s', target: 5 },
    { duration: '30s', target: 10 },
    { duration: '10s', target: 0 },
  ],
  thresholds: {
    http_req_duration: ['p(95)<1000'],
    http_req_failed: ['rate<0.05'],
  },
};

const BASE_URL = 'https://test.k6.io';

export default function () {

  const main = http.get(`${BASE_URL}`);

  check(main, {
    'main page status 200': (r) => r.status === 200,
    'main page response < 1000ms': (r) => r.timings.duration < 1000,
  });

  const contacts = http.get(`${BASE_URL}/contacts.php`);

  check(contacts, {
    'contacts status 200': (r) => r.status === 200,
  });

  const news = http.get(`${BASE_URL}/news.php`);

  check(news, {
    'news status 200': (r) => r.status === 200,
    'news response < 1000ms': (r) => r.timings.duration < 1000,
  });

  sleep(1);
}