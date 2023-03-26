package com.example.virtualfisheryinspector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class FRecognition extends AppCompatActivity {

    TextView mainlinkTextView;
    TextView linkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frecognition);

        mainlinkTextView=findViewById(R.id.main_link);
        mainlinkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        linkTextView=findViewById(R.id.main_hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}