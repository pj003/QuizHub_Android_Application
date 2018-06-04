package com.example.katykarthik.quizhubnew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Quiz extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment= null;
                //Toast.makeText(Quiz.this, "Error not cleared", Toast.LENGTH_SHORT).show();

                switch (item.getItemId())
                {
                    case R.id.action_class_quiz:
                        selectedFragment = ClassFragment.newInstance();
                        break;
                    case R.id.action_ranking_quiz:
                        selectedFragment = RankingFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout_quiz,selectedFragment);
                transaction.commit();
                return true;
            }
        });

        setDefaultFragment();
        //Toast.makeText(Quiz.this, "Error cleared", Toast.LENGTH_SHORT).show();

    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_quiz, CategoryFragment.newInstance());
        transaction.commit();
    }
}
