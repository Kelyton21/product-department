package com.devsuperior.produto_departamento.dto;
import com.devsuperior.produto_departamento.entities.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private DepartmentDTO department;

    public ProductDTO() {
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public DepartmentDTO getDepartment() {
        return department;
    }
}
