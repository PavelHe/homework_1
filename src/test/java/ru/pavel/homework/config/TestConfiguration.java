package ru.pavel.homework.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import ru.pavel.homework.controller.*;
import ru.pavel.homework.dao.*;
import ru.pavel.homework.service.*;

@Configuration
@PropertySource(value = {"file:src/test/resources/props.properties"}, name = "testProps")
public class TestConfiguration {

    private @Value("#{environment['testFilePath']}") String filePath;
    private @Value("#{environment['testDefaultLocale']}") String defaultLocale;

    @Bean
    public StudentController testStudentController() {
        return new StudentControllerImpl(testQuestionService(), defaultLocale);
    }

    @Bean
    public QuestionService testQuestionService() {
        return new QuestionServiceImpl(testQuestionDao());
    }

    @Bean
    public QuestionDao testQuestionDao() {
        return new QuestionDaoImpl(filePath);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("locales/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }


}
