package com.example.android.geoquiz2019;

import java.io.Serializable;

public class Question implements Serializable {
    private int textResId;
    private boolean answerTrue;

    public Question(int textResId, boolean answerTrue) {
        this.textResId = textResId;
        this.answerTrue = answerTrue;
    }



    public int getTextResId() {
        return textResId;
    }

    //change here
}
