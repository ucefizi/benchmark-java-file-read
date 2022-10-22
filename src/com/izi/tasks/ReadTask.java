package com.izi.tasks;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class ReadTask implements Task{
    private long runTime;
    private String name;
    private List<String> lines;
    private File file;

    @Override
    public abstract void read() throws IOException;

    @Override
    public long getRunTime() {
        return runTime;
    }

    @Override
    public  void setRunTime(long runTime){
        this.runTime = runTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }

    @Override
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }
}
