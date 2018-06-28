package ru.pavel.homework;

import java.io.*;

import org.springframework.context.support.*;
import ru.pavel.homework.controller.*;


public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/context.xml");
        StudentController controller = context.getBean(StudentController.class);
        controller.startAnswers();
    }

}
