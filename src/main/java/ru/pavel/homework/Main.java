package ru.pavel.homework;

import java.io.*;

import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import ru.pavel.homework.controller.*;

@ComponentScan
@Configuration
@PropertySource(value = {"classpath:props.properties"}, name = "props")
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        StudentController controller = (StudentController) context.getBean("studentControllerImpl");
        controller.startAnswers();
    }

}
