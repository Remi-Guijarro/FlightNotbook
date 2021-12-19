## Dependencies

### Back

- Java 11
- Maven 3.8
- MySQL

### Front

- pnpm

## Start database

```bash
mysql.server start
```

## Stop database

```bash
mysql.server stop
```

## Start Back

```bash
cd Back
./mvnw spring-boot:run
```

## Start front

```bash
cd Front
pnpm dev
```
