package bni.co.id.producer.exchange_rate.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrencyTabularVO {
    private String baseCurrencyId;
    private String currencyId;
    private String rate;
    private String transactionTime;
}
