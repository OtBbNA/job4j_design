package ru.job4j.ood.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserSCP {

    private String name;
    private int age;
    private String phoneNumber;

    private List<String> users = new ArrayList<>();

    public UserSCP() {
    }

    public UserSCP(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void adduser(String name, int age, String phoneNumber) {
        if (name.contains(",") || phoneNumber.contains(",")) {
            throw new IllegalArgumentException();
        }
        users.add(String.format("%s,%s,%s", name, age, phoneNumber));
    }

    public String getUser(int id) {
        return users.get(id);
    }

    public OptionalDouble getAvgAge() {
        return users.stream().mapToInt(x -> Integer.parseInt(x.split(",", 3)[1])).average();
    }

    public List<String> getSomeUser(Predicate<String> predicate) {
        return users.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        UserSCP user = new UserSCP();
        user.adduser("Sasha", 10, "23787489273");
        user.adduser("Masha", 15, "56788567876");
        user.adduser("Misha", 21, "98746366587");
        user.adduser("Grisha", 31, "68657867876");
        System.out.println(user.getSomeUser(x -> x.contains("56")));
        System.out.println(user.getUser(3));
        user.getAvgAge().stream().forEach(System.out::println);
    }
}
