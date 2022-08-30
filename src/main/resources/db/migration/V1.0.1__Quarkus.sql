CREATE TABLE management_role (
  id BIGINT NOT NULL,
   role_code VARCHAR(5) NOT NULL,
   role_name VARCHAR(50) NOT NULL,
   CONSTRAINT pk_management_role PRIMARY KEY (id)
);

ALTER TABLE management_role ADD CONSTRAINT uc_management_role_role_code UNIQUE (role_code);
CREATE TABLE reason_for_leaving (
  id BIGINT NOT NULL,
   description VARCHAR(100) NOT NULL,
   CONSTRAINT pk_reason_for_leaving PRIMARY KEY (id)
);
CREATE TABLE stock_exchange (
  id BIGINT NOT NULL,
   exchange_code VARCHAR(5) NOT NULL,
   exchange_name VARCHAR(100) NOT NULL,
   currency_id BIGINT,
   country_id BIGINT,
   CONSTRAINT pk_stock_exchange PRIMARY KEY (id)
);

ALTER TABLE stock_exchange ADD CONSTRAINT uc_stock_exchange_exchange_code UNIQUE (exchange_code);

ALTER TABLE stock_exchange ADD CONSTRAINT FK_STOCK_EXCHANGE_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES ts_country (id);

ALTER TABLE stock_exchange ADD CONSTRAINT FK_STOCK_EXCHANGE_ON_CURRENCY FOREIGN KEY (currency_id) REFERENCES ts_currency (id);
CREATE TABLE stock_index (
  id BIGINT NOT NULL,
   index_code VARCHAR(5) NOT NULL,
   index_name VARCHAR(100) NOT NULL,
   CONSTRAINT pk_stock_index PRIMARY KEY (id)
);

ALTER TABLE stock_index ADD CONSTRAINT uc_stock_index_index_code UNIQUE (index_code);
CREATE TABLE counter (
  id BIGINT NOT NULL,
   ticker VARCHAR(10) NOT NULL,
   counter_name VARCHAR(100) NOT NULL,
   year_high DECIMAL NOT NULL,
   year_low DECIMAL NOT NULL,
   current_price DECIMAL NOT NULL,
   exchange_id BIGINT,
   year_end VARCHAR(255) NOT NULL,
   market_cap DECIMAL,
   intrinsic_value DECIMAL,
   margin_of_safety DECIMAL,
   counter_id BIGINT,
   CONSTRAINT pk_counter PRIMARY KEY (id)
);

ALTER TABLE counter ADD CONSTRAINT uc_counter_ticker UNIQUE (ticker);

ALTER TABLE counter ADD CONSTRAINT FK_COUNTER_ON_COUNTER FOREIGN KEY (counter_id) REFERENCES stock_exchange (id);

ALTER TABLE counter ADD CONSTRAINT FK_COUNTER_ON_EXCHANGE FOREIGN KEY (exchange_id) REFERENCES stock_exchange (id);
CREATE TABLE financial_report (
  id BIGINT NOT NULL,
   counter_id BIGINT,
   report_type INTEGER NOT NULL,
   report_date date NOT NULL,
   assets DECIMAL(14, 2) NOT NULL,
   liabilities DECIMAL(14, 2) NOT NULL,
   issued_shares DECIMAL(14, 2) NOT NULL,
   cf_operating_activities DECIMAL(14, 2) NOT NULL,
   interest_expenses DECIMAL(14, 2) NOT NULL,
   tax_shield DECIMAL(14, 2),
   capex DECIMAL(14, 2) NOT NULL,
   dividend DECIMAL(14, 6) NOT NULL,
   net_assets DECIMAL(14, 2),
   eps DECIMAL(14, 6) NOT NULL,
   eps_last_year DECIMAL(14, 6),
   earning_growth DECIMAL(14, 2),
   pe_ratio DECIMAL(14, 2),
   pb_ratio DECIMAL(14, 2),
   dividend_ratio DECIMAL(14, 2),
   free_cash_flow DECIMAL(14, 2),
   CONSTRAINT pk_financial_report PRIMARY KEY (id)
);

ALTER TABLE financial_report ADD CONSTRAINT FK_FINANCIAL_REPORT_ON_COUNTER FOREIGN KEY (counter_id) REFERENCES counter (id);
CREATE TABLE manager (
  id BIGINT NOT NULL,
   counter_id BIGINT,
   role_id BIGINT,
   full_name VARCHAR(150) NOT NULL,
   from_date date NOT NULL,
   to_date date,
   comment VARCHAR(200),
   reason_id BIGINT,
   CONSTRAINT pk_manager PRIMARY KEY (id)
);

ALTER TABLE manager ADD CONSTRAINT FK_MANAGER_ON_COUNTER FOREIGN KEY (counter_id) REFERENCES counter (id);

ALTER TABLE manager ADD CONSTRAINT FK_MANAGER_ON_REASON FOREIGN KEY (reason_id) REFERENCES reason_for_leaving (id);

ALTER TABLE manager ADD CONSTRAINT FK_MANAGER_ON_ROLE FOREIGN KEY (role_id) REFERENCES management_role (id);
CREATE TABLE valuation_matrix (
  id BIGINT NOT NULL,
   report_date date NOT NULL,
   report_type INTEGER NOT NULL,
   growth_rate DECIMAL(14, 2),
   discounted_growth_rate DECIMAL(14, 2),
   fcf_year1 DECIMAL(14, 2),
   fcf_year2 DECIMAL(14, 2),
   fcf_year3 DECIMAL(14, 2),
   fcf_year4 DECIMAL(14, 2),
   fcf_year5 DECIMAL(14, 2),
   fcf_year6 DECIMAL(14, 2),
   fcf_year7 DECIMAL(14, 2),
   fcf_year8 DECIMAL(14, 2),
   fcf_year9 DECIMAL(14, 2),
   fcf_year10 DECIMAL(14, 2),
   fcf_by_ten DECIMAL(14, 2),
   CONSTRAINT pk_valuation_matrix PRIMARY KEY (id)
);
CREATE TABLE counter_stock_index (
  counter_id BIGINT NOT NULL,
   stock_index_id BIGINT NOT NULL
);

ALTER TABLE counter_stock_index ADD CONSTRAINT fk_coustoind_on_counter FOREIGN KEY (counter_id) REFERENCES counter (id);

ALTER TABLE counter_stock_index ADD CONSTRAINT fk_coustoind_on_stock_index FOREIGN KEY (stock_index_id) REFERENCES stock_index (id);