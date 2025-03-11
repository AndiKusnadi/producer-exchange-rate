package bni.co.id.producer.exchange_rate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "bni.co.id.producer.exchange_rate.repository")
@EnableTransactionManagement
@Slf4j
public class TransactionConfig {
    public TransactionConfig() {
        log.info("** >> Transaction Config << **");
    }
}
