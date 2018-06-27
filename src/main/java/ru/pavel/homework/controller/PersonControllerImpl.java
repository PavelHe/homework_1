package ru.pavel.homework.controller;

import java.io.*;
import java.util.*;

import ru.pavel.homework.model.*;
import ru.pavel.homework.service.*;


public class PersonControllerImpl implements PersonController {

    private QuestionService questions;

    public PersonControllerImpl(QuestionService questions) {
        this.questions = questions;
    }

    @Override
    public void startAnswers() {
        List<Question> questionList = questions.getQuestionsFromCSV();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Person person = createPerson(reader);
            for (Question question : questionList) {
                System.out.println("Chose right number of answer. Press number 1, 2 or 3 and press 'Enter' to next question.");
                System.out.println(question.getText());
                printAnswers(question.getAnswers());
                int choseAnswer = Integer.parseInt(reader.readLine());
                if (choseAnswer == question.getRightAnswer()) {
                    person.setRightAnswers(person.getRightAnswers() + 1);
                }
            }
            printFinalResults(person);
        } catch (Exception e) {
            throw new IllegalArgumentException("Not correct number!");
        }
    }

    @Override
    public Person createPerson(BufferedReader reader) {
        Person person = null;
        try {
            System.out.print("Hi! You'r name is: ");
            String name = reader.readLine();
            System.out.print("You'r surname is: ");
            String surname = reader.readLine();
            person = new Person(name, surname);
            System.out.println("====================================");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return person;
    }

    private void printAnswers(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            int numberOfAnswer = i + 1;
            System.out.println(numberOfAnswer + " : " + answers.get(i).getText());
        }
    }

    private void printFinalResults(Person person) {
        System.out.println(person.getName() + ", you'r correct answers is: " + person.getRightAnswers());
    }
}
