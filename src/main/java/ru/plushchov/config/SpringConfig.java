package ru.plushchov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.plushchov.dao.RepositoryConfig;
import ru.plushchov.service.ServiceConfig;

import java.util.concurrent.Executor;

@Configuration
//@ComponentScan("ru.plushchov")
@Import({RepositoryConfig.class, ServiceConfig.class})
public class SpringConfig {

        @Bean
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

//    @Bean(name = "messageSource")
//    public ResourceBundleMessageSource getMessageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("classpath:application.properties");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setUseCodeAsDefaultMessage(true);
//        return messageSource;
//    }
}
