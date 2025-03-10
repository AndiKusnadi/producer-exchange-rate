alter table "BACKOFFICE"."TRANSACTION_RATE_HEADER" drop column currency_base;
alter table "BACKOFFICE"."TRANSACTION_RATE_DETAIL" drop column rate;
alter table "BACKOFFICE"."TRANSACTION_RATE_DETAIL" add  rate number(10, 20);
