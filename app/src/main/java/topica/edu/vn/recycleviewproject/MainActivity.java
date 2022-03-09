package topica.edu.vn.recycleviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ArrayList<ExampleItem>exampleItems;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;
    private Button btnInsert;
    private Button btnRemove;
    private EditText editTextRemove;
    private EditText editTextInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecycleView();
        setButtons();



    }
    private void setButtons() {
        editTextInsert=findViewById(R.id.editTextInsert);
        editTextRemove=findViewById(R.id.editTextRemove);
        btnInsert=findViewById(R.id.btnInsert);
        btnRemove=findViewById(R.id.btnRemove);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

    }

    public void insertItem(int position) {
        exampleItems.add(position,new ExampleItem(R.drawable.ic_baseline_android_24,"New item at posion"+position,"this is line 2"));
        mAdapter.notifyDataSetChanged();
    }
    public void removeItem(int position) {
        exampleItems.remove(position);
        mAdapter.notifyDataSetChanged();
    }
    public void changeItem(int position,String text)
    {
        exampleItems.get(position).changeText1("Clicked");
    }

    private void buildRecycleView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemclickListerner(new ExampleAdapter.OnItemclickListerner() {//kich hoat mot listerler= lister trong lop ben kia
            @Override
            public void onItemClick(int position) {
                changeItem(position,"Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    private void createExampleList() {
        exampleItems=new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.ic_baseline_android_24,"Line 1","Line 2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24,"Line 3","Line 4"));
        exampleItems.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24,"Line 5","Line 6"));

    }
}