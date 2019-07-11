package com.williamEnnals.classes;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    public final String name;
    public final int routingNumber;
    private Map<String, User> users;

    public Bank(String name, int routingNumber) {
        this.name = name;
        this.routingNumber = routingNumber;
        this.users = new HashMap<>();
    }

    public boolean addNewUser(String firstName, String lastName, String userName, int age, long socialSecurityNumber){
        if(users.get(userName) == null) {
            User newUser = new User(firstName, lastName, userName, age, socialSecurityNumber);
            users.put(newUser.getUserName(), newUser);
            return true;
        }

        return false;

    }


    public boolean removeUser(User user){
        if(users.get(user) != null) {
            users.remove(user);
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }
}


