package misc;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConversion {

    public static void main(String[] args) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        map.put("GBP", new HashMap<String,Double>() {{put("EUR",10.0);}});
        map.put("EUR", new HashMap<String,Double>() {{ put("USD",1.1);}});
        map.put("USD", new HashMap<String, Double>() {{put("JPY", 108.3);}});

//        System.out.print(currencyConverter( 10.0, "GBP", "USD",map));
    }
}
