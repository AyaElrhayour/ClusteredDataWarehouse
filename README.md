# ClusteredData Warehouse

## Overview

ClusteredData Warehouse is a technical assignment to process and send deal details with robust validation, and persistence capabilities.

## Key Features

- **✅ Advanced Deal Validation**  
  Ensures every deal is thoroughly checked for:  
  - Unique ID integrity  
  - Valid ISO currency codes  
  - Properly formatted timestamps  
  - Accurate deal amounts  

- **🛡️ Duplicate Detection**  
  Automatically identifies and prevents duplicate deals, maintaining data consistency.  

- **📊 Comprehensive Logging**  
  Provides detailed logs and an audit trail for tracking all operations and errors.  

- **🚨 Robust Error Handling**  
  Gracefully manages exceptions and ensures the system remains stable under unexpected conditions.  

## Tech Stack

**Server:** Springboot, Spring Data Jpa, Hibernate

**Unit Testing:** JUnit 5, Mockito

**Database:** PostgreSql

**Containerization:** Docker, Docker compose

**Logging** SLF4J

## PORTS

Springboot App : 8082

PostgreSql Database: 5432

## Prerequisites

- JDK 17
- Docker & Docker Compose
- Maven 3.8+

## Deployment

To deploy this project run, you can make use of the Makefile commands to facilitate test of the app.

Clone the repository
```bash
git clone https://github.com/AyaElrhayour/ClusteredDataWarehouse.git
```

First to test the application run

```bash
  make test
```

You can see the coverage of the app that was performed. The code coverage reached 100% for the service layer.

run the docker compose file to run the spring app, postgreSql database using

```bash
  make run
```

To shut down your containers run

```bash
  make down
```

## API Documentation

#### Send a deal

```http
  POST /api/deals
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. Id of the deal |
| `fromCurrencyISOCode` | `string` | **Required**. From Currency ISO Code |
| `toCurrencyISOCode` | `string` | **Required**. To Currency ISO Code |
| `dealAmount` | `double` | **Required**. Amount of the deal |

Request Example:
```json
{
  "id": "FX987654",
  "fromCurrencyISOCode": "GBP",
  "toCurrencyISOCode": "JPY",
  "dealAmount": 500000.50
}
```

Response Example:
```json
{
  "id": "FX987654",
  "fromCurrencyISOCode": "GBP",
  "toCurrencyISOCode": "JPY",
  "dealTimestamp": "2025-03-03T00:00:00Z",
  "dealAmount": 500000.50,
}
```

## Support

For support, email ayaelrhayour123@gmail.com .
