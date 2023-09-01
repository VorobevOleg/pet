package ru.vorobev.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.vorobev.converters.DtoConverter;
import ru.vorobev.dto.CurrencyDto;
import ru.vorobev.entities.Currency;
import ru.vorobev.repositories.CurrencyRepository;
import ru.vorobev.services.CurrencyService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    private final DtoConverter dtoConverter;

    @Override
    @Cacheable("currencies")
    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public void saveCurrency(CurrencyDto currencyDto) {
        currencyRepository.save(dtoConverter.to(currencyDto));
    }

    @Override
    @CacheEvict("currencies")
    public void deleteAndEvictCurrency(String id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public void updateCurrency(CurrencyDto currencyDto) {

        Currency currencyFromDb = currencyRepository.findById(currencyDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Currency not found by id: " + currencyDto.getId()));

        Currency currencyToSave = dtoConverter.to(currencyDto);

        currencyFromDb.setNumCode(currencyToSave.getNumCode());
        currencyFromDb.setCharCode(currencyToSave.getCharCode());
        currencyFromDb.setNominal(currencyToSave.getNominal());
        currencyFromDb.setName(currencyToSave.getName());

    }
}
