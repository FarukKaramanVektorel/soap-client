package org.soapclient.service;



import lombok.RequiredArgsConstructor;
import org.soap.wsdl.GetEmployeeRequest;
import org.soap.wsdl.GetEmployeeResponse;
import org.soapclient.dto.EmployeeDTO;
import org.soapclient.model.EmployeeEntity;
import org.soapclient.repository.EmployeeRepository;
import org.soapclient.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private static final String ENDPOINT_URL = "http://localhost:8010/ws";
    private static final String SOAP_ACTION = "http://localhost:8010/endpoint/getEmployeeRequest";

    private final WebServiceTemplate webServiceTemplate;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDTO getEmployee(int id) {
        // SOAP isteği
        GetEmployeeRequest request = new GetEmployeeRequest();
        request.setId(id);

        GetEmployeeResponse response = (GetEmployeeResponse) webServiceTemplate
                .marshalSendAndReceive(ENDPOINT_URL,
                        request,
                        new SoapActionCallback(SOAP_ACTION));

        // SOAP yanıtını entity'ye dönüştür ve kaydet
        EmployeeEntity entity = employeeMapper.toEntity(response.getEmployee());
        entity = employeeRepository.save(entity);

        // Entity'yi DTO'ya dönüştür ve dön
        return employeeMapper.toDTO(entity);
    }
}