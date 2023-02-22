package com.interviewpedia.preparation.dp.gof._2_structural.decorator;

public abstract class DataSourceDecorator implements DataSource {
    protected DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
