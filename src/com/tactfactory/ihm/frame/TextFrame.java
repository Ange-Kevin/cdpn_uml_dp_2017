package com.tactfactory.ihm.frame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextField;

import com.tactfactory.ihm.button.impl.GoToButton;

@SuppressWarnings("serial")
public abstract class TextFrame extends Frame {

    private String text;

    public TextFrame(String text) {
        this.text = text;
    }

    @Override
    protected Container initLayout() {
        Container pane = super.initLayout();

        JTextField textField = new JTextField(this.text + "coucou");
        textField.setEditable(false);

        pane.add(textField);
        pane.add(new GoToButton("Back", "main"), BorderLayout.EAST);

        return pane;
    }
}
