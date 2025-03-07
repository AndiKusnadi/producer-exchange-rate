package bni.co.id.producer.exchange_rate.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class ApplicationProperties {
    @Value("${currency.rate.url}")
    private String currencyRateUrl;
    @Value("${currency.rate.api.key}")
    private String currencyRateApiKey;

    @Value("${topic.exchange.rate}")
    private String topicExchangeRate;

    @Value("${topic.exchange.rate.group.id}")
    private String topicExchangeRateGroupId;
}