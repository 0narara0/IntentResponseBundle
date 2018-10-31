package com.cmy.www.intentresponsebundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity  {
    TextView textViewName;
    TextView textViewAge;
    TextView textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewAge = (TextView)findViewById(R.id.textViewAge);
        textViewGender =(TextView)findViewById(R.id.textViewGender);


        textViewName.setText("이름:  " + bundle.getString("Name","No Data"));
        textViewAge.setText("나이:  "+bundle.getString("Age","No Data"));
        textViewGender.setText("성별:  "+bundle.getString("Gender","No Data"));

    }

    @Override
    public void finish(){

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultName",((TextView)textViewName).getText().toString());
        bundle.putString("resultAge",((TextView)textViewAge).getText().toString());
        bundle.putString("resultGender",((TextView)textViewGender).getText().toString());
        intent.putExtras(bundle);
        setResult(100, intent);
        super.finish();
    }

}
