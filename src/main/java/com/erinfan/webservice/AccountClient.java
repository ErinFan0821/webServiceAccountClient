package com.erinfan.webservice;

import com.erinfan.service.AccountDetailsRequest;
import com.erinfan.service.AccountDetailsResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class AccountClient {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");
        AccountDetailsRequest request = new AccountDetailsRequest();
        AccountDetailsResponse response = (AccountDetailsResponse) webServiceTemplate.marshalSendAndReceive(request);

        System.out.println(response.getAccountDetails().getAccountName());
    }
}
