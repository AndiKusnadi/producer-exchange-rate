drop table "BACKOFFICE"."TRANSACTION_RATE";

CREATE TABLE "BACKOFFICE"."TRANSACTION_RATE_HEADER"
(
    id number primary key,
    currency_base varchar2(255),
    trx_date varchar2(255),
    version integer not null,
    created_time timestamp,
    currency_id varchar2(255),
        CONSTRAINT fk_currency_rate FOREIGN KEY (currency_id) REFERENCES BACKOFFICE.master_rate(currency_id)
);

CREATE TABLE "BACKOFFICE"."TRANSACTION_RATE_DETAIL"
(
    id number primary key,
    transaction_header_id number ,
    version integer not null,
    created_time timestamp,
    currency_id varchar2(255),
    rate number(17, 16),
        CONSTRAINT fk_currency_rate_detail FOREIGN KEY (currency_id) REFERENCES BACKOFFICE.master_rate(currency_id),
        constraint fk_transaction_header foreign key(transaction_header_id) references BACKOFFICE.TRANSACTION_RATE_HEADER(id)
);
