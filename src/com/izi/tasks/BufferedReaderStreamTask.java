package com.izi.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BufferedReaderStreamTask extends ReadTask{
    public BufferedReaderStreamTask(File file) {
        setName("BufferedReaderStream");
        setLines(new ArrayList<>());
        setFile(file);
    }

    @Override
    public void read() throws FileNotFoundException {
        InputStream input = new FileInputStream(getFile());
        InputStreamReader inf = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(inf, 1024*1024);
        getLines().addAll(br.lines().collect(Collectors.toList()));
    }
}
