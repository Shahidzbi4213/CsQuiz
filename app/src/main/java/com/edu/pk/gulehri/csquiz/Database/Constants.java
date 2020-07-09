package com.edu.pk.gulehri.csquiz.Database;

public class Constants {


    public static final String TABLE_FIRST = "quiz_question";
    public static final String TABLE_SECOND = "Categories";


    public static final String UID = "_id";
    public static final String COLUMNS_QUESTION = "Question";
    public static final String COLUMNS_OPTION1 = "Option1";
    public static final String COLUMNS_OPTION2 = "Option2";
    public static final String COLUMNS_OPTION3 = "Option3";
    public static final String COLUMNS_OPTION4 = "Option4";
    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_LANGUAGE = "Language";
    public static final String ANSWER = "Answer";

    public static final String UID_SECOND = "_id";
    public static final String COLUMN_CATEGORY_SECOND = "Category";
    public static final String COLUMN_LANGUAGE_SECOND = "Language";


    public static final String CREATE_TABLE_QUESTION = "CREATE TABLE " + TABLE_FIRST +
            "( " + UID + " INTEGER PRIMARY KEY, " + COLUMNS_QUESTION + " TEXT, " + COLUMNS_OPTION1
            + " TEXT, " + COLUMNS_OPTION2 + " TEXT, " + COLUMNS_OPTION3 + " TEXT, " +
            COLUMNS_OPTION4 + " TEXT, " + ANSWER + " INTEGER, " + COLUMN_LANGUAGE + " TEXT, " + COLUMN_CATEGORY + " TEXT  " + " );";

    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_SECOND +
            "( " + UID_SECOND + " INTEGER PRIMARY KEY, " + COLUMN_CATEGORY_SECOND + " TEXT, " + COLUMN_LANGUAGE_SECOND + " TEXT  " + " );";


    public static final String[] ALL_COLUMNS = {COLUMNS_QUESTION, COLUMNS_OPTION1, COLUMNS_OPTION2, COLUMNS_OPTION3, COLUMNS_OPTION4, ANSWER, COLUMN_LANGUAGE, COLUMN_CATEGORY};

    public static final String[] ALL_COLUMNS_SECOND = {COLUMN_CATEGORY_SECOND};

    public static final String DELETE_TABLE_FIRST = " DROP TABLE IF EXISTS " + TABLE_FIRST;
    public static final String DELETE_TABLE_SECOND = " DROP TABLE IF EXISTS " + TABLE_SECOND;


}
