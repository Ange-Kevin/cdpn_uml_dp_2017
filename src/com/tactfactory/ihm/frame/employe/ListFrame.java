package com.tactfactory.ihm.frame.employe;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextField;

import com.tactfactory.dao.EmployeDAO;
import com.tactfactory.ihm.button.impl.GoToButton;
import com.tactfactory.ihm.frame.Frame;
import com.tactfactory.model.Employe;

@SuppressWarnings("serial")
public class ListFrame extends Frame {

    @Override
    protected Container initLayout() {
        Container pane = super.initLayout();

        JTextField textField = new JTextField(this.generateList());
        textField.setEditable(false);

        pane.add(textField);
        pane.add(new GoToButton("Back", "main"), BorderLayout.EAST);

        return pane;
    }

    private String generateList() {
        String result = "";

        for (Employe e : EmployeDAO.getInstance().findAll()) {
            String firstname = e.getFirstname();
            String lastname = e.getLastname().toUpperCase();
            result += String.format(" - %s %s\n", lastname, firstname);
        }

        // TODO Finish.

        return result;
    }
}
