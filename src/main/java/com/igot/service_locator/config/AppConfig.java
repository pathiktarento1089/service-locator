package com.igot.service_locator.config;


import com.common.commonutil.service.CommonService;
import com.common.commonutil.service.impl.CommonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.common.commonutil.*"})
public class AppConfig {
    @Bean
    public CommonService commonService() {
        return new CommonServiceImpl();
    }


}
