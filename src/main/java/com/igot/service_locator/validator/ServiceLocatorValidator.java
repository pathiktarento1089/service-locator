package com.igot.service_locator.validator;


import com.common.commonutil.exception.ServiceLocatorException;
import com.igot.service_locator.entity.ServiceLocatorEntity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceLocatorValidator {


    public void validate(ServiceLocatorEntity entity) {
        log.info("ServiceLocatorValidator::validate");
        if(entity == null){
           throw new ServiceLocatorException("SERVICE_LOCATOR_CONFIG","Service locator config is mandatory");
        }
        if(StringUtils.isBlank(entity.getUrl())){
            throw new ServiceLocatorException("URL","Url is mandatory");
        }
        if(StringUtils.isBlank(entity.getServiceCode())){
            throw new ServiceLocatorException("SERVICE_CODE","Service code is missing");
        }
        if(StringUtils.isBlank(entity.getServiceName())){
            throw new ServiceLocatorException("SERVICE_NAME","Service name is missing");
        }
        if(StringUtils.isBlank(entity.getOperationType())){
            throw new ServiceLocatorException("OPERATION_TYPE","Operation type is missing");
        }
//        if(StringUtils.isBlank(entity.getUrlPlaceholder())){
//            throw new ServiceLocatorException("URL_PLACEHOLDER","Url Placeholder is missing");
//        }
        if(entity.getRequestMethod() == null
                || !EnumUtils.isValidEnum(ServiceLocatorEntity.RequestMethod.class,entity.getRequestMethod().name())){
            throw new ServiceLocatorException("REQUEST_METHOD","Request method is mandatory");
        }

    }
}
