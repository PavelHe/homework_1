package ru.pavel.homework.model;


public class Student {

    private final String name;
    private final String surname;
    private int rightAnswers;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        rightAnswers = 0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return (name != null ? name.equals(student.name) : student.name == null) && (surname != null ? surname.equals(student.surname) : student.surname == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", rightAnswers=" + rightAnswers +
                '}';
    }
}
