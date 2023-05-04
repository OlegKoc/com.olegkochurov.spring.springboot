package com.olegkochurov.spring.springboot.dao;



import com.olegkochurov.spring.springboot.entity.Employee;
//import com.olegkochurov.spring.springboot.spring_course_sspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>// <Employee - c каким entity работаем и <Integer> - PrimaryKey
{
public List<Employee> findAllByName(String name);
}
