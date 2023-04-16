package net.skhu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

public class SpinnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);

        String[] stringArray = {"집주소", "직장주소", "기타"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById((R.id.spinner_addressType));
        spinner.setAdapter(adapter);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner1 = findViewById(R.id.spinner_phoneType);
                int index1 = spinner1.getSelectedItemPosition();
                String text1 = spinner1.getSelectedItem().toString();

                Spinner spinner2 = findViewById(R.id.spinner_addressType);
                int index2 = spinner2.getSelectedItemPosition();
                String text2 = spinner2.getSelectedItem().toString();

                String s = String.format("전화:%s(%d)  주소:%s(%d)", text1, index1, text2, index2);
                Toast.makeText(SpinnersActivity.this, s, Toast.LENGTH_SHORT).show();
            }


        };
        Button button = (Button) findViewById(R.id.btnSave_spi);
        button.setOnClickListener(listener1);

        AdapterView.OnItemSelectedListener listener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String s = stringArray[i];
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택되지 않았을 때 동작하는 코드

            }
        };
        spinner.setOnItemSelectedListener(listener2);


    }
}