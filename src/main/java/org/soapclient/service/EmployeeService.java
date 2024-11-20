package org.soapclient.service;



import org.soap.wsdl.GetEmployeeRequest;
import org.soap.wsdl.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
// EmployeeService.java
@Service
public class EmployeeService {
    private static final String ENDPOINT_URL = "http://localhost:8010/ws";
    private static final String SOAP_ACTION = "http://localhost:8010/endpoint/getEmployeeRequest";

    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public EmployeeService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public GetEmployeeResponse getEmployee(int id) {
        GetEmployeeRequest request = new GetEmployeeRequest();
        request.setId(id);

        GetEmployeeResponse response = (GetEmployeeResponse) webServiceTemplate
                .marshalSendAndReceive(ENDPOINT_URL,
                        request,
                        new SoapActionCallback(SOAP_ACTION));

        return response;
    }
}