package ru.vorobev.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ru.vorobev.entities.Currency;
import ru.vorobev.repositories.CurrencyRepository;
import ru.vorobev.services.CurrencyService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    @Cacheable("currencies")
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    @Cacheable(value = "currency", key = "#id")
    public Currency getById(String id) {
        return currencyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Currency not found by id: " + id));
    }

    @Override
    @Caching(put = @CachePut(cacheNames = "currency", key = "#currency.id"),
            evict = @CacheEvict(cacheNames = "currencies", allEntries = true))
    public Currency saveAndRefreshCache(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "currency", key = "#id"),
            @CacheEvict(cacheNames = "currencies", allEntries = true)})
    public void deleteAndEvict(String id) {
        getById(id);
        currencyRepository.deleteById(id);
    }

    @Override
    @Caching(put = @CachePut(cacheNames = "currency", key = "#currency.id"),
            evict = @CacheEvict(cacheNames = "currencies", allEntries = true))
    public Currency updateAndRefreshCache(Currency currency) {
        getById(currency.getId());
        return currencyRepository.save(currency);
    }
}
