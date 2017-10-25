package com.tactfactory.application;

import java.util.HashMap;
import java.util.Map;

import com.tactfactory.ihm.frame.Frame;
import com.tactfactory.ihm.frame.impl.MainFrame;
import com.tactfactory.ihm.frame.impl.text.HelloFrame;
import com.tactfactory.ihm.frame.impl.text.MenuFrame;

/** Manage the IHM screen. */
public class Router {
    private Map<Class<?>, Frame> frames;
    private Class<? extends Frame> active;

    private static Router instance = null;

    static {
        Router.instance = new Router();
    }

    private Router() {
        this.frames = new HashMap<>();

        this.add(new MainFrame());
        this.add(new HelloFrame());
        this.add(new MenuFrame());
    }

    protected Router getInstance() {
        return Router.instance;
    }

    /** Record the given frame. */
    private boolean add(Frame newFrame) {
        newFrame.initialize();

        return this.frames.put(newFrame.getClass(), newFrame) == null;
    }

    /** Go to given frame. */
    public static boolean goTo(Class<? extends Frame> frameClass) {
        if (frameClass.equals(instance.active)) {
            return true;
        }

        Frame frame = instance.frames.get(frameClass);

        if (frame != null) {
            if (instance.active != null) {
                Frame current = instance.frames.get(instance.active);

                frame.setLocation(current.getLocation());
                current.setVisible(false);
            }

            frame.setVisible(true);
            instance.active = frameClass;

            return true;
        }

        return false;
    }
}
