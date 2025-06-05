package com.devsuperior.produto_departamento.dto;

import com.devsuperior.produto_departamento.entities.Department;

public class ProductUpdateDTO {
    
    private String name;
    private Double price;
    private Department department;

    public ProductUpdateDTO() {
    }
    public ProductUpdateDTO(String name, Double price, Department department) {
        this.name = name;
        this.price = price;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
