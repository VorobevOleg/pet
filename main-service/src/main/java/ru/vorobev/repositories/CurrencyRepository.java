package ru.vorobev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vorobev.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
