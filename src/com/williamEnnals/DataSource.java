package com.williamEnnals;

public class DataSource {

    public static final String DB_NAME = "bank_application.db";
    public static final String CONNNECTION_STRING = "jdbc:sqlite:C:\\Users\\Will\\Documents\\Java\\" +
            "Projects\\BankAccountApplication\\bankApp\\" + DB_NAME;

    public static final String TABLE_BANKS = "banks";
    public static final String COLUMN_BANK_ID = "_id";
    public static final String COLUMN_BANK_NAME = "name";
    public static final String COLUMN_BANK_ROUTING_NUMBER = "routing_number";

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERS_ID = "_id";
    public static final String COLUMN_USERS_FIRST_NAME = "first_name";
    public static final String COLUMN_USERS_LAST_NAME = "last_name";
    public static final String COLUMN_USERS_USERNAME = "username";
    public static final String COLUMN_USERS_EMAIL = "email";
    public static final String COLUMN_USERS_PHONE_NUMBER = "phone_number";



}