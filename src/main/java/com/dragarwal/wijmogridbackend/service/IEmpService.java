package com.dragarwal.wijmogridbackend.service;

import com.dragarwal.wijmogridbackend.model.EmployeeDetailsEntity;

import java.util.List;

public interface IEmpService {

    List<EmployeeDetailsEntity> getAllEmployee();

    EmployeeDetailsEntity createEmployee(EmployeeDetailsEntity employeeDetails);

    void removeDuplicates(String searchTerm);

    List<EmployeeDetailsEntity> searchEmployee(String employeeName);

    List<EmployeeDetailsEntity> sortEmployee(String sortBy , String orderType);
}
