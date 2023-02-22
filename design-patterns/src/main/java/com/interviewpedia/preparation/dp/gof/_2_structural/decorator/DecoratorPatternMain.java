package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public class DecoratorPatternMain {
    public static void main(String[] args) {
        DataSource ds = new FileDataSource("filename");
        ds.writeData("data");
        System.out.println(ds.readData());

        DataSource eds = new EncryptionBasedDataSource(ds);
        eds.writeData("data");
        System.out.println(eds.readData());

        DataSource cds = new CompressionBasedDataSource(ds);
        cds.writeData("data");
        System.out.println(cds.readData());
    }
}
