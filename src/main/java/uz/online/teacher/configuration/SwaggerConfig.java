package uz.online.teacher.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerCustomConfiguration() {

        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.name("jwtAuth");
        securityScheme.bearerFormat("JWT");
        securityScheme.type(SecurityScheme.Type.HTTP);
        securityScheme.in(SecurityScheme.In.HEADER);
        securityScheme.scheme("bearer");
        securityScheme.description("JWT based authentication...");

        return new OpenAPI()
                .info(new Info()
                        .title("Teacher project")
                        .description("This project is for teacher")
                        .license(new License()
                                .name("JJF lisence")
                                .url("http://Teacher.uz"))
                        .contact(new Contact()
                                .name("Jabborov Jaloliddin Faxriddinovich")
                                .url("https://t.me/webase_jalol")
                                .email("jabborovjaloliddin9@gmail.com"))
                        .version("1.0.0"))
                .components(new Components().addSecuritySchemes("jwtAuth", securityScheme))
                .addSecurityItem(new SecurityRequirement().addList("jwtAuth"));
    }

//    @Bean
//    public GroupedOpenApi userGroup() {
//        return GroupedOpenApi.builder()
//                .packagesToScan("com.example.investment.controller")
//                .pathsToMatch("/user/**")
//                .group("Users")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi accountGroup() {
//        return GroupedOpenApi.builder()
//                .packagesToScan("com.example.investment.controller")
//                .pathsToMatch("/account/**")
//                .group("Account")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi otherGroup() {
//        return GroupedOpenApi.builder()
//                .packagesToScan("com.example.investment.controller")
//                .pathsToExclude("/user/**", "/account/**")
//                .group("Others")
//                .build();
//    }
}
