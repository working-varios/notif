package com.ito.notifico.lineanegocio.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class WebConfig {
    /** The log. */
    private final Logger log = LoggerFactory.getLogger(WebConfig.class);
    /**
     * Main config.
     *
     * @return the docket
     */
    @Bean
    public Docket mainConfig() {

        log.debug("Starting Swagger");
        springfox.documentation.service.Contact contact = new Contact("ITO SOFTWARE SAS", "http://www.ito-software.com",
                "info@ito-software.com");

        @SuppressWarnings("rawtypes")
        List<VendorExtension> vext = new ArrayList<VendorExtension>();

        ApiInfo apiInfo = new ApiInfo("Notifico - Microservicio Línea de negocio", "ITO GENERATOR", "1.0", "http://www.ito-software.com", contact,
                "ITO SOFTWARE SAS", "http://www.ito-software.com", vext);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }
}