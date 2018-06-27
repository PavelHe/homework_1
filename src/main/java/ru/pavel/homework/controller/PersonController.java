package ru.pavel.homework.controller;

import java.io.*;

import ru.pavel.homework.model.*;


public interface PersonController {

    void startAnswers();

    Person createPerson(BufferedReader reader);

}
