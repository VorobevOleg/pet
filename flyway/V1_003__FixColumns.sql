alter table currencies_rates
    alter column value type numeric(7, 4) using value::numeric(7, 4);

alter table currencies_rates
    alter column previous type numeric(7, 4) using previous::numeric(7, 4);