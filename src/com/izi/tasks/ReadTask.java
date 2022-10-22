package com.izi.tasks;

import java.io.IOException;

public abstract class ReadTask implements Task{
    private long runTime;

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
}
