package com.company;
import com.utility.BowlingRounds;

public class Main {

    public static void main(String[] args) {
        BowlingRounds BR = new BowlingRounds();
        BR.nineFrames();
        BR.tenthFrame();
        BR.nineFrameScore();
        BR.nineTenFrameValidation();
        BR.totalScore();
    }
}
