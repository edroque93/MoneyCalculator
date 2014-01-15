package moneycalculator.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Number;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    private List<ExchangeRate> exchangeRateList;

    public MockExchangeRateLoader() {
        exchangeRateList = new ArrayList<>();
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("EUR")[0],
                        new Number(1)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("GBP")[0],
                        new Number(0.82)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("USD")[0],
                        new Number(1.36)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("CNY")[0],
                        new Number(8.2)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("AUD")[0],
                        new Number(1.53)));
    }

    @Override
    public ExchangeRate load(Date date, Currency to, Currency from) {
        return new ExchangeRate(date, from, to, getRate(from, to));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(new Date(), from, to, getRate(from, to));
    }

    private Number getRate(Currency from, Currency to) {
        Currency euro = CurrencySet.getInstance().search("EUR")[0];
        Number toEuro = null;

        for (ExchangeRate rate : exchangeRateList)
            if (rate.getFrom() == euro && rate.getTo() == from) {
                toEuro = rate.getRate();
                break;
            }

        if (toEuro != null)
            for (ExchangeRate rate : exchangeRateList)
                if (rate.getTo() == to && rate.getFrom() == euro)
                    return rate.getRate().divide(toEuro);

        return new Number(1);
    }

}
