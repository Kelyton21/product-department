package com.devsuperior.produto_departamento.dto;

public class DepartmentDTO {
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
