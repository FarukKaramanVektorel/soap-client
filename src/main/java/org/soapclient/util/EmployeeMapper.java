package org.soapclient.util;

import org.soap.wsdl.Employee;
import org.soapclient.dto.EmployeeDTO;
import org.soapclient.model.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity toEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(employee.getId());
        entity.setFirstname(employee.getFirstname());
        entity.setLastname(employee.getLastname());
        entity.setJobtitle(employee.getJobtitle());
        entity.setEmail(employee.getEmail());
        return entity;
    }

    public EmployeeDTO toDTO(EmployeeEntity entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setJobtitle(entity.getJobtitle());
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFirstname() + " " + entity.getLastname());
        return dto;
    }
}