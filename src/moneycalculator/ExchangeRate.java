package moneycalculator;


import java.util.Date;
import moneycalculator.Currency;

public class ExchangeRate {

    private Currency from, to;
    private Number rate;
    private Date date;

    public ExchangeRate(Currency from, Currency to, Number rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Number getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }
    
}
