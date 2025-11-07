package com.devsuperior.produto_departamento.dto;

public class DepartmentGetDTO {

    private Long id;
    private String name;
    public DepartmentGetDTO() {
    }
    public DepartmentGetDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
