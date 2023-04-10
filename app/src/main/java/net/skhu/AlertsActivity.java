package net.skhu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertsActivity extends AppCompatActivity {
    int selectedAnimalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //AlertDialog 빌드 : inner클래스 문법, AD대화상자를 만들기 위해 AD.Builder 클래스 객체 생성
        builder.setMessage(R.string.saveSuccess);                           //AD 문자열 메세지 지정
        builder.setNeutralButton(R.string.close, null);              // AD대화상자에 버튼 추가 : R.string.close는 문자열 리소스 id
        AlertDialog dialog = builder.create();                              //AD 대화상자 객체 생성
        dialog.show();                                                     // AD대화상자 객체를 화면에 출력
    }

    public void button2_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  // AD.Builder 클래스의 객체 생성
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // AD대화상자에 긍정버튼 추가, 버튼 클릭 시 실핼될 리스너 객체 생성
            @Override
            public void onClick(DialogInterface dialog, int index) { // 버튼이 클릭되면, 삭제 작업을 실행할 오버라이딩 메소드
                Toast.makeText(AlertsActivity.this, "삭제성공", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no, null);  //부정적 버튼'no' 추가
        AlertDialog dialog = builder.create();                // AD대화상자 객체 생성
        dialog.show();                                        // 출력
    }

    public void button3_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);    //대화상자 빌드
        builder.setTitle(R.string.selectAnimal);                               //대화상자 제목
        builder.setSingleChoiceItems(R.array.animals, selectedAnimalIndex, null); //
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {  //긍정(확인)버튼 지정, 버튼 클릭 시 실행될 리스너 객체 생성
            @Override
            public void onClick(DialogInterface dialog, int index) { // 선택된 항목에 대한 작업 실행
                ListView listView = ((AlertDialog) dialog).getListView(); //AD대화상자에서 선택된 항목의 index를 구하여
                selectedAnimalIndex = listView.getCheckedItemPosition();  // SelecedAnimalIndex 멤버변수에 대입
                String msg = selectedAnimalIndex + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();
                int drawableId = 0;
                switch (selectedAnimalIndex) {
                    case 0:
                        drawableId = R.drawable.animal_cat_large;
                        break;
                    case 1:
                        drawableId = R.drawable.animal_dog_large;
                        break;
                    case 2:
                        drawableId = R.drawable.animal_owl_large;
                        break;
                }
                ImageView imageView1 = findViewById(R.id.imageView1);

                imageView1.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}