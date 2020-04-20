package com.shifat63.magazine.Configuration;

import com.shifat63.magazine.Service.GenericApplicationService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class AppConfiguration extends WebMvcConfigurerAdapter {

    private final GenericApplicationService genericApplicationService;

    public AppConfiguration(GenericApplicationService genericApplicationService) {
        this.genericApplicationService = genericApplicationService;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/MagazineFiles/**")
                .addResourceLocations("file:///" + genericApplicationService.GetStorageLocation());
        super.addResourceHandlers(registry);
    }
}