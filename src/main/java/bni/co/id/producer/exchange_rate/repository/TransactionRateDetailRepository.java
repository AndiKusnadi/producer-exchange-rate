package bni.co.id.producer.exchange_rate.repository;

import bni.co.id.producer.exchange_rate.entity.MRate;
import bni.co.id.producer.exchange_rate.entity.TransactionRateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRateDetailRepository extends JpaRepository<TransactionRateDetail, Long> {
    @Query("select data from TransactionRateDetail data where data.currencyId = :currencyId")
    List<TransactionRateDetail> findByCurrencyId(@Param("currencyId") MRate pRate);
}
