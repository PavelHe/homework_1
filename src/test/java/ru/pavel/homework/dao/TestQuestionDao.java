package ru.pavel.homework.dao;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import ru.pavel.homework.config.*;
import ru.pavel.homework.model.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestQuestionDao {

    private final static int ANSWERS_COUNT_IN_CSV = 6;

    @Autowired
    @Qualifier("testQuestionDao")
    private QuestionDao dao;

    @Test
    public void testGetQuestionsFromCSV() throws Exception {
        List<Question> questions = dao.getQuestionsFromCSV();

        assertEquals(ANSWERS_COUNT_IN_CSV, questions.size());
    }

}
