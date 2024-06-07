package com.dragarwal.wijmogridbackend.repo;

import com.dragarwal.wijmogridbackend.model.EmployeeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEmpRepo extends JpaRepository<EmployeeDetailsEntity , Long> {
    List<EmployeeDetailsEntity> findByEmployeeName(String employeeName);
}
