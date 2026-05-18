# Security Report

## Цільовий додаток

- Назва: Schedule Management System
- URL: https://schedule-latest-pz3d.onrender.com
- Метод: OWASP ZAP Baseline Scan
- Інструмент: OWASP ZAP

## Знайдені проблеми

| # | Рівень | Опис | Де знайдено |
|---|--------|------|-------------|
| 1 | Medium | Vulnerable JS Library | /static/js/main.b7dfd247.js |
| 2 | Medium | Content Security Policy Header Not Set | Головна сторінка |
| 3 | Low | Non-Storable Content | favicon, manifest.json, robots.txt |
| 4 | Low | Permissions Policy Header Not Set | Головна сторінка |
| 5 | Low | Timestamp Disclosure - Unix | JS bundle |
| 6 | Info | Modern Web Application | Головна сторінка |
| 7 | Low | Cross-Origin-Embedder-Policy Header Missing | Всі основні сторінки |

---

## Деталі

### Проблема 1: Vulnerable JS Library

- **Що знайдено:** ZAP виявив потенційно застарілу або вразливу JavaScript-бібліотеку.
- **Де:**  
  `/static/js/main.b7dfd247.js`
- **Ризик:** Medium — можливі client-side вразливості або використання застарілих залежностей.
- **Рекомендація:** оновити npm-залежності та перевірити проєкт через:
  
### Проблема 2: Content Security Policy (CSP) Header Not Set

- **Що знайдено:** відсутній HTTP-заголовок `Content-Security-Policy`.
- **Де:** головна сторінка додатку.
- **Ризик:** Medium — збільшується ризик XSS-атак та виконання небезпечного JavaScript-коду.
- **Рекомендація:** додати CSP header у конфігурацію backend або web server.

### Проблема 3: Non-Storable Content

- **Що знайдено:** деякі ресурси не містять cache-control політик для правильного керування кешуванням.
- **Де:** `favicon.png`, `manifest.json`, `robots.txt`
- **Ризик:** Low — можливе некоректне кешування контенту браузером.
- **Рекомендація:** налаштувати HTTP cache headers для статичних ресурсів.

### Проблема 4: Permissions Policy Header Not Set

- **Що знайдено:** відсутній HTTP-заголовок `Permissions-Policy`.
- **Де:** головна сторінка додатку.
- **Ризик:** Low — браузерні API можуть бути доступними без додаткових обмежень.
- **Рекомендація:** додати Permissions-Policy header у конфігурацію сервера.

### Проблема 5: Timestamp Disclosure - Unix

- **Що знайдено:** у JavaScript bundle виявлено Unix timestamp.
- **Де:** `/static/js/main.b7dfd247.js`
- **Ризик:** Low — можливе часткове розкриття технічної інформації про build або deployment.
- **Рекомендація:** мінімізувати leakage технічної інформації у production build.

### Проблема 6: Modern Web Application

- **Що знайдено:** ZAP визначив додаток як сучасний SPA/web application.
- **Де:** головна сторінка.
- **Ризик:** Info — інформаційне повідомлення, не є реальною вразливістю.
- **Рекомендація:** виправлення не потребується.

### Проблема 7: Cross-Origin-Embedder-Policy Header Missing or Invalid

- **Що знайдено:** відсутній або некоректний заголовок `Cross-Origin-Embedder-Policy`.
- **Де:** основні сторінки додатку.
- **Ризик:** Low — можуть виникати проблеми із захистом cross-origin ресурсів.
- **Рекомендація:** додати відповідний security header у конфігурацію сервера.