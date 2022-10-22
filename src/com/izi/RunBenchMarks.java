package com.izi;

import com.izi.tasks.BufferedReaderLineTask;
import com.izi.tasks.BufferedReaderStreamTask;
import com.izi.tasks.ScannerTask;
import com.izi.tasks.Task;

public class RunBenchMarks {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("running scanner with line by line");
        Task scannerTask = new ScannerTask();
        Thread scannerThread = new Thread(scannerTask);
        scannerThread.start();

        System.out.println("running Buffered Reader with stream");
        Task bufferedReaderStreamTask = new BufferedReaderStreamTask();
        Thread bufferedReaderStreamThread = new Thread(bufferedReaderStreamTask);
        bufferedReaderStreamThread.start();

        System.out.println("running Buffered Reader with line by line");
        Task bufferedReaderLineTask = new BufferedReaderLineTask();
        Thread bufferedReaderLineThread = new Thread(bufferedReaderLineTask);
        bufferedReaderLineThread.start();

        scannerThread.join();
        System.out.println("Scanner with line by line took " + scannerTask.getRunTime() + " ms");

        bufferedReaderStreamThread.join();
        System.out.println("Buffered Reader with stream took " + bufferedReaderStreamTask.getRunTime() + " ms");

        bufferedReaderLineThread.join();
        System.out.println("Buffered Reader with line by line took " + bufferedReaderLineTask.getRunTime() + " ms");
    }
}
