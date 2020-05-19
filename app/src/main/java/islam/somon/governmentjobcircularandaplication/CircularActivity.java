package islam.somon.governmentjobcircularandaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class CircularActivity extends AppCompatActivity {

    LinearLayoutManager mLinearLayoutManager;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setReverseLayout(true);
        mLinearLayoutManager.setStackFromEnd(true);

        mRecyclerView = findViewById(R.id.recyclerView);



        mFirebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = mFirebaseDatabase.getReference("Data");
        showData();



    }

    private void showData()
    {

        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(databaseReference, Model.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull Model model) {
                holder.setDetails(getApplicationContext(),model.getTitle(), model.getImage());

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemVIew = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
                ViewHolder viewHolder = new ViewHolder(itemVIew);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(CircularActivity.this, " hello", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                        Toast.makeText(CircularActivity.this, "Long CLick ", Toast.LENGTH_SHORT).show();

                    }
                });
                return viewHolder;
            }
        };

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);



    }

    protected void onStart(){
        super.onStart();

        if(firebaseRecyclerAdapter != null)
        {
            firebaseRecyclerAdapter.startListening();

        }






    }


}




