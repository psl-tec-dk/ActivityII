package tec.psl.activityii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Button btn_closeSecond;
    private TextView txt_msgSecond;
    private Intent intent;
    private Spinner spn_drink, spn_mad;
    private ArrayList<String> list = new ArrayList<>();
    private String chosen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt_msgSecond = findViewById(R.id.txt_msgSecond);
        spn_drink = findViewById(R.id.spn_drink);
        spn_mad = findViewById(R.id.spn_mad);

        list.add("Vælg fra listen");
        list.add("The");
        list.add("Kaffe");
        list.add("Chokolade");
        list.add("Cappuchino");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spn_drink.setAdapter(adapter);
        spn_mad.setAdapter(adapter);

        spn_drink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 0) { return; }
//                Toast.makeText(SecondActivity.this, "Pos: " + pos, Toast.LENGTH_SHORT).show();
                chosen = list.get(pos);
                Toast.makeText(SecondActivity.this, "Dit Valg: " + list.get(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        intent = getIntent();
        txt_msgSecond.setText(intent.getStringExtra("fromMain"));

        btn_closeSecond = findViewById(R.id.btn_closeSecond);
        btn_closeSecond.setOnClickListener( v-> {
            intent.putExtra("msg", chosen);
            setResult(AppConstants.RESULT_CODE_SECOND, intent);
            finish();
        });
    }
}