package com.dragarwal.wijmogridbackend.controller;

import com.dragarwal.wijmogridbackend.model.EmployeeDetailsEntity;
import com.dragarwal.wijmogridbackend.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmpController {
    @Autowired
    IEmpService iEmpService;

    @GetMapping("/allemp")
    public List<EmployeeDetailsEntity> getAllEmployees() {
        return iEmpService.getAllEmployee();
    }

    @PostMapping("/addemp")
    public EmployeeDetailsEntity addEmployee(@RequestBody EmployeeDetailsEntity employeeDetails) {
        return iEmpService.createEmployee(employeeDetails);
    }

    @DeleteMapping("/removeDuplicates")
    public void removeDuplicates(@RequestParam(required = false) String searchTerm) {
        iEmpService.removeDuplicates(searchTerm);
    }

    @GetMapping("/searchEmployee")
    public List<EmployeeDetailsEntity> searchEmployee(@RequestParam String employeeName) {
        return iEmpService.searchEmployee(employeeName);
    }

    @GetMapping("/sortEmployees")
    public List<EmployeeDetailsEntity> sortEmployees(@RequestParam String sortBy, @RequestParam String sortOrder) {
        return iEmpService.sortEmployee(sortBy, sortOrder);
    }
}
