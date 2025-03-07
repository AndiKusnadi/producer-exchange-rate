-- Step 1: Create a Sequence
drop SEQUENCE "BACKOFFICE"."EXCHANGE_RATE_SEQ";
drop TABLE "BACKOFFICE"."MASTER_RATE";

CREATE TABLE "BACKOFFICE"."MASTER_RATE"
(
    currency_id varchar2(255) primary key
);

-- Step 1: Create a Sequence
CREATE SEQUENCE "BACKOFFICE"."TRX_EXCHANGE_RATE_SEQ"
    START WITH 1  -- Start from 1
    INCREMENT BY 1  -- Increase by 1
    NOCACHE;

CREATE TABLE "BACKOFFICE"."TRANSACTION_RATE"
(
    id number primary key,
    currency_base varchar2(255),
    trx_date varchar2(255),
    currency_id varchar2(255),
        CONSTRAINT fk_currency_rate FOREIGN KEY (currency_id) REFERENCES BACKOFFICE.master_rate(currency_id)
);