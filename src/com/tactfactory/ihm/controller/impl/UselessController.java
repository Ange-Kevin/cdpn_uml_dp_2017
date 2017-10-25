package com.tactfactory.ihm.controller.impl;

import com.tactfactory.ihm.controller.Controller;
import com.tactfactory.ihm.frame.Frame;
import com.tactfactory.ihm.frame.impl.MainFrame;
import com.tactfactory.ihm.frame.impl.text.HelloFrame;
import com.tactfactory.ihm.frame.impl.text.MenuFrame;

public class UselessController implements Controller {

    public Frame helloAction() {
        return new HelloFrame();
    }

    public Frame menuAction() {
        return new MenuFrame();
    }

    public Frame mainAction() {
        return new MainFrame();
    }
}
