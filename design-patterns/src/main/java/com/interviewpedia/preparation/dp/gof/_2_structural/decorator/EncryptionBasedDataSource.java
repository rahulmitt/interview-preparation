package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public class EncryptionBasedDataSource extends DataSourceDecorator{
    public EncryptionBasedDataSource(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        System.out.println("writing encrypted data to file");
    }

    @Override
    public String readData() {
        return "decrypted data";
    }
}
