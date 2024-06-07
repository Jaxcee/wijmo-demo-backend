package com.dragarwal.wijmogridbackend.service;

import com.dragarwal.wijmogridbackend.model.EmployeeDetailsEntity;
import com.dragarwal.wijmogridbackend.repo.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmpService implements IEmpService {
    @Autowired
    private IEmpRepo iEmpRepo;

    @Override
    public List<EmployeeDetailsEntity> getAllEmployee() {
        return iEmpRepo.findAll();
    }

    @Override
    public EmployeeDetailsEntity createEmployee(EmployeeDetailsEntity employeeDetails) {
        iEmpRepo.save(employeeDetails);
        return employeeDetails;
    }

    @Override
    public void removeDuplicates(String searchTerm) {
        List<EmployeeDetailsEntity> employeeDetailsEntities;
        if (searchTerm == null || searchTerm.isEmpty()) {
            employeeDetailsEntities = iEmpRepo.findAll();
        } else {
            employeeDetailsEntities = iEmpRepo.findByEmployeeName(searchTerm);
        }

        Set<String> uniqueEmployees = new HashSet<>();
        List<EmployeeDetailsEntity> duplicateEmployees = new ArrayList<>();

        for (EmployeeDetailsEntity employeeDetailsEntity : employeeDetailsEntities) {
            if (!uniqueEmployees.contains(employeeDetailsEntity.getEmployeeName())) {
                uniqueEmployees.add(employeeDetailsEntity.getEmployeeName());
            } else {
                duplicateEmployees.add(employeeDetailsEntity);
            }
        }

        iEmpRepo.deleteAll(duplicateEmployees);
        System.out.println("Duplicate employees deleted successfully");
    }

    @Override
    public List<EmployeeDetailsEntity> searchEmployee(String employeeName) {
        return iEmpRepo.findByEmployeeName(employeeName);
    }

    @Override
    public List<EmployeeDetailsEntity> sortEmployee(String sortBy, String orderType) {
        Sort sort = Sort.by(sortBy);
        sort = orderType.equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();
        return iEmpRepo.findAll(sort);
    }
}
