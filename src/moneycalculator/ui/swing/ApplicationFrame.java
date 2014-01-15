package moneycalculator.ui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    public ApplicationFrame() throws HeadlessException {
        this.setTitle("MoneyCalculator!");
        this.setMinimumSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createContent());
    }

    private JPanel createToolbar() {
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        toolbar.add(createCalculateButton());
        toolbar.add(createExitButton());
        return toolbar;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                exit();
            }
        });
        return button;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calculate();
            }
        });
        return button;
    }

    private void exit() {
        dispose();
    }

    private void calculate() {
        System.out.println("Calculating...");
    }

    private JPanel createContent() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new MoneyPanel());
        panel.add(new CurrencyPanel());
        return panel;
    }
}