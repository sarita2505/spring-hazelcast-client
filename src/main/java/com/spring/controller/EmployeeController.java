package com.spring.controller;

import com.spring.dao.impl.EmployeeDtaImpl;
import com.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDtaImpl employeeDta;

    Integer i=0;
    @PostMapping("/save")
    public ResponseEntity<List<Employee>> saveData(@RequestBody Employee employee){
       employeeDta.save(employee);
       return ResponseEntity.ok(employeeDta.find());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateData(@RequestBody Employee employee,@PathVariable("id")Integer id ){
        employee=employeeDta.update(employee,id);
        return new ResponseEntity(employee,HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Integer id){
        Employee employee=new Employee();
        employee=employeeDta.findById(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<List<Employee>> find(){
        List<Employee>employee=new ArrayList<>();
        employee=employeeDta.find();
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){

     i=employeeDta.delete(id);
        return  ResponseEntity.ok(i+"rows deleted");
    }
}
