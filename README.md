# API Documentation

This document provides an overview of the REST API endpoints for report and authentication management.

## Endpoints

### 1. Authentication API
Endpoints related to user authentication and registration.

**Base URL:** `/v1/auth`

#### `POST /v1/auth/token`
Authenticates a user and retrieves a token.

- **Request Body:**
    - `GetTokenRequest` (JSON): Contains `username` and `password`.
- **Response:** `200 OK`
    - Returns a `TokenResponse` with the authentication token.

#### `POST /v1/auth/register`
Registers a new user.

- **Request Body:**
    - `RegisterRequest` (JSON): Contains `username` and `password`.
- **Response:** `204 No Content`
    - Indicates successful registration without a response body.

### 2. ASIN Report API
Endpoints related to ASIN report management.

**Base URL:** `/v1/report/asin`

#### `GET /v1/report/asin?asin={asin}`
Retrieves the ASIN report for a specific ASIN code.

- **Parameters:**
    - `asin` (String, required): The ASIN code to retrieve the report for.
- **Response:** `200 OK`
    - Returns an `AsinReportDto` object with the report details.

#### `GET /v1/report/asin?asins={asins}`
Retrieves ASIN reports for a list of ASIN codes.

- **Parameters:**
    - `asins` (List of Strings, required): A list of ASIN codes to retrieve reports for.
- **Response:** `200 OK`
    - Returns a list of `AsinReportDto` objects with the reports for each specified ASIN.

#### `GET /v1/report/asin`
Retrieves a summary report of ASINs.

- **Response:** `200 OK`
    - Returns an `AsinSummaryReportDto` object with the summary report details.


### 3. Date Report API
Endpoints related to date-based reports.

**Base URL:** `/v1/report/date`

#### `GET /v1/report/date?date={date}`
Retrieves the report for a specific date.

- **Parameters:**
    - `date` (String, required): Date in `YYYY-MM-DD` format.
- **Response:** `200 OK`
    - Returns a `DateReportDto` object with the report for the specified date.

#### `GET /v1/report/date?begin={begin}&end={end}`
Retrieves date reports within a specified date range.

- **Parameters:**
    - `begin` (String, required): Start date in `YYYY-MM-DD` format.
    - `end` (String, required): End date in `YYYY-MM-DD` format.
- **Response:** `200 OK`
    - Returns a list of `DateReportDto` objects within the specified date range.

#### `GET /v1/report/date`
Retrieves a summary report for date-based reports.

- **Response:** `200 OK`
    - Returns a `DateSummaryReportDto` object with the summary report details.
