package com.izi.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderLineTask extends ReadTask{
    public BufferedReaderLineTask() {
        setName("BufferedReaderLineByLine");
    }

    @Override
    public void read() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("random-junk.in");
        InputStreamReader inf = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(inf, 1024*1024);
        String in = br.readLine();

        int size;
        for(size = 0; in != null && !"".equals(in); ++size) {
            in = br.readLine();
        }
    }
}
