package moneycalculator.persistence;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Number;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Date date, Currency to, Currency from) {
        return new ExchangeRate(date, from, to, new Number(0.75f));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(new Date(), from, to, new Number(0.75));
    }
}
