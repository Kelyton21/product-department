package com.devsuperior.produto_departamento.dto;

import com.devsuperior.produto_departamento.entities.Department;

public class DepartmentDTO {
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Department entity) {
        this.name = entity.getName();
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
