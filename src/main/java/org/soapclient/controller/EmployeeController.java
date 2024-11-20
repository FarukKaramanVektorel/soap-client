package org.soapclient.controller;



import org.soap.wsdl.Employee;
import org.soap.wsdl.GetEmployeeResponse;
import org.soapclient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        GetEmployeeResponse response = employeeService.getEmployee(id);
        return response.getEmployee();
    }
}
