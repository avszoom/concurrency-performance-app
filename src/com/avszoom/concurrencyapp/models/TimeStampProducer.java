package com.avszoom.concurrencyapp.models;

import java.sql.Timestamp;

public class TimeStampProducer {

    public static Timestamp createTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
