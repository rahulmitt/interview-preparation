package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public class CompressionBasedDataSource extends DataSourceDecorator{
    public CompressionBasedDataSource(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        System.out.println("writing compressed data to file");
    }

    @Override
    public String readData() {
        return "decompressed data";
    }
}
