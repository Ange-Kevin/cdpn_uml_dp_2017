package com.tactfactory.application;

import java.util.ArrayList;

import com.tactfactory.ihm.controller.Controller;
import com.tactfactory.ihm.controller.impl.UselessController;
import com.tactfactory.ihm.frame.Frame;

/** Manage the IHM screen. */
public class Router {
    private Frame active = null;

    private static volatile Router instance = null;
    private ArrayList<ControllerRouter> controllers;

    static {
        Router.instance = new Router();
    }

    private Router() {
        this.controllers = new ArrayList<ControllerRouter>();

        this.add(new UselessController());
    }

    protected Router getInstance() {
        return Router.instance;
    }

    /** Record the given Controller. */
    private boolean add(Controller controller) {
        return this.controllers.add(new ControllerRouter(controller));
    }

    /** Go to required route. */
    public static boolean goTo(String routeName) {
        routeName += "Action";

        for (ControllerRouter controller : instance.controllers) {
            Frame frame = controller.invoke(routeName);

            if (frame != null) { // New frame loaded.
                if (instance.active != null) {
                    Frame current = instance.active;

                    frame.setLocation(current.getLocation());
                    current.setVisible(false);
                }

                frame.initialize();
                frame.setVisible(true);
                instance.active = frame;

                return true;
            }
        }

        return false;
    }
}
