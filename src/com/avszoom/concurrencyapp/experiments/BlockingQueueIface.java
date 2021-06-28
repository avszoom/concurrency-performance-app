package com.avszoom.concurrencyapp.experiments;

import com.avszoom.concurrencyapp.models.ExperimentResult;

public interface BlockingQueueIface {
    // run experiment for timeToRun millisecond for tCount producers and consumers thread.
    ExperimentResult startExperiment(int tCount, int timeToRun);
}
