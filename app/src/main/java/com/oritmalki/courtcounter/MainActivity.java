package com.oritmalki.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView scoreViewA;
    TextView scoreViewB;
    Button threePointsA;
    Button threePointsB;
    Button twoPointsA;
    Button twoPointsB;
    Button freeThrowA;
    Button freeThrowB;
    Button reset;
    int scoreA;
    int scoreB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        threePointsA = (Button) findViewById(R.id.threePoints_A);
//        threePointsA.setOnClickListener(this);
//        threePointsB = (Button) findViewById(R.id.threePoints_B);
//        threePointsB.setOnClickListener(this);
//        twoPointsA = (Button) findViewById(R.id.twoPoints_A);
//        twoPointsA.setOnClickListener(this);
//        twoPointsB = (Button) findViewById(R.id.twoPoints_B);
//        twoPointsB.setOnClickListener(this);
//        freeThrowA = (Button) findViewById(R.id.freeThrow_A);
//        freeThrowA.setOnClickListener(this);
//        freeThrowB = (Button) findViewById(R.id.freeThrow_B);
//        freeThrowB.setOnClickListener(this);
//        reset = (Button) findViewById(R.id.reset_button);
//        reset.setOnClickListener(this);

        scoreA = 0;
        scoreB = 2;
        displayForTeam(scoreViewA, scoreA);
        displayForTeam(scoreViewB, scoreB);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.threePoints_A:
                addThreePoints(scoreA);
                displayForTeam(scoreViewA, scoreA);
                break;
            case R.id.threePoints_B:
                addThreePoints(scoreB);
                displayForTeam(scoreViewB, scoreB);
                break;
            case R.id.twoPoints_A:
                addTwoPoints(scoreA);
                displayForTeam(scoreViewA, scoreA);
                break;
            case R.id.twoPoints_B:
                addTwoPoints(scoreB);
                displayForTeam(scoreViewB, scoreB);
            case R.id.freeThrow_A:
                addOnePoint(scoreA);
                displayForTeam(scoreViewA, scoreA);
                break;
            case R.id.freeThrow_B:
                addOnePoint(scoreB);
                displayForTeam(scoreViewB, scoreB);
                break;
            case R.id.reset_button:
                reset();
                displayForTeam(scoreViewA, scoreA);
                displayForTeam(scoreViewB, scoreB);

        }
    }



    public void displayForTeam(TextView scoreView, int score) {

        scoreView.setText(String.valueOf(score));
    }

    public void addThreePoints(int score) {
        score += 3;
    }

    public void addTwoPoints(int score) {
        score += 2;
    }

    public void addOnePoint(int score) {
        score++;
    }

    public void reset() {
        scoreA = 0;
        scoreB =0;
    }

}
