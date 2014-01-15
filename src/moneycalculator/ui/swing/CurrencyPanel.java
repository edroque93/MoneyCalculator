package moneycalculator.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.ui.CurrencyDialog;

public class CurrencyPanel extends JPanel implements CurrencyDialog {

    private Currency currency;

    public CurrencyPanel() {
        this(CurrencySet.getInstance().search("Euro")[0]);
    }

    public CurrencyPanel(Currency currency) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        this.createComponents();
    }

    private void createComponents() {
        this.add(createComboBox());
    }

    private JComboBox createComboBox() {
        String[] currencies = CurrencySet.getInstance().getArray();
        JComboBox comboBox = new JComboBox(currencies);
        comboBox.setSelectedIndex(0);
        currency = CurrencySet.getInstance().search(comboBox.getSelectedItem().toString())[0];
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    currency = CurrencySet.getInstance().search(event.getItem().toString())[0];
            }

        });
        return comboBox;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }
}
