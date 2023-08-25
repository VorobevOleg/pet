package ru.vorobev.entities.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * DTO для передачи информации о валютах
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CbrDailyDto implements ApiDto{

    @JsonAlias("Date")
    private ZonedDateTime date;

    @JsonAlias("PreviousDate")
    private ZonedDateTime previousDate;

    @JsonAlias("PreviousURL")
    private String previousURL;

    @JsonAlias("Timestamp")
    private ZonedDateTime timestamp;

    @JsonAlias("Valute")
    private Map<String, CurrensyDto> currensyMap;

}
