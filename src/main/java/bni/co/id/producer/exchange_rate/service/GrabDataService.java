package bni.co.id.producer.exchange_rate.service;

import bni.co.id.producer.exchange_rate.config.ApplicationProperties;
import bni.co.id.producer.exchange_rate.entity.MRate;
import bni.co.id.producer.exchange_rate.entity.TransactionRateDetail;
import bni.co.id.producer.exchange_rate.entity.TransactionRateHeader;
import bni.co.id.producer.exchange_rate.repository.MRateRepository;
import bni.co.id.producer.exchange_rate.repository.TransactionRateDetailRepository;
import bni.co.id.producer.exchange_rate.repository.TransactionRateHeaderRepository;
import bni.co.id.producer.exchange_rate.util.GeneralFacility;
import bni.co.id.producer.exchange_rate.vo.CurrencyTabularVO;
import bni.co.id.producer.exchange_rate.vo.CurrencyVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private TransactionRateDetailRepository transactionRateDetailRepository;

    @Autowired
    private TransactionRateHeaderRepository transactionRateHeaderRepository;

    @Autowired
    private MRateRepository rateRepository;

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

    public List<CurrencyTabularVO> getCurrency(String pCurrencyId) {
        Optional<MRate> rate = this.rateRepository.findById(pCurrencyId);
        List<CurrencyTabularVO> result = new ArrayList<>();

        List<TransactionRateDetail> trxDetailList = this.transactionRateDetailRepository.findByCurrencyId(rate.orElseThrow());
        for(TransactionRateDetail det : trxDetailList){
            CurrencyTabularVO tab = new CurrencyTabularVO();
            tab.setBaseCurrencyId("USD");
            tab.setCurrencyId(det.getCurrencyId().getCurrencyId());
            tab.setRate(det.getRate().toString());
            tab.setTransactionTime(det.getTransactionRateHeaderId().getTrxDate());
            result.add(tab);
            log.info("DDD " + det.getRate());
        }
        return result;
    }
}
