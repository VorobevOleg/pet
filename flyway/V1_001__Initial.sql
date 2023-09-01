CREATE TABLE IF NOT EXISTS currencies
(
    id              text    PRIMARY KEY    NOT NULL,
    num_code        text                   NOT NULL,
    char_code       text                   NOT NULL,
    nominal         int                    NOT NULL,
    name            text                   NOT NULL
);

--Для быстрого поиска по имени валюты
CREATE EXTENSION pg_trgm;
CREATE INDEX IF NOT EXISTS currencies_idx_name ON currencies USING GIN (name gin_trgm_ops);

CREATE TABLE IF NOT EXISTS currencies_rates
(
    id              uuid            PRIMARY KEY                UNIQUE  NOT NULL,
    currency_id     text            REFERENCES currencies(id)          NOT NULL,
    value           numeric(3,4),
    previous        numeric(3,4),
    timestamp       timestamptz
);

-- Для быстрого поиска по времени отсортированном по убыванию
CREATE INDEX IF NOT EXISTS currencies_rates_idx_timestamp_DESC ON currencies_rates USING btree (timestamp DESC);
-- Для быстрого поиска по времени отсортированном по возрастанию
CREATE INDEX IF NOT EXISTS currencies_rates_idx_timestamp_ASC ON currencies_rates USING btree (timestamp);

