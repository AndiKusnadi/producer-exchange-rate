package bni.co.id.producer.exchange_rate.controller;

import bni.co.id.producer.exchange_rate.service.GrabDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
