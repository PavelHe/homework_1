package ru.pavel.homework.controller;

import java.io.*;
import java.util.*;

import ru.pavel.homework.model.*;


public interface StudentController {

    default Student startAnswers() {
        return startAnswers(null, null);
    }

    Student startAnswers(BufferedReader reader, Locale locale);

}
