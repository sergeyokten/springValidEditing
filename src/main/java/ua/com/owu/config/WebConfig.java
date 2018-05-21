package ua.com.owu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.owu.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     @Bean
         public JavaMailSender mailSender() {
             JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
             mailSender.setHost("smtp.gmail.com");
             mailSender.setPort(587);
             mailSender.setUsername("sergey.okten@gmail.com");
             mailSender.setPassword("");


             Properties javaMailProperties = mailSender.getJavaMailProperties();
             javaMailProperties.setProperty("mail.transport.protocol", "smtp");
             javaMailProperties.setProperty("mail.smtp.auth", "true");
             javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
             javaMailProperties.setProperty("mail.debug", "true");
             return mailSender;

         }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/xxx/**")
                .addResourceLocations("/styles/");

        String path = System.getProperty("user.home") + File.separator + "pics" + File.separator;

        registry.addResourceHandler("/avatarka/**")
                .addResourceLocations("file:" + path);
    }
}
