/*
tenthRoundValidation -> Sum of 1st two rounds of 10th frame
Validate -> sum of 1st 2 rounds of 9 frames in a loop
sum -> Gives sum of 9 frames
r1 -> Stores value of 1st round of 10th frame
r1_2 -> Stores sum of 1st 2 rounds of 10th frame
r1_2_3 -> Stores sum of 1st 3 rounds of 10th frame
r3 -> Stores the value of round 3 of 10th frame
r2_3 -> Stores sum of 2nd and 3rd round of 10th frame
ninthRound -> Stores value of 9th round of 9th frame
ninthRoundSpare -> Stores value of sum of 9th frame
totalSum -> Stores the score after validating 9th and 10th frame
score -> Stores Total score of the bowling game
*/
package com.utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingRounds {

    int round1[] = new int[15];
    int round2[] = new int[15];
    int round3[] = new int[15];
    int tenthRoundValidation=0, validate=0, sum=0, r1=0, r1_2=0, r1_2_3=0, ninthRound=0, totalSum=0, ninthRoundSpare=0, score=0, r3=0, r2_3=0 ;
    List<Integer> totalScore = new ArrayList<>(15); //To display individual Round score as a list
    Scanner scan = new Scanner(System.in);

    public void nineFrames(){

        //To get 9 frames input
        for (int i=1;i<10;i++){
            System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
            round1[i]=scan.nextInt();
            //to check for strike
            if(round1[i]==10){
                System.out.println("You Rolled a Strike!!!!!!!!");
            }
            else{
                System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
                round2[i]=scan.nextInt();
            }
            totalScore.add(round1[i]);
            totalScore.add(round2[i]);
        }
    }

    //Method to calculate score for first 9 frames
    public int nineFrameScore(){
        for (int i=1;i<10;i++){
            validate = round1[i]+round2[i];
            // Strike score calculation
            if (round1[i] == 10){
                //subsequent strike calculation
                if(round1[i+1]==10){
                    sum = sum + validate + round1[i + 1] + round1[i + 2];
                }
                else{
                    sum = sum + validate + round1[i + 1] + round2[i + 1];
                }
            }
            //Spare score calculation
            else if (validate == 10){
                sum = sum + validate + round1[i+1];
            }
            //Normal score calculation
            else if (validate<10){
                sum = sum + validate;
            }
            ninthRound = round1[9]; // To store the 9th round score if it's a strike.
            ninthRoundSpare = round1[9] + round2[9]; // To store 9th frame score if its a spare
        }
//        System.out.println("Sum is: "+sum); // Prints sum of 9 frames
        return sum;
    }

    // Method to fetch tenth frame input and score
    public void tenthFrame(){
        for (int i=10;i<11;i++){
            System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
            round1[i]=scan.nextInt();
            //To check if 1st round of 10th frame is a strike
            if (round1[i]==10){
                System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
                round2[i]=scan.nextInt();
                if (round2[i]==10){
                    System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
                    round3[i]=scan.nextInt();
                }
            }
            //To check if 1st round of 10th frame is neither strike nor spare
            else if (round1[i]<10){
                System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
                round2[i]=scan.nextInt();
            }
            tenthRoundValidation = round1[i] + round2[i]; //to check for spare
            //Spare calculation
            if (tenthRoundValidation == 10){
                System.out.println("Round: "+i+" - Roll the ball. Enter number 1 to 10: ");
                round3[i]=scan.nextInt();
            }
            totalScore.add(round1[i]);
            totalScore.add(round2[i]);
            totalScore.add(round3[i]);
            System.out.println("Your score is: "+totalScore);
        }
        // 10th Frame score calculation
        for (int i=10;i<11;i++){
            r1 = round1[i];
            r1_2 = round1[i]+round2[i];
            r1_2_3 = round1[i] + round2[i] + round3[i];
            r3 = round3[i];
            r2_3 = round2[i]+round3[i];
        }
    }
    // 9th Frame and 10th Frame validation
    public int nineTenFrameValidation(){
        //Strike of 9th Round calculation
        if (ninthRound == 10){
            totalSum = totalSum + r1_2;
            //consecutive strike calculation of 10th frame
            if (r1_2==20){
                totalSum = totalSum + ninthRound + r3;
            }
            // To check if 10th frame has strike or spare
            else if (r1 == 10 || r1_2 == 10){
                totalSum = totalSum + r3;
            }
        }
        // 9th round Spare calculation
        else if (ninthRoundSpare == 10){
            totalSum = totalSum + r1;
            //To check if 10th frame has strike or spare after 9th frame's spare
            if (r1 == 10 || r1_2 == 10){
                totalSum = totalSum + r2_3;
            }
        }
        //To check if 10th frame has strike or spare. If so sum of 10th Frame
        else if (r1 == 10 || r1_2 == 10)
        {
            totalSum = totalSum + r1_2_3;
        }
        // if 10th Frame is neither strike nor spare
        else if (ninthRoundSpare <10){
            totalSum = r1_2;
        }
        return totalSum;
    }
    // Method to calculate total score of bowling
    public int totalScore(){
        score = score + sum + totalSum;
        System.out.println("Your Total Score is: "+score);
        return score;
    }
}
