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
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //AlertDialog 생성 : inner클래스 문법
        builder.setMessage(R.string.saveSuccess);                           //
        builder.setNeutralButton(R.string.close, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button2_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) { // 삭제 작업 실행
                Toast.makeText(AlertsActivity.this, "삭제성공", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button3_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);    //대화상자 빌드
        builder.setTitle(R.string.selectAnimal);                               //대화상자 제목
        builder.setSingleChoiceItems(R.array.animals, selectedAnimalIndex, null); //
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) { // 선택된 항목에 대한 작업 실행
                ListView listView = ((AlertDialog) dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
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