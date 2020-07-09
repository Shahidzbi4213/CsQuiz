package com.edu.pk.gulehri.csquiz.model;

import com.edu.pk.gulehri.csquiz.R;

public class Languages {
    public String Names;
    public int id;
    public int imgID;


    public static final String CPLUS = "C++";
    public static final String JAVA = "Java";
    public static final String PYTHON = "Python";
    public static final String CSHARP = "C Sharp";
    public static final String JAVA_SCRIPT = "JavaScript";
    public static final String ANDROID = "Android";
    public static final String PHP = "Php";
    public static final String HTML = "Html";


    public static final Languages[] CsLanguages = {

            new Languages("C++", R.drawable.cplus),
            new Languages("Java", R.drawable.java),
            new Languages("Python", R.drawable.python),
            new Languages("C Sharp", R.drawable.csharp),
            new Languages("Android", R.drawable.android),
            new Languages("JavaScript", R.drawable.js),
            new Languages("Php", R.drawable.php),
            new Languages("Html", R.drawable.html)
    };


    public Languages(String names, int imgID) {
        Names = names;
        this.imgID = imgID;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public static Languages[] getCsLanguages() {
        return CsLanguages;
    }
}
