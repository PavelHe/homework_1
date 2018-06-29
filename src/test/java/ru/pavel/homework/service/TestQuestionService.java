package ru.pavel.homework.service;

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
public class TestQuestionService {

    private final static int ANSWERS_COUNT_IN_CSV = 6;

    @Autowired
    @Qualifier("testQuestionService")
    private QuestionService service;

    @Test
    public void testGetQuestionsFromCSV() throws Exception {
        List<Question> questions = service.getQuestionsFromCSV();

        assertEquals(ANSWERS_COUNT_IN_CSV, questions.size());
    }

}
