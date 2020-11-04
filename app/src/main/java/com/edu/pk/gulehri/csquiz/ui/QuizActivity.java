package com.edu.pk.gulehri.csquiz.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.edu.pk.gulehri.csquiz.Database.MyDbOpenHelper;
import com.edu.pk.gulehri.csquiz.R;
import com.edu.pk.gulehri.csquiz.adaptor.MyAdaptor;
import com.edu.pk.gulehri.csquiz.model.Question;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class QuizActivity extends AppCompatActivity {


    public static final String SHARED_PREFRENCE = "shared_Prefrence";
    public static final String SHARED_PREFRENCE_HIGH_SCORE = "shared_prefrence_high_score";

    //tag for debugging logcat
    private static final String TAG = "myTag";
    //For Storing question
    public static List<Question> questionList;
    public static Question currentQuestion;
    public static String category, language;
    private static long backPressedTime;
    //flag used here to check of back button is pressed and activity in the background
    private static boolean flag;
    public TextView textViewQuestionCount, textViewQuestion, textViewScore;
    //Handler object that will used to call intent
    Handler handler = new Handler();

    //Used for saving high score
    private int HighScore;

    //User interface
    private RadioGroup mRadioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button confirmButton;

    //Timer Variable
    private CircularView circularViewWithTimer;
    private int seconds = 15;

    //Helper Class Variable to get reference
    private MyDbOpenHelper helper;

    //Variables for counting questions
    private int questionCounter;
    private int questionTotal;
    private int questionsCounterState;
    //For Checking Answer
    private boolean answer;

    //For Saving Current color of view
    private ColorStateList buttonLabel;

    private int correctAnswer = 0, wrongAnswer = 0, mScore = 0;

    //Variable used in Dialog UI
    private Dialog myDialog;
    private Button mainMenu, playAgain, showAnswers;
    private TextView questionSize, correctQuestion, wrongQuestion, myScore, highScore, txtClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Here We take create object of our result dialog and sit it view when it called
        myDialog = new Dialog(QuizActivity.this, R.style.Theme_Dialog);
        myDialog.setContentView(R.layout.activity_result);

        //this method is used to take reference to all yhe view in QuizActivity
        setReferences();

        //helper object that help in creating Database
        helper = new MyDbOpenHelper(this);

        //getting the intent from adaptor
        Intent intent = getIntent();
        //Storing value of category name and passing it it getAllData method
        category = intent.getStringExtra(MyAdaptor.ITEM_POSITION);
        language = intent.getStringExtra(MyAdaptor.LANGUAGE);


        //Getting question of selected category and storing it list
        questionList = helper.getAllData(category, language);

        //This giver us the number of total question in the list
        questionTotal = questionList.size();

        //this is gives the default color of radio button which is black and store in ColorState Variable
        buttonLabel = rb1.getTextColors();

        //this method is gives Call here to give us next question and shows what option is selected
        startQuiz();

        Log.d(TAG, "onCreate: QuizActivity ");

    }

    //Here we take reference of all the views
    private void setReferences() {
        mRadioGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        confirmButton = findViewById(R.id.btn_confirm_next);
        textViewQuestion = findViewById(R.id.question);
        textViewQuestionCount = findViewById(R.id.textViewQuestionCount);
        textViewScore = findViewById(R.id.score);
        circularViewWithTimer = findViewById(R.id.circular_view_with_timer);

        mainMenu = myDialog.findViewById(R.id.mainmenu);
        playAgain = myDialog.findViewById(R.id.playagain);
        showAnswers = myDialog.findViewById(R.id.viewAnswer);

        questionSize = myDialog.findViewById(R.id.questionSize);
        correctQuestion = myDialog.findViewById(R.id.correctQuestion);
        wrongQuestion = myDialog.findViewById(R.id.wrongQuestion);
        myScore = myDialog.findViewById(R.id.myScore);
        highScore = myDialog.findViewById(R.id.highScore);
        txtClose = myDialog.findViewById(R.id.txtclose);

    }

    //This method gives us next question
    private void showNextQuestion() {

        seconds = 15;
        //this line make sure that all the radio button is unchecked when next question appears
        mRadioGroup.clearCheck();

        // setting the background of radio buttons
        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));

        //setting the text color inside radio button
        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);


        /*
         * This if condition make sure if number question that appear is less than the total
         * questions in the list if it return true then the next question get called */

        if (questionCounter < questionTotal) {
            currentQuestion = questionList.get(questionCounter);

            //setting the question in textView that is get from database through getQuestion()
            textViewQuestion.setText(currentQuestion.getQuestion());

            //setting up the Option in radioButtons
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());


            //increment the number of question that is shown
            questionCounter++;

            //setting the up textView that how many questions is appear out of total
            textViewQuestionCount.setText("" + questionCounter + "/" + questionTotal);

            //Here answer = false mean no answer is selected yet
            answer = false;

            //Here the text of button will be Confirm for verify the answer
            confirmButton.setText(R.string.changeToConfirm);

            //timer will start as soon the question appear
            setCountDownTimer();

            //start circular timer  to rotate
            circularViewWithTimer.startTimer();

            noOptionSelected();


        }
        /* If all the question appeared thn this else block will run
         * WHICH will disable the radio button and confirm button
         * And show the result dialog after 1 second*/
        else {

            //Disabling the radioButton And ConfirmButton
            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);
            rb4.setClickable(false);
            confirmButton.setClickable(false);

            //Handler will pop the dialog after 1 second
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //this show result dialog after quiz
                    setupDialogue();

                }
            }, 1000); //1000 milli seconds = 1 second
        }

    }

    //This method set Timer for question
    private void setCountDownTimer() {
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()

                        //for displaying text inside circleView Timer
                        .shouldDisplayText(true)

                        //Duration for one question
                        .setCounterInSeconds(seconds)

                        //for showing second/minutes unit down the timer
                        .shouldDisplayTimeUnit(false)

                        .setCircularViewCallback(new CircularViewCallback() {

                            /*This method called when time finish for one question and
                            show us the next question  */
                            @Override
                            public void onTimerFinish() {
                                if (!answer) {
                                    mScore = mScore - 3;
                                    wrongAnswer++;
                                    textViewScore.setText(String.valueOf(mScore));
                                    seconds = 15;
                                    showNextQuestion();
                                } else {
                                    showNextQuestion();
                                }
                            }

                            //This called when timer canceled either by pressing backButton or other reason
                            @Override
                            public void onTimerCancelled() {
                                //Stopping the timer
                                circularViewWithTimer.stopTimer();
                            }
                        });

        //Convert Dp in to pixel
        circularViewWithTimer.setOptions(builderWithTimer);
    }

    private void startQuiz() {
        questionTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button1:
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_option_selected));

                        rb1.setTextColor(Color.WHITE);
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);

                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        break;
                    case R.id.radio_button2:
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_option_selected));

                        rb2.setTextColor(Color.WHITE);
                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);

                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        break;
                    case R.id.radio_button3:
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_option_selected));

                        rb2.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.WHITE);
                        rb4.setTextColor(Color.BLACK);

                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        break;
                    case R.id.radio_button4:
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_option_selected));

                        rb2.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.WHITE);

                        break;

                }
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answer) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();

                    } else {
                        Toast.makeText(QuizActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });

    }

    private void checkAnswer() {

        //When answer is select the the variable value will change to true
        answer = true;

        //Timer will stop
        circularViewWithTimer.stopTimer();

        //it gives the id of selected radio button
        RadioButton rbSelected = mRadioGroup.findViewById(mRadioGroup.getCheckedRadioButtonId());

        //it gives the id of selected answer we add 1 to it cuz our answer start from 1 and at first it gives 0.
        int answerCompare = mRadioGroup.indexOfChild(rbSelected) + 1;

        //this method check if the selected answer is tru or not
        checkSolution(answerCompare, rbSelected);
    }

    private void checkSolution(int answerCompare, RadioButton rbSelected) {
        switch (currentQuestion.getAnswer()) {

            case 1:
                if (currentQuestion.getAnswer() == answerCompare) {
                    rb1.setBackground(ContextCompat.getDrawable(this, R.drawable.when_option_correct));
                    rb1.setTextColor(Color.WHITE);
                    correctAnswer++;
                    // textViewCorrect.setText("Correct: " + String.valueOf(correctAnswer));
                    mScore = mScore + 5;
                    textViewScore.setText(String.valueOf(mScore));
                } else {
                    changeToWrong(rbSelected);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNextQuestion();
                    }
                }, 100);
                break;

            case 2:
                if (currentQuestion.getAnswer() == answerCompare) {
                    rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.when_option_correct));
                    rb2.setTextColor(Color.WHITE);
                    correctAnswer++;
                    // textViewCorrect.setText("Correct: " + String.valueOf(correctAnswer));
                    mScore = mScore + 5;
                    textViewScore.setText(String.valueOf(mScore));
                } else {
                    changeToWrong(rbSelected);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNextQuestion();
                    }
                }, 100);
                break;

            case 3:
                if (currentQuestion.getAnswer() == answerCompare) {
                    rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.when_option_correct));
                    rb3.setTextColor(Color.WHITE);
                    correctAnswer++;
                    //textViewCorrect.setText("Correct: " + String.valueOf(correctAnswer));
                    mScore = mScore + 5;
                    textViewScore.setText(String.valueOf(mScore));
                } else {
                    changeToWrong(rbSelected);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNextQuestion();
                    }
                }, 100);
                break;

            case 4:
                if (currentQuestion.getAnswer() == answerCompare) {
                    rb4.setBackground(ContextCompat.getDrawable(this, R.drawable.when_option_correct));
                    rb4.setTextColor(Color.WHITE);
                    correctAnswer++;

                    mScore = mScore + 5;
                    textViewScore.setText(String.valueOf(mScore));
                } else {
                    changeToWrong(rbSelected);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNextQuestion();
                    }
                }, 100);
                break;
        }

        if (questionCounter < questionTotal) {
            confirmButton.setText(R.string.changeToNext);
        } else {
            confirmButton.setText(R.string.changeToFinish);
        }
    }

    private void changeToWrong(RadioButton rbSelected) {
        rbSelected.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_option_wrong));
        rbSelected.setTextColor(Color.WHITE);
        wrongAnswer++;
        mScore = mScore - 3;
        textViewScore.setText(String.valueOf(mScore));

    }

    @Override
    protected void onPause() {
        myDialog.dismiss();
        super.onPause();
        Log.d(TAG, "onPause: QuizActivity ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        circularViewWithTimer.resumeTimer();
        Log.d(TAG, "onResume: QuizActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: QuizActivity");
        circularViewWithTimer.resumeTimer();
        if (flag) {
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: QuizActivity");
    }

    private void noOptionSelected() {
        if (!rb1.isChecked() || !rb2.isChecked() || !rb3.isChecked() || !rb4.isChecked()) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setCountDownTimer();
                    //start circular view to rotate
                    circularViewWithTimer.startTimer();

                }
            }, 0);
        }
    }

    public void setupDialogue() {
        myDialog.setCancelable(false);
        myDialog.setCanceledOnTouchOutside(false);

        Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = myDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        questionSize.setText(String.valueOf(questionTotal));
        myScore.setText((String.valueOf(mScore)));
        correctQuestion.setText((String.valueOf(correctAnswer)));
        wrongQuestion.setText(String.valueOf(wrongAnswer));

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Intent myIntent = new Intent(QuizActivity.this, StartQuizActivity.class);
                startActivity(myIntent);
                finish();

            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(QuizActivity.this, StartQuizActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(QuizActivity.this, Category.class);
                startActivity(myIntent);
                finish();
            }
        });

        showAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, ShowAnswer.class);
                startActivity(intent);
                finish();
            }
        });


        myDialog.show();
        loadHighScore();

        if (mScore > HighScore) {
            updateHighScore(mScore);
        }
    }

    private void updateHighScore(int newHighScore) {
        HighScore = newHighScore;
        highScore.setText(String.valueOf(HighScore));

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFRENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFRENCE_HIGH_SCORE, HighScore);
        editor.apply();
    }

    private void loadHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFRENCE, MODE_PRIVATE);
        HighScore = sharedPreferences.getInt(SHARED_PREFRENCE_HIGH_SCORE, 0);
        highScore.setText(String.valueOf(HighScore));
    }

    @Override
    public void onBackPressed() {

        //The Condition says when back button is pressed twice with in 2 seconds only thn it will send intent StartQuizActivity
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            /*When Back Button is pressed flag value become true*/
            flag = true;
            Intent intent = new Intent(this, Category.class);
            intent.putExtra("LANG_NAME", language);
            startActivity(intent);
            //When intent is send the object of current Activity will destroy
            finish();

        }
        /*if back button is not pressed twice with in the 2 second the toast will appear*/
        else {
            Toast.makeText(this, "One more tap to exit", Toast.LENGTH_SHORT).show();
        }
        //this gives the current time in milliseconds.
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //Saving seconds before activity destroyed
        seconds = Integer.parseInt(circularViewWithTimer.getText().toString());
        outState.putInt("myKey", seconds);
        outState.putInt("myKeySecond", questionCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Getting seconds after activity is created
        seconds = savedInstanceState.getInt("myKey");
        questionCounter = savedInstanceState.getInt("myKeySecond");

    }

}



