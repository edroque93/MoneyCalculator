package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class MockCurrencySetLoader {

    private static MockCurrencySetLoader instance;

    private MockCurrencySetLoader() {
    }

    public static MockCurrencySetLoader getInstance() {
        if (instance == null)
            instance = new MockCurrencySetLoader();
        return instance;
    }

    public void load() {
        CurrencySet set = CurrencySet.getInstance();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("GBP", "British pound", "£"));
        set.add(new Currency("USD", "United States dollar", "$"));
        set.add(new Currency("CNY", "Chinese yuan", "元"));
        set.add(new Currency("AUD", "Australian dollar", "$"));
    }

}
