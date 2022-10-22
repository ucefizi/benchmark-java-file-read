package com.izi;

import com.izi.tasks.BufferedReaderLineTask;
import com.izi.tasks.BufferedReaderStreamTask;
import com.izi.tasks.ScannerTask;
import com.izi.tasks.Task;

import java.util.HashMap;
import java.util.Map;

public class RunBenchMarks {

    private static final Map<Thread, Task> benchMarkThreads = new HashMap<>();

    private static void initialise() {
        Task scannerTask = new ScannerTask();
        Thread scannerThread = new Thread(scannerTask);
        benchMarkThreads.put(scannerThread, scannerTask);

        Task bufferedReaderStreamTask = new BufferedReaderStreamTask();
        Thread bufferedReaderStreamThread = new Thread(bufferedReaderStreamTask);
        benchMarkThreads.put(bufferedReaderStreamThread, bufferedReaderStreamTask);

        Task bufferedReaderLineTask = new BufferedReaderLineTask();
        Thread bufferedReaderLineThread = new Thread(bufferedReaderLineTask);
        benchMarkThreads.put(bufferedReaderLineThread, bufferedReaderLineTask);
    }

    public static void main(String[] args) throws InterruptedException {

        initialise();

        for (Thread thread: benchMarkThreads.keySet()) {
            System.out.println("Starting " + benchMarkThreads.get(thread).getName() + " thread");
            thread.start();
        }

        for (Thread thread: benchMarkThreads.keySet()) {
            thread.join();
            System.out.println(benchMarkThreads.get(thread).getName() + " thread took " + benchMarkThreads.get(thread).getRunTime() + " ms");
        }
    }
}
