package com.interviewpedia.preparation.dp.gof._2_structural.composite.leaf;

import com.interviewpedia.preparation.dp.gof._2_structural.composite.component.Department;

public class SalesDept implements Department {
    protected int id;
    private String name;

    @Override
    public void printDepartmentName() {
        System.out.println(id + " :: " + name);
    }
}
