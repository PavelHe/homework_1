package ru.pavel.homework.controller;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import ru.pavel.homework.model.*;
import ru.pavel.homework.service.*;
import ru.pavel.homework.utils.*;

@Service
public class StudentControllerImpl implements StudentController {

    @Autowired
    private MessageSourceWrapper messageSource;
    private final QuestionService questions;
    private String defaultLocale;

    public StudentControllerImpl(@Qualifier("questionServiceImpl") QuestionService questions,
                                 @Value("${defaultLocale}") String defaultLocale) {
        this.questions = questions;
        this.defaultLocale = defaultLocale;
    }

    @Override
    public Student startAnswers(BufferedReader reader, Locale locale) {
        reader = validateReader(reader);
        locale = validateLocale(locale);

        List<Question> questionList = questions.getQuestionsFromCSV();
        Student student = null;
        try {
            student = createStudent(reader, locale);
            for (Question question : questionList) {
                System.out.println(messageSource.getMessage("text.info", locale));
                System.out.println(question.getText());
                printAnswers(question.getAnswers());
                int choseAnswer = Integer.parseInt(reader.readLine());
                if (choseAnswer == question.getRightAnswer()) {
                    student.setRightAnswers(student.getRightAnswers() + 1);
                }
            }
            printFinalResults(student, locale);
        } catch (Exception e) {
            throw new IllegalArgumentException(messageSource.getMessage("error.ncNumber", locale));
        } finally {
            closeReader(reader);
        }
        return student;
    }

    private Student createStudent(BufferedReader reader, Locale locale) {
        Student student = null;
        try {
            System.out.print(messageSource.getMessage("text.askName", locale));
            String name = reader.readLine();
            System.out.print(messageSource.getMessage("text.askSurname", locale));
            String surname = reader.readLine();
            student = new Student(name, surname);
            System.out.println(messageSource.getMessage("text.separator", locale));
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

    private void printFinalResults(Student student, Locale locale) {
        System.out.println(messageSource.getMessage("text.result",
                new Object[]{student.getName(), student.getRightAnswers()}, locale));
    }

    private BufferedReader validateReader(BufferedReader reader) {
        return reader == null ? new BufferedReader(new InputStreamReader(System.in)) : reader;
    }

    private Locale validateLocale(Locale locale) {
        return locale == null ? Locale.forLanguageTag(defaultLocale) : locale;
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
