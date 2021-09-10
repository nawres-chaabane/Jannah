package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DeliveryActivity extends AppCompatActivity {
    Button armexBtn, tunisiaBtn,jumiaBtn,yassirBtn;
    String name1="yes",name2="No";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        final DatabaseReference reference;
        reference=FirebaseDatabase.getInstance().getReference().child("Delivery");
        armexBtn=(Button) findViewById(R.id.armex_button);
        armexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("armex",name1);
                hashMap.put("tunsia express",name2);
                hashMap.put("jumia",name2);
                hashMap.put("yassir express",name2);
                reference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(DeliveryActivity.this, "Select delivery successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DeliveryActivity.this,MainActivity.class);
                        }
                    }
                });

            }
        });
        tunisiaBtn=(Button) findViewById(R.id.tunisia_button);
        tunisiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("armex",name2);
                hashMap.put("tunsia express",name1);
                hashMap.put("jumia",name2);
                hashMap.put("yassir express",name2);
                reference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(DeliveryActivity.this, "Select delivery successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DeliveryActivity.this,MainActivity.class);
                        }
                    }
                });
            }
        });
        jumiaBtn=(Button) findViewById(R.id.jumia_btn);
        jumiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("armex",name2);
                hashMap.put("tunsia express",name2);
                hashMap.put("jumia",name1);
                hashMap.put("yassir express",name2);
                reference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(DeliveryActivity.this, "Select delivery successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DeliveryActivity.this,MainActivity.class);
                        }
                    }
                });
            }
        });
        yassirBtn=(Button) findViewById(R.id.yassir_btn);
        yassirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> hashMap=new HashMap<>();
                hashMap.put("armex",name2);
                hashMap.put("tunsia express",name2);
                hashMap.put("jumia",name2);
                hashMap.put("yassir express",name1);
                reference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(DeliveryActivity.this, "Select delivery successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DeliveryActivity.this,MainActivity.class);
                        }
                    }
                });
            }
        });
    }

}