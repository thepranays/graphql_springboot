package com.graphql.example.models;

public class Student {
    private String name;
    private Branch branch;
    private Integer id;

    public Student(String name, Branch branch,Integer id) {
        this.name = name;
        this.branch = branch;
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
