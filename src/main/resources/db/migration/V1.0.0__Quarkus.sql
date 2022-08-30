CREATE TABLE ts_country (
  id BIGINT NOT NULL,
   countryCode VARCHAR(3),
   countryName VARCHAR(50),
   CONSTRAINT pk_ts_country PRIMARY KEY (id)
);

ALTER TABLE ts_country ADD CONSTRAINT uc_ts_country_countrycode UNIQUE (countryCode);
CREATE TABLE ts_currency (
  id BIGINT NOT NULL,
   currencyCode VARCHAR(5),
   country_id BIGINT,
   currencyName VARCHAR(50),
   CONSTRAINT pk_ts_currency PRIMARY KEY (id)
);

ALTER TABLE ts_currency ADD CONSTRAINT uc_ts_currency_currencycode UNIQUE (currencyCode);

ALTER TABLE ts_currency ADD CONSTRAINT FK_TS_CURRENCY_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES ts_country (id);