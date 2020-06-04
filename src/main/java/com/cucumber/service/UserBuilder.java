package com.cucumber.service;

import com.cucumber.model.User;

import static com.cucumber.service.TestDataReader.getTestData;
import static com.cucumber.util.Constants.Properties.PASSWORD;
import static com.cucumber.util.Constants.Properties.USERNAME;

public class UserBuilder {

    public static User withCredentialsFromProperty() {
        return new User(getTestData(USERNAME), getTestData(PASSWORD));
    }

}
