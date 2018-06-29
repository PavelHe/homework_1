package ru.pavel.homework.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import ru.pavel.homework.dao.*;
import ru.pavel.homework.model.*;

@Service("questionServiceImpl")
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(@Qualifier("questionDaoImpl") QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestionsFromCSV() {
        return questionDao.getQuestionsFromCSV();
    }
}
