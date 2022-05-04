package tec.psl.activityii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btn_closeSecond;
    private TextView txt_msgSecond;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt_msgSecond = findViewById(R.id.txt_msgSecond);

        intent = getIntent();
        txt_msgSecond.setText(intent.getStringExtra("fromMain"));

        btn_closeSecond = findViewById(R.id.btn_closeSecond);
        btn_closeSecond.setOnClickListener( v-> {
            intent.putExtra("msg", "Hilsen fra second");
            setResult(AppConstants.RESULT_CODE_SECOND, intent);
            finish();
        });
    }
}