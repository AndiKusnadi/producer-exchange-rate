package bni.co.id.producer.exchange_rate.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

@Configuration
@Order(1)
@ComponentScan(value = "bni.co.id.producer.exchange_rate.service")
public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
