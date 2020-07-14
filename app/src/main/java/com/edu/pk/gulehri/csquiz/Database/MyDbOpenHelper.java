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
        Question question1 = new Question("What is multithreaded programming?", "It’s a process in which two different processes run simultaneously.", "It’s a process in which two or more parts of same process run simultaneously.", " Its a process in which many different process are able to access same information.", "Its a process in which a single process can access information from many sources.", 2, Languages.JAVA, Categories.MULTI_THREADING);
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
        Categories categories4 = new Categories("Keywords", Languages.CPLUS);
        insertCategory(categories4);
        Categories categories12 = new Categories("Function", Languages.CPLUS);
        insertCategory(categories12);
        Categories categories5 = new Categories("Interfaces", Languages.CPLUS);
        insertCategory(categories5);
        Categories categories6 = new Categories("Exception Handling", Languages.CPLUS);
        insertCategory(categories6);
        Categories categories7 = new Categories("Multi Threading", Languages.CPLUS);
        insertCategory(categories7);
        Categories categories8 = new Categories("Nested Class", Languages.CPLUS);
        insertCategory(categories8);
        Categories categories9 = new Categories("Enums", Languages.CPLUS);
        insertCategory(categories9);
        Categories categories10 = new Categories("Data Structure", Languages.CPLUS);
        insertCategory(categories10);
        Categories categories11 = new Categories("Standard Template Library (STL)", Languages.CPLUS);
        insertCategory(categories11);

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
        Categories categories6 = new Categories("Activity and Intents", Languages.ANDROID);
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
    }

    //Html
    private void html() {
        Categories categories1 = new Categories("Basics", Languages.HTML);
        insertCategory(categories1);
        Categories categories2 = new Categories("Tags", Languages.HTML);
        insertCategory(categories2);
        Categories categories3 = new Categories("List", Languages.HTML);
        insertCategory(categories3);
        Categories categories4 = new Categories("Layout", Languages.HTML);
        insertCategory(categories4);
        Categories categories5 = new Categories("Form", Languages.HTML);
        insertCategory(categories5);
        Categories categories6 = new Categories("Graphics", Languages.HTML);
        insertCategory(categories6);
        Categories categories7 = new Categories("Media", Languages.HTML);
        insertCategory(categories7);
        Categories categories8 = new Categories("API's", Languages.HTML);
        insertCategory(categories8);
    }

    //Php
    private void php() {
        Categories categories1 = new Categories("Basics", Languages.PHP);
        insertCategory(categories1);
        Categories categories2 = new Categories("Data types", Languages.PHP);
        insertCategory(categories2);
        Categories categories3 = new Categories("Keywords", Languages.PHP);
        insertCategory(categories3);
        Categories categories4 = new Categories("OOP", Languages.PHP);
        insertCategory(categories4);
        Categories categories5 = new Categories("Interfaces", Languages.PHP);
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

    public List<Question> getAllData() {
        List<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = Constants.COLUMN_CATEGORY + " = ?";
        String[] selectionArgs = {};


        Cursor c = db.query(Constants.TABLE_FIRST, Constants.ALL_COLUMNS, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                Question questions = new Question();
                questions.setQuestion(c.getString(c.getColumnIndex(Constants.COLUMNS_QUESTION)));
                questions.setOption1(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(Constants.COLUMNS_OPTION4)));
                questions.setAnswer(c.getInt(c.getColumnIndex(Constants.ANSWER)));
                questionsList.add(questions);
            } while (c.moveToNext());
        }
        c.close();
        return questionsList;
    }

    public List<Question> getAllData(String Category, int number, String Language) {
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
