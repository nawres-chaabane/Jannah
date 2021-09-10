package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegistrationActivity extends AppCompatActivity {
    private Button Register;
    TextView txtSignIn;
    private EditText InputFullName,InputEmail,InputPassword;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtSignIn=(TextView) findViewById(R.id.sign_registration);
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        Register=(Button) findViewById(R.id.btn);
        InputEmail=(EditText) findViewById(R.id.email_adress);
        InputFullName=(EditText) findViewById(R.id.full_name);
        InputPassword=(EditText) findViewById(R.id.password);
        loadingBar= new ProgressDialog(this);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String name=InputFullName.getText().toString();
        String mail=InputEmail.getText().toString();
        String password=InputPassword.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please write your full name",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(mail)){
            Toast.makeText(this,"Please write your mail",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please write your password",Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Register");
            loadingBar.setMessage("Please wait few minutes");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            ValidateEmail(name,mail,password);
        }
    }

    private void ValidateEmail(String name, String mail, String password) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!(snapshot.child("Users").child(mail).exists())){
                    HashMap<String,Object> userdataMap=new HashMap<>();
                    userdataMap.put("mail",mail);
                    userdataMap.put("name",name);
                    userdataMap.put("password",password);
                    RootRef.child("Users").child(mail).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this,"your account has been created successfully",Toast.LENGTH_SHORT);
                                loadingBar.dismiss();
                                Intent intent= new Intent(RegistrationActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                loadingBar.dismiss();
                                Toast.makeText(RegistrationActivity.this,"Network problem please try again ...",Toast.LENGTH_SHORT);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(RegistrationActivity.this,"This"+mail+"already exists..",Toast.LENGTH_SHORT);
                    loadingBar.dismiss();;
                    Toast.makeText(RegistrationActivity.this,"Please select onther mail",Toast.LENGTH_SHORT);
                    Intent intent= new Intent(RegistrationActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}