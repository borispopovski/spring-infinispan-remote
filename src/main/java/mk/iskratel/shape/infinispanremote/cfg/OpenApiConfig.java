package mk.iskratel.shape.infinispanremote.cfg;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
public class OpenApiConfig {

  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder()
        .group("infinispan-remote")
        .pathsToMatch("/**")
        .build();
  }

  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info().title("infinispan-remote - REST API")
        .description("Infinispan Remote")
        .version("3.0.0")
        .termsOfService("Iskratel")
        .license(new License().name("Iskratel Standard License")
        		.url("https://www.iskratel.mk/en/")));
  }

}
