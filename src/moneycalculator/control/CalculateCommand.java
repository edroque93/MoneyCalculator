package moneycalculator.control;

import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyViewer;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    private Number calculateAmount() {
        return moneyDialog.getMoney().getAmount().multiply(getExchangeRate());
    }

    private Number getExchangeRate() {
        return null;
    }

}
