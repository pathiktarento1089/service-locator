package com.igot.service_locator.controller;

import com.igot.service_locator.entity.IntegrationModel;
import com.igot.service_locator.service.IntegrationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class IntegrationController {

    @Autowired
    IntegrationModelService service;

    @PostMapping("/callExternalApi")
    public Object callExternalApiService(@RequestBody IntegrationModel integrationModel, HttpServletRequest httpServletRequest) throws IOException {
        return service.getDetailsFromExternalService(integrationModel,httpServletRequest);
    }



}
