package com.devsuperior.produto_departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.devsuperior.produto_departamento.dto.DepartmentDTO;
import com.devsuperior.produto_departamento.services.DepartmentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    @Autowired 
    private DepartmentService departmentService;

    @PostMapping
    public Long createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.createDepartment(departmentDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public DepartmentDTO updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        return departmentService.update(id, departmentDTO);
    }
    
    @GetMapping
    public List<DepartmentDTO> findAll(){
        return departmentService.findAll();
    }
    
}
