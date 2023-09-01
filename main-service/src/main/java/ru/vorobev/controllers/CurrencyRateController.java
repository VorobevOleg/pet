package ru.vorobev.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vorobev.dto.CbrDailyDto;
import ru.vorobev.services.CurrencyRateService;

/**
 * Контроллер для работы с инфой о курсах валют
 */
@Slf4j
@RestController
@RequestMapping("/currensy-rate")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewCurrencyRateToDb(@RequestBody CbrDailyDto cbrDailyDto) {
        log.debug("REST: Saving in DB CbrDailyDto timestamp: '{}'", cbrDailyDto.getTimestamp());
        currencyRateService.saveCbrDailyDto(cbrDailyDto);
        log.debug("REST: Saved in DB CbrDailyDto timestamp: '{}'", cbrDailyDto.getTimestamp());
    }

}
