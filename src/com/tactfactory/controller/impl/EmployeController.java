package com.tactfactory.controller.impl;

import com.tactfactory.controller.Controller;
import com.tactfactory.ihm.frame.Frame;
import com.tactfactory.ihm.frame.employe.ListFrame;

public class EmployeController implements Controller {

    public Frame listEmployeAction() {
        return new ListFrame();
    }
}
