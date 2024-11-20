package org.soapclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String jobtitle;
    private String email;
    private String fullName; // firstname + lastname birleşimi


    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }
}
