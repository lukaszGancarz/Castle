package com.clockworkjava.castle.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Knight {

    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Imie rycerza musi byc miedzy 2, a 40 znakow")
    private String name;

    @NotNull
    @Range(min = 18, max = 60, message = "Rycerz musi miec conajmniej 18 lat i nie wiecej niz 60")
    //@Digits(integere=..., fraction=...) -Rozmiar po przecinku
//    @Min(2)
//    @Max(40)
    private int age;
    private Quest quest;
    private int level;

    public Knight() {
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        if (quest != null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;
        Knight knight = (Knight) o;
        return getAge() == knight.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge());
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + "(" + age + "). Ma za zadanie " + quest;
    }
}
