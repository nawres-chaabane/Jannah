package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HelpActivity extends AppCompatActivity {
    EditText inputProblem;
    Button sentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        inputProblem=(EditText) findViewById(R.id.input_help);
        sentBtn=(Button) findViewById(R.id.sent_btn);
        final DatabaseReference helpRef;
        helpRef= FirebaseDatabase.getInstance().getReference().child("Problem");
        String help=inputProblem.getText().toString();
        sentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("problem",help);
                helpRef.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(HelpActivity.this, "your problem has been sent", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(HelpActivity.this,MainActivity.class);
                        }
                    }
                });
            }
        });
    }
}