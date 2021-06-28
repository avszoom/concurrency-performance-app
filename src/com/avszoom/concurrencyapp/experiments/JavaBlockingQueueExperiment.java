package com.avszoom.concurrencyapp.experiments;

import com.avszoom.concurrencyapp.models.ExperimentResult;
import com.avszoom.concurrencyapp.models.TimeStampProducer;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JavaBlockingQueueExperiment implements BlockingQueueIface {

    final int QUEUE_SIZE = 10;
    boolean exit = false;
    int producedItem = 0;
    int consumedItem = 0;

    synchronized public int getProducedItem() {
        return producedItem;
    }

    synchronized public void setProducedItem(int producedItem) {
        this.producedItem = producedItem;
    }

    synchronized public int getConsumedItem() {
        return consumedItem;
    }

    synchronized public void setConsumedItem(int consumedItem) {
        this.consumedItem = consumedItem;
    }

    BlockingQueue<Timestamp> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    final Runnable producer = () -> {
        while(!exit){
            try {
                Timestamp ts = TimeStampProducer.createTimeStamp();
                this.queue.put(ts);
                System.out.println("produced: " + ts.toString());
                setProducedItem(getProducedItem()+1);
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    };

    final Runnable consumer = () -> {
        while(!exit){
            try {
                Timestamp ts = this.queue.take();
                System.out.println("consumed: " + ts.toString());
                setConsumedItem(getConsumedItem()+1);
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    };

    @Override
    public ExperimentResult startExperiment(int tCount, int timeToRun) {

        Instant start = Instant.now();

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        for(int tcnt=1;tcnt<=tCount;tcnt++){
            Thread thread = new Thread(producer);
            thread.start();
        }

        for(int tcnt=1;tcnt<=tCount;tcnt++){
            Thread thread = new Thread(consumer);
            thread.start();
        }
        Long duration;
        while((duration = Duration.between(start, Instant.now()).toMillis()) < timeToRun){}
        exit = true;
        return new ExperimentResult(getProducedItem(),getConsumedItem(),duration.intValue(),tCount);
    }
}
