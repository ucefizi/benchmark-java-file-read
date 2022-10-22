package com.izi.tasks;

import java.io.*;
import java.util.ArrayList;

public class BufferedReaderLineTask extends ReadTask{
    public BufferedReaderLineTask(File file) {
        setName("BufferedReaderLineByLine");
        setLines(new ArrayList<>());
        setFile(file);
    }

    @Override
    public void read() throws IOException {
        InputStream input = new FileInputStream(getFile());
        InputStreamReader inf = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(inf, 1024*1024);
        String in = br.readLine();

        while (in != null && !"".equals(in)) {
            getLines().add(in);
            in = br.readLine();
        }
    }
}
