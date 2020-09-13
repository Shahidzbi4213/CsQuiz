package com.edu.pk.gulehri.csquiz.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.edu.pk.gulehri.csquiz.model.Categories;
import com.edu.pk.gulehri.csquiz.model.Languages;
import com.edu.pk.gulehri.csquiz.model.Question;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyDbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Quiz";
    private static final int VERSION = 1;
    private String TAG = "myTag";
    private SQLiteDatabase db;

    public MyDbOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        db = getReadableDatabase();
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(Constants.CREATE_TABLE_QUESTION);
        db.execSQL(Constants.CREATE_TABLE_CATEGORY);
        Log.d(TAG, "onCreate: Database Created");
        addCategory();
        addQuestions();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constants.DELETE_TABLE_FIRST);
        db.execSQL(Constants.DELETE_TABLE_SECOND);
        onCreate(db);
        Log.d(TAG, "onUpgrade: DatabaseUpgraded");

    }

    private void addQuestions() {

        //Java
        javaBasicQuestions();
        javaKeywordQuestions();
        javaDataTypesQuestions();
        javaOOPQuestions();
        javaFunctionQuestions();
        javaExceptionHandling();
        javaMultiThreading();
        javaDataStructure();
        javaCollectionFrameWork();
        javaInnerClasses();
        javaInterfaces();
        javaGUI();
        javaJDBC();

        //Html
        htmlBasics();
        htmlTagsFirst();
        htmlTagsSecond();
        htmlLinksAndList();
        htmlGraphics();
        htmlForms();
        htmlMedia();
        htmlLayouts();
        htmlApi();

        //C++
        cPlusBasics();
        cPlusDataTypes();
        cPlusKeyWordAndPointers();
        cPlusExceptionHandling();
        cPlusStandardTemplateLibrary();
        cPlusOOP();
        cPlusFunction();
        cPlusClassesAndObjects();
        cPlusDataStructure();
        cPlusModularizationInterfacesAndNameSpace();

        //Android
        androidBasics();
        androidActivityAndIntents();
        androidFragments();
        androidContentProvider();

        //Php
        phpBasics();
        phpOOP();
        phpArraysAndFunctions();
        phpErrorAndExceptionHandling();

    }

    private void addCategory() {
        javaCategory();
        cPlusCategory();
        cSharpCategory();
        python();
        android();
        html();
        php();
        javaScriptCategory();
    }

    /*===============================================================================================================================================*/
    /* Java */
    /*===============================================================================================================================================*/
    //Adding Basics Questions
    private void javaBasicQuestions() {
        Question b1 = new Question("Java Source Code is compiled into ______________.", ".Obj", "Source Code", "Bytecode", ".Exe", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b1);
        Question b2 = new Question("Which of the tool is used to compile java code ?", "java", "javac", "jar", " javadoc", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b2);
        Question b3 = new Question("Which of these can not be used for a variable name in Java?", "identifier", "keyword", "identifier & keyword", "none of the mentioned", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b3);
        Question b4 = new Question("What does AWT stands for?", "All Window Tools", "All Writing Tools", "Abstract Window Toolkit", " Abstract Writing Toolkit", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b4);
        Question b5 = new Question("Which of the following is not a Java features?", "Dynamic", "Architecture Neutral", "Use of pointers", "Object-oriented", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b5);
        Question b6 = new Question("_____ is used to find and fix bugs in the Java programs.", "JVM", "JDK", "JDB", "JRE", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b6);
        Question b7 = new Question("In java, jar stands for_____.", "Java Archive Runner", "Java Application Resource", "Java Application Runner", "None of the above", 4, Languages.JAVA, Categories.BASICS);
        insertQuestion(b7);
        Question b8 = new Question("What is the extension of java file ?", ".exe", ".cpp", ".java", ".py", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b8);
        Question b9 = new Question("Who created java language ?", "Bjarne Stroustrup", "James Gosling", "Guido van Rossum", "Rasmus Lerdorf", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b9);
        Question b10 = new Question("What is a correct syntax to output 'Hello World' in Java?", "Console.WriteLine(\"Hello World\");", "echo(\"Hello World\");", "System.out.println(\"Hello World\");", "print (\"Hello World\");", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b10);
        Question b11 = new Question("Which one is not valid COMMENTS in Java code?", "/* This is a comment  ", "// This is a comment  ", "/* This is a Comment */", "/** This is a Comment */", 1, Languages.JAVA, Categories.BASICS);
        insertQuestion(b11);
        Question b12 = new Question("How do you create a method in Java?", "methodName()", "methodName[]", "methodName.", "(methodName)", 1, Languages.JAVA, Categories.BASICS);
        insertQuestion(b12);
        Question b13 = new Question("Which keyword is used to create a class in Java?", "Class", "class", "className", "class()", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b13);
        Question b14 = new Question("What is the correct way to create an object called myObj of MyClass?", "new myObj = MyClass();", "class MyClass = new myObj();", "MyClass myObj = new MyClass();", "class myObj = new MyClass();", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b14);
        Question b15 = new Question("Which operator is used to multiply numbers?", "/", "x", "*", "%", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b15);
        Question b16 = new Question("Which keyword is used to import a package from the Java API library?", "package", "import", "lib", "getlib", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b16);
        Question b17 = new Question("Which statement is true regarding an object?", "An object is what classes instantiated are from", "An object is an instance of a class", " An object is a variable", "An object is not an instance of a class.", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b17);
        Question b18 = new Question(" Which method can be defined only once in a program?", "static method", "main method", "finalize method", "private method", 2, Languages.JAVA, Categories.BASICS);
        insertQuestion(b18);
        Question b19 = new Question("Every statement in Java language should end with a?", "Dot or Period", "Comma", "Semicolon", "Colon", 3, Languages.JAVA, Categories.BASICS);
        insertQuestion(b19);
        Question b20 = new Question("When was first Version of Java i.e Java 1.0 was released?", "1991", "1994", "1999", "1996", 4, Languages.JAVA, Categories.BASICS);
        insertQuestion(b20);
    }

    //Adding Keywords Questions
    private void javaKeywordQuestions() {
        Question question1 = new Question("Final keyword in java is used with", "class", "class fields", "class methods", "All of the above", 4, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question1);
        Question question2 = new Question("Super keyword in java is used to", "Refer immediate parent class instance variables", "Invoke immediate parent class methods", "Invoke immediate parent class constructor", "All", 4, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question2);
        Question question3 = new Question("In java, “this” keyword is used to", "Pass as an argument to a method", "Refer current class object", "Return current class object", "All are correct", 4, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question3);
        Question question4 = new Question("Which keyword is used to refer current object of a class in Java?", "this", "new", "super", "current", 1, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question4);
        Question question5 = new Question(" try, catch, finally, throw, and throws keywords in java are related to", "Event handling", "string handling", "exception handling", "None of the above", 3, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question5);
        Question question6 = new Question("Transient keyword in java is used in", "synchronization", "serialization", "inheritance", "polymorphism", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following is a reserved keyword in Java?", "object", "main", "strictfp", "system", 3, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question7);
        Question question8 = new Question("Which keyword is used for accessing the features of a package?", "package", "import", "extends", "export", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following modifiers can be used for a variable so that it can be accessed by any thread or a part of a program?", "global", "transient", "volatile", "default", 3, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question9);
        Question question10 = new Question("The public keyword is an", "identifier", "access specifier", "variable type", "exception", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question10);
        Question question11 = new Question("Acceptable keyword in JAVA is", "short", "Short", "SHORT", "none", 1, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question11);
        Question question12 = new Question("Which of these keywords is used to prevent content of a variable from being modified?", "final", "last", "constant", "static", 1, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question12);
        Question question13 = new Question("Which of the following are not Java keywords ?", "double", "switch", "then", "instanceof", 3, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question13);
        Question question14 = new Question("How many keywords are present in Java?", "48", "51", "60", "36", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question14);
        Question question15 = new Question("Which of these keywords is used to make a class?", "class", "struct", "int", "none of the mentioned", 1, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question15);
        Question question16 = new Question("The loop keyword of java is", "Byte", "While", "Double", " Float", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question16);
        Question question17 = new Question("Which one of the following is access keyword?", "Public", "Private", "Protected", "All of these", 4, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question17);
        Question question18 = new Question("A thread can acquire a lock by using which reserved keyword?", "volatile", "synchronized", "locked", "none", 2, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question18);
        Question question19 = new Question("Which keyword is used to explicitly throw an exception?", "try", "throwing", "catch", "throw", 4, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question19);
        Question question20 = new Question("In java, ............ can only test for equality, where as .......... can evaluate any type of the Boolean expression.", "switch, if", "if, switch", "if, break", "continue, if", 1, Languages.JAVA, Categories.KEYWORDS);
        insertQuestion(question20);
    }

    //Adding Data types Questions
    private void javaDataTypesQuestions() {
        Question question1 = new Question("Java is a ........... language.", "weakly typed", "strongly typed", "moderate typed", "None of these", 2, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question1);
        Question question2 = new Question("How many primitive data types are there in Java?", "4", "6", "8", "9", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question2);
        Question question3 = new Question("The smallest integer type is ......... and its size is ......... bits.", "short, 8", "byte, 8", "short, 16", "long, 32", 2, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question3);
        Question question4 = new Question("Size of int in Java is", "16 bit", "32 bit", "64 bit", "8 bit", 2, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question4);
        Question question5 = new Question("Size of float and double in Java is", "32 and 64", "64 and 32", "32 and 32", "64 and 64", 1, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question5);
        Question question6 = new Question("double STATIC = 2.5 ;\n" +
                "System.out.println( STATIC );", "Prints 2.5", "Raises an error as STATIC is used as a variable which is a keyword", "Raises an exception", "None of these  ", 1, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following automatic type conversion will be possible?", "short to int", "byte to int", "int to long", "long to int", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question7);
        Question question8 = new Question("In Java, the word true is ................", "A Java keyword", "A Boolean literal", "Same as value 1", "Same as value 0", 2, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question8);
        Question question9 = new Question("What is the range of byte data type in Java?", "-128 to 127", "-32768 to 32767", " -2147483648 to 2147483647", "None of the mentioned", 1, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question9);
        Question question10 = new Question("Which data type value is returned by all transcendental math functions?", "int", "float", "double", "long", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question10);
        Question question11 = new Question("Which of these coding types is used for data type characters in Java?", "ASCII", "ISO-LATIN-1", "UNICODE", "None of the mentioned", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question11);
        Question question12 = new Question("Which one is a valid declaration of a boolean?", "boolean b1 = 1;", "boolean b2 = ‘false’;", "boolean b2 = false;", "boolean b4 = ‘true’", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question12);
        Question question13 = new Question("Which of the below data type doesn’t support overloaded methods for +,-,* and /?", "int", "float", "double", " BigDecimal", 4, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question13);
        Question question14 = new Question("Which of the following is not a primitive data type ?", "byte", "int", "enum", "long", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question14);
        Question question15 = new Question("Character data type cannot store following value.", " Digit", "Letter", "Special Character", "String", 4, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question15);
        Question question16 = new Question("Default value of variable having boolean data type is ___________.", "true", "false", "null", "garbage", 2, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question16);
        Question question17 = new Question("Default value of String (or any object) in Java Programming is _____________.", "0", "false", "null", "true", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question17);
        Question question18 = new Question(" Integer a = 5; Is an example of ---?", "Auto Boxing", "Type Conversion", "Auto Unboxing", "Immutability", 1, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question18);
        Question question19 = new Question("Which of these is a super class of wrappers Double and Float?", "Long", "Digits", "Float", " Number", 4, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question19);
        Question question20 = new Question("What is the default size of boolean datatype?", " 2 bytes", "4 bytes", "1 bit", "2 bits", 3, Languages.JAVA, Categories.DATA_TYPES);
        insertQuestion(question20);
    }

    //Adding OOP Questions
    private void javaOOPQuestions() {
        Question question1 = new Question("Which of the following is not OOPS concept in Java?", "Inheritance", "Encapsulation", "Polymorphism", "Compilation", 4, Languages.JAVA, Categories.OOP);
        insertQuestion(question1);
        Question question2 = new Question("When does method overloading is determined?", "At run time", "At compile time", "At coding time", "At execution time", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question2);
        Question question3 = new Question("Which concept of Java is a way of converting real world objects in terms of class?", "Polymorphism", "Encapsulation", "Abstraction", " Inheritance", 3, Languages.JAVA, Categories.OOP);
        insertQuestion(question3);
        Question question4 = new Question("Which among the following is called first, automatically, whenever an object is created?", "Class", "Constructor", "New", "Trigger", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question4);
        Question question5 = new Question(" Which of following is shared structure of a set of similar objects", "Encapsulation", "A Class", "Inheritance", "None of Above", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question5);
        Question question6 = new Question(" Which keyword is used to inherit a class or abstract class is", "extends", "extend", "implement", "inherit", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question6);
        Question question7 = new Question("OOPs is invented by _______.", "Andrea Ferro", "Dennis Ritchie", "Adele Goldberg", "Alan Kay", 4, Languages.JAVA, Categories.OOP);
        insertQuestion(question7);
        Question question8 = new Question("Which Feature of OOP encourages the code re-usability?", "Polymorphism", "Inheritance", "Abstraction", "Encapsulation", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question8);
        Question question9 = new Question("In which access should a constructor be defined, so that object of the class can be created in any function?", "Public", "Protected", "Private", "Any access specifier will work", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question9);
        Question question10 = new Question("If class C inherits class B. And B has inherited class A. Then while creating the object of class C, what will be the sequence of constructors getting called?", "Constructor of C then B, finally of A", "Constructor of A then C, finally of B", "Constructor of C then A, finally B", "Constructor of A then B, finally C", 4, Languages.JAVA, Categories.OOP);
        insertQuestion(question10);
        Question question11 = new Question("What is it called where object has its own lifecycle and child object cannot belong to another parent object?", "Aggregation", "Composition", "Encapsulation", "Association", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question11);
        Question question12 = new Question("For constructor overloading, each constructor must differ in ___________ and __________.", "Number of arguments and type of arguments", "Number of arguments and return type", "Return type and type of arguments", "Return type and definition", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question12);
        Question question13 = new Question("How many types of constructors are available, in general, in any language?", "2", "3", "4", "5", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question13);
        Question question14 = new Question("Which constructor is called while assigning some object with another?", "Default", "Parameterized", "Copy", "Direct assignment is used", 3, Languages.JAVA, Categories.OOP);
        insertQuestion(question14);
        Question question15 = new Question("When is the static constructor called?", "After the first instance is created", "Before default constructor call of first instance", "Before first instance is created", "At time of creation of first instance", 3, Languages.JAVA, Categories.OOP);
        insertQuestion(question15);
        Question question16 = new Question("Hiding the implementation complexity can ____________.", "Make the programming easy", "Make the programming complex", "Provide more number of features", "Provide better features", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question16);
        Question question17 = new Question("Class is _________ abstraction.", "Object", "Logical", "Real", "Hypothetical", 2, Languages.JAVA, Categories.OOP);
        insertQuestion(question17);
        Question question18 = new Question("Abstraction can apply to ____________.", "Control and data", "Only data", "Only control", "Classes", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question18);
        Question question19 = new Question("Encapsulation and abstraction differ as ____________.", "Binding and Hiding respectively", "Hiding and Binding respectively", "Can be used any way", "Hiding and hiding respectively", 1, Languages.JAVA, Categories.OOP);
        insertQuestion(question19);
        Question question20 = new Question("Encapsulation helps in writing ___________ classes in java.", "Mutable", "Abstract", "Wrapper", "Immutable", 4, Languages.JAVA, Categories.OOP);
        insertQuestion(question20);

    }

    //Adding Function Questions
    private void javaFunctionQuestions() {
        Question question1 = new Question("What is the return type of a method that does not return any value?", "int", "float", "double", "void", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question1);
        Question question2 = new Question("What is the process of defining more than one method in a class differentiated by method signature?", "Function overriding", "Function overloading", "Function doubling", "None of the mentioned", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following is a method having same name as that of it’s class?", " finalize", "delete", "class", "constructor", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question3);
        Question question4 = new Question("Which method can be defined only once in a program?", "main method", "finalize method", "static method", " private method", 1, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question4);
        Question question5 = new Question("Which method of the Class.class is used to determine the name of a class represented by the class object as a String?", "getClass()", "intern()", "getName()", "toString()", 3, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question5);
        Question question6 = new Question("Which of these method of String class is used to obtain character at specified index?", "char()", "Charat()", "charat()", " charAt()", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question6);
        Question question7 = new Question("Which of these method of String class can be used to test to strings for equality?", "isequal()", "isequals()", "equal()", "equals()", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question7);
        Question question8 = new Question(" class string_class{\n" +
                "        public static void main(String args[]){\n" +
                "            String obj = \"I LIKE JAVA\";   \n" +
                "            System.out.println(obj.charAt(3));\n" +
                "        }}", "I", "L", "K", "E", 1, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question8);
        Question question9 = new Question("  class string_demo {" +
                "            String obj = \"I\" + \"like\" + \"Java\";   \n" +
                "            System.out.println(obj);     \n" +
                "        } }", "I", "like", "Java", "IlikeJava", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question9);
        Question question10 = new Question("Which of these method of Object class can generate duplicate copy of the object on which it is called?", "clone()", " copy()", "duplicate()", "dito()", 1, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question10);
        Question question11 = new Question("Which of these method is a rounding function of Math class?", "max()", "min()", "abs()", "all of the mentioned", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question11);
        Question question12 = new Question("What is the value of “d” in the following Java code snippet? \n double d = Math.round ( 2.5 + Math.random() );", "2", "3", "2.5", "4", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question12);
        Question question13 = new Question(" int x = 3.14; \n" +
                "             int y = (int) Math.abs(x);\n" +
                "             System.out.print(y);", "0", "3", "3.0", "3.1", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question13);
        Question question14 = new Question("Which of these method returns the remainder of dividend / divisor?", "remainder()", "getRemainder()", "CSIremainder()", "IEEEremainder()", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question14);
        Question question15 = new Question("Which of these methods of Boolean wrapper returns boolean equivalent of an object.", "getBool()", "booleanValue()", "getbooleanValue()", "getboolValue()", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question15);
        Question question16 = new Question("Which of these methods return string equivalent of Boolean object?", "getString()", "toString()", "converString()", "getStringObject()", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question16);
        Question question17 = new Question("Which of these methods is not defined in both Byte and Short wrappers?", "intValue()", "isInfinite()", "toString()", "hashCode()", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question17);
        Question question18 = new Question("Which of these method returns a largest whole number less than or equal to variable X?", "double ceil(double X)", " double floor(double X)", "double max(double X)", "double min(double X)", 2, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question18);
        Question question19 = new Question("Which of these method of Object class is used to obtain class of an object at run time?", "get()", "void getclass()", "Class getclass()", "None of the mentioned", 3, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question19);
        Question question20 = new Question("Which of these is correct way of calling a constructor having no parameters, of superclass A by subclass B?", "super(void);", "superclass.();", "super.A();", "super();", 4, Languages.JAVA, Categories.FUNCTION);
        insertQuestion(question20);

    }

    //Adding Exception Handling Questions
    private void javaExceptionHandling() {
        Question question1 = new Question(" When does Exceptions in Java arises in code sequence?", " Run Time", "Can Occur Any Time", "Compilation Time", "None of the mentioned", 1, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question1);
        Question question2 = new Question("Which of these is a super class of all errors and exceptions in the Java language?", "Catchable", "Throwable", "RunTimeExceptions", "None of the above", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question2);
        Question question3 = new Question("In which of the following package Exception class exist?", " java.file", " java.lang", "java.io", "java.util", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question3);
        Question question4 = new Question("Which exception is thrown when divide by zero statement executes?", "NumberFormatException", " NullPointerException", "ArithmeticException", "None of these", 3, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following should be true of the object thrown by a thrown statement?", "Should be assignable to String type", "Should be assignable to Exception type", "Should be assignable to Throwable type", "Should be assignable to Error type", 3, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question5);
        Question question6 = new Question("Which of these is a super class of all exceptional type classes?", "String", "RuntimeExceptions", "Throwable", " Catchable", 3, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question6);
        Question question7 = new Question("Which of these handles the exception when no catch is used?", "Default handler", "finally", "throw handler", "Java run time system", 1, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question7);
        Question question8 = new Question("What exception thrown by parseInt() method?", "ArithmeticException", "ClassNotFoundException", "NullPointerException", "NumberFormatException", 4, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question8);
        Question question9 = new Question("Which of these class is related to all the exceptions that can be caught by using catch?", "Error", "Exception", "RuntimeException", "All of the mentioned", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question9);
        Question question10 = new Question("Which of these keywords must be used to handle the exception thrown by try block in some rational manner?", "try", "finally", "throw", " catch", 4, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question10);
        Question question11 = new Question("Which of these keywords must be used to monitor for exceptions?", "try", "finally", "throw", "catch", 1, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question11);
        Question question12 = new Question("The class at the top of exception class hierarchy is .................", "ArithmeticException", "Throwable", "Object", "Exception", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question12);
        Question question13 = new Question("What happen in case of multiple catch blocks?", "Either super or subclass can be caught first.", "The superclass exception must be caught first.", "The superclass exception cannot caught first.", "None of these", 3, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question13);
        Question question14 = new Question("Which exception is thrown when an array element is accessed beyond the array size?", "ArrayElementOutOfBounds", "ArrayIndexOutOfBoundsException", "ArrayIndexOutOfBounds", "None of these", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question14);
        Question question15 = new Question("Which of these operator is used to generate an instance of an exception than can be thrown by using throw?", "new", "malloc", "alloc", "thrown", 1, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question15);
        Question question16 = new Question(" A single try block must be followed by which of these?", "finally", "catch", "finally & catch", "none of the mentioned", 3, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question16);
        Question question17 = new Question("Which of these exceptions handles the divide by zero error?", "MathException", "ArithmeticException", "IllegalAccessException", "IllegalException", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question17);
        Question question18 = new Question("What is the use of try & catch?", "It allows us to manually handle the exception", "It allows to fix errors", "It prevents automatic terminating of the program in cases when an exception occurs", "All of the mentioned", 4, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question18);
        Question question19 = new Question("Which of these statements is incorrect?", "try block need not to be followed by catch block", "try block can be followed by finally block instead of catch block", " try can be followed by both catch and finally block", "try need not to be followed by anything", 4, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question19);
        Question question20 = new Question("Which of these methods return description of an exception?", "getException()", "getMessage()", "obtainDescription()", "obtainException()", 2, Languages.JAVA, Categories.EXCEPTION_HANDLING);
        insertQuestion(question20);
    }

    //Adding Multi Treading Questions
    private void javaMultiThreading() {
        Question question1 = new Question("Multithreaded programming is a process?", "where two different processes run simultaneously", "where two or more parts of same process run simultaneously.", " where many different process are able to access same information.", "where a single process can access information from many sources.", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question1);
        Question question2 = new Question("What is maximum thread priority in Java", "5", "10", "12", "15", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question2);
        Question question3 = new Question("Which method must be implemented by a Java thread?", "run()", "start()", "execute()", "onStart()", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question3);
        Question question4 = new Question("Which of these are types of multitasking?", "Process based", " Thread based", "Process and Thread based", "None of the mentioned", 3, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question4);
        Question question5 = new Question("Thread priority in Java is?", "Integer", "float", "double", "long", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question5);
        Question question6 = new Question(" Thread t = Thread.currentThread();\n" +
                "            System.out.println(t);   ", "Thread[5,main]", "Thread[main,5]", "Thread[main,0]", "Thread[main,5,main]", 4, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question6);
        Question question7 = new Question("What requires less resources?", "Thread", "Process", "Thread and Process", "None of the Above", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question7);
        Question question8 = new Question("Which of the following is a correct constructor for thread?", "Thread(Runnable a, String str)", "Thread(int priority)", "Thread(Runnable a, int priority)", "Thread(Runnable a, ThreadGroup t)", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following will ensure the thread will be in running state?", "notify()", "wait()", "Thread.killThread()", "yield()", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question9);
        Question question10 = new Question("What should not be done to avoid deadlock?", "Avoid using multiple threads", " Avoid hold several locks at once", "Execute foreign code while holding a lock", "Use interruptible locks", 3, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question10);
        Question question11 = new Question("What is the name of the method that is used to start the execution of a thread?", " init();", "start();", "run();", "resume();", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question11);
        Question question12 = new Question("Which function of pre defined class Thread is used to check weather current thread being checked is still running?", "isAlive()", "Join()", "isRunning()", "Alive()", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question12);
        Question question13 = new Question("Which of these method of Thread class is used to find out the priority given to a thread?", "get()", "ThreadPriority()", "getPriority()", "getThreadPriority()", 3, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question13);
        Question question14 = new Question("How many threads can a process contain?", "1", "2", "multiple", "none", 3, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question14);
        Question question15 = new Question("What state does Thread enter in when it has been created and started?", "New", "Runnable", "Running", "Waiting", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question15);
        Question question16 = new Question("What is valid about threads", "Threads have their own heap allocated area.", "Threads have their own stack.", "Threads doesn't have own stack.", "None", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question16);
        Question question17 = new Question(" What is the default value of priority variable MIN_PRIORITY AND MAX_PRIORITY?", " 0 & 256", "0 & 1", "1 & 10", "1 & 256", 3, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question17);
        Question question18 = new Question("Which of these keywords are used to implement synchronization?", "synchronize", "synchronised", "sync", "synchronized", 4, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question18);
        Question question19 = new Question("Which of these method of Thread class is used to Suspend a thread for a period of time?", "sleep()", "terminate()", "suspend()", "stop()", 1, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question19);
        Question question20 = new Question("A Daemon thread is a ---?", "Low priority thread ", "Assistant thread", "Controller thread", "Dangerous thread ", 2, Languages.JAVA, Categories.MULTI_THREADING);
        insertQuestion(question20);
    }

    //Adding Data Structure Questions
    private void javaDataStructure() {
        Question question1 = new Question("Which of these best describes an array?", "A data structure that shows a hierarchical behaviour", "Container of objects of similar types", "Arrays are immutable once initialised", "Array is not a data structure", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question1);
        Question question2 = new Question("How do you instantiate an array in Java?", "int arr[] = new int(3);", "int arr[];", "int arr[] = new int[3];", " int arr() = new int(3);", 3, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question2);
        Question question3 = new Question("When does the ArrayIndexOutOfBoundsException occur?", "Compile-time", "Run-time", "Not an error", "Not an exception at all", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question3);
        Question question4 = new Question("What are the advantages of arrays?", "Objects of mixed data types can be stored", "Elements in an array cannot be sorted", "Index of first element of an array is 1", "Easier to store elements of same data type", 4, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question4);
        Question question5 = new Question("Elements in an array are accessed ________", "randomly", "sequentially", "exponentially", "logarithmically", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question5);
        Question question6 = new Question("Assuming int is of 4bytes, what is the size of int arr[15];?", "15", "30", "19", "60", 4, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question6);
        Question question7 = new Question("What are the disadvantages of arrays?", "Data structure like queue or stack cannot be implemented", "chances of wastage of memory space", "Index value of an array can be negative", "Elements are sequentially accessed", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question7);
        Question question8 = new Question("A linear collection of data elements where the linear node is given by means of pointer is called?", "Linked list", "Node list", "Primitive list", "Unordered list", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question8);
        Question question9 = new Question("...... is not the operation that can be performed on queue.", "Traversal", "Insertion", " Deletion", "Retrieval", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question9);
        Question question10 = new Question("What does ‘stack overflow’ refer to?", "accessing item from an undefined stack", "adding items to a full stack", "removing items from an empty stack", "index out of bounds exception", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question10);
        Question question11 = new Question("A queue follows __________", "FIFO (First In First Out) principle", "LIFO (Last In First Out) principle", "Ordered array", "Linear tree", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question11);
        Question question12 = new Question("A stack follows __________", "FIFO (First In First Out) principle", "LIFO (Last In First Out) principle", "Ordered array", "Linear tree", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question12);
        Question question13 = new Question("If the elements “A”, “B”, “C” and “D” are placed in a queue and are deleted one at a time, in what order will they be removed?", "ABCD", "DCBA", "DCAB", "ABDC", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question13);
        Question question14 = new Question("In linked list implementation of a queue, where does a new element be inserted?", "At the head of link list", "At the centre position in the link list", "At the tail of the link list", "At any position in the linked list", 3, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is false about a doubly linked list?", "We can navigate in both the directions", "It requires more space than a singly linked list", "The insertion and deletion of a node take a bit longer", "Implementing a doubly linked list is easier than singly linked list", 4, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question15);
        Question question16 = new Question("With what data structure can a priority queue be implemented?", "Array", "List", "Heap", "Tree", 4, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question16);
        Question question17 = new Question("The number of edges from the root to the node is called __________ of the tree.", "Height", "Depth", "Length", "Width", 2, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question17);
        Question question18 = new Question("Which of the following is not an advantage of trees?", "Hierarchical structure", "Faster search", "Router algorithms", "Undo/Redo operations in a notepad", 4, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question18);
        Question question19 = new Question("What data structure is used when converting an infix notation to prefix notation?", "Stack", "Queue", "B-Trees", "Linked-list", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question19);
        Question question20 = new Question("Which of the following is an infix expression?", "(a+b)*(c+d)", "ab+c*", " +ab", "abc+*", 1, Languages.JAVA, Categories.DATA_STRUCTURE);
        insertQuestion(question20);
    }

    //Adding Inner Classes Questions
    private void javaInnerClasses() {
        Question question1 = new Question("Which among the following best describes a nested class?", "Class inside a class", "Class inside a function", "Class inside a package", "Class inside a structure", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question1);
        Question question2 = new Question("How many categories are nested classes divided into?", "2", "3", "4", "5", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question2);
        Question question3 = new Question("Which feature of OOP reduces the use of nested classes?", "Encapsulation", "Inheritance", "Binding", "Binding", 2, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question3);
        Question question4 = new Question("Use of nested class ____________ encapsulation.", "Increases", "Decreases", "Doesn't affect", "Slightly decreases", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question4);
        Question question5 = new Question("The nested class can be declared ____________", "Public", "Private", "Protected", "Public, Protected, Private or Package private", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question5);
        Question question6 = new Question("Which is true about a method-local inner class?", "It must be marked final.", "It can be marked abstract.", "It can be marked public.", "It can be marked static.", 2, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question6);
        Question question7 = new Question("Which constructs an anonymous inner class instance?", "Runnable r = new Runnable() { };", "Runnable r = new Runnable(public void run() { });", "Runnable r = new Runnable {public void run(){}};", "System.out.println(new Runnable(){ public void run(){}});", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question7);
        Question question8 = new Question("Non-static nested classes have access to _____________ from enclosing class.", "Private members", "Protected members", "Public members", "All the members", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question8);
        Question question9 = new Question("Static nested classes doesn't have access to ______________ from enclosing class.", "Private members", "Protected members", "Public members", "Any other members", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question9);
        Question question10 = new Question("Which among the following is the correct advantage/disadvantage of nested classes?", "Makes the code more complex", "Makes the code unreadable", "Makes the code efficient and readable", "Makes the code multithreaded", 3, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question10);
        Question question11 = new Question("How to access static nested classes?", "OuterClass.StaticNestedClass", "OuterClass->StaticNestedClass", "OuterClass(StaticNestedClass)", "OuterClass[StaticNestedClass]", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question11);
        Question question12 = new Question("Instance of inner class can exist only _________ enclosing class.", "Outside", "Private to", "Public to", "Within", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question12);
        Question question13 = new Question("A static nested class is _____________ class in behavior that is nested in another _________ class.", "Top level, top level", "Top level, low level", "Low level, top level", "Low level, low level", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question13);
        Question question14 = new Question("What are local classes?", "Classes declared inside a package", "Classes declared inside a class", "Classes declared inside a function", "Classes declared inside a structure", 3, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question14);
        Question question15 = new Question("Which type of data can a local class access from the function in which it is defined?", "Static and extern", "Abstract and static", "Void and extern", "Const and static", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question15);
        Question question16 = new Question("How many local classes can be defined inside a single function?", "only 1", "2", "5", "As many as required", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question16);
        Question question17 = new Question("How to create object of the inner class?", "OuterClass.InnerClass innerObject = outerObject.new InnerClass();", "OuterClass.InnerClass innerObject = new InnerClass();", "InnerClass innerObject = outerObject.new InnerClass();", "OuterClass.InnerClass = outerObject.new InnerClass();", 1, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question17);
        Question question18 = new Question("All the data members of local class must be ___________", "Defined with declaration", "Defined in constructor", "Declared and defined in constructor", "Declared using a member function", 2, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question18);
        Question question19 = new Question("Can a function, other than the enclosing function of local class, access the class members?", "Yes, using object", " Yes, using direct call", "Yes, using pointer", "No, can’t access", 4, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question19);
        Question question20 = new Question("What is the scope of local class?", "Within the class only", "Within the function ", "Within the program", "One time creation and live till end of program", 2, Languages.JAVA, Categories.INNER_CLASS);
        insertQuestion(question20);
    }

    //Adding Collections Questions
    private void javaCollectionFrameWork() {
        Question question1 = new Question("Which of these packages contain all the collection classes?", "java.lang", "java.util", "java.net", " java.awt", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question1);
        Question question2 = new Question("Which of these methods deletes all the elements from invoking collection?", "clear()", "reset()", "delete()", "refresh()", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question2);
        Question question3 = new Question("Which of these classes is not part of Java’s collection framework?", "Maps", "Array", "Stack", "Queue", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question3);
        Question question4 = new Question("What is Collection in Java?", "A group of objects", "A group of classes", "A group of interfaces", "None of the mentioned", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question4);
        Question question5 = new Question("The collection", "extends Collections class", "extends Iterable interface", "implements Serializable interface", "implements Traversable interface", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question5);
        Question question6 = new Question("List, Set and Queue __________ Collection.", "extends", "implements", "both of the above", "None of the above", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question6);
        Question question7 = new Question("Which among the following stores element in ascending order?", "ArrayList", "HashSet", "TreeSet", "Both A & C", 3, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question7);
        Question question8 = new Question("Iterator and ListIterator can traverse over", "lists", "sets", "maps", "All of the above", 4, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question8);
        Question question9 = new Question("Elements of which of the collection can be traversed using Enumeration?", "ArrayList", "Vector", "HashSet", "TreeMap", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question9);
        Question question10 = new Question("Arraylist, Linkedlist and vector are all ___________", "interface", "class", "enums", "Depends on implementation", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question10);
        Question question11 = new Question("Which of these methods can be used to move to next element in a collection?", "next()", "hasNext()", "move()", "shuffle()", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question11);
        Question question12 = new Question("Which of these methods sets every element of a List to a specified object?", "set()", "fill()", "add()", "complete()", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question12);
        Question question13 = new Question("Which of these return type of hasNext() method of an iterator?", "Integer", "Collections Object", "Double", "Boolean", 4, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question13);
        Question question14 = new Question("The Comparable interface contains which called?", "toCompare", "compare", "compareTo", "compareWith", 4, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question14);
        Question question15 = new Question("The default capacity of a ArrayList is:", "12", "16", "32", "10", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question15);
        Question question16 = new Question("Deque and Queue are derived from:", "AbstractList", "Collection", "AbstractCollection", "List", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question16);
        Question question17 = new Question("Which interface restricts duplicate elements?", "Set", "List", "Map", "All of these", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question17);
        Question question18 = new Question("LinkedList implements?", "Deque", "List", "Set", "None", 2, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question18);
        Question question19 = new Question("Which does not allow to store a null value?", "TreeSet", "LinkedHashSet", "HashSet", "None", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question19);
        Question question20 = new Question("An ordered array has a search time complexity of?", "O(n)", "O(1)", "O(log n)", "O(n-1)", 1, Languages.JAVA, Categories.COLLECTION_FRAME_WORK);
        insertQuestion(question20);
    }

    //Adding GUI Questions
    private void javaGUI() {
        Question question1 = new Question("Which of these package is used for graphical user interface?", "java.applet", "java.awt", "java.io", "java.awt.image", 2, Languages.JAVA, Categories.GUI);
        insertQuestion(question1);
        Question question2 = new Question("Which of these class is super class of all the events?", "EventObject", "EventClass", "ActionEvent", "ItemEvent", 1, Languages.JAVA, Categories.GUI);
        insertQuestion(question2);
        Question question3 = new Question("Which object can be constructed to show any number of choices in the visible window?", "Labels", "List", "Checkbox", "Choice", 2, Languages.JAVA, Categories.GUI);
        insertQuestion(question3);
        Question question4 = new Question("Which method is used to set the graphics current color to the specified color in the graphics class?", "setFont(Font font)", "setColor(Color c)", "drawString(String str, int x, int y)", "None of the above", 2, Languages.JAVA, Categories.GUI);
        insertQuestion(question4);
        Question question5 = new Question("AWT Stands for ?", "Applet Windowing Toolkit", "Absolute Windowing Toolkit", "Abstract Windowing Toolkit", "None of the above", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question5);
        Question question6 = new Question("Which class is used for this Processing Method processActionEvent()?", "Button,List,MenuItem", "Button,Checkbox,Choice", "Scrollbar,Component,Button", "None of the above", 1, Languages.JAVA, Categories.GUI);
        insertQuestion(question6);
        Question question7 = new Question("Which method can set or change the text in a Label?", "getText()", "writeText()", "setText()", "All", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question7);
        Question question8 = new Question("Which is a component in AWT that can contain another components like buttons, textfields, labels etc.?", "Window", "Panel", "Frame", " Container", 4, Languages.JAVA, Categories.GUI);
        insertQuestion(question8);
        Question question9 = new Question("Which package provides many event classes and Listener interfaces for event handling?", "java.awt", "java.awt.Graphics", "java.awt.event", "None of the above", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question9);
        Question question10 = new Question("Which of the following sets the frame to 300 pixels wide by 200 high?", "frm.setSize(300, 200);", "frm.setSize(200, 300);", " frm.paint(300, 200);", "frm.setVisible(300, 200);", 1, Languages.JAVA, Categories.GUI);
        insertQuestion(question10);
        Question question11 = new Question("What is the one component that nearly all GUI programs will have?", "Button", "Monitor", "Mouse", "Frame", 4, Languages.JAVA, Categories.GUI);
        insertQuestion(question11);
        Question question12 = new Question("The three software parts of a GUI program are:", " Windows, Buttons, Mice", " GUI Components, Graphics, Code", "GUI Components, Event Listeners, Application Code", "Frames, Code, Events", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question12);
        Question question13 = new Question(" What is a Graphics object?", "The part of the Frame that you can draw on.", "The whole Frame.", "The entire monitor.", "The graphics board.", 1, Languages.JAVA, Categories.GUI);
        insertQuestion(question13);
        Question question14 = new Question("Which class provides many methods for graphics programming?", "java.awt", "java.Graphics", "java.awt.Graphics", "None of the above", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question14);
        Question question15 = new Question("Swing components that don't rely on native GUI are referred to as ______.", "lightweight components", "heavyweight components", "GUI components", " Non-GUI components", 1, Languages.JAVA, Categories.GUI);
        insertQuestion(question15);
        Question question16 = new Question("Which of these methods can be used to know which key is pressed ?", "getActionEvent()", "getActionKey()", "getModifier()", "getKey()", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following classes is a heavyweight component?", "JButton", "JTextField", "JPanel", "JFrame", 4, Languages.JAVA, Categories.GUI);
        insertQuestion(question17);
        Question question18 = new Question("Which component cannot be added to a container?", "JButton", "JPanel", "JFrame", "JComponent", 3, Languages.JAVA, Categories.GUI);
        insertQuestion(question18);
        Question question19 = new Question("What is best to describe the relationship between JComponent and JButton?", "Association", "Aggregation", "Composition", "Inheritance", 4, Languages.JAVA, Categories.GUI);
        insertQuestion(question19);
        Question question20 = new Question("Where can the event handling code be written?", "Same class", "Other class", "Anonymous class", "All mentioned above", 4, Languages.JAVA, Categories.GUI);
        insertQuestion(question20);
    }

    //Adding JDBC Questions
    private void javaJDBC() {
        Question question1 = new Question("Which of the following is advantage of using JDBC connection pool?", " Slow performance", "Using more memory", "Using less memory", "Better performance", 4, Languages.JAVA, Categories.JDBC);
        insertQuestion(question1);
        Question question2 = new Question("Which of the following is not a component/class of JDBC API?", "Statement", "ResultSet", "SQLException", " ConnectionPool", 4, Languages.JAVA, Categories.JDBC);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following type of JDBC driver, is also called Type 3 JDBC driver?", "JDBC-ODBC Bridge plus ODBC driver", "Native-API, partly Java driver", "JDBC-Net, pure Java driver", "Native-protocol, pure Java driver", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question3);
        Question question4 = new Question("Where is metadata stored in MySQL?", "In the MySQL database metadata", "In the MySQL database metasql", "In the MySQL database mysql", "None of the above is correct", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question4);
        Question question5 = new Question("Which JDBC driver Type(s) can be used in either applet or servlet code?", "Both Type 1 and Type 2", "Both Type 1 and Type 3", "Both Type 3 and Type 4", "Type 4 only", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question5);
        Question question6 = new Question("A JAVA program that uses JDBC, should determine that information is directly from the database system at runtime, to have", "Efficient system", "Robust system", "Active system", "Accurate system", 2, Languages.JAVA, Categories.JDBC);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following is used to rollback a JDBC transaction?", "rollback()", "rollover()", "deleteTransaction()", "RemoveTransaction()", 1, Languages.JAVA, Categories.JDBC);
        insertQuestion(question7);
        Question question8 = new Question("Which interfaces provide methods for batch processing in JDBC?", "java.sql.Statement", " java.sql.PreparedStatement", "All the above", "None of the above", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question8);
        Question question9 = new Question("JDBC technology-based drivers generally fit into how many categories?", "4", "3", "5", "2", 1, Languages.JAVA, Categories.JDBC);
        insertQuestion(question9);
        Question question10 = new Question("JDBC stands for?", " Java database concept", "Java database connectivity", "Java database communications", "None of the above", 2, Languages.JAVA, Categories.JDBC);
        insertQuestion(question10);
        Question question11 = new Question("Which JDBC drivers will run your program?", "The JDBC-ODBC bridge", "The JDBC driver manager", "The JDBC driver test suite", "None of the above", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question11);
        Question question12 = new Question("The interface ResultSet has a method, getMetaData(), that returns a/an", "Tuple", "Value", "Object", "Result", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question12);
        Question question13 = new Question("Abbreviate the term UDA?", " Unified Data Access", "Universal Data Access", "Universal Digital Access", "Uniform Data Access", 2, Languages.JAVA, Categories.JDBC);
        insertQuestion(question13);
        Question question14 = new Question("Which of the following contains both date and time?", "java.io.date", "java.sql.date", "java.util.date", "java.util.dateTime", 4, Languages.JAVA, Categories.JDBC);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is method of JDBC batch process?", "setBatch()", "deleteBatch()", "removeBatch()", "addBatch()", 4, Languages.JAVA, Categories.JDBC);
        insertQuestion(question15);
        Question question16 = new Question("Which of the following is not a JDBC connection isolation levels?", "TRANSACTION_NONE", "TRANSACTION_READ_COMMITTED", "TRANSACTION_REPEATABLE_READ", "TRANSACTION_NONREPEATABLE_READ", 4, Languages.JAVA, Categories.JDBC);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following is used to call stored procedure?", "Statement", "PreparedStatement", "CallableStatement", "CalledStatement", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question17);
        Question question18 = new Question("Which of the following is used to limit the number of rows returned?", "setMaxRows(int i)", "setMinRows(int i)", "getMaxRows(int i)", "getMinRows(int i)", 1, Languages.JAVA, Categories.JDBC);
        insertQuestion(question18);
        Question question19 = new Question("Which packages contain the JDBC classes?", "java.jdbc and javax.jdbc", "java.jdbc and java.jdbc.sql", "java.sql and javax.sql", "java.rdb and javax.rdb", 3, Languages.JAVA, Categories.JDBC);
        insertQuestion(question19);
        Question question20 = new Question("Which one of the following contains date information?", "java.sql.TimeStamp", " java.sql.Time", "java.io.Time", "java.io.TimeStamp", 1, Languages.JAVA, Categories.JDBC);
        insertQuestion(question20);
    }

    //Adding Interfaces Questions
    private void javaInterfaces() {
        Question question1 = new Question("Which of these can be used to fully abstract a class from its implementation?", "Objects", "Packages", "Interfaces", "None of the Mentioned", 3, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question1);
        Question question2 = new Question("What type of variable can be defined in an interface?", "public static", "private final", "public final", "static final", 4, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question2);
        Question question3 = new Question("Which of these keywords is used by a class to use an interface defined previously?", "import", "Import", "implements", "Implements", 3, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question3);
        Question question4 = new Question("Which of the following is the correct way of implementing an interface salary by class manager?", "class manager extends salary {}", "class manager implements salary {}", "class manager imports salary {}", "none of the mentioned", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question4);
        Question question5 = new Question("What does an interface contain?", "Method definition", " Method declaration", "Method declaration and definition", "Method Name", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question5);
        Question question6 = new Question("What happens when a constructor is defined for an interface?", "Compilation failure", "Runtime Exception", "The interface compiles successfully", "The implementing class will throw exception", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question6);
        Question question7 = new Question("What type of methods an interface contain by default?", "abstract", "static", "final", "private", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question7);
        Question question8 = new Question("Which of the following access specifiers can be used for an interface?", "Protected", "Private", "Public", "Public, protected, private", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question8);
        Question question9 = new Question("What happens when we access the same variable defined in two interfaces implemented by the same class?", " Compilation failure", "Runtime Exception", "The JVM is not able to identify the correct variable", "The interfaceName.variableName needs to be defined", 4, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question9);
        Question question10 = new Question("Which of these keywords is used to define interfaces in Java?", "interface", "Interface", "intf", "Intf", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question10);
        Question question11 = new Question("Which is correct option about java interface?", "Interface is used to achieve multiple inheritance in java", "Object of an interface cannot be created", "An interface can extend another interface", "All of the above", 4, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question11);
        Question question12 = new Question("Which is true statements about an interface in java?", "An interface can extend another interface", "We can create object of an interface in java", "An interface can have constructor", "None", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question12);
        Question question13 = new Question("Which of the following is a use of interface?", " Code Reusability", " Runtime Polymorphism ", "Data Encapsulation", "Less Memory", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question13);
        Question question14 = new Question("What type of inheritance is facilitated by interfaces?", "Feature Based", "Role Based", "Method Based", "None of the above", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question14);
        Question question15 = new Question("When a class A implements an interface B, what relation is created b/w them?", "A is B", "A has B", "B is A", "B has A", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question15);
        Question question16 = new Question("Which of the following can't be a member of an interface?", "Constructors", "Static Methods", "on Static Data Members", "All of these", 4, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question16);
        Question question17 = new Question("What will happen if we provide concrete implementation of method in interface?", "Runtime exception is thrown", "Compilation failure", "Method not found exception is thrown", "Concrete class don't this implementation", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question17);
        Question question18 = new Question("Can an interface ever contain method bodies?", "Yes", "No", "Always", "Sometimes", 2, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question18);
        Question question19 = new Question("Can an interface be given the private access modifier? ", "No- then the interface could never be used", "No- since only private classes could use the interface", "Yes- this would make all of its methods and constants private", "Yes- depend on situation", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question19);
        Question question20 = new Question("What is an interface?", "collection of constants and method declarations.", "class that a child class can extend.", "collection of GUI components", "collection of public methods of a class", 1, Languages.JAVA, Categories.INTERFACES);
        insertQuestion(question20);
    }

    /*===============================================================================================================================================*/
    /* Html */
    /*===============================================================================================================================================*/
    //Adding Html Basics Questions
    private void htmlBasics() {
        Question question1 = new Question("HTML is what type of language ?", "Scripting Language", "Markup Language", "Programming Language", "Network Protocol", 2, Languages.HTML, Categories.BASICS);
        insertQuestion(question1);
        Question question2 = new Question("HTML uses", "User defined tags", "Pre-specified tags", "Fixed tags defined by the language", "Tags only for linking", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question2);
        Question question3 = new Question("The year in which HTML was first proposed _______.", "1990", "1995", "2000", "2005", 1, Languages.HTML, Categories.BASICS);
        insertQuestion(question3);
        Question question4 = new Question("What is the full form of HTML?", "Hyper Teach Markup Language", "Hyper Tech Markup Language", "Hyper Tech Makeup Language", "Hyper Text Markup Language", 4, Languages.HTML, Categories.BASICS);
        insertQuestion(question4);
        Question question5 = new Question("What should be the first tag in any HTML document?", "<head>", "<title>", "<html>", "<body>", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question5);
        Question question6 = new Question("HTML web pages can be read and rendered by _________.", "Compiler", "Server", "Web Browser", "Interpreter", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question6);
        Question question7 = new Question("HTML tags are surrounded by which type of brackets.", "Curly", "Square", "Round", "Angle", 4, Languages.HTML, Categories.BASICS);
        insertQuestion(question7);
        Question question8 = new Question("HTML documents stored in the file in the form ______", ".hxm", ".htm or .html", ".hm", ".hml", 2, Languages.HTML, Categories.BASICS);
        insertQuestion(question8);
        Question question9 = new Question("Which attribute sets the text direction as related to lang attribute.", " Sub", "Ds", "Lang", "Dir", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question9);
        Question question10 = new Question("Choose the correct tag for the largest heading in HTML.", "h1", "h3", "h4", "h6", 1, Languages.HTML, Categories.BASICS);
        insertQuestion(question10);
        Question question11 = new Question("In which part of the HTML metadata is contained?", "body tag", "hmtl tag", "head tag", "title tag", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question11);
        Question question12 = new Question("Which feature was already introduced before HTML5?", "Canvas/SVG", "Video", "Geolocation", "Frames", 4, Languages.HTML, Categories.BASICS);
        insertQuestion(question12);
        Question question13 = new Question("What is the correct syntax of doctype in HTML5?", "<doctype html!>", "<!doctype html>", "<doctype html>", "</doctype html>", 2, Languages.HTML, Categories.BASICS);
        insertQuestion(question13);
        Question question14 = new Question("Which tag supports Non-English language?", "<input>", "<audio>", "<embed>", "<bdo>", 4, Languages.HTML, Categories.BASICS);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is not supported in HTML5?", "scheme", "content", "http-equiv", "name", 1, Languages.HTML, Categories.BASICS);
        insertQuestion(question15);
        Question question16 = new Question("What if one does not use the doctype in the starting of HTML document?", "Browser finds the document in quirky mode", "Browser finds a document in standard mode", "Browser stops working", "Browser crashes after showing the page", 1, Languages.HTML, Categories.BASICS);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following is not sectioning elements?", "<article>", "<aside>", "<nav>", "<header>", 4, Languages.HTML, Categories.BASICS);
        insertQuestion(question17);
        Question question18 = new Question("What is the replacement for cookies in HTML5?", "Web beacons", "Java scripts", "Local Storage", " All the above", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question18);
        Question question19 = new Question("The default character encoding in HTML5 is.", "UTF-16", "UTF-32", "UTF-8", "ISO-8859-1", 3, Languages.HTML, Categories.BASICS);
        insertQuestion(question19);
        Question question20 = new Question("The <applet> element in HTML5 is replaced with?", "<object>", "<frame>", "<form>", "<class>", 1, Languages.HTML, Categories.BASICS);
        insertQuestion(question20);
    }

    //Adding Html Tags Questions
    private void htmlTagsFirst() {
        Question question1 = new Question("Which works similar to <i> element?", "<strong>", "<em>", "<b>", "<blockquote>", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question1);
        Question question2 = new Question("Which of the following is not semantic element?", "<table>", "<article>", "<div>", "<form>", 3, Languages.HTML, Categories.TAGS1);
        insertQuestion(question2);
        Question question3 = new Question("Anchor tag in HTML is denoted as", "<a>", "<anchor>", "<link>", "<href>", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question3);
        Question question4 = new Question("Which of the following is not a pair tag?", "<u>", "<p>", "<area>", "<img>", 4, Languages.HTML, Categories.TAGS1);
        insertQuestion(question4);
        Question question5 = new Question("Which element is used for short quote?", "<q>", "<quote>", "<blockquote>", "<abbr>", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question5);
        Question question6 = new Question("What is the work of <address> tag?", "contains contact details for author", "contains IP address", "contains home address", "contains url", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question6);
        Question question7 = new Question("To show deleted text, which element is used?", "<ins>", "<delete>", "<del>", "<em>", 3, Languages.HTML, Categories.TAGS1);
        insertQuestion(question7);
        Question question8 = new Question("How <bdo> element works?", "stops writing in the current text direction", "override text direction", "only override direction of rtl text", "only changes the direction of ltr text", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question8);
        Question question9 = new Question("Which element is used for abbreviation or acronym?", "<abr>", "<q>", "<abbr>", "<shortcut>", 3, Languages.HTML, Categories.TAGS1);
        insertQuestion(question9);
        Question question10 = new Question("Which element defines a title of the Work?", "<abbr>", "<cite>", "<address>", "<blockquote>", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question10);
        Question question11 = new Question("For smaller text which element is used?", "<tiny>", "<min>", "<short>", "<small>", 4, Languages.HTML, Categories.TAGS1);
        insertQuestion(question11);
        Question question12 = new Question("Which of the following tag defines the progress of a task?", "<meter>", "<progress>", "<gauge>", "<wbr>", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question12);
        Question question13 = new Question("Which of the following defines some content aside from the content it is placed in (like a sidebar)?", "<aside>", "<header>", "<sidebar>", "<nav>", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question13);
        Question question14 = new Question("Which of the following gives a text description of the image if it is not available?", "alt", "title", "src", "detail", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question14);
        Question question15 = new Question("For caption of the image we use ____________", "<src>", "<figure>", "<alt>", "<caption>", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question15);
        Question question16 = new Question("which of the following tag is used to mark a beginning of paragraph?", "<TD>", "<br>", "<P>", "<TR>", 3, Languages.HTML, Categories.TAGS1);
        insertQuestion(question16);
        Question question17 = new Question("Correct HTML tag for the smallest heading is", "h1", "h4", "h2", "h6", 4, Languages.HTML, Categories.TAGS1);
        insertQuestion(question17);
        Question question18 = new Question("Choose the correct HTML tag to make a text bold?", "<b>", "<bold>", "<bb>", "<bld>", 1, Languages.HTML, Categories.TAGS1);
        insertQuestion(question18);
        Question question19 = new Question("What is the correct HTML tag for inserting a line break?", "<lb>", "<br>", "<break>", "<newline>", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question19);
        Question question20 = new Question("The _____ character tells browsers to stop tagging the text", "?", "/", ">", "%", 2, Languages.HTML, Categories.TAGS1);
        insertQuestion(question20);
    }

    //Adding Html Tags Questions
    private void htmlTagsSecond() {
        Question question1 = new Question("Some tags enclose the text. Those tags are known as", "Couple tags", "Single tags", "Double tags", "Pair tags", 4, Languages.HTML, Categories.TAGS2);
        insertQuestion(question1);
        Question question2 = new Question("Tags and test that are not directly displayed on the page are written in _____ section.", "<html>", "<head>", "<title>", "<body>", 2, Languages.HTML, Categories.TAGS2);
        insertQuestion(question2);
        Question question3 = new Question("Which tag inserts a line horizontally on your web page?", "<hr>", "<line>", "<br>", "<tr>", 1, Languages.HTML, Categories.TAGS2);
        insertQuestion(question3);
        Question question4 = new Question("Which tag allows you to add a row in a table?", "<td> and </td>", "<cr> and </cr>", "<th> and </th>", "<tr> and </tr>", 4, Languages.HTML, Categories.TAGS2);
        insertQuestion(question4);
        Question question5 = new Question("Which HTML tag is used to define a table?", "<tb>", "<tl>", "<table>", "<tab>", 3, Languages.HTML, Categories.TAGS2);
        insertQuestion(question5);
        Question question6 = new Question("With the help of which tag, is a row defined in HTML?", "<row>", "<table-row>", "<tablerow>", "<tr>", 4, Languages.HTML, Categories.TAGS2);
        insertQuestion(question6);
        Question question7 = new Question("Each cell of the table can be represented by using ______", "<tr>", "<td>", "<th>", "<thead>", 2, Languages.HTML, Categories.TAGS2);
        insertQuestion(question7);
        Question question8 = new Question("Headings of table lies inside ___________", "<thead>", "<tfoot>", "<th>", "<tbody>", 1, Languages.HTML, Categories.TAGS2);
        insertQuestion(question8);
        Question question9 = new Question("border-spacing is given in _______", "cm", "pixel", "foot", "inch", 2, Languages.HTML, Categories.TAGS2);
        insertQuestion(question9);
        Question question10 = new Question("In HTML tables gap between two cells of same tables are known as", "Cell spacing", "Cell difference", "Cell padding", "All of above", 1, Languages.HTML, Categories.TAGS2);
        insertQuestion(question10);
        Question question11 = new Question("In HTML document the tags", "Should be written in upper case", "should be written in lower case", "should be written in propercase", "can be written in both uppercase or lowercase", 4, Languages.HTML, Categories.TAGS2);
        insertQuestion(question11);
        Question question12 = new Question("There are ____ different of heading tags in HTML", "5", "6", "4", "7", 2, Languages.HTML, Categories.TAGS2);
        insertQuestion(question12);
        Question question13 = new Question("Which of the following is not a style tag?", "<b>", "<tt>", "<i>", "All of above are style tags", 4, Languages.HTML, Categories.TAGS2);
        insertQuestion(question13);
        Question question14 = new Question("Which attribute you’ll use with TD tag to merge two cells horizontally?", "merge=colspan2", "rowspan=2", "colspan=2", "merge=row2", 3, Languages.HTML, Categories.TAGS2);
        insertQuestion(question14);
        Question question15 = new Question("Which attribute is used to name an element uniquely?", "class", "id", "dot", "none", 2, Languages.HTML, Categories.TAGS2);
        insertQuestion(question15);
        Question question16 = new Question("<script>...</script> tag can be placed within ____", "Header", "Body", "both A and B", "none of the above", 3, Languages.HTML, Categories.TAGS2);
        insertQuestion(question16);
        Question question17 = new Question("What should be the first tag in any HTML document?", "<head>", "<document>", "<html>", "<body>", 3, Languages.HTML, Categories.TAGS2);
        insertQuestion(question17);
        Question question18 = new Question("<b> tag makes the enclosed text bold. What is other tag to make text bold", "<strong>", "<dar>", "<black>", "<emp>", 1, Languages.HTML, Categories.TAGS2);
        insertQuestion(question18);
        Question question19 = new Question("Marquee is a tag in HTML to", "Marquee is a tag in HTML to", "Mark the text so that it is hidden in browser", "Display text with scrolling effect", "None of above", 3, Languages.HTML, Categories.TAGS2);
        insertQuestion(question19);
        Question question20 = new Question("The way the browser displays the object can be modified by _____", "attributes", "parameters", "modifiers", "None of above", 1, Languages.HTML, Categories.TAGS2);
        insertQuestion(question20);
    }

    //Adding Html Lists Questions
    private void htmlLinksAndList() {
        Question question1 = new Question("Which tag is used for List items?", "<li>", "<ol>", "<ul>", "<dl>", 1, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question1);
        Question question2 = new Question("Which element contains definition?", "<dl>", "<dd>", "<dt>", "<ul>", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following can’t be the value of list-style-type?", "square", "circle", "ellipse", "disc", 3, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question3);
        Question question4 = new Question("For displaying a list horizontally, we can use ______", "<dd>", "display:inline", "<dt>", "type", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question4);
        Question question5 = new Question("Which attribute is only used with <ol>?", "value", "type", "compact", "start", 4, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question5);
        Question question6 = new Question("From which tag descriptive list starts ?", "<LL>", "<DD>", "<DL>", "<DS>", 3, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question6);
        Question question7 = new Question("Which one of the following is a type of lists that HTML supports?", "Ordered lists", "Unordered lists", "Description lists", "All of the above", 4, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question7);
        Question question8 = new Question("By which tag, an unordered list is represented?", "<u>", "<ol>", "<ul>", "<l>", 3, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question8);
        Question question9 = new Question("In order to start a list from 10, what attribute should be added in the opening tag of ordered list?", "begin= “10”", "start= “10”", "style= “begin:10”", "style= “start:10”", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question9);
        Question question10 = new Question("What is the default start of item marker in ordered list?", "1", "i", "l", "None of the above", 1, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question10);
        Question question11 = new Question("What is the default item marker in unordered lists of HTML?", "Circle", "Square", "Disc", "None of the above", 3, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question11);
        Question question12 = new Question("Which one of the following tag is used for creating a hyperlink?", "<link>", "<a>", "<hyperlink>", "<title>", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question12);
        Question question13 = new Question("Which attribute is used to give destination address in <a> tag of HTML?", "href", "type", "address", "link", 1, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question13);
        Question question14 = new Question("Which one of the following value of target attribute opens the linked url in a new tab?", "_self", "_parent", " _top", "_blank", 4, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question14);
        Question question15 = new Question("By default, an unvisited link in HTML is _____", "purple and underlined", "blue and underlined", "red and underlined", "blue and italics", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question15);
        Question question16 = new Question("By default, a visited link in HTML is _____", "purple and underlined", "blue and underlined", "red and underlined", "blue and italics", 1, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question16);
        Question question17 = new Question("By default, the link in HTML is red and underlined when the link is _____", "visited", "unvisited", "active", "It is red and underlined", 3, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question17);
        Question question18 = new Question("Default style of link can be changed by ", " javascript", "css", "php", "Cannot be changed at all", 2, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question18);
        Question question19 = new Question("Default attribute value of 'target' is _____ in HTML.", "_parent", "_blank", "_top", "_self", 4, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question19);
        Question question20 = new Question("___ attribute is used to specify MIME type of linked document ?", "Rev Attribute", "Media Attribute", "MIME Attribute", "Type Attribute", 4, Languages.HTML, Categories.LINKS_AND_LISTS);
        insertQuestion(question20);
    }

    //Adding Html Forms Questions
    private void htmlForms() {
        Question question1 = new Question("Choose the correct option?", "HTML form elements are used for taking user input.", "HTML form elements are defined inside <for> tag.", "HTML form elements can be of different types.", "All of these.", 4, Languages.HTML, Categories.FORMS);
        insertQuestion(question1);
        Question question2 = new Question("Which one of the following is a form element?", "text box", "radio button", "submit button", " All of these", 4, Languages.HTML, Categories.FORMS);
        insertQuestion(question2);
        Question question3 = new Question("In HTML form the <input type=\"text\"> is used for", "One line text", "Block of text", "One paragraph", "None", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question3);
        Question question4 = new Question("Which one of the following does not hold true regarding GET method in HTML?", "Use of GET method in HTML is more secured.", "Use of GET method enables us to bookmark the page.", "GET has size limitation.", "None of the above", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following tag is used for drop down list?", "<select>", "<text>", "<textarea>", "<dropdown>", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question5);
        Question question6 = new Question("What is the default type of ‘type’ attribute of <input> element?", "Numerals", "Text", "Password", "Special Characters", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question6);
        Question question7 = new Question("The attribute of <form> tag", "Method", "Action", "Both Method and Action", "None", 3, Languages.HTML, Categories.FORMS);
        insertQuestion(question7);
        Question question8 = new Question("Which of the following attributes of text box control allow to limit the maximum character?", "size", "len", "maxlength", "all of these", 3, Languages.HTML, Categories.FORMS);
        insertQuestion(question8);
        Question question9 = new Question("A label's for attribute should match the input's ______.", "Id ", "Type", "Name", "None", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question9);
        Question question10 = new Question("The action attribute tells the form?", "How to send the form’s data", "Where to send the form’s data", "When to send the form’s data", "All of the above", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question10);
        Question question11 = new Question("How do you create a button on a form?", "With a <form> tag.", "With an <input type=\"submit\"> tag.", "With a link.", "Don’t know", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question11);
        Question question12 = new Question("Attribute and value in form tag to tell the browser to take all the data submitted with the form to the end of the file’s URL", "Method=\"post\"", "Method=\"get\"", "Both", "None", 3, Languages.HTML, Categories.FORMS);
        insertQuestion(question12);
        Question question13 = new Question("Which attribute is not used on new forms?", "size", "text", "name", "maxlength", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question13);
        Question question14 = new Question("Which attribute is not used for the radio type?", "name", "value", "checked", " selected", 4, Languages.HTML, Categories.FORMS);
        insertQuestion(question14);
        Question question15 = new Question("What is the correct HTML for making a checkbox?", "<check>", "<input type=\"checkbox\">", "<checkbox>", "<input type=\"check\">", 3, Languages.HTML, Categories.FORMS);
        insertQuestion(question15);
        Question question16 = new Question("What is the correct HTML for making a text input field?", "<textinput type=\"text\">", "<input type=\"text\">  ", "<input type=\"textfield\">", "<textfield>", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question16);
        Question question17 = new Question("In HTML, which attribute is used to specify that an input field must be filled out?", "formvalidate", "required ", "validate", "placeholder", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question17);
        Question question18 = new Question("Which one of the following does not hold true regarding GET method in HTML?", "Use of GET method in HTML is more secured.", "Use of GET method enables us to bookmark the page.", "GET has size limitation.", "None of the above", 1, Languages.HTML, Categories.FORMS);
        insertQuestion(question18);
        Question question19 = new Question("Which one of the following does not hold true regarding POST method in HTML?", "Use of POST method in HTML is more secured.", "Use of POST method enables us to bookmark the page.", "POST has no size limitation.", "None of the above", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question19);
        Question question20 = new Question("How more than one option can be selected in drop down?", "Use of multiple attribute inside <option> tag.", "Use of multiple attribute inside <select> tag.", "use of multiple attribute inside <text> tag.", "Not possible to select more than one option in drop down.", 2, Languages.HTML, Categories.FORMS);
        insertQuestion(question20);
    }

    //Adding Html Media Questions
    private void htmlMedia() {
        Question question1 = new Question("Which of the following is not a HTML5 tag?", "<video>", "<audio>", "<source>", "<slider>", 4, Languages.HTML, Categories.MEDIA);
        insertQuestion(question1);
        Question question2 = new Question("Which of the following HTML Video – Media Type is not supported in IE?", "WebM", "MP4", "Ogg", "MP4 FLAC", 3, Languages.HTML, Categories.MEDIA);
        insertQuestion(question2);
        Question question3 = new Question("HTML5 features, include native audio and video support without the need for.", "Flash", "Canvas", "Svg", "None of the above", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question3);
        Question question4 = new Question("Which boolean attribute if specified, will allow video automatically seek back to the start after reaching at the end.", "autoplay", "loop", "autobuffer", "controls", 2, Languages.HTML, Categories.MEDIA);
        insertQuestion(question4);
        Question question5 = new Question("In HTML Audio/Video DOM ________ sets or returns the volume of the audio/video.", "src", "volume controls", "volume", "None of the above", 3, Languages.HTML, Categories.MEDIA);
        insertQuestion(question5);
        Question question6 = new Question("What will happen if height and width of video are not set while video loads?", "page flickers", "page does not load", "page crash", "page closes", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following attribute adds audio controls, like play, pause, and volume?", "audio", "source", "src", "controls", 4, Languages.HTML, Categories.MEDIA);
        insertQuestion(question7);
        Question question8 = new Question("How to embedded Audio Files in HTML?", "<embed src = “song.mid” width = “100” height = “15”>", "<embed sound = “song.mid” width = “100” height = “15”>", "<embed audio = “song.mid” width = “100” height = “15”>", "<embed music = “song.mid” width = “100” height = “15”>", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question8);
        Question question9 = new Question("Which one of the following does not support flash?", "iPhone", "android", "windows", " linux", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question9);
        Question question10 = new Question("In handling media events which event is generated when the first frame of the media has finished loading.", "loadstart", "loadeddata", "ended", "error", 2, Languages.HTML, Categories.MEDIA);
        insertQuestion(question10);
        Question question11 = new Question("___________ returns the URL of the current audio/video", "url", "href", "src", "currentSrc", 4, Languages.HTML, Categories.MEDIA);
        insertQuestion(question11);
        Question question12 = new Question("___________ returns the length of the current audio/video (in seconds)", "time", "duration", "currentTime", "currentDuration", 2, Languages.HTML, Categories.MEDIA);
        insertQuestion(question12);
        Question question13 = new Question("Which of the following sets or returns whether the audio/video is muted or not", "mute", "muted", "volume", "sound", 2, Languages.HTML, Categories.MEDIA);
        insertQuestion(question13);
        Question question14 = new Question("___________ returns the current ready state of the audio/video", "isReady", "ready", "readyState", "runningState", 3, Languages.HTML, Categories.MEDIA);
        insertQuestion(question14);
        Question question15 = new Question("___________ returns whether the user is currently seeking in the audio/video", "seeking", "seekable", "seek", "seeked", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question15);
        Question question16 = new Question("___________ returns whether the playback of the audio/video has ended or not", "finish", "end", "ended", "isEnd", 3, Languages.HTML, Categories.MEDIA);
        insertQuestion(question16);
        Question question17 = new Question("___________ returns an AudioTrackList object representing available audio tracks", "trackSize", "playlistLength", "tracks", "audioTracks", 4, Languages.HTML, Categories.MEDIA);
        insertQuestion(question17);
        Question question18 = new Question("___________ returns whether the audio/video is paused or not", "paused", "isPlaying", "paused", "stop", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question18);
        Question question19 = new Question("___________ returns a VideoTrackList object representing the available video tracks", "trackSize", "playlistLength", "tracks", "videoTracks", 4, Languages.HTML, Categories.MEDIA);
        insertQuestion(question19);
        Question question20 = new Question("___________ sets or returns whether the audio/video should start over again when finished", "loop", "repeat", "repetition", "None of the above", 1, Languages.HTML, Categories.MEDIA);
        insertQuestion(question20);
    }

    //Adding Html Graphics Questions
    private void htmlGraphics() {
        Question question1 = new Question("Which of the following is not the property of SVG images?", "SVG images are scalable", "SVG images are zoomable", "SVG is an open standard", "SVG images are resolution dependent", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question1);
        Question question2 = new Question(" _______ drawings can be dynamic and interactive.", "Canvas based", "SVG", "CSS3", "JavaScript", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following is the predefined shape elements that can be used by developers?", "Path <path>", "Rectangle <rect>", "Circle <circle>", "Line <line>", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question3);
        Question question4 = new Question("Which method is used to increase or decrease the units in a canvas grid.", "Canvas Transform", "Canvas Rotation", "Canvas Scaling", "Canvas Composition", 3, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following element is used for canvas graphics?", "<paint>", "<canvas>", "<svg>", "<graphic>", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question5);
        Question question6 = new Question("Which of the following statement is not true?", "SVG stands for Scalable Vector Graphics", "SVG is used to define graphics for the Web", "SVG is a W3C recommendation", "SVG doesn’t support event handlers", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question6);
        Question question7 = new Question("The _______ method must add the scaling transformation described by the arguments to the transformation matrix.", "scale(x, y)", "translate(x, y)", "rotate(angle)", "skew(x,y)", 1, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question7);
        Question question8 = new Question("Which SVG element produces the same effect as if the nodes were deeply cloned into a non-exposed DOM?", "tref", "use", "stroke", "bin", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question8);
        Question question9 = new Question("Which version does not support for HTML5 canvas natively?", "Firefox", "Safari", "Chrome", "IE8", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question9);
        Question question10 = new Question("The canvas element has a DOM method it is called.", "getContext", "getId", "getElement", "None of the above", 1, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question10);
        Question question11 = new Question("HTML5 element <canvas> can be used to.", "Draw graphics", "Photo compositions", "Animations", "All the mentioned above", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question11);
        Question question12 = new Question("The HTML canvas is a", "Three-dimensional grid", "One-dimensional grid", "Two-dimensional grid", "None of the above", 3, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question12);
        Question question13 = new Question("To draw text on a canvas, which property and method is used.", " font", "stokeText(text,x,y)", "fillText(text,x,y)", "None of the above", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question13);
        Question question14 = new Question("Which of the following tag of SVG is used to draw a line?", "linear", "line", "Both of the above.", "None of the above.", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is a valid SVG filter?", "feComposite", "feConvolveMatrix", "feDiffuseLighting", " All of the above.", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question15);
        Question question16 = new Question("The main competitor to SVG is _______ .", "Microsoft's Paint", "Photoshop", "Flash", "None of these", 3, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following tag of SVG is used to draw a ellipse?", "circle", "ellipse", "Both of the above", "None of the above", 2, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question17);
        Question question18 = new Question("What is SVG ?", "Scalable Visual Graphics", "Static Vector Graphics", "Scalable Vector Graphics", "Simple Vector Graphics", 3, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question18);
        Question question19 = new Question("Which property of SVG restricts the region to which paint can be applied?", "animateTransform", "radialGradient", "linearGradient", "clip-Path", 4, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question19);
        Question question20 = new Question("Which element serves as a container for atomic filter operations?", "filter", "feimage", "feblend", "tref", 1, Languages.HTML, Categories.GRAPHICS);
        insertQuestion(question20);
    }

    //Adding Html Layouts Questions
    private void htmlLayouts() {
        Question question1 = new Question("Which of the following works as a sidebar?", "<aside>", "<footer>", "<details>", "<section>", 1, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question1);
        Question question2 = new Question("Which one of the following contains information about the author?", "<header>", "<footer>", "<address>", "<body>", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question2);
        Question question3 = new Question("Header element does not contain ______", " logo", "heading elements", "authorship information", "<address>", 4, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question3);
        Question question4 = new Question("Which element contains major navigational block?", "<address>", "<footer>", "<nav>", "<header>", 3, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question4);
        Question question5 = new Question("Which element represents self-contained composition in document?", " <nav>", "<header>", "<footer>", "<article>", 4, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question5);
        Question question6 = new Question("Which element groups related content together?", "<aside>", "<footer>", "<section>", "<div>", 3, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question6);
        Question question7 = new Question("For grouping together one or more <h1> to <h6> element what element is used?", "<header>", "<hgroup>", "<div>", "<section>", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question7);
        Question question8 = new Question("Bootstrap was first introduced in ______", "google", "twitter", "instagram", "snapchat", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following specifies what happens if content overflow an element’s box?", "overflow", "overflow-x", "overflow-y", " float", 1, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question9);
        Question question10 = new Question("Footer element can’t contain ____________ information.", "contact information", "copyright information", "the author of the document", "blog post", 4, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question10);
        Question question11 = new Question("Which of the following specifies the main content of the document?", "<main>", "<time>", "<details>", "<section>", 1, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question11);
        Question question12 = new Question("Which element denotes that the text is a short fragment of computer code?", "<data>", "<code>", " <cite>", "<dfn>", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question12);
        Question question13 = new Question("Which element represents a dialog box?", "<menu>", "<menuitem>", "<dialog>", "<summary>", 3, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question13);
        Question question14 = new Question("Which of the following specifies relationship between current document and external resource?", " <meta>", " <style>", "<title>", "<link>", 4, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is keyboard input element?", "<mark>", "<kbd>", "<dfn>", "<em>", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question15);
        Question question16 = new Question("Which element sets default font face, size and color for other elements?", " <applet>", "<big>", "<acronym>", "<basefont>", 4, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question16);
        Question question17 = new Question("Which element is not a scripting element?", "<picture>", "<script>", "<canvas>", "<noscript>", 1, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question17);
        Question question18 = new Question("Which element represents a scalar value within the given range?", "<option>", "<meter>", "<label>", "<input>", 2, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question18);
        Question question19 = new Question("Which of the following is a generic inline container for phrasing content?", "<strong>", "<sub>", "<span>", "<sup>", 3, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question19);
        Question question20 = new Question("Variable element is ________", "<var>", "<wbr>", "<sup>", "<time>", 1, Languages.HTML, Categories.LAYOUTS);
        insertQuestion(question20);
    }

    //Adding Html API Questions
    private void htmlApi() {
        Question question1 = new Question("Which method is used to get user’s position?", " getCurrentPosition()", " getDirectPosition()", "post()", "getDirection()", 1, Languages.HTML, Categories.API);
        insertQuestion(question1);
        Question question2 = new Question("The HTML Geolocation API is used to get the geographical position of a user.", "direction", "position", "network", "None of the above", 2, Languages.HTML, Categories.API);
        insertQuestion(question2);
        Question question3 = new Question("How many kinds of map does Geo support?", "2", "3", "4", "5", 3, Languages.HTML, Categories.API);
        insertQuestion(question3);
        Question question4 = new Question(" Which method cancels an ongoing watchPosition call?", "getCurrentPosition()", "watchPosition()", "cancelWatch()", "clearWatch()", 4, Languages.HTML, Categories.API);
        insertQuestion(question4);
        Question question5 = new Question("The location of the device could not be determined,the error code is 2 then what will be the constant?", "UNKNOWN_ERROR", "PERMISSION_DENIED", "POSITION_UNAVAILABLE", "TIMEOUT", 3, Languages.HTML, Categories.API);
        insertQuestion(question5);
        Question question6 = new Question("What does showPosition() returns?", "only latitude", "only longitude", "only direction", " both latitude and longitude", 4, Languages.HTML, Categories.API);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following technique is not for the mobile browser to identify the location of a user?", "GPS", "IP based position", "WIFI based position", "A-GPS", 2, Languages.HTML, Categories.API);
        insertQuestion(question7);
        Question question8 = new Question("Which event will fire every time when the mouse is moved while the object is being dragged.", "Drop", " Drag", "Dragend", "Dragstart", 2, Languages.HTML, Categories.API);
        insertQuestion(question8);
        Question question9 = new Question("DND API makes easy to copy, reorder and deletion of items with the help of _______", "Mouse", "Keyboard", "Both", "None of the above", 1, Languages.HTML, Categories.API);
        insertQuestion(question9);
        Question question10 = new Question("Which event is fired as the mouse is moving over an element when a drag is occurring?", "dragover", "dragenter", "dragstart", "dragleave", 1, Languages.HTML, Categories.API);
        insertQuestion(question10);
        Question question11 = new Question("Which of the following property is common in all drag events?", " dragEffects", "dataTransfer", "dragData", "dragEnter", 2, Languages.HTML, Categories.API);
        insertQuestion(question11);
        Question question12 = new Question("In localStorage object data ________", "is deleted after the browser closed", " is not deleted after the browser closed", "can be seen but can not edit", "can be seen as well as edit", 2, Languages.HTML, Categories.API);
        insertQuestion(question12);
        Question question13 = new Question("In sessionStorage object data ________", "is not deleted after the browser closed", "can be seen but can’t edit", " can be seen as well as edit", "is deleted after the browser closed", 4, Languages.HTML, Categories.API);
        insertQuestion(question13);
        Question question14 = new Question("Before HTML5 where data had to be stored?", "browser", "only in Chrome", "cookies ", "None of above", 3, Languages.HTML, Categories.API);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is not a web storage interface?", "storage", "window", "storageEvent", "privacy", 4, Languages.HTML, Categories.API);
        insertQuestion(question15);
        Question question16 = new Question("Which is a JavaScript running in the background, without affecting the performance of the page", "Web Worker", "Canvas", "SVG", "None of above", 1, Languages.HTML, Categories.API);
        insertQuestion(question16);
        Question question17 = new Question("To reuse the web worker which code is used.", "w.terminate();", "w = undefined;", "w = terminate;", "w.undefined();", 2, Languages.HTML, Categories.API);
        insertQuestion(question17);
        Question question18 = new Question("Server-Sent Events allows a web page to get updates from", "Windows", "Local Storage", "Server", "None of above", 3, Languages.HTML, Categories.API);
        insertQuestion(question18);
        Question question19 = new Question("Which event will be used when a connection to the server is opened.", "onopen", "onmessage", "onerror", "None of above", 1, Languages.HTML, Categories.API);
        insertQuestion(question19);
        Question question20 = new Question("Which browser does a server-sent event does not support.", "Chrome", "Mozilla", "Internet explorer", "Opera", 3, Languages.HTML, Categories.API);
        insertQuestion(question20);
    }

    /*===============================================================================================================================================*/
    /* C++ */
    /*===============================================================================================================================================*/

    //Adding Basics Questions
    private void cPlusBasics() {
        Question question1 = new Question("Which of the following is the correct syntax of including a user defined header files in C++?", "#include <userdefined.h>", " #include <userdefined>", "#include “userdefined”", "#include [userdefined]", 3, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question1);
        Question question2 = new Question("Which of the following is a correct identifier in C++?", "7var_name", "VAR_1234", "7VARNAME", "$var_name", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following is called address operator?", " *", "$", "&", "%", 3, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question3);
        Question question4 = new Question("Which of the following is used for comments in C++?", "// comment", " /* comment */", "// comment */", "both // comment OR /* comment */", 4, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question4);
        Question question5 = new Question("What are the actual parameters in C++?", "with which functions are called", "which are used in the definition of a function", "Which are used in Defining Variable", "None of the above", 1, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question5);
        Question question6 = new Question("What are the formal parameters in C++?", "with which functions are called", "which are used in the definition of a function", "Which are used in Defining Variable", "None of the above", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question6);
        Question question7 = new Question("Which function is used to read a single character from the console in C++?", " cin.get(ch)", " getline(ch)", " read(ch)", "scanf(ch)", 1, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question7);
        Question question8 = new Question(" Which function is used to write a single character to console in C++?", "write(ch)", "printf(ch)", "cout.putline(ch)", "cout.put(ch)", 4, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question8);
        Question question9 = new Question("Who created C++?", " Dennis Ritchie", "Ken Thompson", "Bjarne Stroustrup", " Brian Kernighan", 3, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question9);
        Question question10 = new Question("Which of the following is called insertion/put to operator?", ">>", "<<", " >", "<", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question10);
        Question question11 = new Question("A language which has the capability to generate new data types are called ________ .", "Extensible", "Overloaded", " Encapsulated", "Reprehensible", 1, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question11);
        Question question12 = new Question("Constant variables can be created in C++ by using ________ .", " enum", "const", " #define", "All of these", 4, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question12);
        Question question13 = new Question("In C++, cin and cout are the predefined stream __________ .", "Operator", "Functions", "Objects", "Data types", 3, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question13);
        Question question14 = new Question("Classes in C++ are________ .", "derived data types", " User defined data types", "built-in data types", "All of these", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question14);
        Question question15 = new Question("What is the only function all C++ programs must contain?", "System()", "Start()", "Program()", "Main()", 4, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question15);
        Question question16 = new Question("What punctuation ends most lines of C++ code?", "semi-colon", "single quote", "colon", "dot", 1, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following is the correct operator to compare two variables?", "=", "==", "!=", "isEqual()", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question17);
        Question question18 = new Question("To perfor file input / output operation in C++, we must include which header file ?", "<fiostream>", "<ifstream>", "<ofstream>", "<fstream>", 4, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question18);
        Question question19 = new Question("What was the original name given to C++?", "C++", "C with classes", "C with objects", "None of the above", 2, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question19);
        Question question20 = new Question("when c++ was developed ________ .", "1996", "1997", "1998", "2000", 3, Languages.CPLUS, Categories.BASICS);
        insertQuestion(question20);
    }

    //Adding Data Type Questions
    private void cPlusDataTypes() {
        Question question1 = new Question("Identify wrong C Keywords below.", "auto, double, int, struct", "auto, double, int, struct", "case, enum, register, typedef", "char, extern, intern, return", 4, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question1);
        Question question2 = new Question("What is size of void in bytes?", "0", "1", "2", "4", 1, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question2);
        Question question3 = new Question("How would you declare an integer called sum and initialize it to 10?", " int sum 10", " int sum=10;", "integer sum =10;", "None of the above", 2, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question3);
        Question question4 = new Question("It is guaranteed that a ____ has at least 8 bits and a ____ has at least 16 bits.", " int, float", "char, int", " char, short", "bool, char", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question4);
        Question question5 = new Question("The size_t integer type in C++ is?", "Unsigned integer of at least 64 bits", "Signed integer of at least 16 bits", "Unsigned integer of at least 16 bits", " Signed integer of at least 64 bits", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question5);
        Question question6 = new Question("Which of the following is not one of the sizes of the floating point types?", "short float", " float", "long double", " double", 1, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question6);
        Question question7 = new Question("How much memory a float takes to store the value?", "1 bytes", "2 bytes", "4 bytes", "6 bytes", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question7);
        Question question8 = new Question("How much memory a double takes to store the value? ", "2 bytes", "4 bytes", "6 bytes", "8 bytes", 4, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question8);
        Question question9 = new Question("How much memory a character takes to store the value?", "1 byte", "2 bytes", "4 bytes", "6 bytes", 1, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question9);
        Question question10 = new Question("Is bool a fundamental data type in C++?", "Yes", "No, it is a typedef of unsigned char", "No, it is an enum of {false, true}", "No, it is expanded from macros", 1, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question10);
        Question question11 = new Question("What is the value of the bool? \n bool is_int(789.54)", "True", "False", "789", ".54", 2, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question11);
        Question question12 = new Question("Which of the two operators ++ and — work for the bool data type in C++?", "__", " ++ & —", "++", "None of the above", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question12);
        Question question13 = new Question("How many characters are specified in the ASCII scheme?", "32", "64", "128", "256", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question13);
        Question question14 = new Question("In which type do the enumerators are stored by the compiler?", " string", "integer", "float", " string & float", 2, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question14);
        Question question15 = new Question("What will happen when defining the enumerated type?", "it will not allocate memory", "it will allocate memory", "it will not allocate memory to its variables", "allocate memory to objects", 1, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question15);
        Question question16 = new Question("Which of the following belongs to the set of character types?", "char", "wchar_t", "only char", "both wchar_t and char", 4, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question16);
        Question question17 = new Question("both wchar_t and char \n void a;", "variable a is of type void", "a is an object of type void", "declares a variable with value a", "flags an error", 4, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question17);
        Question question18 = new Question("Which of three sizes of floating point types should be used when extended precision is required?", "float", "double", "long double", "extended float", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question18);
        Question question19 = new Question("What is the size of wchar_t in C++?", "2", "4", "6", "Based on the number of bits in the system", 4, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question19);
        Question question20 = new Question("Identify the user-defined types from the following?", "enumeration", "classes", "both enumeration and classes", "None of the above", 3, Languages.CPLUS, Categories.DATA_TYPES);
        insertQuestion(question20);
    }

    //Adding Keywords Questions
    private void cPlusKeyWordAndPointers() {
        Question question1 = new Question(" In C++ the words that is already defined and is reserved for a single special purpose, is called as", "Keywords", "Statements", "Functions", "Queries", 1, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question1);
        Question question2 = new Question("Which one is not a C++ keyword?", "for", "class", "void", "None of the above", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question2);
        Question question3 = new Question("Keywords are also called", "Preprocessors", "Reserved words", "Punctuation marks", "Operators", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question3);
        Question question4 = new Question("Total number of keywords in C++ is", "20", "48", "64", "128", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question4);
        Question question5 = new Question("Which keyword is used to define the user defined data types?", "def", "union", "typedef", " type", 3, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question5);
        Question question6 = new Question("What does the following statement mean? \n \n int (*fp)(char*)", " pointer to a pointer", "pointer to an array of chars", "pointer to function taking a char* argument and returns an int", "None of the above", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question6);
        Question question7 = new Question("Which of the followings is/are pointer-to-member declarator?", "->*", "*", "::*", "None of the above", 3, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question7);
        Question question8 = new Question("What is size of generic pointer in c?", "1", "2", "3", "Null", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following is the feature of pointers?", "Pointers save memory space", "Pointers are used to allocate memory dynamically", "Pointers are used for file handling", "All of the above", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question9);
        Question question10 = new Question("Which other keywords are also used to declare the class other than class?", "struct", "union", "object", "both struct & union", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question10);
        Question question11 = new Question("Which of these keywords is used to make a class?", "class", "struct", "int", "none of the mentioned", 1, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question11);
        Question question12 = new Question("Which of the following is illegal?", "int *ip;", "string s, *sp = 0;", "int i; double* dp = &i;", "int *pi = 0;", 3, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question12);
        Question question13 = new Question("int a = 100, b = 200;\n" +
                "   int *p = &a, *q = &b;\n" +
                "   p = q;", "b is assigned to a", "p now points to b", "a is assigned to b", "q now points to a", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question13);
        Question question14 = new Question("A pointer can be initialized with", "Null", "Zero", "Address of an object of same type", "All of them", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question14);
        Question question15 = new Question("A void pointer cannot point to which of these?", "methods in c++", "class member in c++", "variable in c++", "None of the above", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question15);
        Question question16 = new Question(" Which of the following keywords is used to define an alternate name for an already existing data type?", "default", "volatile", "typedef", "static", 3, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question16);
        Question question17 = new Question("The loop keyword is", "Byte", "While", "Double", " Float", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question17);
        Question question18 = new Question("Which one of the following is access keyword?", "Public", "Private", "Protected", "All of these", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question18);
        Question question19 = new Question("The public keyword is an", "identifier", "access specifier", "variable type", "exception", 2, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question19);
        Question question20 = new Question("Which keyword is used to explicitly throw an exception?", "try", "throwing", "catch", "throw", 4, Languages.CPLUS, Categories.KEYWORDS_POINTERS);
        insertQuestion(question20);
    }

    //Adding OOP Questions
    private void cPlusOOP() {
        Question question1 = new Question("The OOPs concept in C++, exposing only necessary information to users or clients is known as", "Abstraction", "Encapsulation", "Data hiding", "Hiding complexity", 1, Languages.CPLUS, Categories.OOP);
        insertQuestion(question1);
        Question question2 = new Question("Hiding the complexity is known as", "Abstraction", "Encapsulation", "Composition", "Hiding complexity", 2, Languages.CPLUS, Categories.OOP);
        insertQuestion(question2);
        Question question3 = new Question("For Cat and Animal class, correct way of inheritance is", "class Cat: public Animal", "class Animal: public Cat", "Both are correct way", "None is correct way", 1, Languages.CPLUS, Categories.OOP);
        insertQuestion(question3);
        Question question4 = new Question("In a class, encapsulating an object of another class is called", "Abstraction", "Encapsulation", "Composition", "Inheritance", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question4);
        Question question5 = new Question("Features not available in C++ object oriented programming is", "Virtual destructor", "Virtual function", "Virtual constructor", "None of the above", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question5);
        Question question6 = new Question(" IS A relationship in C++ is", "Composition", "Encapsulation", "Abstraction", "Inheritance", 4, Languages.CPLUS, Categories.OOP);
        insertQuestion(question6);
        Question question7 = new Question("What does polymorphism in OOPs mean?", "Concept of allowing overiding of functions", "Concept of hiding data", "Concept of keeping things in differnt modules/files", "Concept of wrapping things into a single unit", 1, Languages.CPLUS, Categories.OOP);
        insertQuestion(question7);
        Question question8 = new Question("Which concept allows you to reuse the written code?", "Encapsulation", " Abstraction", "Polymorphism", "Inheritance", 4, Languages.CPLUS, Categories.OOP);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following shows multiple inheritances?", "A->B->C", "A->B; A->C", "A,B->C", "B->A", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question9);
        Question question10 = new Question("Which of the following explains Polymorphism?", "int func(int, int);\n" +
                "float func1(float, float);", "int func(int);\n" +
                "int func(int);", "int func(float);\n" +
                "float func(int, int, char);", "int func();\n" +
                "int new_func();", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question10);
        Question question11 = new Question("What does modularity mean?", "Hiding part of program", " Subdividing program into small independent parts", "Overriding parts of program", "Wrapping things into single unit", 2, Languages.CPLUS, Categories.OOP);
        insertQuestion(question11);
        Question question12 = new Question("Which of the following is not a type of Constructor?", "Friend constructor", "Copy constructor", "Default constructor", "Parameterized constructor", 1, Languages.CPLUS, Categories.OOP);
        insertQuestion(question12);
        Question question13 = new Question("How many types of polymorphism are there in C++?", "1", "2", "4", "5", 2, Languages.CPLUS, Categories.OOP);
        insertQuestion(question13);
        Question question14 = new Question("How run-time polymorphisms are implemented in C++?", "Using Inheritance", "Using Virtual functions", "Using Templates", "Using Inheritance and Virtual functions", 4, Languages.CPLUS, Categories.OOP);
        insertQuestion(question14);
        Question question15 = new Question("How compile-time polymorphisms are implemented in C++?", "Using Inheritance", "Using Virtual functions", "Using Templates", "Using Inheritance and Virtual functions", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question15);
        Question question16 = new Question("What is Inheritance in C++?", "Wrapping of data into a single class", "Deriving new classes from existing classes", "Overloading of classes", "Classes with same names", 2, Languages.CPLUS, Categories.OOP);
        insertQuestion(question16);
        Question question17 = new Question("How many specifiers are used to derive a class?", "1", "2", "3", "5", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question17);
        Question question18 = new Question("What is the role of a constructor in classes?", "To modify the data whenever required", " To destroy an object", "To initialize the data members of an object when it is created", "To call private functions from the outer world", 3, Languages.CPLUS, Categories.OOP);
        insertQuestion(question18);
        Question question19 = new Question("How many types of constructors are there in C++?", "4", "3", "2", "5", 2, Languages.CPLUS, Categories.OOP);
        insertQuestion(question19);
        Question question20 = new Question("How many Destructors are allowed in a Class?", "1", "2", "3", "4", 1, Languages.CPLUS, Categories.OOP);
        insertQuestion(question20);
    }

    //Adding Exception Handling Questions
    private void cPlusExceptionHandling() {
        Question question1 = new Question("Which keyword is used to handle the exception?", "Try", "Throw", "Catch", "None of the above", 3, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question1);
        Question question2 = new Question("Which is used to throw a exception?", "Try", "Throw", "Catch", "None of the above", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question2);
        Question question3 = new Question("What will happen when the exception is not caught in the program?", "error", "program will execute", "block of that code will not execute", " program will execute & displays wrong output", 1, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question3);
        Question question4 = new Question("What is an exception in C++ program?", "A problem that arises during compilation", "Also known as the syntax error", " Also known as semantic error", "A problem that arises during the execution of a program", 4, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question4);
        Question question5 = new Question("Why do we need to handle exceptions?", "To avoid unexpected behaviour of a program during run-time", "To let compiler remove all exceptions by itself", "To successfully compile the program", "To get correct output", 1, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question5);
        Question question6 = new Question("Which part of the try-catch block is always fully executed?", " try part", "catch part", "finally part", "throw part", 3, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following is an exception in C++?", "Divide by zero", "Semicolon not written", "Variable not declared", "An expression is wrongly written", 1, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question7);
        Question question8 = new Question("Return type of uncaught_exception() is ___________.", "int", "bool", "char *", "double", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question8);
        Question question9 = new Question("Which is the Parent class for all exceptions?", "std::bad_exception", "std::logic_error", "std::exception", " std::runtime_error", 3, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question9);
        Question question10 = new Question("What are the different types of exceptions?", "1", "2", "4", "5", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question10);
        Question question11 = new Question("What id the syntax for catching any type of exceptions?", "catch(Exception e)", "catch(…)", "catch(Exception ALL)", " catch(ALL)", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question11);
        Question question12 = new Question("Header file used for exception handling in C++?", "<cstdlib>", "<string>", "<handler>", "<exception>", 4, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question12);
        Question question13 = new Question("Which function is invoked when we try to throw an exception that is not supported by a function?", " indeterminate()", "unutilized()", "unexpected()", "unpredicted()", 3, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question13);
        Question question14 = new Question("Where should we place catch block of the derived class in a try-catch block?", "Before the catch block of Base class", "After the catch block of Base class", " Anywhere in the sequence of catch blocks", " After all the catch blocks", 1, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question14);
        Question question15 = new Question("How Exception handling is implemented in the C++ program?", "Using Exception keyword", " Using Exception block", "Using Error handling schedules", "Using try-catch block", 4, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question15);
        Question question16 = new Question("Which exception is thrown by dynamic_cast?", "bad_cast", "bad_typeid", "bad_exception", "bad_alloc", 1, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question16);
        Question question17 = new Question("How do define the user-defined exceptions?", "Overriding class functionality", "Inheriting class functionality", "Inheriting & overriding exception class functionality", "None of the above", 3, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question17);
        Question question18 = new Question("Which type of program is recommended to include in try block?", "Static memory allocation", "Dynamic memory allocation", "Const reference", "Pointer", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question18);
        Question question19 = new Question("What kind of exceptions are available in c++?", "Handled", "Unhandled", "Static", "Dynamic", 2, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question19);
        Question question20 = new Question("How many standard exception exist in c++", "9.0", "8.0", "6.0", "5.0", 4, Languages.CPLUS, Categories.EXCEPTION_HANDLING);
        insertQuestion(question20);
    }

    //Adding Function Questions
    private void cPlusFunction() {
        Question question1 = new Question("Which of the following is the default return value of functions in C++?", " int", "char", "float", "void", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question1);
        Question question2 = new Question("From which function the execution of a C++ program starts?", "start() function", "main() function", "new() function", "end() function", 2, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following is important in a function?", "Return type", " Function name", "Both return type and function name", "The return type, function name and parameter list", 3, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question3);
        Question question4 = new Question("Correct way to declare pure virtual function in a C++ class is", "Virtual void foo() =0 ;", "Void virtual foo()= { 0 }", "Virtual void foo() {} = 0;", "None of the above", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question4);
        Question question5 = new Question("How are many minimum numbers of functions need to be presented in c++?", "0", "3", "2", "1", 4, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question5);
        Question question6 = new Question("The variable that are listed in the function's calls are called", "Actual parameter", "Declared parameter", "Passed parameter", "None of them", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question6);
        Question question7 = new Question("The maths function acos (x) stands for", "Inverse Cosine of x", "Inverse Sine of x", "Inverse Tangent of x", "  Floor of x", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question7);
        Question question8 = new Question("which of the following is used to terminate the function declaration?", ":", ")", ";", "]", 3, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question8);
        Question question9 = new Question("Which is more effective while calling the functions?", "call by value", "call by pointer", "call by object", "call by reference", 4, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question9);
        Question question10 = new Question("What is the scope of the variable declared in the user defined function?", "whole program", "only inside the {} block", "the main function", "header section", 2, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question10);
        Question question11 = new Question("How many ways of passing a parameter are there in c++?", "1", "2", "3", "4", 3, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question11);
        Question question12 = new Question("Which is used to keep the call by reference value as intact?", "static", " const", "absolute", "virtual", 2, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question12);
        Question question13 = new Question("By default how the value are passed in c++?", "call by value", "call by reference", "call by pointer", " call by object", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question13);
        Question question14 = new Question("What will happen when we use void in argument passing?", " It will return value with help of object", "Maybe or may not be return any value to its caller", " It will return value to its caller", "It will not return value to its caller", 4, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question14);
        Question question15 = new Question(" What is an inline function?", "A function that is expanded at each call during execution", "A function that is called during compile time", "A function that is not checked for syntax errors", "A function that is not checked for semantic analysis", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question15);
        Question question16 = new Question("When we define the default values for a function?", "When a function is defined", "When a function is declared", "When the scope of the function is over", "When a function is called", 2, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following feature is used in function overloading and function with default argument?", "Encapsulation", "Polymorphism", "Abstraction", "Modularity", 3, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question17);
        Question question18 = new Question("How many can max number of arguments present in function in the c99 compiler?", "99", "100", "102", "127", 4, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question18);
        Question question19 = new Question("Which of the following function declaration using default arguments is incorrect?", "int foo(int x, int y =5, int z=10)", " int foo(int x=5, int y =10, int z)", " int foo(int x=5, int y, int z=10)", "All are correct", 1, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question19);
        Question question20 = new Question("All variables declared in function definition are called", "Protected variables", "Local variable", "Global Variables", "Private variable", 2, Languages.CPLUS, Categories.FUNCTION);
        insertQuestion(question20);
    }

    //Adding Standard Template Library Questions
    private void cPlusStandardTemplateLibrary() {
        Question question1 = new Question("What is the Standard Template Library?", "Set of C++ template classes to provide common programming data structures and functions", "Set of C++ classes", "Set of Template functions used for easy data structures implementation", " Set of Template data structures only", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question1);
        Question question2 = new Question("How many components STL has?", "1", "2", "3", "4", 4, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question2);
        Question question3 = new Question("What are the containers?", " Containers store objects and data", "Containers stores all the algorithms", "Containers contain overloaded functions", "Containers contain set of Iterators", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question3);
        Question question4 = new Question("The list and vector classes is defined in", "STL classes", "Assert function", "String class", "None of them", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question4);
        Question question5 = new Question("A collection of generic class and function is called as", "Header file", "Function template", "Standard Template Library (STL)", "None of the above", 3, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question5);
        Question question6 = new Question("How many Associative Containers are provided by C++?", "2", "3", "4", "6", 3, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question6);
        Question question7 = new Question("What are Iterators?", "Iterators are used to iterate over C-like arrays", "Iterators are used to iterate over pointers", "Iterators are used to point memory addresses of STL containers", "Iterators are used to iterate over functions", 3, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question7);
        Question question8 = new Question("How many types of Iterators are provided by C++?", "2", "3", "4", "5", 4, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question8);
        Question question9 = new Question("Which header file is used for Iterators?", "<iterator>", "<algorithm>", "<iter>", "<loopIter>", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question9);
        Question question10 = new Question("Which of the following is used for generic programming?", "Virtual functions", "Modules", "Templates", "Abstract Classes", 3, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question10);
        Question question11 = new Question("What is a template?", "A template is used for creating the attributes", "A template is a formula for creating a generic class", "A template is used to manipulate the class", "None of the above", 2, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question11);
        Question question12 = new Question("Which of the following are the components of STL?", "Algorithms", "containers", "function, iterators", "All of these", 4, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question12);
        Question question13 = new Question("Container Adaptors provide a different interface for sequential containers these are", "Queue", "priority Queue", "stack", "All of these", 4, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question13);
        Question question14 = new Question("Which of the header file is used to implement algorithms provided by C++ STL?", "<algorithm>", "<header>", "<algos>", "<Algorithm>", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question14);
        Question question15 = new Question("Which of the following is a Non-modifying Sequence Operation?", "swap()", "transform()", "remove()", "search()", 4, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question15);
        Question question16 = new Question("Which function is used increment the iterator by a particular value?", "next()", "advance()", "prev()", "move()", 2, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question16);
        Question question17 = new Question("Pick the correct statement.", "Input iterator moves sequentially forward", "Input iterator moves sequentially backward", "Input iterator moves in both direction", "Input iterator moves sequentially downwards", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question17);
        Question question18 = new Question("Which function can be used to find the sum of a vector container?", "findsum()", "accumulate()", "calcsum()", "checksum()", 2, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question18);
        Question question19 = new Question("Which of the following is an advantage of Forward iterator over input and output iterator?", " Can be used as both accessing and assigning iterator", "Forward iterator can be incremented or decremented", "Can be used with relational operators also", "Can be used with arithmetic operators also", 1, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question19);
        Question question20 = new Question("vector<int>::iterator i1; \n " +
                "for (i1=v1.begin();i1!=v1.end();++i1) \n" +
                "*i1 = 1; \n \n" +
                "Whats is i1?", " Input Iterator", "Output Iterator", "Both Input and Output Iterator", "Neither Input nor Output Iterator", 2, Languages.CPLUS, Categories.STANDARD_TEMPLATE_LIBRARY);
        insertQuestion(question20);
    }

    //Adding Nested Class Questions
    private void cPlusClassesAndObjects() {
        Question question1 = new Question("Which among the following best describes a nested class?", "Class inside a class", "Class inside a function", "Class inside a package", "Class inside a structure", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question1);
        Question question2 = new Question("What does a class in C++ holds?", "data", "functions", "both data & functions", " arrays", 3, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question2);
        Question question3 = new Question("Which is used to define the member of a class externally?", " :", " ::", "#", " !!$", 2, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question3);
        Question question4 = new Question("Which other keywords are also used to declare the class other than class?", " struct", "union", "object", "both struct & union", 4, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following is a valid class declaration?", "class A { int x; };", "class B {}", "public class A {}", "object A { int x; };", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question5);
        Question question6 = new Question("The data members and functions of a class in C++ are by default ____________", "protected", "private", "public", "public & protected", 2, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question6);
        Question question7 = new Question(" Which category of data type a class belongs to?", "Fundamental data type", "Derived data type", "User defined derived data type", "Atomic data type", 3, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question7);
        Question question8 = new Question("Which operator a pointer object of a class uses to access its data members and member functions?", ".", " ->", ":", "::", 2, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question8);
        Question question9 = new Question("Which is also called as abstract class?", "Virtual function", "Derived class", "Pure virtual function", "None of the mentioned", 3, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question9);
        Question question10 = new Question("How to access the object in the class?", "Ternary operator", "Scope resolution operator", "Direct member access operator", "None of the above", 3, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question10);
        Question question11 = new Question("Which of the following can derived class inherit?", "members", "functions", " both members & functions", " classes", 3, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question11);
        Question question12 = new Question("Which constructor will initialize the base class data member?", "derived class", "base class", "class", "derived & base class", 2, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question12);
        Question question13 = new Question("Which class is used to design the base class?", "abstract class", "derived class", "base class", "derived & base class", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question13);
        Question question14 = new Question("Which is used to create a pure virtual function?", "$", "=0", "&", " !", 2, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question14);
        Question question15 = new Question("Where does the abstract class is used?", "base class only", "derived class", "both derived & base class", "virtual class", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question15);
        Question question16 = new Question("Which of these following members are not accessed by using direct member access operator?", "public", "private", "protected", "both private & protected", 4, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question16);
        Question question17 = new Question("Pick out the other definition of objects.", "member of the class", "associate of the class", " attribute of the class", "instance of the class", 4, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question17);
        Question question18 = new Question("How many objects can present in a single class?", "1", "2", "4", "As many as possible", 4, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question18);
        Question question19 = new Question("Pick out the correct option.", "We cannot make an instance of an abstract base class", "We can make an instance of an abstract base class", "We can make an instance of an abstract super class", "We can make an instance of an abstract derived class", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question19);
        Question question20 = new Question("Where does the object is created?", " class", "constructor", "destructor", "attributes", 1, Languages.CPLUS, Categories.CLASSES_AND_OBJECTS);
        insertQuestion(question20);
    }

    //Adding Interface Questions
    private void cPlusModularizationInterfacesAndNameSpace() {
        Question question1 = new Question("which of the following is used to implement the c++ interfaces?", "absolute variables", "abstract classes", "constant variables", "default variables", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question1);
        Question question2 = new Question(" What is the ability to group some lines of code that can be included?", "specific task", "program control", "modularization", "macros", 3, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question2);
        Question question3 = new Question("What is similar to interface in c++", " methods", " instance of class", "pure abstract class", "None of the mentioned", 3, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question3);
        Question question4 = new Question("Identify the correct statement.", "c++ does not have built-in interfaces", "c++ does have built-in interfaces", "c++ have no cocept of interfaces", "None of the mentioned", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question4);
        Question question5 = new Question("What does the client module import?", "macro", "interface", "records", "None of the mentioned", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question5);
        Question question6 = new Question("How many types of modularization are there in c++?", "3", "4", "1", "None of the mentioned", 4, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question6);
        Question question7 = new Question("How many types do functions fall depends on modularization?", "1", "2", "3", "4", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question7);
        Question question8 = new Question("Interface class in C++ is created by", "Using interface keyword before class", "Using pure virtual function", "Using pure virtual function and virtual function both", "Using class keyword", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question8);
        Question question9 = new Question("For a method to be an Interface between the outside world and a class, it has to be declared __________.", "private", "protected", "public", "external", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question9);
        Question question10 = new Question("What does an interface contain?", "Method definition", " Method declaration", "Method declaration and definition", "Method Name", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question10);
        Question question11 = new Question("What happens when a constructor is defined for an interface?", "Compilation failure", "Runtime Exception", "The interface compiles successfully", "The implementing class will throw exception", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question11);
        Question question12 = new Question("Which operator is used to signify the namespace?", "conditional operator", "ternary operator", "scope operator", "bitwise operator", 3, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question12);
        Question question13 = new Question("Identify the correct statement.", " Namespace is used to group class, objects and functions", "Namespace is used to mark the beginning of the program", "A namespace is used to separate the class, objects", "Namespace is used to mark the beginning & end of the program", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question13);
        Question question14 = new Question("What is the use of Namespace?", "To encapsulate the data", "To structure a program into logical units", "Encapsulate the data & structure a program into logical units", "It is used to mark the beginning of the program", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question14);
        Question question15 = new Question(" What is the general syntax for accessing the namespace variable?", "namespace::operator", " namespace,operator", "namespace#operator", "namespace$operator", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question15);
        Question question16 = new Question("Which keyword is used to access the variable in the namespace?", "using", "  dynamic", "const", "static ", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question16);
        Question question17 = new Question("namespace A{ int var = 10;\n" +
                "\tnamespace B{ int i = 15; \n" +
                "\t}}", "cout<<A::i;", "cout<<B::i;", "cout<<A::B::i;", "cout<<i;", 3, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question17);
        Question question18 = new Question("What is the correct syntax of defining a namespace?", "namespace name{}", "Namespace name{};", "namespace name{};", "typedef namespace name{} NAME", 1, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question18);
        Question question19 = new Question("namespace A{ int var; }\n" +
                "\t\t\tA::var = 5;", "namespace A{ int i }", "namespace B{ int i; };", "namespace C{ int i; }", "Namespace D{ int i }", 3, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question19);
        Question question20 = new Question("Which operator is used for accessing a member of namespace?", " :", " ::", "->", ".", 2, Languages.CPLUS, Categories.MODULARIZATION_AND_INTERFACES_NAMESPACE);
        insertQuestion(question20);
    }

    //Adding Data Structure Questions
    private void cPlusDataStructure() {
        Question question1 = new Question("Which of these best describes an array?", "A data structure that shows a hierarchical behaviour", "Container of objects of similar types", "Arrays are immutable once initialised", "Array is not a data structure", 2, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question1);
        Question question2 = new Question("Which of the following correctly declares an array?", "int array[10];", "int array;", "array{10};", "array array[10];", 1, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following accesses the seventh element stored in array?", "array[6];", "array[7];", "array(7);", " array;", 1, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question3);
        Question question4 = new Question("What is the meaning of the following declaration? \n int(*p[5])();", "p is pointer to function", "p is array of pointer to function", "p is pointer to such function which return type is the array", "p is pointer to array of function", 2, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following data structure is non-linear type?", "Strings", "Lists", "Stacks", "None of above", 4, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question5);
        Question question6 = new Question("A binary tree whose every node has either zero or two children is called", "Complete binary tree", "Binary search tree", "Extended binary tree", "None of above", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question6);
        Question question7 = new Question("Which of the following sorting algorithms can be used to sort a random linked list with minimum time complexity?", "Insertion Sort", "Quick Sort", "Heap Sort", "Merge Sort", 4, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question7);
        Question question8 = new Question("Which of these is not an application of linked list?", "To implement file systems", "For separate chaining in hash-tables", "Random Access of elements", "To implement non-binary trees", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question8);
        Question question9 = new Question("If the elements “A”, “B”, “C” and “D” are placed in a queue and are deleted one at a time, in what order will they be removed?", "ABCD", "DCBA", "DCAB", "ABDC", 1, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question9);
        Question question10 = new Question("Which of the following deletes the element pointed to X from doubly LL , if X pointed last element:", "X -> fwd -> bwd = X -> bwd;", "X -> bwd -> fwd = X -> bwd;", "X -> bwd -> fwd = NULL;", "X -> fwd -> bwd = NULL;", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question10);
        Question question11 = new Question("What does ‘stack overflow’ refer to?", "accessing item from an undefined stack", "adding items to a full stack", "removing items from an empty stack", "index out of bounds exception", 2, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question11);
        Question question12 = new Question("The operation for adding an entry to a stack is traditionally called:", "insert", "append", "add", "push", 4, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question12);
        Question question13 = new Question("What is the value of the postfix expression \n 6 3 2 4 + – *", "Something between 15 and 100", "Something between -5 and -15", "Something between 5 and 15", "Something between -15 and -100", 4, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question13);
        Question question14 = new Question("Evaluate the following prefix expression:\n" + "+ * 2 + / 14 2 5 1", "40", "50", "25", "15", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question14);
        Question question15 = new Question("What is the worst-case time for quick sort to sort an array of n elements?", "O(n log n)", "O(n)", "O(n²)", "O(log n)", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question15);
        Question question16 = new Question("Which searching can be performed iteratively ?", "linear search", "Binary search", "Above Both", "None of the Above", 3, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question16);
        Question question17 = new Question("A tree with n vertices, consists of________ edges.", "n", "n-1", "n-2", "log(n)", 2, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question17);
        Question question18 = new Question("Heap is a good data structure to implement", "priority Queue", "Deque", "linear queue", "None of the Above", 1, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question18);
        Question question19 = new Question("A stack follows __________", "FIFO (First In First Out) principle", "LIFO (Last In First Out) principle", "Ordered array", "Linear tree", 2, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question19);
        Question question20 = new Question("A queue follows __________", "FIFO (First In First Out) principle", "LIFO (Last In First Out) principle", "Ordered array", "Linear tree", 1, Languages.CPLUS, Categories.DATA_STRUCTURE);
        insertQuestion(question20);
    }

    /*===============================================================================================================================================*/
    /* Android */
    /*===============================================================================================================================================*/

    //Adding Basics
    private void androidBasics() {
        Question question1 = new Question("In android application Which file holds to use the internet_____.", " create file", "Manifest file", "system file", "None of these", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question1);
        Question question2 = new Question("Android is", "Web server", " web browser", "operating system", "None of these", 3, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question2);
        Question question3 = new Question("Which one is not a nickname of a version of Android? ", "cupcake", "Gingerbread", "Honeycomb", "Muffin", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question3);
        Question question4 = new Question("_____method is used to close an activity.", "Finish", "Stop", "Destroy", "Close", 1, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question4);
        Question question5 = new Question("Src folder contain____files", " Java source code", "XML", "Manifest", "None of these", 1, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question5);
        Question question6 = new Question("When did Google purchase Android?", "2007", "2005", "2008", "2010", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question6);
        Question question7 = new Question(" _____is the first callback method invoked by the system during an Activity life-cycle?", "on Start()", "on Stop()", "onResume()", "onCreate()", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question7);
        Question question8 = new Question("The Android project folder “res/” contain_____?", "Resource files", "Java Activity classes", "Libraries", "None of these", 1, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question8);
        Question question9 = new Question("Android is developed by the", "Apple", "Google", "Microsoft", "Android Inc", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question9);
        Question question10 = new Question("APK stands for ?", "Android power key", "Android packaging kit", "Android packaging key", "Android pin key", 3, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question10);
        Question question11 = new Question("How can pass the data between the activities", "Content provider", "Intent", "Service", "All of the above", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question11);
        Question question12 = new Question("AVD stands for ", "Android virtual device", "Application virtual device", "Android virtual display", "None of these", 1, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question12);
        Question question13 = new Question("What Activity method is used to get reference to view using id of a resource XML?", "findViewByReference(int id);", "findViewById(int id)", "retrieveResourceById(int id)", "findViewById(String id)", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question13);
        Question question14 = new Question("What is the name of the folder that contains the R.java file?", "src", "res", "bin", "gen", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question14);
        Question question15 = new Question("Which of these files contains text values that you can use in your application?", "AndroidManifest.xml", "res/Text.xml", "res/values/strings.xml", "res/layout/Main.xml", 3, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question15);
        Question question16 = new Question("Which of the following is not an Activity lifecycle call-back method?", "onStart", "onBackPressed", "onCreate", "onPause", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following methods is called in an Activity when another activity gets into the foreground?", "onStop()", "onPause()", "onDestroy()", "onResume()", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question17);
        Question question18 = new Question("Which of the following attributes is used to set an activity screen to landscape orientation?", "screenorientation = landscape", "screenOrientation=”landscape”", "android:ScreenOrientation=“landscape”", "android:ScreenOrientation=“landscape”", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question18);
        Question question19 = new Question("What is the is count of android life cycle methods?", "4", "7", "5", "8", 2, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question19);
        Question question20 = new Question("Which are the screen sizes in Android?", "Small", "Normal", "Large", "All of the Above", 4, Categories.BASICS, Languages.ANDROID);
        insertQuestion(question20);
    }

    //Adding Activity and Intents in android
    private void androidActivityAndIntents() {
        Question question1 = new Question("Intent intent = new Intent(First.this, Second.class );", "Creates an hidden Intent", "Creates an implicit Intent", "Create an explicit Intent", "Starts an activity", 4, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question1);
        Question question2 = new Question("Which type of intent, specify the component to start by name (the fully-qualified class name).", "Explicit", "Implicit", "Depends upon the application", "None of these", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question2);
        Question question3 = new Question("To retrieve the bundle object, _____________ is used.", "getExtra()", "getExtras()", "gets()", "putExtras()", 2, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question3);
        Question question4 = new Question("The 'type' part of intent object-based messages stores", "Intent type", "Parameter type", "Data type in MIME", "Intent action", 3, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question4);
        Question question5 = new Question(" _____________ is called when the activity is no more visible to the user.", "onDestroy()", "onDestroyed()", "onStopped()", "onStop()", 4, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question5);
        Question question6 = new Question("The main purpose of the activity is ___________.", "Interaction with user", "Send messages", "POP up notifications", "Data sharing", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question6);
        Question question7 = new Question("When multiple activities match the intents, it is handled by _____________.", "chooser()", "createChooser()", "getChooser()", "makeChooser()", 2, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question7);
        Question question8 = new Question("An integer value to recognise the calling activity is _____________.", "resultcode", "code", "requestcode", "All of the Above", 3, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question8);
        Question question9 = new Question("To free up the resources before getting destroyed,_____________ is called", "onDestroy()", "onFree()", "onStop()", "onDetach()", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question9);
        Question question10 = new Question("_____________ method explicitly specifies the MIME data type to indicate the type of data.", "setDataType()", "setType()", "Type", "None of the Above", 2, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question10);
        Question question11 = new Question("_____________ is called when the activity becomes visible to the user.", "onStart()", "onResume()", "onAttach()", "onCreate()", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question11);
        Question question12 = new Question("_____________ is used to send back data to the activity.", "startActivity()", "startActivityForResult()", "startActivities()", "startIntent()", 2, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question12);
        Question question13 = new Question("For creating an activity like WhatsApp, _____________ activity is used.", "Basic", "Blank", "navigation drawer", "tabbed", 4, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question13);
        Question question14 = new Question("Intents are mainly used to _____________.", "Display a Webpage", "Launch an activity", "Open another App", "All of the Above", 4, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question14);
        Question question15 = new Question("For creating an activity, java class has to extend _____________.", "Activitymain", "Activity base class", "ShowActivity class", "None of the Above", 2, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question15);
        Question question16 = new Question("The activity available for working with fragments is _____________.", "Fragments", "Blank activity", "Blank activity with fragment", "None of the Above", 3, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question16);
        Question question17 = new Question("Which of the following is used to set the data back ?", "Both uri.parse() and setData()", "uri.parse()", "setData()", "None of the Above", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question17);
        Question question18 = new Question("The types of intents in android is/are ", "Explicit intents", "Implicit intents", "Above Both", "Start intents", 3, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question18);
        Question question19 = new Question("The activity life cycle doesn’t contain _____________.", " onCreate()", "onPause()", "onAttach()", "onStart()", 3, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question19);
        Question question20 = new Question("What is not specified by implicit intent ", "Components within the intent object", "Parameters of the intent object", "Return value of the intent object", "None of the Above", 1, Categories.ACTIVITY_AND_INTENTS, Languages.ANDROID);
        insertQuestion(question20);
    }

    //Adding Fragments
    private void androidFragments() {
        Question question1 = new Question("Fragment in Android can be found through ?", "findByID", "findFragmentByID", "getContext.findFragmentByID", "FragmentManager.findFragmentByID", 4, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question1);
        Question question2 = new Question("What is fragment in android?", "JSON", "Layout", "Peace of Activity", "Container", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question2);
        Question question3 = new Question("What is fragment life cycle in android?", "onReceive", "onCreate", "onAttach-> onCreate −>onCreateView −>\n onActivityCreated −> onStart −> onResume", "None of the above", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question3);
        Question question4 = new Question("How many methods are there in an Fragment lifecycle?", "A.13", "10", "12", "8", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question4);
        Question question5 = new Question("Which method is called first in fragment life cycle methods?", "onAttach()", "onActivityCreated()", "onViewCreated()", "onCreate()", 1, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question5);
        Question question6 = new Question("Which one is NOT related to fragment class?", "dialogFragment", " listFragment", "preferenceFragment", "cursorFragment", 4, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question6);
        Question question7 = new Question("The android component that shows the part of an activity on screen is called", "intent", "fragment", "view", "manifest", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question7);
        Question question8 = new Question("Which of the following are type of fragment?", "Single frame fragments", "List fragments", "Fragments transaction", "All of the Above", 4, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question8);
        Question question9 = new Question("Which of the following Is used to embed fragment in and activity?", "using Java ", "using XML", "Above Both", "None of the Above", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question9);
        Question question10 = new Question("Which method is used for looking an existing fragment instance?", "findFragmentById", "findFragmentByTag", "Above Both", "findFragmentByView", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question10);
        Question question11 = new Question("How many ways we can communicate with fragment?", "2", "3", "4", "5", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question11);
        Question question12 = new Question("_________ is called once the fragment is ready to be displayed on screen.", "onStart()", "onResume()", "onViewCreated()", "onCreateView()", 1, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question12);
        Question question13 = new Question("_________ is called when fragment is no longer connected to the activity.", "onDestroyView()", "onDetach()", "onStop()", "onDestroy()", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question13);
        Question question14 = new Question("_________ creates a new transaction to change fragments at runtime.", "beginTransaction()", "startTransaction()", "addTransaction()", "createTransaction()", 1, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question14);
        Question question15 = new Question(" when interacting with nested fragments we can use the following method.", "getSupportFragmentManager()", "getChildFragmentManager()", "getFragmentManager()", "None of the Above", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question15);
        Question question16 = new Question("Which method is used to remove fragment from Back Stack?", "removeBackStack()", "stopBackStack()", "popBackStack()", "None of the Above", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question16);
        Question question17 = new Question("The _________ is responsible for all runtime management of fragments including adding, removing, hiding, showing.", "Fragment manager", "Interface", "Fragment Controller", "BackStack", 1, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question17);
        Question question18 = new Question("In order to respond to changes in user interface at runtime we can add fragment to activity using _________.", "<LinearLayout>", "<RelativeLayout>", "<FrameLayout>", "<ConstraintLayout>", 3, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question18);
        Question question19 = new Question("Which of the following is used to communicate with fragments?", "Bundle", "Methods", "Listener ", "All of the Above", 4, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question19);
        Question question20 = new Question("View Pager Is Used For ", " Swiping Activities", "Swiping Fragments", "Paging Down List Items", "View Pager Is Not Supported By Android SDK", 2, Languages.ANDROID, Categories.FRAGMENTS);
        insertQuestion(question20);
    }

    //Adding Content Providers
    private void androidContentProvider() {
        Question question1 = new Question("What is the use of content provider in android?", "To send the data from an application to another application", "To store the data in a database", "To share the data between applications", "None of the above", 3, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question1);
        Question question2 = new Question("To access a provider in \"batch mode\", which object array is created", "ContentProviderArray", "ContentProviderBatch", "ContentProviderBatchOperation", "ContentProviderOperation", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question2);
        Question question3 = new Question("What are the predefined query string constants available in Android?", "ContactsContract.Contacts.CONTENT_URI", "Browser.SEARCHES_URI", "MediaStore.Images.Media.INTERNAL_CONTENT_URI", "All of the Above", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question3);
        Question question4 = new Question("Status data will be exposed to the rest of the Android system via _________ .", "Intents", "Content provider", "Network receivers", "Altering permissions", 2, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question4);
        Question question5 = new Question("_________ is the recommended way for sharing data across packages?", "Content providers", "Data persistence", "Messaging", "None of the Above", 1, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question5);
        Question question6 = new Question("Which of the following is not a ContentProvider provided natively by android", "The application list", "The bookmarks", "The telephone log", "The contacts list", 1, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question6);
        Question question7 = new Question("What is the use of content provider in android?", "To send data from an app to another app", "To share the data between applications", "To store the data in a database", "None of the Above", 2, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question7);
        Question question8 = new Question("The requests from Content Provider class is handled by method", "onCreate", "onSelect", "onClick", "contentResolver", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question8);
        Question question9 = new Question("When ContentProvider would be activated?", "Using Intent", "Using SQLite", "Using ContentResolver", "None of the Above", 3, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question9);
        Question question10 = new Question("The sortOrder parameter of query method in cursor object has data type of", "boolean", "int", "string array", "string", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question10);
        Question question11 = new Question("For Creating your own content provider which class you will inherit?", "Content", "ContentProvider", "Object", "None of the Above", 2, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question11);
        Question question12 = new Question("For reading the contacts from the Contacts, Which permission you will set in AndroidManifest.xml file if you are using ContentProvider.", "FIND_CONTACTS", "GET_CONTACTS", "READ_CONTACTS", "None of the Above", 3, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question12);
        Question question13 = new Question("Insert data into a content provider, you need to use ______", "insert() ", "bulkInsert() ", "getContentProvider()", "Both insert() and bulkInsert()", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question13);
        Question question14 = new Question("Asynchronous queries can be implemented by using a", "CursorLoader object", "AsyncCursor object", "AsyncLoader object", "AsyncCursorLoader object", 1, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question14);
        Question question15 = new Question("To update contents of content provider using curser and commit you need to call________", "updates()", "commitUpdates()", "commit()", "None of the Above", 2, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question15);
        Question question16 = new Question("In the android content provider architecture, the component that does not resides on data layer is", "Internet", "SQLite", "Files", "Content Providers", 4, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question16);
        Question question17 = new Question("A content provider is an ______ that allows apps to share data in a controlled way. ", "Interface", "Class", "Library", "None of the Above", 1, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question17);
        Question question18 = new Question("The __________ methods provide the basic \"CRUD\" (create, retrieve, update, and delete) functions of persistent storage.", "CursorLoader", "ContentResolver", "CursorAdapter", "None of the Above", 2, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question18);
        Question question19 = new Question("What does the following flag provide? \n FLAG_GRANT_READ_URI_PERMISSION", "Read permission", "Write permission", "Above Both", "None of the Above", 1, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question19);
        Question question20 = new Question("The provider has the separate _________ permission for inserting, updating, or deleting data.", "android.permission.READ_USER_DICTIONARY", "FLAG_GRANT_WRITE_URI_PERMISSION", "android.permission.WRITE_USER_DICTIONARY", "None of the Above", 3, Languages.ANDROID, Categories.CONTENT_PROVIDER);
        insertQuestion(question20);
    }

    /*===============================================================================================================================================*/
    /*PHP Multiple Choice Questions*/
    /*===============================================================================================================================================*/
    private void phpBasics() {
        Question question1 = new Question("PHP files have a default file extension of_______", ".html", ".xml", ".php", ".ph", 3, Languages.PHP, Categories.BASICS);
        insertQuestion(question1);
        Question question2 = new Question("What should be the correct syntax to write a PHP code?", "< php >", "< ? php >", "<? ?>", "<?php ?>", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question2);
        Question question3 = new Question("Who is known as the father of PHP?", "Rasmus Lerdorf", "Willam Makepiece", "Drek Kolkevi", "List Barely", 1, Languages.PHP, Categories.BASICS);
        insertQuestion(question3);
        Question question4 = new Question("<?php $num  = 1;\n" +
                "  $num1 = 2;\n" +
                "    print $num . \"+\". $num1;?>\n", "3", "1+2", "1.+.2", "Error", 2, Languages.PHP, Categories.BASICS);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following is not true?", "PHP can be used to develop web applications.", "PHP makes a website dynamic", "PHP applications can not be compile.", "PHP can not be embedded into html.", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question5);
        Question question6 = new Question("Which of the below statements is equivalent to $add += $add?", "$add = $add", "$add = $add +$add", "$add = $add + 1", "$add = $add + $add + 1", 2, Languages.PHP, Categories.BASICS);
        insertQuestion(question6);
        Question question7 = new Question("Which statement will output $x on the screen?", "echo “\\$x”;", "echo “$$x”;", "echo “/$x”;", "echo “$x;”;", 1, Languages.PHP, Categories.BASICS);
        insertQuestion(question7);
        Question question8 = new Question("PHP is a ________.", "Tightly typed language", "Loosely typed language", "Server typed language", "Client typed language", 2, Languages.PHP, Categories.BASICS);
        insertQuestion(question8);
        Question question9 = new Question("______ is concatenation operator in PHP ?", "+(plus)", ".(dot)", "^", "_", 2, Languages.PHP, Categories.BASICS);
        insertQuestion(question9);
        Question question10 = new Question("Which of the below symbols is a newline character?", "\\r", "/n", "\\n", "None of the Above", 3, Languages.PHP, Categories.BASICS);
        insertQuestion(question10);
        Question question11 = new Question("If $a = 12 what will be returned when ($a == 12) ? 5 : 1 is executed?", "12", "Error", "1", "5", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question11);
        Question question12 = new Question("Which of the following PHP statement/statements will store 111 in variable num?", "$num = 111;", "int $num = 111;", "int num = 111;", "111 = $num;", 1, Languages.PHP, Categories.BASICS);
        insertQuestion(question12);
        Question question13 = new Question("Which version of PHP introduced Try/catch Exception?", "PHP 4", "PHP 5", "PHP 6", "PHP 5 and later", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question13);
        Question question14 = new Question("Which sign is used to access variable of variable in PHP?", " $$", "$", "#@", "$::", 1, Languages.PHP, Categories.BASICS);
        insertQuestion(question14);
        Question question15 = new Question("<?php $a = \"clue\";\n" +
                "      $a .= \"get\";\n" +
                "     echo \"$a\"; ?>\n", "get", "clueget", "True", "False", 2, Languages.PHP, Categories.BASICS);
        insertQuestion(question15);
        Question question16 = new Question(". <?php  $total = \"25 students\";\n" +
                "    $more = 10;\n" +
                "    $total = $total + $more;\n" +
                "    echo \"$total\"; ?>\n", "Error", "35 students", "35", "25 students", 3, Languages.PHP, Categories.BASICS);
        insertQuestion(question16);
        Question question17 = new Question("Which of the conditional statements is/are supported by PHP?", "if statements and if-else statements", "if-elseif statements", "switch statements", "All of the Above", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question17);
        Question question18 = new Question("Which is the right way of declaring a variable in PHP?", "$_hello", "$This", "Above Both", "$3hello", 3, Languages.PHP, Categories.BASICS);
        insertQuestion(question18);
        Question question19 = new Question("How should we add a single line comment in our PHP code?", "//", "#", "/* */", "All of the Above", 4, Languages.PHP, Categories.BASICS);
        insertQuestion(question19);
        Question question20 = new Question("What does PHP stand for?", "Personal Home Page", "Hypertext Preprocessor", "Above Both", "Preprocessor Home Page", 3, Languages.PHP, Categories.BASICS);
        insertQuestion(question20);
    }

    private void phpOOP() {
        Question question1 = new Question("Which method scope prevents a method from being overridden by a subclass?", "Abstract", "Protected", "Final", "Static", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question1);
        Question question2 = new Question("PHP recognizes constructors by the name _________", "classname()", "_construct()", "functionConstruct()", "function __construct()", 4, Languages.PHP, Categories.OOP);
        insertQuestion(question2);
        Question question3 = new Question("An individual instance in OOP is called as", "Class", "Function", "Object", "Constructor", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question3);
        Question question4 = new Question("Which version of PHP introduced the advanced concepts of OOP?", "PHP 4", "PHP 5", "PHP 5.3", "PHP 6", 2, Languages.PHP, Categories.OOP);
        insertQuestion(question4);
        Question question5 = new Question("The practice of creating objects based on predefined classes is often referred to as _______", "class instantiation", "object instantiation", "object creation", "class creation", 1, Languages.PHP, Categories.OOP);
        insertQuestion(question5);
        Question question6 = new Question(". Which one of the following can be used to instantiate an object in PHP assuming class name to be Foo?", "$obj = new $foo;", "$obj = new foo;", "$obj = new foo ();", "obj = new foo ();", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question6);
        Question question7 = new Question("Which one of the following is the right way to invoke a method?", "$object->methodName();", "object->methodName();", "object::methodName();", "$object::methodName();", 1, Languages.PHP, Categories.OOP);
        insertQuestion(question7);
        Question question8 = new Question("Which of the following method scopes is/are not supported by PHP?", "private", "friendly", "static", "abstract", 2, Languages.PHP, Categories.OOP);
        insertQuestion(question8);
        Question question9 = new Question("Which one of the following functions is used to determine whether a class exists?", "exist()", "exist_class()", "class_exist()", "__exist()", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question9);
        Question question10 = new Question("Which one of the following keyword is used to inherit our subclass into a superclass?", "extends", "implements", "inherit", "include", 1, Languages.PHP, Categories.OOP);
        insertQuestion(question10);
        Question question11 = new Question("Which keyword is used to refer to properties or methods within the class itself?", "private", "public", "protected", "$this", 4, Languages.PHP, Categories.OOP);
        insertQuestion(question11);
        Question question12 = new Question("Which one of the following is the right way to clone an object?", "_clone(targetObject);", "destinationObject = clone targetObject;", "destinationObject = _clone(targetObject);", "destinationObject = clone(targetObject);", 2, Languages.PHP, Categories.OOP);
        insertQuestion(question12);
        Question question13 = new Question("The class from which the child class inherits is called ________", "Parent class", "Base class", "Above Both", "Super class", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question13);
        Question question14 = new Question("Which feature allows us to call more than one method or function of the class in single instruction?", "Typecasting", "Method Including", "Method adding", "Method chaining", 4, Languages.PHP, Categories.OOP);
        insertQuestion(question14);
        Question question15 = new Question("Which magic method is used to implement overloading in PHP?", "__call", "__invoke", "__wakeup", "__unset", 1, Languages.PHP, Categories.OOP);
        insertQuestion(question15);
        Question question16 = new Question("Which one of the following is not a valid class name?", "ShopProduct", "1shopproduct", "Shopproduct1", "Shopproduct", 2, Languages.PHP, Categories.OOP);
        insertQuestion(question16);
        Question question17 = new Question("Which one of the following functions is used to determine object type?", "obj_type()", "type()", "is_a()", "is_obj()", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question17);
        Question question18 = new Question("If your object must inherit behavior from several sources you must use a/an", "Interface", "Object", "Abstract class", "Static class", 1, Languages.PHP, Categories.OOP);
        insertQuestion(question18);
        Question question19 = new Question("If one intends to create a model that will be assumed by several closely related objects, which class must be used?", "Normal class", "Static class", "Abstract class", "Interface", 3, Languages.PHP, Categories.OOP);
        insertQuestion(question19);
        Question question20 = new Question("Which one of the following is the right way to call a class constant, given that the class is mathFunction?", "echo PI;", "echo mathFunction::PI;", "echo mathFunction->PI;", "echo mathFunction=PI;", 2, Languages.PHP, Categories.OOP);
        insertQuestion(question20);
    }

    private void phpArraysAndFunctions() {
        Question question1 = new Question("PHP’s numerically indexed array begin with position ___________", "1", "2", "0", "-1", 3, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question1);
        Question question2 = new Question("Which of the functions is used to sort an array in descending order?", "sort()", "rsort()", "asort()", "dsort()", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question2);
        Question question3 = new Question("Which function will return true if a variable is an array or false if it is not?", "this_array()", "is_array()", "do_array()", "in_array()", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question3);
        Question question4 = new Question("<?php\n" +
                "$fruits = array (\"apple\", \"orange\", \"banana\");\n" +
                "echo (next($fruits));\t\n" +
                "echo (next($fruits)); ?>\n", "orangebanana", "appleorange", "orangeorange", "appleapple", 1, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question4);
        Question question5 = new Question("Which function can be used to move the pointer to the previous array position?", "last()", "before()", "prev()", "previous()", 3, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question5);
        Question question6 = new Question("Which in-built function will add a value to the end of an array?", "array_unshift()", "into_array()", "inend_array()", "array_push()", 4, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question6);
        Question question7 = new Question("<?php\n" +
                "    $state = array (\"One\", \"Two\", \"Three\");\n" +
                "    echo (array_search (\"Three\", $state) ); ?>\n", "2", "1", "True", "False", 1, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question7);
        Question question8 = new Question("<?php\n" +
                "$a = array(12, 5, 2);\n" +
                "echo(array_product($a)); ?>\n", "024", "120", "101", "060", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question8);
        Question question9 = new Question("<?php\n" +
                "$a = array(\"red\", \"green\", \"blue\");\n" +
                "array_pop($a); print_r($a); ?>\n", "Array ( [0] => red [1] => green )", "Array ( [0] => green [1] => blue )", "Array ( [0] => red [1] => blue )", "Array ( [0] => blue [1] => blue )", 1, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question9);
        Question question10 = new Question("Which function should we use to sort the array in natural order?", "dsort()", "casesort()", "natcasesort()", "naturalsort()", 3, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question10);
        Question question11 = new Question("Which of the following are valid function names?", "function()", "€()", ".function()", "$function()", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question11);
        Question question12 = new Question("A function in PHP which starts with __ (double underscore) is known as __________", "Magic Function", "Inbuilt Function", "Default Function", "User Defined Function", 1, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question12);
        Question question13 = new Question("How to define a function in PHP?", "function {body}", "data type functionName(params) {body}", "functionName(params) { body }", "function functionName(params) {body}", 4, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question13);
        Question question14 = new Question("Which one of the following PHP functions can be used to find files?", "glob()", "file()", "fold()", "get_file()", 1, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question14);
        Question question15 = new Question("The base conversion function DecHex () coverts from", "Base 10 to base 8", "Base 10 to base 16", "Base 16 to base 10", "Base 8 to base 10", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question15);
        Question question16 = new Question("<?php\n" +
                "    echo chr(52);  ?>\n", "1", "2", "3", "4", 4, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question16);
        Question question17 = new Question(" <?php\n" +
                "    echo ucwords(\"i love my country\");\n" +
                "    ?>\n", "I love my country", "i love my Country", "I love my Country", "I Love My Country", 4, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question17);
        Question question18 = new Question("What does explode () function do?", "Converts a string into integers", "Converts a string into arrays", "Finds the length of array", "Finds the length of string", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question18);
        Question question19 = new Question("<?php\n" +
                "    echo ord (\"hi\"); ?>\n", "106", "103", "104", "100", 3, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question19);
        Question question20 = new Question("The current () function is a", "2 array argument", "1 array argument", "3 array argument", "None of the Above", 2, Languages.PHP, Categories.ARRAYS_AND_FUNCTIONS);
        insertQuestion(question20);

    }

    private void phpErrorAndExceptionHandling() {
        Question question1 = new Question("In Which php version Exception handling was added?", "PHP 5.1", "PHP 5.2", "PHP 5.3", "PHP 5", 4, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question1);
        Question question2 = new Question("How many methods are available for the exception class?", "5", "6", "7", "9", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question2);
        Question question3 = new Question("Which of the following statements invoke the exception class?", "throws new Exception();", "throw new Exception();", "new Exception();", "new throws Exception();", 2, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question3);
        Question question4 = new Question("We cannot override any of the preceding methods of exception base class because they are declared as_____", "final", "protected", "static", "private", 1, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question4);
        Question question5 = new Question("Which of the following is/are an exception?", "OutOfBoundException", "OutOfRangeException", "OverflowException", "All of the Above", 4, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question5);
        Question question6 = new Question("Which of the following are valid statements to raise an exception", "throw new exception()", "throw new exception(\"Error Occurred\")", "throw new exception(\"Error Occured\",5)", "All of the Above", 4, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question6);
        Question question7 = new Question("For exception handling PHP5 introduced a class, name", "Exe { }", "Exception { }", "Catch { }", "None of the Above", 2, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question7);
        Question question8 = new Question("How many error levels are available in PHP?", "14", "15", "16", "17", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question8);
        Question question9 = new Question("What is the description of Error level E_ERROR?", "Fatal run-time error", "Near-fatal error", "Compile-time error", "Fatal Compile-time error", 1, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question9);
        Question question10 = new Question("Which function is responsible for sending a custom message to the system log?", "systemlog()", "syslog()", "log_system()", "sys_log()", 2, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question10);
        Question question11 = new Question("Which character does the error_reporting directive use to represent the logical operator NOT?", "/", "!", "~", "^", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question11);
        Question question12 = new Question("Which version of PHP introduced E_STRICT Error level?", "PHP 4", "PHP 5", "PHP 5.3", "PHP 6", 2, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question12);
        Question question13 = new Question("The statements that causes PHP to disregard repeated error messages that occur within same file and line?", "ignore_repeated_errors", "ignore_repeat_error", "repeatedly_ignore_error", "repeated_error_ignore", 1, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question13);
        Question question14 = new Question("Which function initializes the constants necessary for using the openlog(), clodelog(), and syslog() functions?", "define_variable()", "define_log_variable()", "log_variable()", "define_syslog_variable()", 4, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question14);
        Question question15 = new Question("Which is the error level to report probable run-time errors?", "E_ERROR", "E_NOTICE", "E_CORE", "E_USER_ERROR", 2, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question15);
        Question question16 = new Question("Which is the correct method to turn off error display?", "ini_set(\"Off\")", "error_reporting=Off", "init_set(\"error_reporting\",\"Off\")", "init_set(\"error_reporting=Off\")", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question16);
        Question question17 = new Question("How can errors be logged in files?", "Turn on log_errors", "Set error_log to file name", "Both A and B", "None of the Above", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question17);
        Question question18 = new Question("An error that causes by failed code, is called as", "Notice error", "Fatal error", "Warning error", "None of them", 3, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question18);
        Question question19 = new Question("What does SPL stand for?", "Standard PHP Library", "Source PHP Library", "Standard PHP List", "Source PHP List", 1, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question19);
        Question question20 = new Question("How many predefined exceptions does SPL provide access to?", "13", "14", "15", "16", 1, Languages.PHP, Categories.ERROR_AND_EXCEPTION_HANDLING);
        insertQuestion(question20);
    }

    private void phpStringsAndRegularExpressions() {
        Question question1 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question1);
        Question question2 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question2);
        Question question3 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question3);
        Question question4 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question4);
        Question question5 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question5);
        Question question6 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question6);
        Question question7 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question7);
        Question question8 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question8);
        Question question9 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question9);
        Question question10 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question10);
        Question question11 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question11);
        Question question12 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question12);
        Question question13 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question13);
        Question question14 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question14);
        Question question15 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question15);
        Question question16 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question16);
        Question question17 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question17);
        Question question18 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question18);
        Question question19 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question19);
        Question question20 = new Question("", "", "", "", "", , Languages.PHP, Categories.STRINGS_AND_REGULAR_EXPRESSIONS);
        insertQuestion(question20);

    }










                                                                /* private void phpBasics(){
        Question question1 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question1);
        Question question2 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question2);
        Question question3 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question3);
        Question question4 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question4);
        Question question5 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question5);
        Question question6 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question6);
        Question question7 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question7);
        Question question8 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question8);
        Question question9 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question9);
        Question question10 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question10);
        Question question11 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question11);
        Question question12 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question12);
        Question question13 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question13);
        Question question14 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question14);
        Question question15 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question15);
        Question question16 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question16);
        Question question17 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question17);
        Question question18 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question18);
        Question question19 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question19);
        Question question20 = new Question("","","","","",,Languages.PHP,Categories.BASICS);
        insertQuestion(question20);

    }*/
    /*===============================================================================================================================================*/
    /*Categories*/
    /*===============================================================================================================================================*/

    //Java Category
    private void javaCategory() {
        Categories categories1 = new Categories("Basics", Languages.JAVA);
        insertCategory(categories1);
        Categories categories2 = new Categories("Data Types", Languages.JAVA);
        insertCategory(categories2);
        Categories categories3 = new Categories("OOP", Languages.JAVA);
        insertCategory(categories3);
        Categories categories4 = new Categories("Keywords", Languages.JAVA);
        insertCategory(categories4);
        Categories categories13 = new Categories("Function", Languages.JAVA);
        insertCategory(categories13);
        Categories categories5 = new Categories("Interfaces", Languages.JAVA);
        insertCategory(categories5);
        Categories categories6 = new Categories("EXCEPTION Handling", Languages.JAVA);
        insertCategory(categories6);
        Categories categories7 = new Categories("MULTI THREADING", Languages.JAVA);
        insertCategory(categories7);
        Categories categories8 = new Categories("Inner Class", Languages.JAVA);
        insertCategory(categories8);
        Categories categories10 = new Categories("Data Structure", Languages.JAVA);
        insertCategory(categories10);
        Categories categories11 = new Categories("Collection FrameWork", Languages.JAVA);
        insertCategory(categories11);
        Categories categories12 = new Categories("JDBC", Languages.JAVA);
        insertCategory(categories12);
        Categories categories9 = new Categories("GUI", Languages.JAVA);
        insertCategory(categories9);

    }

    //C++ Category
    private void cPlusCategory() {
        Categories categories1 = new Categories("Basics", Languages.CPLUS);
        insertCategory(categories1);
        Categories categories2 = new Categories("Data Types", Languages.CPLUS);
        insertCategory(categories2);
        Categories categories3 = new Categories("OOP", Languages.CPLUS);
        insertCategory(categories3);
        Categories categories4 = new Categories("Keywords and Pointers", Languages.CPLUS);
        insertCategory(categories4);
        Categories categories12 = new Categories("Function", Languages.CPLUS);
        insertCategory(categories12);
        Categories categories5 = new Categories("Modularization,Interfaces And \nNamespace", Languages.CPLUS);
        insertCategory(categories5);
        Categories categories6 = new Categories("EXCEPTION Handling", Languages.CPLUS);
        insertCategory(categories6);
        Categories categories7 = new Categories("Data Structure", Languages.CPLUS);
        insertCategory(categories7);
        Categories categories8 = new Categories("Classes and Objects", Languages.CPLUS);
        insertCategory(categories8);
        Categories categories9 = new Categories("Standard Template Library", Languages.CPLUS);
        insertCategory(categories9);

    }

    //C# Category
    private void cSharpCategory() {
        Categories categories1 = new Categories("Basics", Languages.CSHARP);
        insertCategory(categories1);
        Categories categories2 = new Categories("Data Types", Languages.CSHARP);
        insertCategory(categories2);
        Categories categories3 = new Categories("OOP", Languages.CSHARP);
        insertCategory(categories3);
        Categories categories4 = new Categories("Keywords", Languages.CSHARP);
        insertCategory(categories4);
        Categories categories5 = new Categories("Interfaces", Languages.CSHARP);
        insertCategory(categories5);
        Categories categories12 = new Categories("Function", Languages.CSHARP);
        insertCategory(categories12);
        Categories categories6 = new Categories("Exception Handling", Languages.CSHARP);
        insertCategory(categories6);
        Categories categories7 = new Categories("Multi Threading", Languages.CSHARP);
        insertCategory(categories7);
        Categories categories8 = new Categories("Inner Class", Languages.CSHARP);
        insertCategory(categories8);
        Categories categories9 = new Categories("Enums", Languages.CSHARP);
        insertCategory(categories9);
        Categories categories10 = new Categories("Data Structure", Languages.CSHARP);
        insertCategory(categories10);
        Categories categories11 = new Categories("Collections", Languages.CSHARP);
        insertCategory(categories11);
    }

    //JavaScript Category
    private void javaScriptCategory() {
        Categories categories1 = new Categories("Basics", Languages.JAVA_SCRIPT);
        insertCategory(categories1);
        Categories categories2 = new Categories("Data Types", Languages.JAVA_SCRIPT);
        insertCategory(categories2);
        Categories categories10 = new Categories("Function", Languages.JAVA_SCRIPT);
        insertCategory(categories10);
        Categories categories3 = new Categories("Error Handling", Languages.JAVA_SCRIPT);
        insertCategory(categories3);
        Categories categories4 = new Categories("DOM", Languages.JAVA_SCRIPT);
        insertCategory(categories4);
        Categories categories5 = new Categories("BOM", Languages.JAVA_SCRIPT);
        insertCategory(categories5);
        Categories categories6 = new Categories("Ajax", Languages.JAVA_SCRIPT);
        insertCategory(categories6);
        Categories categories7 = new Categories("Json", Languages.JAVA_SCRIPT);
        insertCategory(categories7);
        Categories categories8 = new Categories("Objects", Languages.JAVA_SCRIPT);
        insertCategory(categories8);
        Categories categories9 = new Categories("Core Objects", Languages.JAVA_SCRIPT);
        insertCategory(categories9);
    }

    //Python Category
    private void python() {
        Categories categories1 = new Categories("Basics", Languages.PYTHON);
        insertCategory(categories1);
        Categories categories2 = new Categories("Keywords", Languages.PYTHON);
        insertCategory(categories2);
        Categories categories3 = new Categories("Classes and Objects", Languages.PYTHON);
        insertCategory(categories3);
        Categories categories13 = new Categories("Function", Languages.PYTHON);
        insertCategory(categories13);
        Categories categories4 = new Categories("Multi Threading", Languages.PYTHON);
        insertCategory(categories4);
        Categories categories5 = new Categories("Exception Handling", Languages.PYTHON);
        insertCategory(categories5);
        Categories categories6 = new Categories("Reg Expression", Languages.PYTHON);
        insertCategory(categories6);
        Categories categories7 = new Categories("GUI", Languages.PYTHON);
        insertCategory(categories7);
        Categories categories8 = new Categories("Networking", Languages.PYTHON);
        insertCategory(categories8);
        Categories categories9 = new Categories("Enums", Languages.PYTHON);
        insertCategory(categories9);
        Categories categories10 = new Categories("Data Structure", Languages.PYTHON);
        insertCategory(categories10);
        Categories categories11 = new Categories("Database access", Languages.PYTHON);
        insertCategory(categories11);
        Categories categories12 = new Categories("Artificial intelligence", Languages.PYTHON);
        insertCategory(categories12);
    }

    //Android Category
    private void android() {
        Categories categories1 = new Categories("Basics", Languages.ANDROID);
        insertCategory(categories1);
        Categories categories2 = new Categories("XML", Languages.ANDROID);
        insertCategory(categories2);
        Categories categories3 = new Categories("Layouts", Languages.ANDROID);
        insertCategory(categories3);
        Categories categories4 = new Categories("Menus & Navigation", Languages.ANDROID);
        insertCategory(categories4);
        Categories categories5 = new Categories("Text, Input & Selection", Languages.ANDROID);
        insertCategory(categories5);
        Categories categories6 = new Categories("ACTIVITY And INTENTS", Languages.ANDROID);
        insertCategory(categories6);
        Categories categories7 = new Categories("Usability & Styling", Languages.ANDROID);
        insertCategory(categories7);
        Categories categories8 = new Categories("Fragments", Languages.ANDROID);
        insertCategory(categories8);
        Categories categories9 = new Categories("Storage", Languages.ANDROID);
        insertCategory(categories9);
        Categories categories10 = new Categories("SQLite", Languages.ANDROID);
        insertCategory(categories10);
        Categories categories11 = new Categories("Services ", Languages.ANDROID);
        insertCategory(categories11);
        Categories categories12 = new Categories("Widgets", Languages.ANDROID);
        insertCategory(categories12);
        Categories categories13 = new Categories("Notifications & Messages", Languages.ANDROID);
        insertCategory(categories13);
        Categories categories14 = new Categories("Content Provider", Languages.ANDROID);
        insertCategory(categories14);

    }

    //Html
    private void html() {
        Categories categories1 = new Categories("Basics", Languages.HTML);
        insertCategory(categories1);
        Categories categories2 = new Categories("Tags-1", Languages.HTML);
        insertCategory(categories2);
        Categories categories22 = new Categories("Tags-2", Languages.HTML);
        insertCategory(categories22);
        Categories categories3 = new Categories("Links and Lists", Languages.HTML);
        insertCategory(categories3);
        Categories categories4 = new Categories("LAYOUTS", Languages.HTML);
        insertCategory(categories4);
        Categories categories5 = new Categories("FORMS", Languages.HTML);
        insertCategory(categories5);
        Categories categories6 = new Categories("Graphics", Languages.HTML);
        insertCategory(categories6);
        Categories categories7 = new Categories("MEDIA", Languages.HTML);
        insertCategory(categories7);
        Categories categories8 = new Categories("API", Languages.HTML);
        insertCategory(categories8);
    }

    //Php
    private void php() {
        Categories categories1 = new Categories("Basics", Languages.PHP);
        insertCategory(categories1);
        Categories categories2 = new Categories("ARRAYS AND FUNCTIONS", Languages.PHP);
        insertCategory(categories2);
        Categories categories3 = new Categories("ERROR AND EXCEPTION HANDLING", Languages.PHP);
        insertCategory(categories3);
        Categories categories4 = new Categories("OOP", Languages.PHP);
        insertCategory(categories4);
        Categories categories5 = new Categories("STRINGS AND REGULAR EXPRESSIONS", Languages.PHP);
        insertCategory(categories5);
        Categories categories6 = new Categories("Data Structure", Languages.PHP);
        insertCategory(categories6);
        Categories categories7 = new Categories("Exception Handling", Languages.PHP);
        insertCategory(categories7);
        Categories categories8 = new Categories("Form", Languages.PHP);
        insertCategory(categories8);
        Categories categories9 = new Categories("State Management", Languages.PHP);
        insertCategory(categories9);
        Categories categories10 = new Categories("Get & Post", Languages.PHP);
        insertCategory(categories10);
        Categories categories11 = new Categories("Function", Languages.PHP);
        insertCategory(categories11);

    }


    private void insertQuestion(@NotNull Question question) {
        ContentValues values = new ContentValues();
        values.put(Constants.COLUMNS_QUESTION, question.getQuestion());
        values.put(Constants.COLUMNS_OPTION1, question.getOption1());
        values.put(Constants.COLUMNS_OPTION2, question.getOption2());
        values.put(Constants.COLUMNS_OPTION3, question.getOption3());
        values.put(Constants.COLUMNS_OPTION4, question.getOption4());
        values.put(Constants.COLUMN_CATEGORY, question.getCategory());
        values.put(Constants.COLUMN_LANGUAGE, question.getLanguage());
        values.put(Constants.ANSWER, question.getAnswer());

        long insert = db.insert(Constants.TABLE_FIRST, null, values);
        Log.d(TAG, "insertQuestion: Row Inserted to the Database " + insert);
    }

    private void insertCategory(@NotNull Categories categories) {
        ContentValues value = new ContentValues();
        value.put(Constants.COLUMN_CATEGORY_SECOND, categories.getCategory());
        value.put(Constants.COLUMN_LANGUAGE_SECOND, categories.getLanguage());

        long insert = db.insert(Constants.TABLE_SECOND, null, value);
        Log.d(TAG, "insertCategory: Category Inserted to the Database " + insert);

    }

    public List<Question> getAllData(String Category, String Language) {
        List<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = Constants.COLUMN_CATEGORY + " = ? " + "AND " + Constants.COLUMN_LANGUAGE + " = ? ";
        String[] selectionArgs = {Category, Language};

        //String orderBy = " RANDOM() LIMIT " + number;


        Cursor c = db.query(Constants.TABLE_FIRST, Constants.ALL_COLUMNS, selection, selectionArgs, null, null, null);
        if (c.moveToFirst()) {
            do {
                Question questions = new Question();
                questions.setQuestion(c.getString(c.getColumnIndex(Constants.COLUMNS_QUESTION)));
                questions.setOption1(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION4)));
                questions.setAnswer(c.getInt(c.getColumnIndex(Constants.ANSWER)));
                questions.setLanguage(c.getString(c.getColumnIndex(Constants.COLUMN_LANGUAGE)));
                questions.setCategory(c.getString(c.getColumnIndex(Constants.COLUMN_CATEGORY)));
                questionsList.add(questions);
            } while (c.moveToNext());
        }
        c.close();
        return questionsList;
    }

    public Cursor getCategory(String Language) {

        db = getReadableDatabase();
        String selection = Constants.COLUMN_LANGUAGE_SECOND + "=? ";
        String[] selectionArgs = {Language};
        return db.query(Constants.TABLE_SECOND, Constants.ALL_COLUMNS_SECOND, selection, selectionArgs, null, null, null);
    }

}
