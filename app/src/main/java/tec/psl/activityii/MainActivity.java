package tec.psl.activityii;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_goToSecond, btn_goToThird;
    private TextView txt_msg;
    private ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_goToSecond = findViewById(R.id.btn_goToSecond);
        btn_goToThird = findViewById(R.id.btn_goToThird);
        txt_msg = findViewById(R.id.txt_msg);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == AppConstants.RESULT_CODE_SECOND) {
                            // TODO tilføje kode der behandler resultatet fra SecondActivity
                            Intent intent = result.getData();
                            txt_msg.setText(intent.getStringExtra("msg"));
                            Toast.makeText(MainActivity.this, intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(result.getResultCode() == AppConstants.RESULT_CODE_THIRD) {
                            // TODO tilføje kode der behandler resultatet fra ThirdActivity
                            txt_msg.setText(result.getData().getStringExtra("msg"));
                            //Toast.makeText(MainActivity.this, "*******", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

        btn_goToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("fromMain", "Besked fra main");
                launcher.launch(intent);
            }
        });
        btn_goToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("fromMain", "Besked fra main");
                launcher.launch(intent);
            }
        });

    }
}