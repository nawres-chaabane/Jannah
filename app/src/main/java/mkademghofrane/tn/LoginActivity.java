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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import mkademghofrane.tn.prevalent.Prevalent;
import mkademghofrane.tn.model.Users;

public class LoginActivity extends AppCompatActivity {
    private EditText InputEmail,InputPassword;
    private Button SignIn;
    TextView txtRegister;
    private ProgressDialog  loadingBar;
    private String parentName="Users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtRegister=(TextView) findViewById(R.id.register_login);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
        SignIn=(Button) findViewById(R.id.btn);
        InputEmail=(EditText) findViewById(R.id.email_adress);
        InputPassword=(EditText) findViewById(R.id.password);
        loadingBar= new ProgressDialog(this);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }

    private void loginUser() {
        String mail= InputEmail.getText().toString();
        String password=InputPassword.getText().toString();
        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show(); }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter Your password", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("sign in");
            loadingBar.setMessage("Please wait few minutes we are checking");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(mail,password);
        }

    }

    private void AllowAccessToAccount(String mail, String password) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(parentName).child(mail).exists()){
                    Users usersData=snapshot.child(parentName).child(mail).getValue(Users.class);
                    if(usersData.getMail().equals(mail)){
                        if(usersData.getPassword().equals(password)){
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            Prevalent.currentOnlineUser=snapshot.getValue(Users.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this,"Logged is successfully",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                        else{
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this,"Password is incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Account with this"+mail+"do not exist", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}