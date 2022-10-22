package com.izi.tasks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReaderStreamTask extends ReadTask{
    @Override
    public void read() {
        InputStream input = this.getClass().getResourceAsStream("random-junk.in");
        InputStreamReader inf = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(inf, 1024*1024);
        List<String> lines = br.lines().collect(Collectors.toList());
    }
}
