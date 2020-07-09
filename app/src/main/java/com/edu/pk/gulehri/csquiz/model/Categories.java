package com.edu.pk.gulehri.csquiz.model;


public class Categories {

    public String category;
    public String language;

    public int id;

    public static final String BASICS = "Basics";
    public static final String Data_Types = "Data Types";
    public static final String OOP = "OOP";

    public static final String Keywords = "Keywords";
    public static final String Function = "Function";
    public static final String Interfaces = "Interfaces";
    public static final String Exception_Handling = " Exception Handling";

    public static final String Multi_Threading = " Multi Threading";
    public static final String Inner_Class = "Inner Class";
    public static final String Enums = "Enums";

    public static final String Data_Structure = "Data Structure";
    public static final String Collection_FrameWork = "Collection FrameWork";
    public static final String JDBC = "JDBC";
    public static final String Android = "Android";


    public Categories(String category, String language) {
        this.category = category;
        this.language = language;
    }


    public static final Categories[] data =
            {
                    new Categories("Basics", Languages.JAVA),
                    new Categories("Data Types", Languages.JAVA),
                    new Categories("OOP", Languages.JAVA),
                    new Categories("Keywords", Languages.JAVA),
                    new Categories("Interfaces", Languages.JAVA),
                    new Categories("Exception Handling", Languages.JAVA),
                    new Categories("Multi Threading", Languages.JAVA),
                    new Categories("Inner Class", Languages.JAVA),
                    new Categories("Enums", Languages.JAVA),
                    new Categories("Data Structure", Languages.JAVA),
                    new Categories("Collection FrameWork", Languages.JAVA),
                    new Categories("JDBC", Languages.JAVA),

                    new Categories("Intents", Languages.ANDROID)
            };


    public Categories() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static Categories[] getData() {
        return data;
    }
}

