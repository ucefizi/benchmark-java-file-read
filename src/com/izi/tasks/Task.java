package com.izi.tasks;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Task extends Runnable {

    @Override
    default void run() {
        long starMicros = ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());

        try {
            read();
        } catch (IOException e) {
            System.out.printf("Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }

        long endMicros = ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
        setRunTime(endMicros - starMicros);
    }

    void read() throws IOException;
    long getRunTime();
    void setRunTime(long runTime);
    String getName();
    void setName(String name);
    List<String> getLines();
    void setLines(List<String> lines);
    File getFile();
    void setFile(File file);
}
