## 3️⃣ Modelo de Datos (Data Model)

[cite_start]A continuación se detalla la estructura de la base de datos en memoria (H2) utilizada para este reto técnico[cite: 79, 111].

### Entidades y Campos

#### 1. Account (Cuenta Bancaria)
[cite_start]Representa la cuenta de ahorros o corriente del cliente[cite: 34, 87].
* [cite_start]`id` (Long, PK): Identificador único de la cuenta[cite: 87].
* [cite_start]`accountNumber` (String): Número de cuenta único estructurado[cite: 87].
* [cite_start]`balance` (double): Saldo disponible actual en la cuenta[cite: 87].

#### 2. Transaction (Transacción / Movimiento)
[cite_start]Representa cada depósito o retiro efectuado sobre una cuenta[cite: 35, 88].
* [cite_start]`id` (Long, PK): Identificador único del movimiento[cite: 88].
* [cite_start]`type` (String): Tipo de operación (`DEPOSIT` o `WITHDRAWAL`)[cite: 88].
* [cite_start]`amount` (double): Monto de la transacción[cite: 88].
* [cite_start]`accountId` (Long, FK): Referencia a la cuenta que realiza la operación[cite: 88].
* [cite_start]`createdAt` (LocalDateTime): Fecha y hora exacta en la que se ejecutó el movimiento[cite: 88].

### Relación entre Entidades

[cite_start]La relación lógica implementada cumple con el siguiente principio[cite: 114]:

* **Account (1) ------> (*) Transaction**
* **Una Cuenta (`Account`)** puede tener **muchos Movimientos (`Transactions`)** asociados a lo largo del tiempo.
* [cite_start]**Cada Movimiento (`Transaction`)** pertenece estrictamente a **una única Cuenta (`Account`)** a través del campo `accountId`[cite: 88].




### Diagrama de Relación (ERD)

```text
  ┌──────────────────────┐               ┌──────────────────────┐
  │       ACCOUNT        │               │     TRANSACTION      │
  ├──────────────────────┤               ├──────────────────────┤
  │ PK │ id              │1             *│ PK │ id              │
  │    │ accountNumber   │────────────── font-style: italic; font-weight: bold; color: rgb(26, 115, 232); text-decoration-line: underline; cursor: pointer;─┤ FK │ accountId       │
  │    │ balance         │               │    │ type            │
  └──────────────────────┘               │    │ amount          │
                                         │    │ createdAt       │
                                         └──────────────────────┘

