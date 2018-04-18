package com.example.entities;

public class EntityField <T>{
    private String name;
    private T value;
    private Integer dataIndex;

    public EntityField() {}

    public EntityField(String name, T value, Integer dataIndex) {
        this.name = name;
        this.value = value;
        this.dataIndex = dataIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Integer getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(Integer dataIndex) {
        this.dataIndex = dataIndex;
    }

    public static void main(String[] args) {
        //Entity
    }
}
