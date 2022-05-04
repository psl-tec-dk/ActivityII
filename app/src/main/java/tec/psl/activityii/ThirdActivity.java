package tec.psl.activityii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button btn_closeThird;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_closeThird = findViewById(R.id.btn_closeThird);
        intent = getIntent();

        Log.d("PSL_LOG1", intent.getStringExtra("fromMain"));

        btn_closeThird.setOnClickListener(v -> {
            intent.putExtra("msg", "Hilsen fra Third");
            setResult(AppConstants.RESULT_CODE_THIRD, intent);
            finish();
        });

    }
}