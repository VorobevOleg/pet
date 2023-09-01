package ru.vorobev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobev.entities.CurrencyRate;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, UUID> {

    public List<CurrencyRate> findAllByTimestamp(ZonedDateTime tistamp);

}
