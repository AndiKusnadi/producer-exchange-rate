package bni.co.id.producer.exchange_rate.service;

import bni.co.id.producer.exchange_rate.config.ApplicationProperties;
import bni.co.id.producer.exchange_rate.vo.CurrencyVO;
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

    public void grabDataCurrency(){
        System.out.println(this.applicationProperties.getCurrencyRateUrl());
        System.out.println(this.applicationProperties.getCurrencyRateApiKey());
        log.info("aaaeee"  + this.applicationProperties.getCurrencyRateUrl());
        String url = this.applicationProperties.getCurrencyRateUrl() + this.applicationProperties.getCurrencyRateApiKey();
        CurrencyVO currencyVO = this.restTemplate.getForObject(url, CurrencyVO.class);

    }

}
