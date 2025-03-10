alter table "BACKOFFICE"."TRANSACTION_RATE" drop column  version;
alter table "BACKOFFICE"."TRANSACTION_RATE" add    version  integer default 0 not null;

alter table "BACKOFFICE"."MASTER_RATE" drop column version;
alter table "BACKOFFICE"."MASTER_RATE" add  version integer default 0 not null;

