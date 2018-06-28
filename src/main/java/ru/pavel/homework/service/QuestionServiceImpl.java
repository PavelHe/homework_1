package ru.pavel.homework.service;

import java.util.*;

import ru.pavel.homework.dao.*;
import ru.pavel.homework.model.*;


public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestionsFromCSV() {
        return questionDao.getQuestionsFromCSV();
    }
}
