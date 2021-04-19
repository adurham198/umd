package com.example.umd;

import android.os.Bundle;
import android.widget.TextView;

import com.example.umd.objects.Player;
import com.example.umd.objects.Uname;

import java.util.List;

public class DietAdviceScreen extends MainActivity{
    TextView DietAdviceText;
    Uname sharedData = Uname.getInstance();
    List<Player> players;
    SQLiteDatabaseHandler dbhelper;
    Player thisPlayer;
    String highlyActiveAdvice = "Given that you are very active (6-7 active days per week), your calorie recommendations may not be super accurate. " +
            "The reason for this is that there is a greater possibility that your weekly calories are off based on your perceived" +
            " workout frequency. This being said, it is important that you keep a closer eye on your daily calories and adjust accordingly" +
            " based on your activity levels for that day.";
    String moderateActivity = "It looks as though you are fairly active by working out 3-5 days per week. Your calorie predictions might be" +
            " slightly low depending on if you are able to get to the gym 5 times in any given week or only 3 days. This being said, " +
            "it is important for you to make sure that you are adjusting your calories accordingly depending on if you are on the higher " +
            "or lower end of activity for any given week.";
    String lowActivity = "Since you plan to typically workout anywhere between 0-2 days per week, it is very important that you do not " +
            "veer too far away from your recommended caloric intake since your activity is so low. This is because your intake recommendation " +
            "was calculated using the lowest multiplier and there is not much leeway in your caloric recommendations.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_advice_screen);
        DietAdviceText = findViewById(R.id.recommendationText);

        dbhelper = new SQLiteDatabaseHandler(this);
        dbhelper.initializedb();


        players = dbhelper.allPlayers();
        String thisPlayerName = sharedData.getValue();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getName().equals(thisPlayerName)) {
                thisPlayer = players.get(i);
            }
        }

        if(thisPlayer.getFreq().equals("7") || thisPlayer.getFreq().equals("6")){
            DietAdviceText.setText(highlyActiveAdvice);
        }
        else if(thisPlayer.getFreq().equals("5")|| thisPlayer.getFreq().equals("4") || thisPlayer.getFreq().equals("3")){
            DietAdviceText.setText(moderateActivity);
        }
        else if(thisPlayer.getFreq().equals("2")|| thisPlayer.getFreq().equals("1") || thisPlayer.getFreq().equals("0")){
            DietAdviceText.setText(lowActivity);
        }

    }
}
