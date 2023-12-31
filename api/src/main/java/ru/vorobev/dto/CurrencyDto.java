package ru.vorobev.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO для передачи информации о конкретной валюте
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto implements Serializable {

    @JsonAlias("ID")
    private String id;

    @JsonAlias("NumCode")
    private Integer numCode;

    @JsonAlias("CharCode")
    private String charCode;

    @JsonAlias("Nominal")
    private Integer nominal;

    @JsonAlias("Name")
    private String name;

    @JsonAlias("Value")
    private BigDecimal value;

    @JsonAlias("Previous")
    private BigDecimal previous;
}
