package com.interviewpedia.preparation.dp.gof._2_structural.composite.composite;

import com.interviewpedia.preparation.dp.gof._2_structural.composite.component.Department;

import java.util.ArrayList;
import java.util.List;

public class HeadOfDepartment implements Department {
    private int id;
    private String name;
    private List<Department> childDept;

    public HeadOfDepartment(int id, String name) {
        this.id = id;
        this.name = name;
        childDept = new ArrayList<>();
    }

    public void addDept(Department dept) {
        childDept.add(dept);
    }

    public boolean removeDept(Department dept) {
        return childDept.remove(dept);
    }

    @Override
    public void printDepartmentName() {
        childDept.forEach(d -> d.printDepartmentName());
    }
}
