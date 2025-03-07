-- Step 1: Create a Sequence
CREATE SEQUENCE "BACKOFFICE"."EXCHANGE_RATE_SEQ"
    START WITH 1  -- Start from 1
    INCREMENT BY 1  -- Increase by 1
    NOCACHE;  -- Prevent caching (optional)

CREATE TABLE "BACKOFFICE"."MASTER_RATE"
(
    id number primary key,
    currency_code varchar2(255)
)