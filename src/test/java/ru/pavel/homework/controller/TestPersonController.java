package ru.pavel.homework.controller;

import java.io.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import ru.pavel.homework.model.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/context.xml")
public class TestPersonController {

    private final static String NAME = "Name";
    private final static String SURNAME = "Surname";

    @Autowired
    private PersonController personController;

    @Test
    public void testCreateUser() throws Exception {
        BufferedReader mockReader = mock(BufferedReader.class);
        when(mockReader.readLine()).thenReturn(NAME, SURNAME);
        Person person = personController.createPerson(mockReader);

        assertEquals(NAME, person.getName());
        assertEquals(SURNAME, person.getSurname());
    }

}
