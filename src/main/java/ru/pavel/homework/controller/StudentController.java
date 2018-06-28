package ru.pavel.homework.controller;

import java.io.*;

import ru.pavel.homework.model.*;


public interface StudentController {

    Student startAnswers();

    Student startAnswers(BufferedReader reader);

}
