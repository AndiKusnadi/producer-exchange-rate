package bni.co.id.producer.exchange_rate.service;

import bni.co.id.producer.exchange_rate.config.ApplicationProperties;
import bni.co.id.producer.exchange_rate.util.GeneralFacility;
import bni.co.id.producer.exchange_rate.vo.CurrencyVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GrabDataService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private GeneralFacility generalFacility;

    public void grabDataCurrency() {
        String url = this.applicationProperties.getCurrencyRateUrl() + this.applicationProperties.getCurrencyRateApiKey();
        CurrencyVO currencyVO = this.restTemplate.getForObject(url, CurrencyVO.class);
        try {
            String currencyStr = this.generalFacility.getObjectMapper().writeValueAsString(currencyVO);
            this.kafkaProducer.sendMessage(this.applicationProperties.getTopicExchangeRate(), this.applicationProperties.getTopicExchangeRateGroupId(), currencyStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
