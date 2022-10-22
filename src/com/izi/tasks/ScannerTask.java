package com.izi.tasks;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerTask extends ReadTask{

    public ScannerTask() {
        setName("Scanner");
    }

    @Override
    public void read() {
        InputStream input = this.getClass().getResourceAsStream("random-junk.in");
        InputStreamReader inf = new InputStreamReader(input);
        Scanner sc = new Scanner(inf);
        String in = sc.nextLine();

        int size;
        for(size = 1; sc.hasNext(); ++size) {
            in = sc.nextLine();
        }
    }
}
