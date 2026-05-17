# Security Testing Report

## Tool Used
- OWASP ZAP Baseline Scan
- Docker image: ghcr.io/zaproxy/zaproxy:stable

## Target
https://demo.owasp-juice.shop

## Scan Summary

| Risk Level | Count |
|---|---|
| High | 0 |
| Medium | 2 |
| Low | 7 |
| Informational | 4 |

## Medium Risk Issues

### 1. Content Security Policy (CSP) Header Not Set
Risk: Medium

Description:
The application does not define a Content-Security-Policy header.
This may increase the risk of Cross-Site Scripting (XSS) attacks and malicious content injection.

Recommendation:
Configure the web server to send a proper CSP header that restricts allowed sources for scripts, styles, and other resources.

---

### 2. Cross-Domain Misconfiguration
Risk: Medium

Description:
The server allows overly permissive Cross-Origin Resource Sharing (CORS) settings using:

Access-Control-Allow-Origin: *

This may allow unauthorized cross-origin access to resources.

Recommendation:
Restrict allowed origins to trusted domains only and avoid using wildcard (*) policies.

---

## Low Risk Issues

### Cross-Origin-Embedder-Policy Header Missing
The application does not define Cross-Origin-Embedder-Policy headers.

### Cross-Origin-Opener-Policy Header Missing
The application does not define Cross-Origin-Opener-Policy headers.

### Dangerous JS Functions
Potentially unsafe JavaScript function detected:
bypassSecurityTrustHtml()

### Deprecated Feature Policy Header
The deprecated Feature-Policy header is used instead of Permissions-Policy.

### Server Version Disclosure
The server exposes version information:
Apache/2.4.67 (Unix)

### Strict-Transport-Security Header Not Set
HSTS header is missing.

### Timestamp Disclosure
Unix timestamps are exposed in HTTP responses.

---

## Informational Findings

- Modern Web Application detected
- Cache-control headers should be reviewed
- Some responses are cacheable
- Some content may be stored by browsers/proxies

---

## Conclusion

The scan did not identify any high-risk vulnerabilities.

However, several medium- and low-risk security issues were detected, mainly related to missing security headers and permissive CORS configuration.

The application should improve HTTP security headers, restrict CORS policies, and review JavaScript security practices to strengthen overall security posture.

---

## Report File

Generated HTML report:
reports/zap-report.html