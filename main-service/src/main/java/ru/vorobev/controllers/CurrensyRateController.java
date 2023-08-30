package ru.vorobev.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vorobev.dto.CbrDailyDto;

/**
 * Контроллер для работы с инфой о курсах валют
 */
@RestController
@RequestMapping("/currensy-rate")
@RequiredArgsConstructor
public class CurrensyRateController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewCurrensyRateToDb(@RequestBody CbrDailyDto cbrDailyDto) {
        System.out.println("Saving in DB ... " + cbrDailyDto);
    }

}
