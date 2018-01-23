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

        initialViews();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.threePoints_A:
                addPointsTeamA(scoreViewA, 3, "scoreA");
                break;
            case R.id.threePoints_B:
                addPointsTeamA(scoreViewB, 3, "scoreB");
                break;
            case R.id.twoPoints_A:
                addPointsTeamA(scoreViewA, 2, "scoreA");
                break;
            case R.id.twoPoints_B:
                addPointsTeamA(scoreViewB, 2, "scoreB");
                break;
            case R.id.freeThrow_A:
                addPointsTeamA(scoreViewA, 1, "scoreA");
                break;
            case R.id.freeThrow_B:
                addPointsTeamA(scoreViewB, 1, "scoreB");
                break;
            case R.id.reset_button:
                reset();
                displayForTeam(scoreViewA, scoreA);
                displayForTeam(scoreViewB, scoreB);
                break;

        }
    }


    public void addPointsTeamA(TextView scoreView, int points, String teamScore) {

        switch (teamScore) {
            case "scoreA":

                scoreA = Integer.parseInt((String) scoreView.getText()) + points;
                displayForTeam(scoreView, scoreA);
                break;

            case "scoreB":
                scoreB = Integer.parseInt((String) scoreView.getText()) + points;
                displayForTeam(scoreView, scoreB);
                break;

        }

    }

    public void displayForTeam(TextView scoreView, int score) {
        scoreView.setText(String.valueOf(score));
    }



    public void reset() {
        scoreA = 0;
        scoreB = 0;
    }

    public void initialViews() {

        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);
        threePointsA = findViewById(R.id.threePoints_A);
        threePointsA.setOnClickListener(this);
        threePointsB = findViewById(R.id.threePoints_B);
        threePointsB.setOnClickListener(this);
        twoPointsA = findViewById(R.id.twoPoints_A);
        twoPointsA.setOnClickListener(this);
        twoPointsB = findViewById(R.id.twoPoints_B);
        twoPointsB.setOnClickListener(this);
        freeThrowA = findViewById(R.id.freeThrow_A);
        freeThrowA.setOnClickListener(this);
        freeThrowB = findViewById(R.id.freeThrow_B);
        freeThrowB.setOnClickListener(this);
        reset = findViewById(R.id.reset_button);
        reset.setOnClickListener(this);

        displayForTeam(scoreViewA, scoreA);
        displayForTeam(scoreViewB, scoreB);

    }


}
