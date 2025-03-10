alter table "BACKOFFICE"."TRANSACTION_RATE_DETAIL" drop column currency_id;
alter table "BACKOFFICE"."TRANSACTION_RATE_DETAIL" add  currency_id varchar2(255);
