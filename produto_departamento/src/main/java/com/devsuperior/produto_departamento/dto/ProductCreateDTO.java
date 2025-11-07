package com.devsuperior.produto_departamento.dto;

public class ProductCreateDTO {
        private String name;
        private double price;
        private Long idDepartment;

    public ProductCreateDTO(String name, double price, Long idDepartment) {
        this.name = name;
        this.price = price;
        this.idDepartment = idDepartment;
    }

    public double getPrice() {
        return price;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public String getName() {
        return name;
    }
}
