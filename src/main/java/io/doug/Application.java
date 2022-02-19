package io.doug;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
            title = "grid-service",
            version = "0.0"
    )
)
public class Application {

    public static final String API_PATH = "/api/v1";
    public static final String GRID_PATH = API_PATH + "/grid";

    public static ApplicationContext APPLICATION;

    public static void main(String[] args) {
        APPLICATION = Micronaut.run(Application.class, args);
    }
}
