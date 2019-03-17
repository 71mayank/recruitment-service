package za.co.recruitment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class RecruitmentSwaggerConfig {

    private static final String RECRUITMENT_API_BASE_PACKAGE = "za.co.recruitment.controller";

    private static final String RECRUITMENT_API_TITLE = "Recruitment Service API";
    private static final String RECRUITMENT_API_DESCRIPTION = "Recruitment REST API";
    private static final String RECRUITMENT_API_VERSION = "1.0";
    private static final String RECRUITMENT_API_TERMS_OF_SERVICE = "Terms of service";
    private static final String RECRUITMENT_API_OWNER_NAME = "Mayank Tantuway";
    private static final String RECRUITMENT_API_OWNER_WEBSITE = "http://easemywork.in/";
    private static final String RECRUITMENT_API_OWNER_EMAIL = "71mayank@gmail.com";
    private static final String RECRUITMENT_API_LICENSE = "Prototype License Version 1.0";
    private static final String RECRUITMENT_API_LICENSE_URL = "http://easemywork.in/licenses/LICENSE-1.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage(RECRUITMENT_API_BASE_PACKAGE))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(RECRUITMENT_API_TITLE)
                .description(RECRUITMENT_API_DESCRIPTION)
                .version(RECRUITMENT_API_VERSION)
                .contact(new Contact(RECRUITMENT_API_OWNER_NAME, RECRUITMENT_API_OWNER_WEBSITE, RECRUITMENT_API_OWNER_EMAIL))
                .termsOfServiceUrl(RECRUITMENT_API_TERMS_OF_SERVICE)
                .license(RECRUITMENT_API_LICENSE)
                .licenseUrl(RECRUITMENT_API_LICENSE_URL)
                .build();
    }
}
