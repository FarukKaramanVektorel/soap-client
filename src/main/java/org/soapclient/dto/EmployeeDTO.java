package org.soapclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String jobtitle;
    private String email;
    private String fullName;

    // fullName getter'ı override edildi
    public String getFullName() {
        return firstname + " " + lastname;
    }

    // fullName setter'ı
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}