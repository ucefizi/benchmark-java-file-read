package com.izi.tasks;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public interface Task extends Runnable {

    @Override
    default void run() {
        long starMillis = Instant.now().toEpochMilli();
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endMillis = Instant.now().toEpochMilli();
        setRunTime(endMillis - starMillis);
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
