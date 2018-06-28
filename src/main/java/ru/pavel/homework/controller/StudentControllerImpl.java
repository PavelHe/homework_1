package ru.pavel.homework.controller;

import java.io.*;
import java.util.*;

import ru.pavel.homework.model.*;
import ru.pavel.homework.service.*;


public class StudentControllerImpl implements StudentController {

    private final QuestionService questions;

    public StudentControllerImpl(QuestionService questions) {
        this.questions = questions;
    }

    @Override
    public Student startAnswers() {
        return startAnswers(null);
    }

    @Override
    public Student startAnswers(BufferedReader reader) {
        reader = validate(reader);
        List<Question> questionList = questions.getQuestionsFromCSV();
        Student student = null;
        try {
            student = createStudent(reader);
            for (Question question : questionList) {
                System.out.println("Chose right number of answer. Press number 1, 2 or 3 and press 'Enter' to next question.");
                System.out.println(question.getText());
                printAnswers(question.getAnswers());
                int choseAnswer = Integer.parseInt(reader.readLine());
                if (choseAnswer == question.getRightAnswer()) {
                    student.setRightAnswers(student.getRightAnswers() + 1);
                }
            }
            printFinalResults(student);
        } catch (Exception e) {
            throw new IllegalArgumentException("Not correct number!");
        } finally {
            closeReader(reader);
        }
        return student;
    }

    private Student createStudent(BufferedReader reader) {
        Student student = null;
        try {
            System.out.print("Hi! You'r name is: ");
            String name = reader.readLine();
            System.out.print("You'r surname is: ");
            String surname = reader.readLine();
            student = new Student(name, surname);
            System.out.println("====================================");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return student;
    }

    private void printAnswers(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            int numberOfAnswer = i + 1;
            System.out.println(numberOfAnswer + " : " + answers.get(i).getText());
        }
    }

    private void printFinalResults(Student student) {
        System.out.println(student.getName() + ", you'r correct answers is: " + student.getRightAnswers());
    }

    private BufferedReader validate(BufferedReader reader) {
        if (reader == null)
            reader = new BufferedReader(new InputStreamReader(System.in));

        return reader;
    }

    private void closeReader(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
