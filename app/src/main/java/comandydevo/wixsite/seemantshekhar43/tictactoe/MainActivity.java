package comandydevo.wixsite.seemantshekhar43.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int myActivePlayer = 0;
    //  0 is for cross
    int[]myGameState ={2,2,2,2,2,2,2,2,2,};
    public void imageTapped(View view){
        ImageView myTapped = (ImageView) view;
        int myTappedTag = Integer.parseInt(myTapped.getTag().toString());
        if (myGameState[myTappedTag]==2){
            myGameState[myTappedTag] = myActivePlayer;
            if (myActivePlayer==0){
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer =1;
            }else {
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer =0;
            }
        }
        else {
            Toast.makeText(this, "This place is filled already!", Toast.LENGTH_SHORT).show();
        }

    }
    public void playAgainTapped(View view){
        myActivePlayer = 0;

        for (int i = 0; i<myGameState.length; i++){
            myGameState[i] = 2;
        }

        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.linearLayoutOne);
        for (int i = 0; i<linearLayoutOne.getChildCount();i++){
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutTwo = (LinearLayout) findViewById(R.id.linearLayoutTwo);
        for (int i = 0; i<linearLayoutTwo.getChildCount();i++){
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutThree = (LinearLayout) findViewById(R.id.linearLayoutThree);
        for (int i = 0; i<linearLayoutThree.getChildCount();i++){
            ((ImageView) linearLayoutThree.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
