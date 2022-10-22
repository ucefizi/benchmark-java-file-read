package com.izi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Main.Readers readers = new Main.Readers();

        System.out.println("running scanner with line by line");
        long startScannerLineMillis = Instant.now().toEpochMilli();
        readers.scannerLine();
        long endScannerLineMillis = Instant.now().toEpochMilli();
        System.out.println("Scanner with line by line took " + (endScannerLineMillis - startScannerLineMillis) + " ms");

        System.out.println("running Buffered Reader with entire file");
        long startBufferedAllMillis = Instant.now().toEpochMilli();
        readers.bufferedAll(1024*1024);
        long endBufferedAllMillis = Instant.now().toEpochMilli();
        System.out.println("Buffered Reader with entire file took " + (endBufferedAllMillis - startBufferedAllMillis) + " ms");

        System.out.println("running Buffered Reader with line by line");
        long startBufferedLineMillis = Instant.now().toEpochMilli();
        readers.bufferedLine(1024*1024);
        long endBufferedLineMillis = Instant.now().toEpochMilli();
        System.out.println("Buffered Reader with line by line took " + (endBufferedLineMillis - startBufferedLineMillis) + " ms");
    }

    private static class Readers {
        private Readers() {
        }

        private void scannerLine() {
            InputStream input = this.getClass().getResourceAsStream("random-junk.in");
            InputStreamReader inf = new InputStreamReader(input);
            Scanner sc = new Scanner(inf);
            String in = sc.nextLine();

            int size;
            for(size = 1; sc.hasNext(); ++size) {
                in = sc.nextLine();
            }

            System.out.println("nbr lines " + size);
        }

        private void bufferedAll(int bufferSize) {
            System.out.println("Buffer size " + bufferSize);
            InputStream input = this.getClass().getResourceAsStream("random-junk.in");
            InputStreamReader inf = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(inf, bufferSize);
            List<String> lines = br.lines().collect(Collectors.toList());
            int size = lines.size();
            System.out.println("nbr lines " + size);
        }

        private void bufferedLine(int bufferSize) throws IOException {
            System.out.println("Buffer size " + bufferSize);
            InputStream input = this.getClass().getResourceAsStream("random-junk.in");
            InputStreamReader inf = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(inf, bufferSize);
            String in = br.readLine();

            int size;
            for(size = 1; in != null && !"".equals(in); ++size) {
                in = br.readLine();
            }

            System.out.println("nbr lines " + size);
        }
    }
}
