package bni.co.id.producer.exchange_rate.controller;

import bni.co.id.producer.exchange_rate.service.GrabDataService;
import bni.co.id.producer.exchange_rate.vo.CurrencyTabularVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("generate")
@Slf4j
public class GenerateController {

    @Autowired
    private GrabDataService grabDataService;

    @GetMapping("get")
    public ResponseEntity<String> grabDataFromCurrency() {
        this.grabDataService.grabDataCurrency();

        return ResponseEntity.ok("OK");
    }

    @GetMapping("er/{currencyId}")
    public ResponseEntity<List<CurrencyTabularVO>> getExchangeRate(@PathVariable("currencyId") String pCurencyId) {
        List<CurrencyTabularVO> result = this.grabDataService.getCurrency(pCurencyId);
        return ResponseEntity.ok(result);
    }
}
