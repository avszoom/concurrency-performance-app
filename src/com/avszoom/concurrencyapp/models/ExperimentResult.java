package com.avszoom.concurrencyapp.models;

public class ExperimentResult {

    private int producedItems;
    private int consumedItems;
    private int experimentTime;
    private int tcount;

    public ExperimentResult(int producedItems, int consumedItems, int experimentTime, int tcount) {
        this.producedItems = producedItems;
        this.consumedItems = consumedItems;
        this.experimentTime = experimentTime;
        this.tcount = tcount;
    }

    public int getProducedItems() {
        return producedItems;
    }

    public void setProducedItems(int producedItems) {
        this.producedItems = producedItems;
    }

    public int getConsumedItems() {
        return consumedItems;
    }

    public void setConsumedItems(int consumedItems) {
        this.consumedItems = consumedItems;
    }

    public int getExperimentTime() {
        return experimentTime;
    }

    public void setExperimentTime(int experimentTime) {
        this.experimentTime = experimentTime;
    }

    public int getTcount() {
        return tcount;
    }

    public void setTcount(int tcount) {
        this.tcount = tcount;
    }

    @Override
    public String toString() {
        return "ExperimentResult{" +
                "producedItems=" + producedItems +
                ", consumedItems=" + consumedItems +
                ", experimentTime=" + experimentTime +
                ", tcount=" + tcount +
                '}';
    }
}
