package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}
