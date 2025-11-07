package ru.tsygvintsev.names;

public final class Names {
    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public Names(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.firstName = firstName;
        this.lastName = null;
        this.patronymic = null;
    }

    public Names(String firstName, String lastName) {
        if ((firstName == null || firstName.trim().isEmpty()) &&
                (lastName == null || lastName.trim().isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр должен быть заполнен");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = null;
    }

    public Names(String firstName, String lastName, String patronymic) {
        if ((firstName == null || firstName.trim().isEmpty()) &&
                (lastName == null || lastName.trim().isEmpty()) &&
                (patronymic == null || patronymic.trim().isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр должен быть заполнен");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        String result = firstName;
        if (lastName != null && !lastName.isEmpty()) {
            result += " " + lastName;
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            result += " " + patronymic;
        }
        return result;
    }
}