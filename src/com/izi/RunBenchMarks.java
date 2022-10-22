package com.izi;

import com.izi.tasks.BufferedReaderLineTask;
import com.izi.tasks.BufferedReaderStreamTask;
import com.izi.tasks.ScannerTask;
import com.izi.tasks.Task;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RunBenchMarks {

    private static final Map<Thread, Task> benchMarkThreads = new HashMap<>();

    private static void initialise() {
        File file = new File("random-junk.in");

        System.out.printf("Using file at path '%s' with size %d kb%n", file.getAbsolutePath(), file.length()/1024);

        Task scannerTask = new ScannerTask(file.getAbsoluteFile());
        Thread scannerThread = new Thread(scannerTask);
        benchMarkThreads.put(scannerThread, scannerTask);

        Task bufferedReaderStreamTask = new BufferedReaderStreamTask(file.getAbsoluteFile());
        Thread bufferedReaderStreamThread = new Thread(bufferedReaderStreamTask);
        benchMarkThreads.put(bufferedReaderStreamThread, bufferedReaderStreamTask);

        Task bufferedReaderLineTask = new BufferedReaderLineTask(file.getAbsoluteFile());
        Thread bufferedReaderLineThread = new Thread(bufferedReaderLineTask);
        benchMarkThreads.put(bufferedReaderLineThread, bufferedReaderLineTask);
    }

    public static void main(String[] args) throws InterruptedException {

        initialise();

        for (Thread thread: benchMarkThreads.keySet()) {
            System.out.printf("Starting %s thread%n", benchMarkThreads.get(thread).getName());
            thread.start();
        }

        for (Thread thread: benchMarkThreads.keySet()) {
            thread.join();
            System.out.printf(
                    "%s thread took %s µs to read %s lines%n",
                    benchMarkThreads.get(thread).getName(),
                    benchMarkThreads.get(thread).getRunTime(),
                    benchMarkThreads.get(thread).getLines().size()
            );
        }
    }
}
