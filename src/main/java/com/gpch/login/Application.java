package com.gpch.login;

        import com.gpch.login.product.ProductRepository;
        import com.gpch.login.user.UserRepository;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, ProductRepository.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}