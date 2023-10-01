package org.tms;

import java.util.ArrayList;
import java.util.List;

public class BufferDataReader implements DataReader {

    private DataReader dataReader;
    private List<Integer> buffer = new ArrayList<>();

    public BufferDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }



    @Override
    public int read() {

        if (!buffer.isEmpty()) {
            return buffer.remove(0);
        }

        System.out.println("Buffer is empty. Filling by 10 elements...");
        for (int i = 0; i < 10; i++) {
            buffer.add(dataReader.read());
        }

        return buffer.remove(0);
    }
}