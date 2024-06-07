package com.dragarwal.wijmogridbackend.model;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "employee_details")
public class EmployeeDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    private String employeeName;

    private String departmentName;

    private long salary;
}
