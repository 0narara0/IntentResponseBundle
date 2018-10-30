package com.cmy.www.intentresponsebundle;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity  {
    TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        textViewName = (TextView)findViewById(R.id.textViewName);
        TextView textViewAge = (TextView)findViewById(R.id.textViewAge);

        textViewName.setText("이름:  " + bundle.getString("Name","No Data"));
        textViewAge.setText("나이:  "+bundle.getString("Age","No Data"));

    }

    @Override
    public void finish(){

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultValue",((TextView)textViewName).getText().toString());
        intent.putExtras(bundle);
        setResult(100, intent);
        super.finish();
    }

}
