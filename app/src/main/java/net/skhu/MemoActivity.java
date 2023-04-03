package net.skhu;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        final EditText editText_title = findViewById(R.id.editText_title);
        editText_title.setText("공지사항 입니다.");

        final EditText editText_content = findViewById(R.id.editText_content);
        editText_title.setText("4주차나 5추자의 구현시험 봅니다.");
        Button button = (Button) findViewById(R.id.btnSave);   //button activity
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                if (isEmptyOrWhiteSpace(title))
                    editText_title.setError("제목을 입력하세요");

                String content = editText_content.getText().toString();

                if (isEmptyOrWhiteSpace(content))
                    editText_content.setError("내용을 입력하세요");

            // 메모 데이터를 서버에 전송하는 코드를 구현해야 함.
            String msg = "저장 성공: " + title;
            Toast.makeText(MemoActivity.this, msg, Toast.LENGTH_LONG).show();


        }
    };
    button.setOnClickListener(listener);
} static boolean isEmptyOrWhiteSpace(String s) {
    if (s == null) return true; return s.toString().trim().length() == 0;
}
}


