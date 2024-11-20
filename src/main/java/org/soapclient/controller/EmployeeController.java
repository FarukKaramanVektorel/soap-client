package org.soapclient.controller;



import org.soap.wsdl.Employee;
import org.soap.wsdl.GetEmployeeResponse;
import org.soapclient.dto.EmployeeDTO;
import org.soapclient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }
}
