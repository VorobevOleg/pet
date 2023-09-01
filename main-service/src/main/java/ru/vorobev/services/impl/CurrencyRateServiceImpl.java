package ru.vorobev.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.vorobev.converters.DtoConverter;
import ru.vorobev.dto.CbrDailyDto;
import ru.vorobev.dto.CurrencyDto;
import ru.vorobev.entities.CurrencyRate;
import ru.vorobev.repositories.CurrencyRateRepository;
import ru.vorobev.services.CurrencyRateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;
    private final DtoConverter dtoConverter;

    @Override
    public void saveCbrDailyDto(CbrDailyDto cbrDailyDto) {

        List<CurrencyRate> actualCurrencyRateList = currencyRateRepository.findAllByTimestamp(cbrDailyDto.getTimestamp());
        Map<String, CurrencyRate> actualCurrencyRateMap = new HashMap<>();
        actualCurrencyRateList.forEach(curRate -> actualCurrencyRateMap.put(curRate.getCurrency().getId(), curRate));

        List<CurrencyDto> currencyDtoList = cbrDailyDto.getCurrensyMap().values().stream().toList();

        List<CurrencyRate> currencyRateListToSave = currencyDtoList.stream()
                .filter(curDto -> !actualCurrencyRateMap.containsKey(curDto.getId()))
                .map(curDto -> {
                    CurrencyRate currencyRate = new CurrencyRate();
                    currencyRate.setCurrency(dtoConverter.to(curDto));
                    currencyRate.setValue(curDto.getValue());
                    currencyRate.setPrevious(curDto.getPrevious());
                    currencyRate.setTimestamp(cbrDailyDto.getTimestamp());
                    return currencyRate;
                })
                .toList();

        currencyRateRepository.saveAll(currencyRateListToSave);
    }
}
