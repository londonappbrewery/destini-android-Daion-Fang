package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;

    private String mStoryState = "T1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        Log.d("*****R.id.buttonBottom=", String.valueOf(R.id.buttonBottom));



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("*****", "Top button.");

                switch (mStoryState) {
                    case "T1":

                        SetUpStateT3();

                        break;
                    case "T3":

                        mStoryTextView.setText(R.string.T6_End);
                        mTopButton.setVisibility(View.GONE);
                        mBottomButton.setVisibility(View.GONE);

                        break;
                    case "T2":

                        SetUpStateT3();
                        break;
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("*****", "Bottom button.");

                if (mStoryState.equals("T1")) {

                    mStoryState = "T2";
                    mStoryTextView.setText(R.string.T2_Story);
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);

                } else if (mStoryState.equals("T3")) {

                    mStoryTextView.setText(R.string.T5_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);

                } else if (mStoryState.equals("T2")) {

                    mStoryState = "T4";
                    mStoryTextView.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                }
            }
        });

    }

    private void SetUpStateT3() {

        mStoryState = "T3";
        mStoryTextView.setText(R.string.T3_Story);
        mTopButton.setText(R.string.T3_Ans1);
        mBottomButton.setText(R.string.T3_Ans2);
    }

}
