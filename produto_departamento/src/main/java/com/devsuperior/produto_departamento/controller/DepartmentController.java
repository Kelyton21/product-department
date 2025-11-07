package com.devsuperior.produto_departamento.controller;

import java.net.URI;
import java.util.List;

import com.devsuperior.produto_departamento.dto.DepartmentGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
    public ResponseEntity<Void> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        
        Long newDepartmentId = departmentService.createDepartment(departmentDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest() // pego a URL da minha api
                .path("/{id}") // adiciono o /{id} no final da URL
                .buildAndExpand(newDepartmentId) // substituo o {id} pelo id do novo departamento
                .toUri(); // converto para URI

        return ResponseEntity.created(location).build(); // retorno um 201 
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build(); // retorno um 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO uDepartmentDTO = departmentService.update(id, departmentDTO);
        return ResponseEntity.ok().body(uDepartmentDTO); // retorno um 200 com o corpo da resposta
    }
    
    @GetMapping
    public ResponseEntity<List<DepartmentGetDTO>> findAll(){
        var departmentDTOs = departmentService.findAll();
        return ResponseEntity.ok().body(departmentDTOs); // retorno um 200 com o corpo da resposta
    }
    
}
