package com.oritmalki.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    static final String SCORE_A_KEY = "PLAYER_A_SCORE";
    static final String SCORE_B_KEY = "PLAYER_B_SCORE";

    TextView scoreViewA;
    TextView scoreViewB;
    TextView winA;
    TextView winB;
    LinearLayout teamA;
    LinearLayout teamB;
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

                scoreA = Integer.parseInt(scoreView.getText().toString()) + points;
                displayForTeam(scoreView, scoreA);
                break;

            case "scoreB":
                scoreB = Integer.parseInt(scoreView.getText().toString()) + points;
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
        winA.setVisibility(View.INVISIBLE);
        winB.setVisibility(View.INVISIBLE);
        for (int i=0; i<teamA.getChildCount();i++) {
            teamA.getChildAt(i).setEnabled(true);
        }
        for (int i=0; i<teamB.getChildCount();i++) {
            teamB.getChildAt(i).setEnabled(true);
        }

    }

    public void initialViews() {

        teamA = findViewById(R.id.team_a);
        teamB = findViewById(R.id.team_b);
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);
        winA = findViewById(R.id.win_a);
        winB = findViewById(R.id.win_b);
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

        scoreViewA.addTextChangedListener(this);
        scoreViewB.addTextChangedListener(this);

        displayForTeam(scoreViewA, scoreA);
        displayForTeam(scoreViewB, scoreB);

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (Integer.parseInt(s.toString()) >= 30) {

            if (Integer.parseInt(scoreViewA.getText().toString()) >=30) {
                winA.setVisibility(View.VISIBLE);
                Toast.makeText(this, "We got a Winner!",Toast.LENGTH_LONG).show();

            }
            else if (Integer.parseInt(scoreViewB.getText().toString()) >=30) {
                winB.setVisibility(View.VISIBLE);
                Toast.makeText(this, "We got a Winner!",Toast.LENGTH_LONG).show();

            }
            for (int i=0; i<teamA.getChildCount();i++) {
                teamA.getChildAt(i).setEnabled(false);
            }
            for (int i=0; i<teamB.getChildCount();i++) {
                teamB.getChildAt(i).setEnabled(false);
            }

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SCORE_A_KEY, scoreViewA.getText().toString());
        outState.putString(SCORE_B_KEY, scoreViewB.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreViewA.setText(savedInstanceState.get(SCORE_A_KEY).toString());
        scoreViewB.setText(savedInstanceState.get(SCORE_B_KEY).toString());
    }
}
