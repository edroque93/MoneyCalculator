package moneycalculator;

import java.util.Map;
import moneycalculator.control.Command;
import moneycalculator.ui.swing.ApplicationFrame;

public class Application {
    
    private ApplicationFrame frame;
    private Map<String, Command> commandMap;
    
    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        
    }
}
