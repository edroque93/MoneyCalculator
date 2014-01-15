package moneycalculator;

import java.util.HashMap;
import java.util.Map;
import moneycalculator.control.Command;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.ui.swing.ApplicationFrame;

public class Application {
    
    private ApplicationFrame frame;
    private Map<String, Command> commandMap;
    
    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        // Load currency..
        CurrencySet.getInstance().add(new Currency("EUR", "Euro", "€"));
        CurrencySet.getInstance().add(new Currency("USD", "Dólar americano", "$"));
        // Load exchange rate...
        
        
        
        frame = new ApplicationFrame();//createActionListenerFactory());
        //frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private void createCommands() {
        commandMap = new HashMap<>();
       // commandMap.put("Calculate", new CalculateCommand());
    }
}
