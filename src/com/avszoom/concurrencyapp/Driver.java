package com.avszoom.concurrencyapp;

import com.avszoom.concurrencyapp.experiments.BlockingQueueIface;
import com.avszoom.concurrencyapp.experiments.JavaBlockingQueueExperiment;

public class Driver {

    public static void main(String args[]){

        System.out.println("Starting Experiment with Internal Java Blocking Queue---------------");
        BlockingQueueIface blockingQueueIface = new JavaBlockingQueueExperiment();
        System.out.println(blockingQueueIface.startExperiment(5,5300));
    }
}
