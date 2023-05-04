package com.olegkochurov.spring.springboot.controller;


import com.olegkochurov.spring.springboot.entity.Employee;
import com.olegkochurov.spring.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // аннотация , которая управляет REST запросами  и ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {       // метод возвращает всех работников(List<Employee>
        var allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")  // метод для возвращения работника по его ID
    public Employee getEmployee(@PathVariable int id) throws NoSuchFieldException {    // @PathVariable - используется для получения временной переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchFieldException("There is employee with id = " + id + " in DataBase");
        }

        return employee;


    }

    @PostMapping("/employees")  // добавляем нового сотрудника
    //  @PostMapping связывает HTTP запрос, использующий HTTP  метод POST с методом контроллера
    public Employee addNewEmployee(@RequestBody Employee employee) {   // @RequestBody Employee employee - получаем работника из тела запроса
        employeeService.saveEmployee(employee);
        return employee;

    }

    @PutMapping("/employees")   // изменяем работика
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}") // удаляем работника по его ID
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id); // проверяем есть ли такой работник в базе

        employeeService.deleteEmployee(id);
        return "работник с ID = " + id + "удален";

    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }


}
