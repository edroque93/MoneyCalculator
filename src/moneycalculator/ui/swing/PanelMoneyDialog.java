package moneycalculator.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;

public class PanelMoneyDialog extends JPanel implements MoneyDialog {

    private String amount = "0";
    private CurrencyDialog currencyDialog;

    public PanelMoneyDialog() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        return textField;
    }

    @Override
    public Money getMoney() {
        return new Money(new Number(Double.parseDouble(amount)), currencyDialog.getCurrency());
    }

    private void createComponents() {
        this.add(createAmountWidget());
        this.add(createCurrencyDialogPanel());
    }

    private JTextField createAmountWidget() {
        final JTextField textField = new JTextField(amount, 10);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialogPanel() {
        PanelCurrencyDialog panel = new PanelCurrencyDialog();
        this.currencyDialog = panel;
        return panel;
    }

}
