package com.tactfactory.application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tactfactory.controller.Controller;
import com.tactfactory.ihm.frame.Frame;

public class ControllerRouter {
    private Set<String> actions = null;
    private Map<String, Method> methods = new HashMap<>();
    private Controller instance = null;

    public ControllerRouter(Controller controller) {
        this.instance = controller;

        for (Method method : this.instance.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }

        this.actions = this.methods.keySet();
    }

    /**
     * Try to invoke the required action.
     * @param routeName
     * @return Frame instance if success, nulll otherwise.
     */
    public Frame invoke(String routeName) {
        if (this.hasAction(routeName)) {
            try {
                return (Frame) this.methods.get(routeName).invoke(this.instance);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /** Tests then returns if current controller representation contains action. */
    private boolean hasAction(String actionName) {
        return this.actions.contains(actionName);
    }
}
