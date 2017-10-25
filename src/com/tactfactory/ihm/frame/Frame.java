package com.tactfactory.ihm.frame;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Frame extends JFrame {

    /** Default constructor. */
    public Frame() {
        super();
    }

    /** Initialize the frame. */
    public final void initialize() {
        this.initLayout();
        this.initFrame();
    }

    protected void initFrame() {
        // this.setSize(800, 600);
        this.pack();
    }

    /**
     * Initialize the main.
     *
     * @return The content pane.
     */
    protected Container initLayout() {
        /*
         * Documentations:
         * https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
         */
        Container pane = this.getContentPane();
        BorderLayout layout = new BorderLayout();

        pane.setLayout(layout);

        return pane;
    }
}
