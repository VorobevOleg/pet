package ru.vorobev.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "currencies_rates")
@Getter
@Setter
@NoArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "previous")
    private BigDecimal previous;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

}