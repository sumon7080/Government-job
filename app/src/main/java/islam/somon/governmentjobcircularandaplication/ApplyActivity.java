package islam.somon.governmentjobcircularandaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplyActivity extends AppCompatActivity
{
    private EditText userName, contactNumber;
    private Spinner serviceName;
    private Button submit;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        userName = findViewById(R.id.userName);
        contactNumber = findViewById(R.id.contactNumber);
        serviceName = findViewById(R.id.serviceName);
        submit = findViewById(R.id.submit);

        databaseReference = FirebaseDatabase.getInstance().getReference("Custormer Demand");

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String uid= FirebaseAuth.getInstance().getUid();
                String id = databaseReference.push().getKey();

                ModalClass modalClass = new ModalClass(uid, userName.getText().toString(), contactNumber.getText().toString(), serviceName.getSelectedItem().toString());
                databaseReference.child(id).setValue(modalClass);
                Toast.makeText(ApplyActivity.this, "অভিনন্দন!! আমাদের প্রতিনিধি অতি অল্প সময়ের মধ্যে আপনার সাথে যোগাযোগ করবে", Toast.LENGTH_SHORT).show();


            }
        });




    }
}
