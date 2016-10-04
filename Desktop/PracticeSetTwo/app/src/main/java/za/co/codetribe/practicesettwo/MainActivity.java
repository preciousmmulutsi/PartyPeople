package za.co.codetribe.practicesettwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int teamAScore = 0;
    private int teamBScore = 0;
    private TextView teamA;
    private TextView teamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = (TextView)findViewById(R.id.team_a_score);
        teamB = (TextView)findViewById(R.id.team_b_score);
    }

    /*Team A*/
    public void addThreeForTeamA(View view)
    {
        teamAScore = teamAScore + 3;
        displayTeamA(teamAScore);
    }
    public void addTwoForTeamA(View view)
    {
        teamAScore = teamAScore + 2;
        displayTeamA(teamAScore);
    }
    public void addOneForTeamA(View view)
    {
        teamAScore = teamAScore + 1;
        displayTeamA(teamAScore);
    }

    public void displayTeamA(int score)
    {

        teamA.setText(" " + score);
    }

    /*Team B*/
    public void addThreeForTeamB(View view)
    {
        teamBScore = teamBScore + 3;
        displayTeamB(teamBScore);
    }
    public void addTwoForTeamB(View view)
    {
        teamBScore = teamBScore + 2;
        displayTeamB(teamBScore);
    }
    public void addOneForTeamB(View view)
    {
        teamBScore = teamBScore + 1;
        displayTeamB(teamBScore);
    }

    public void displayTeamB(int score)
    {

        teamB.setText(" " + score);
    }


    //Button reset

    public void resetScores(View view)
    {
        teamAScore = 0;
        teamBScore = 0;
        teamA.setText(String.valueOf(teamAScore));
        teamB.setText(String.valueOf(teamBScore));
    }

}
