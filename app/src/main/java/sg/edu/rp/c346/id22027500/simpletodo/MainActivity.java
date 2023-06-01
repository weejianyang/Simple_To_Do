package sg.edu.rp.c346.id22027500.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd;
    Button btnClear;
    ListView lvtask;

    Spinner spnAddRemove;
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.editTexttask);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvtask = findViewById(R.id.listViewTask);
        spnAddRemove = findViewById(R.id.spinner);
        btnDelete = findViewById(R.id.buttonDelete);

        ArrayList<String> alTask;
        alTask = new ArrayList<String>();


        ArrayAdapter aaTask;
        aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTask);
        lvtask.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Task = etTask.getText().toString();
                alTask.add(Task);
                aaTask.notifyDataSetChanged();
                etTask.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etTask.setHint("Type in a new task here");
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);

                        break;
                    case 1:
                        etTask.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int etindex = Integer.parseInt(etTask.getText().toString());
                if (alTask.isEmpty()) {


                    //if (etTask.getText().toString() == "") {
                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                }

                else if (etindex >= alTask.size()) {


                    // if (etTask.getText().toString() != "") {
                    // int etindex = Integer.parseInt(etTask.getText().toString());
                    //  }
                    // else if (etindex <0 || etindex > alTask.size()) {
                    Toast.makeText(MainActivity.this, "Wrong index number ", Toast.LENGTH_SHORT).show();
                    // }

                }

                else{
                    alTask.remove(etindex);
                    aaTask.notifyDataSetChanged();
                }
            }


        });
    }
}




