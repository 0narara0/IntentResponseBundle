package com.cmy.www.intentresponsebundle;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewResult1, textViewResult2, textViewResult3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonResult1);
        button.setOnClickListener(this);
        textViewResult1 = findViewById(R.id.textViewResult1);
        textViewResult2 = findViewById(R.id.textViewResult2);
        textViewResult3 = findViewById(R.id.textViewResult3);

    }

    @Override
    public void onClick(View v) {

        EditText editTextName = findViewById(R.id.editTextName);
        String editTextNameString = editTextName.getText().toString();
        EditText editTextAge = findViewById(R.id.editTextAge);
        String editTextAgeString = editTextAge.getText().toString();

        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        RadioButton radioButtonGender = findViewById(radioGroupGender.getCheckedRadioButtonId());
        String radioButtonGenderString = radioButtonGender.getText().toString();


        Bundle bundle = new Bundle();
        bundle.putString("Name", editTextNameString);
        bundle.putString("Age", editTextAgeString);
        bundle.putString("Gender", radioButtonGenderString);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,100);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.hasExtra("resultName")) {
//            Toast.makeText(getApplicationContext(), data.getStringExtra("resultGender"), Toast.LENGTH_SHORT).show();
            textViewResult1.setText(data.getStringExtra("resultName"));

        }
        if(data.hasExtra("resultAge")){
//            Toast.makeText(getApplicationContext(), data.getStringExtra("resultAge"), Toast.LENGTH_SHORT).show();
            textViewResult2.setText(data.getStringExtra("resultAge"));
        }
        if(data.hasExtra("resultGender")){
            textViewResult3.setText(data.getStringExtra("resultGender"));
//            Toast.makeText(getApplicationContext(), data.getStringExtra("resultGender"), Toast.LENGTH_LONG).show();
        }

    }
}
