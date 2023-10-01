package org.tms;

public class LogDataReader implements DataReader {

    private DataReader dataReader;

    public LogDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public int read() {

        int read = dataReader.read();
        System.out.println("Reading from 'LogDataReader': " + read);

        return read;
    }
}