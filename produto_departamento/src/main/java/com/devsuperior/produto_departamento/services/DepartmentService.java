package com.devsuperior.produto_departamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.produto_departamento.dto.DepartmentDTO;
import com.devsuperior.produto_departamento.entities.Department;
import com.devsuperior.produto_departamento.repositories.DepartmentRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Long createDepartment(DepartmentDTO departmentDTO) {
        // DTO -> Entity
        var entity = new Department(null, departmentDTO.getName());
        var departmentSave = departmentRepository.save(entity);
        return departmentSave.getId();
    }

    @Transactional
    public DepartmentDTO update(Long id, DepartmentDTO departmentDTO) {
        
        var department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        
        if (departmentDTO.getName() == null) {
            throw new RuntimeException("Department name cannot be null");
            
        }
        department.setName(departmentDTO.getName());
        
        var updatedDepartment = departmentRepository.save(department);
        
        return new DepartmentDTO(updatedDepartment.getName());
    }

    @Transactional
    public void delete(Long id) {
        var department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        departmentRepository.delete(department);
    }
    
    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = departments.stream()
                .map(department -> new DepartmentDTO(department.getName()))
                .toList();
        return departmentDTOs;
    }
}
