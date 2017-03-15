package com.example.suraz.rtictactoe;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b[] = new Button[16];
    int turn;
    int i;
    int disable1, disable2;
    ArrayList<Integer> pressed=new ArrayList<Integer>(15);


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b[0] = (Button) findViewById(R.id.b0);
        b[0].setOnClickListener(this);

        b[1] = (Button) findViewById(R.id.b1);
        b[1].setOnClickListener(this);

        b[2] = (Button) findViewById(R.id.b2);
        b[2].setOnClickListener(this);

        b[3] = (Button) findViewById(R.id.b3);
        b[3].setOnClickListener(this);

        b[4] = (Button) findViewById(R.id.b4);
        b[4].setOnClickListener(this);

        b[5] = (Button) findViewById(R.id.b5);
        b[5].setOnClickListener(this);

        b[6] = (Button) findViewById(R.id.b6);
        b[6].setOnClickListener(this);

        b[7] = (Button) findViewById(R.id.b7);
        b[7].setOnClickListener(this);

        b[8] = (Button) findViewById(R.id.b8);
        b[8].setOnClickListener(this);

        b[9] = (Button) findViewById(R.id.b9);
        b[9].setOnClickListener(this);

        b[10] = (Button) findViewById(R.id.b10);
        b[10].setOnClickListener(this);

        b[11] = (Button) findViewById(R.id.b11);
        b[11].setOnClickListener(this);

        b[12] = (Button) findViewById(R.id.b12);
        b[12].setOnClickListener(this);

        b[13] = (Button) findViewById(R.id.b13);
        b[13].setOnClickListener(this);

        b[14] = (Button) findViewById(R.id.b14);
        b[14].setOnClickListener(this);

        b[15] = (Button) findViewById(R.id.b15);
        b[15].setOnClickListener(this);


        turn = 1;
        disable1 = -1;
        disable2 = -1;


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b0:
                action(0);
                break;
            case R.id.b1:
                action(1);
                break;
            case R.id.b2:
                action(2);
                break;
            case R.id.b3:
                action(3);
                break;
            case R.id.b4:
                action(4);
                break;
            case R.id.b5:
                action(5);
                break;
            case R.id.b6:
                action(6);
                break;
            case R.id.b7:
                action(7);
                break;
            case R.id.b8:
                action(8);
                break;
            case R.id.b9:
                action(9);
                break;
            case R.id.b10:
                action(10);
                break;
            case R.id.b11:
                action(11);
                break;
            case R.id.b12:
                action(12);
                break;
            case R.id.b13:
                action(13);
                break;
            case R.id.b14:
                action(14);
                break;
            case R.id.b15:
                action(15);
                break;

        }

    }

    public void action(int i) {
        if (b[i].getText().toString().equals("")) {
            if (turn == 1) {
                b[i].setText("X");
                b[i].setTextColor(Color.rgb(102, 224, 255));
                b[i].setBackgroundResource(R.drawable.button_style);
                pressed.add(i);
                turn = 2;
                if(disable1>=0) b[disable1].setBackgroundResource(R.drawable.button_custom);
                disable(disable2);
                disable1=i;
                endGame(i,"X");


            } else {
                b[i].setText("O");
                b[i].setTextColor(Color.rgb(102, 255, 194));
                b[i].setBackgroundResource(R.drawable.button_style);
                pressed.add(i);
                turn = 1;
                if(disable2>=0) b[disable2].setBackgroundResource(R.drawable.button_custom);
                disable(disable1);
                disable2=i;
                endGame(i,"O");
            }


        }

    }
    public void disable(int button) {
        int k;
        ArrayList<Integer> srnd = new ArrayList<Integer>(8);
        for (k=0;k<=15;k++)
        {
            b[k].setEnabled(true);
        }
        if (button == 0) {

            srnd.add(1);
            srnd.add(4);
            srnd.add(5);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);

            srnd.clear();

        }
        if (button == 1) {

            srnd.add(0);
            srnd.add(2);
            srnd.add(4);
            srnd.add(5);
            srnd.add(6);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);

            srnd.clear();
        }
        if (button == 2) {

            srnd.add(1);
            srnd.add(3);
            srnd.add(5);
            srnd.add(6);
            srnd.add(7);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 3) {

            srnd.add(2);
            srnd.add(6);
            srnd.add(7);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
        if (button == 4) {
            srnd.add(0);
            srnd.add(1);
            srnd.add(5);
            srnd.add(8);
            srnd.add(9);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
        if (button == 5) {
            srnd.add(0);
            srnd.add(1);
            srnd.add(2);
            srnd.add(4);
            srnd.add(6);
            srnd.add(8);
            srnd.add(9);
            srnd.add(10);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 6) {
            srnd.add(1);
            srnd.add(2);
            srnd.add(3);
            srnd.add(5);
            srnd.add(7);
            srnd.add(9);
            srnd.add(10);
            srnd.add(11);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 7) {
            srnd.add(2);
            srnd.add(3);
            srnd.add(6);
            srnd.add(10);
            srnd.add(11);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
        if (button == 8) {
            srnd.add(4);
            srnd.add(5);
            srnd.add(9);
            srnd.add(12);
            srnd.add(13);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
        if (button == 9) {
            srnd.add(4);
            srnd.add(5);
            srnd.add(6);
            srnd.add(8);
            srnd.add(10);
            srnd.add(12);
            srnd.add(13);
            srnd.add(14);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 10) {
            srnd.add(5);
            srnd.add(6);
            srnd.add(7);
            srnd.add(9);
            srnd.add(11);
            srnd.add(13);
            srnd.add(14);
            srnd.add(15);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 11) {
            srnd.add(6);
            srnd.add(7);
            srnd.add(10);
            srnd.add(14);
            srnd.add(15);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
        if (button == 12) {
            srnd.add(8);
            srnd.add(9);
            srnd.add(13);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 13) {
            srnd.add(8);
            srnd.add(9);
            srnd.add(10);
            srnd.add(12);
            srnd.add(14);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }
        if (button == 14) {
            srnd.add(9);
            srnd.add(10);
            srnd.add(11);
            srnd.add(13);
            srnd.add(15);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();
        }

        if (button == 15) {
            srnd.add(10);
            srnd.add(11);
            srnd.add(14);
            srnd.removeAll(pressed);
            for (k = 0; k < srnd.size(); k++)
                b[srnd.get(k)].setEnabled(false);
            srnd.clear();

        }
    }

    public void endGame(int button,String symbol) {
        String s[] = new String[15];
        boolean end = false;
        for (int j = 0; j < 15; j++) {
            s[j] = b[j].getText().toString();
        }
        switch (button) {
            case 0:
                if (s[0].equals(symbol) && s[1].equals(symbol) && s[2].equals(symbol) && s[3].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[4].equals(symbol) && s[8].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[5].equals(symbol) && s[10].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }

            case 1:
                if (s[0].equals(symbol) && s[1].equals(symbol) && s[2].equals(symbol) && s[3].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[1].equals(symbol) && s[5].equals(symbol) && s[9].equals(symbol) && s[13].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }

            case 2:
                if (s[0].equals(symbol) && s[1].equals(symbol) && s[2].equals(symbol) && s[3].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[2].equals(symbol) && s[6].equals(symbol) && s[10].equals(symbol) && s[14].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 3:
                if (s[0].equals(symbol) && s[1].equals(symbol) && s[2].equals(symbol) && s[3].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[7].equals(symbol) && s[11].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[6].equals(symbol) && s[9].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 4:
                if (s[4].equals(symbol) && s[5].equals(symbol) && s[6].equals(symbol) && s[7].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[4].equals(symbol) && s[8].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 5:
                if (s[4].equals(symbol) && s[5].equals(symbol) && s[6].equals(symbol) && s[7].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[1].equals(symbol) && s[5].equals(symbol) && s[9].equals(symbol) && s[13].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[5].equals(symbol) && s[10].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 6:
                if (s[4].equals(symbol) && s[5].equals(symbol) && s[6].equals(symbol) && s[7].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[2].equals(symbol) && s[6].equals(symbol) && s[10].equals(symbol) && s[14].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[6].equals(symbol) && s[9].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 7:
                if (s[4].equals(symbol) && s[5].equals(symbol) && s[6].equals(symbol) && s[7].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[7].equals(symbol) && s[11].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 8:
                if (s[8].equals(symbol) && s[9].equals(symbol) && s[10].equals(symbol) && s[11].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[4].equals(symbol) && s[8].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 9:
                if (s[8].equals(symbol) && s[9].equals(symbol) && s[10].equals(symbol) && s[11].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[1].equals(symbol) && s[5].equals(symbol) && s[9].equals(symbol) && s[13].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[6].equals(symbol) && s[9].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 10:
                if (s[8].equals(symbol) && s[9].equals(symbol) && s[10].equals(symbol) && s[11].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[2].equals(symbol) && s[6].equals(symbol) && s[10].equals(symbol) && s[14].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[5].equals(symbol) && s[10].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 11:
                if (s[8].equals(symbol) && s[9].equals(symbol) && s[10].equals(symbol) && s[11].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[7].equals(symbol) && s[11].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 12:
                if (s[12].equals(symbol) && s[13].equals(symbol) && s[14].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[4].equals(symbol) && s[8].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[6].equals(symbol) && s[9].equals(symbol) && s[12].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 13:
                if (s[12].equals(symbol) && s[13].equals(symbol) && s[14].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[1].equals(symbol) && s[5].equals(symbol) && s[9].equals(symbol) && s[13].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 14:
                if (s[12].equals(symbol) && s[13].equals(symbol) && s[14].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[2].equals(symbol) && s[6].equals(symbol) && s[10].equals(symbol) && s[14].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


            case 15:
                if (s[12].equals(symbol) && s[13].equals(symbol) && s[14].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[3].equals(symbol) && s[7].equals(symbol) && s[11].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }
                if (s[0].equals(symbol) && s[5].equals(symbol) && s[10].equals(symbol) && s[15].equals(symbol)) {
                    Toast.makeText(MainActivity.this, "Winner Player "+symbol, Toast.LENGTH_SHORT).show();
                    end = true;
                    break;
                }


        }

        if (end) {
            Intent m = new Intent(this,MainActivity.class);
            m.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(m);
        }

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.suraz.rtictactoe/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.suraz.rtictactoe/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}



