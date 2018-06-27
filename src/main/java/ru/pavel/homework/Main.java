package ru.pavel.homework;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import au.com.bytecode.opencsv.*;
import org.springframework.context.support.*;
import ru.pavel.homework.controller.*;
import ru.pavel.homework.model.*;
import ru.pavel.homework.service.*;


public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/context.xml");
        PersonController controller = context.getBean(PersonController.class);
        controller.startAnswers();
    }

}
