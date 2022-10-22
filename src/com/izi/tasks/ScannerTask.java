package com.izi.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerTask extends ReadTask{

    public ScannerTask(File file) {
        setName("Scanner");
        setLines(new ArrayList<>());
        setFile(file);
    }

    @Override
    public void read() throws FileNotFoundException {
        InputStream input = new FileInputStream(getFile());
        InputStreamReader inf = new InputStreamReader(input);
        Scanner sc = new Scanner(inf);

        while (sc.hasNext()) {
            String in = sc.nextLine();
            getLines().add(in);
        }
    }
}
