package ru.pavel.homework.model;


import java.util.*;

public class Question extends TextModel {

    private int rightAnswer;
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String text, int rightAnswer) {
        super(text);
        this.rightAnswer = rightAnswer;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return rightAnswer == question.rightAnswer && (text != null ? text.equals(question.text) : question.text == null);
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + rightAnswer;
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "rightAnswer=" + rightAnswer +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
