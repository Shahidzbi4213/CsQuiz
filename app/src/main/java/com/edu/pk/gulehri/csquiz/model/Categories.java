package com.edu.pk.gulehri.csquiz.model;


public class Categories {


    public String category;
    public String language;

    public int id;


    //java
    public static final String BASICS = "Basics";
    public static final String DATA_TYPES = "Data Types";
    public static final String OOP = "OOP";
    public static final String KEYWORDS = "Keywords";
    public static final String FUNCTION = "Function";
    public static final String INTERFACES = "Interfaces";
    public static final String EXCEPTION_HANDLING = "EXCEPTION Handling";
    public static final String MULTI_THREADING = "MULTI THREADING";
    public static final String INNER_CLASS = "Inner Class";
    public static final String GUI = "GUI";
    public static final String DATA_STRUCTURE = "Data Structure";
    public static final String COLLECTION_FRAME_WORK = "Collection FrameWork";
    public static final String JDBC = "JDBC";

    //html
    public static final String TAGS1 = "Tags-1";
    public static final String TAGS2 = "Tags-2";
    public static final String LINKS_AND_LISTS = "Links and Lists";
    public static final String LAYOUTS = "LAYOUTS";
    public static final String MEDIA = "MEDIA";
    public static final String GRAPHICS = "Graphics";
    public static final String FORMS = "FORMS";
    public static final String API = "API";


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
                    new Categories("EXCEPTION Handling", Languages.JAVA),
                    new Categories("MULTI THREADING", Languages.JAVA),
                    new Categories("Inner Class", Languages.JAVA),
                    new Categories("GUI", Languages.JAVA),
                    new Categories("Data Structure", Languages.JAVA),
                    new Categories("Collection FrameWork", Languages.JAVA),
                    new Categories("JDBC", Languages.JAVA),

                    new Categories("Basics", Languages.HTML),
                    new Categories("Tags-1", Languages.HTML),
                    new Categories("Tags-2", Languages.HTML),
                    new Categories("Links and Lists", Languages.HTML),
                    new Categories("LAYOUTS", Languages.HTML),
                    new Categories("MEDIA", Languages.HTML),
                    new Categories("Graphics", Languages.HTML),
                    new Categories("FORMS", Languages.HTML),
                    new Categories("API", Languages.HTML),


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

