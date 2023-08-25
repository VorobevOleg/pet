package ru.vorobev.entities.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * DTO для передачи информации о конкретной валюте
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrensyDto {

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