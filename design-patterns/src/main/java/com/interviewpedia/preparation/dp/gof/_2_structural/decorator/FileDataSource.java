package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("Writing to file: " + filename);
    }

    @Override
    public String readData() {
        return "data from " + filename;
    }
}
