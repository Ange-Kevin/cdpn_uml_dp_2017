package com.tactfactory.ihm.frame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextField;

import com.tactfactory.ihm.button.impl.GoToButton;
import com.tactfactory.ihm.frame.impl.MainFrame;

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
        pane.add(new GoToButton("Back", MainFrame.class), BorderLayout.EAST);

        return pane;
    }
}
