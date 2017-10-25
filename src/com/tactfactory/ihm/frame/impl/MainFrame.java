package com.tactfactory.ihm.frame.impl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tactfactory.ihm.button.impl.GoToButton;
import com.tactfactory.ihm.frame.Frame;

@SuppressWarnings("serial")
public class MainFrame extends Frame {

    public MainFrame() {
        super();

        this.setTitle("Application");
    }

    @Override
    protected Container initLayout() {
        Container pane = super.initLayout();

        JPanel panel = new JPanel();
        GridLayout subLayout = new GridLayout(10, 1);

        panel.add(generateAdText());
        panel.add(new GoToButton("Coucou", "hello"));
        panel.add(new GoToButton("Menu", "menu"));

        panel.setLayout(subLayout);

        pane.add(panel, BorderLayout.CENTER);

        return pane;
    }

    private JTextField generateAdText() {
        JTextField ad = new JTextField("Menu");
        ad.setEditable(false);
        ad.setHorizontalAlignment(JTextField.CENTER);

        return ad;
    }
}
