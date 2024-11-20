package org.soapclient.config;

import jakarta.xml.bind.Marshaller;

import org.soapclient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWs
public class SoapConfig {


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // Generated classes paket adı
        marshaller.setPackagesToScan("org.soap.wsdl");
        Map<String, Object> properties = new HashMap<>();
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setMarshallerProperties(properties);
        return marshaller;
    }

    @Value("${soap.service.url}")
    private String serviceUrl;

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(serviceUrl);
        return webServiceTemplate;
    }
}