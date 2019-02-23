package za.co.bookstore.config;

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
public class BookStoreSwaggerConfig {

    private static final String BOOKSTORE_API_BASE_PACKAGE = "za.co.bookstore.controller";

    private static final String BOOKSTORE_API_TITLE = "Book Store Service API";
    private static final String BOOKSTORE_API_DESCRIPTION = "Book Store REST API";
    private static final String BOOKSTORE_API_VERSION = "1.0";
    private static final String BOOKSTORE_API_TERMS_OF_SERVICE = "Terms of service";
    private static final String BOOKSTORE_API_OWNER_NAME = "Mayank Tantuway";
    private static final String BOOKSTORE_API_OWNER_WEBSITE = "http://easemywork.in/";
    private static final String BOOKSTORE_API_OWNER_EMAIL = "71mayank@gmail.com";
    private static final String BOOKSTORE_API_LICENSE = "Prototype License Version 1.0";
    private static final String BOOKSTORE_API_LICENSE_URL = "http://easemywork.in/licenses/LICENSE-1.0";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage(BOOKSTORE_API_BASE_PACKAGE))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(BOOKSTORE_API_TITLE)
                .description(BOOKSTORE_API_DESCRIPTION)
                .version(BOOKSTORE_API_VERSION)
                .contact(new Contact(BOOKSTORE_API_OWNER_NAME, BOOKSTORE_API_OWNER_WEBSITE, BOOKSTORE_API_OWNER_EMAIL))
                .termsOfServiceUrl(BOOKSTORE_API_TERMS_OF_SERVICE)
                .license(BOOKSTORE_API_LICENSE)
                .licenseUrl(BOOKSTORE_API_LICENSE_URL)
                .build();
    }
}
