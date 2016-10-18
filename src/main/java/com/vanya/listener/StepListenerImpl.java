package com.vanya.listener;

import javax.batch.api.listener.StepListener;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */

public class StepListenerImpl implements StepListener {
    @Override
    public void beforeStep() throws Exception {
        System.out.println("~~~~~~~~~~~~~~~Start step");
    }

    @Override
    public void afterStep() throws Exception {
        System.out.println("~~~~~~~~~~~~Stop step");
    }
}
