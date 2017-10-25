package com.tactfactory.ihm.button.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.tactfactory.application.Router;
import com.tactfactory.ihm.frame.Frame;

@SuppressWarnings("serial")
public class GoToButton extends JButton {

    public GoToButton() {
    }

    public GoToButton(Class<? extends Frame> destination) {
        this();

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Router.goTo(destination);
            }
        });
    }

    public GoToButton(String label, Class<? extends Frame> destination) {
        this(destination);

        this.setText(label);
    }
}
