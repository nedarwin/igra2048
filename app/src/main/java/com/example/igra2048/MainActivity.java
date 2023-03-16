package com.example.igra2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public Game game;
    public SharedPreferences prefs;
    public int koli=3;
    public ImageView random ;
    public TextView rnd1;
    public int[] buttons = new int[] {R.id.b1, R.id.b2, R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.b10,R.id.b11,R.id.b12,R.id.b13,R.id.b14,R.id.b15,R.id.b16 };
    public int[] tv = new int[] {R.id.tv1, R.id.tv2, R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,R.id.tv10,R.id.tv11,R.id.tv12,R.id.tv13,R.id.tv14,R.id.tv15,R.id.tv16 };
    public void onClick(View v) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(v.getId()==buttons[i*4+j]) {
                    game.evol(i, j);
                    newob();
                    down();
                    check();
                }

                }

        }
    }
    public void rnd(View v) throws InterruptedException {
        koli-=1;
        if(koli>=0) {
            rnd1.setText(Integer.toString(koli));


            game.random();
            check();
            wheel.setAlpha(1.0f);
            wheel.startAnimation(animRotate);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    wheel.setAlpha(0f);
                }
            }, 380); //specify the number of milliseconds
        }
        else{
            random.setOnClickListener(this::onNot);
        }
    }
    public void down(){
        for(int i=0;i<game.dowm.size();i++){
            ImageButton btn=(ImageButton) findViewById(buttons[game.dowm.get(i)]);
            btn.startAnimation(animDown);
        }
    }
    public void newob(){

        for(int i=0;i< game.foran.size();i+=2){
            ImageButton btn=(ImageButton) findViewById(buttons[game.foran.get(i)*4+game.foran.get(i+1)]);
            btn.startAnimation(animation);
        }
    }
    public void check() {


        for(int i = 0; i<4; i++){
            for(int j=0;j<4;j++){
                ImageButton btn=(ImageButton) findViewById(buttons[i*4+j]);
                TextView tve=findViewById(tv[i*4+j]);
                int x=1;
                if(game.sells[i][j]<243) {
                    x=4;
                    if (game.sells[i][j] < 81) {
                        x = 3;
                        if (game.sells[i][j] <27) {
                            x = 2;
                            if (game.sells[i][j] < 9) {
                                x=1;
                                if (game.sells[i][j] < 3) {
                                    x=0;
                                }
                            }
                        }
                    }
                }
                int y= (int) Math.pow(3,x);
                tve.setText(Integer.toString((game.sells[i][j])/y));
                if((game.sells[i][j])/y==0){
                    tve.setText("1");
                }
                switch(game.theField[i][j]){
                    case 0:

                        btn.setImageResource(R.drawable.tree);
                        break;
                    case 1:

                        btn.setImageResource(R.drawable.stone);
                        break;
                    case 2:

                        btn.setImageResource(R.drawable.mountain);
                        break;
                    case 3:

                        btn.setImageResource(R.drawable.mamonth);
                        break;
                    case 4:

                        btn.setImageResource(R.drawable.fhuman);
                        break;
                    case 5:

                        if (game.x==0){btn.setImageResource(R.drawable.mymy);}
                        if (game.x==1){btn.setImageResource(R.drawable.cat);}

                        break;
                    default:

                        btn.setImageResource(R.drawable.king2);
                        break;


            }
            }
        }
    }
    public void onNot(View v){

    }
    public Animation animation,animDown,animRotate;
    public ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    public ImageView wheel;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = findViewById(R.id.random);
        game= new Game();
        prefs = this.getSharedPreferences(
                "com.example.igra2048", Context.MODE_PRIVATE);
        animation= AnimationUtils.loadAnimation(this, R.anim.newob);
        animDown= AnimationUtils.loadAnimation(this, R.anim.down);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        check();
        rnd1=findViewById(R.id.textView);
        rnd1.setText(Integer.toString(koli));
        b1=findViewById(R.id.b1);
        wheel=findViewById(R.id.wheel);
        b1.setOnClickListener(this::onClick);
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(this::onClick);
        b3=findViewById(R.id.b3);
        b3.setOnClickListener(this::onClick);
        b4=findViewById(R.id.b4);
        b4.setOnClickListener(this::onClick);
        b5=findViewById(R.id.b5);
        b5.setOnClickListener(this::onClick);
        b6=findViewById(R.id.b6);
        b6.setOnClickListener(this::onClick);
        b7=findViewById(R.id.b7);
        b7.setOnClickListener(this::onClick);
        b8=findViewById(R.id.b8);
        b8.setOnClickListener(this::onClick);
        b9=findViewById(R.id.b9);
        b9.setOnClickListener(this::onClick);
        b10=findViewById(R.id.b10);
        b10.setOnClickListener(this::onClick);
        b11=findViewById(R.id.b11);
        b11.setOnClickListener(this::onClick);
        b12=findViewById(R.id.b12);
        b12.setOnClickListener(this::onClick);
        b13=findViewById(R.id.b13);
        b13.setOnClickListener(this::onClick);
        b14=findViewById(R.id.b14);
        b14.setOnClickListener(this::onClick);
        b15=findViewById(R.id.b15);
        b15.setOnClickListener(this::onClick);
        b16=findViewById(R.id.b16);
        b16.setOnClickListener(this::onClick);

        }

    }
