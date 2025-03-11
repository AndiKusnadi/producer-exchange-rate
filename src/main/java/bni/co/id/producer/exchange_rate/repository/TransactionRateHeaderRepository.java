package bni.co.id.producer.exchange_rate.repository;

import bni.co.id.producer.exchange_rate.entity.TransactionRateHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRateHeaderRepository extends JpaRepository<TransactionRateHeader, Long> {
}
