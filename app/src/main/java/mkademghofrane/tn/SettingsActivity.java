package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.appsearch.StorageInfo;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;

import mkademghofrane.tn.prevalent.Prevalent;

public class SettingsActivity extends AppCompatActivity {
    private EditText fullNameEditText, passwordEditText,mailEditText;
    private TextView closeBtn, saveBtn;
    private String checked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        fullNameEditText=(EditText) findViewById(R.id.change_full_name);
        passwordEditText=(EditText) findViewById(R.id.change_password);
        mailEditText=(EditText) findViewById(R.id.change_mail);
        closeBtn=(TextView) findViewById(R.id.close_settings);
        saveBtn=(TextView) findViewById(R.id.update_settings);
        userINfDisplay(fullNameEditText,passwordEditText,mailEditText);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checked.equals("clicked")){
                    userINfSaved();

                }
                else {
                    updateUserInfo();
                }
            }
        });
    }

    private void updateUserInfo() {
        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users");
        HashMap<String,Object> userMap=new HashMap<>();
        userMap.put("name",fullNameEditText.getText().toString());
        userMap.put("mail",mailEditText.getText().toString());
        userMap.put("password",passwordEditText.getText().toString());
        ref.child(Prevalent.currentOnlineUser.getMail()).updateChildren(userMap);
        startActivity(new Intent(SettingsActivity.this,MainActivity.class));
        Toast.makeText(SettingsActivity.this,"account informations are updated",Toast.LENGTH_SHORT).show();
        finish();
    }
    private void userINfSaved() {
        if(TextUtils.isEmpty(fullNameEditText.getText().toString())){
            Toast.makeText(this,"You should write your name",Toast.LENGTH_SHORT);
        }
        else if(TextUtils.isEmpty(passwordEditText.getText().toString())){
            Toast.makeText(this,"You should write password",Toast.LENGTH_SHORT);
        }
        else if(TextUtils.isEmpty(mailEditText.getText().toString())){
            Toast.makeText(this,"You should write your e-mail",Toast.LENGTH_SHORT);
        }
    }
    private void userINfDisplay(EditText fullNameEditText, EditText passwordEditText, EditText mailEditText) {
        DatabaseReference UserRef= FirebaseDatabase.getInstance().getReference().child("Users").child(Prevalent.currentOnlineUser.getMail());
        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child("mail").exists()){
                        String name = dataSnapshot.child("name").getValue().toString();
                        String password = dataSnapshot.child("password").getValue().toString();
                        String mail = dataSnapshot.child("mail").getValue().toString();
                        fullNameEditText.setText(name);
                        mailEditText.setText(mail);
                        passwordEditText.setText(password);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}