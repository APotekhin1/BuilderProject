package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException(
                    "Возраст введен неверно. Должен быть от 0 до 150 лет. У вас: " + age
            );
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException(
                    "Не введено обязательное поле: ИМЯ."
            );
        }
        if (surname == null) {
            throw new IllegalStateException(
                    "Не введено обязательное поле: ФАМИЛИЯ."
            );

        }

        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }

        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }

}
