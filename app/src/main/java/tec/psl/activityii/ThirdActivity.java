package tec.psl.activityii;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private Button btn_closeThird, btn_addItem;
    private EditText et_newItem;
    private Intent intent;
    private ListView lst_myList;
    private ArrayList<String> list;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("list", list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_addItem = findViewById(R.id.btn_addItem);
        et_newItem = findViewById(R.id.ed_newItem);

        btn_closeThird = findViewById(R.id.btn_closeThird);
        lst_myList = findViewById(R.id.lst_myList);

        if(savedInstanceState == null) {
            list =  new ArrayList<>();
        }
        else {
            list = savedInstanceState.getStringArrayList("list");
        }

//        list =  new ArrayList<>();
//        list.add("Købe mælk");
//        list.add("Ringe til Mark");
//        list.add("Hente pakke på posthus");
//        list.add("Købe printerpapir");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lst_myList.setAdapter(adapter);

        intent = getIntent();

        Log.d("PSL_LOG1", intent.getStringExtra("fromMain"));

        btn_closeThird.setOnClickListener(v -> {
            intent.putExtra("msg", "Hilsen fra Third");
            setResult(AppConstants.RESULT_CODE_THIRD, intent);
            finish();
        });

        btn_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_newItem.getText().toString().equals("")) return;
                String newItem = et_newItem.getText().toString();
                list.add(newItem);
                adapter.notifyDataSetChanged();
                et_newItem.setText("");
            }
        });
        lst_myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                list.remove(pos);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}