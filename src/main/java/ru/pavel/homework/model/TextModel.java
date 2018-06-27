package ru.pavel.homework.model;


public abstract class TextModel {

    protected String text;

    public TextModel() {
    }

    public TextModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextModel{" +
                "text='" + text + '\'' +
                '}';
    }
}


