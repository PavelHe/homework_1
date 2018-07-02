package ru.pavel.homework.utils;

import java.util.*;

import org.springframework.context.*;
import org.springframework.stereotype.*;

@Service
public class MessageSourceWrapper {

    private final MessageSource messageSource;

    public MessageSourceWrapper(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String value, Locale locale) {
        return messageSource.getMessage(value, null, locale);
    }

    public String getMessage(String value, Object[] args, Locale locale) {
        return messageSource.getMessage(value, args, locale);
    }

}
