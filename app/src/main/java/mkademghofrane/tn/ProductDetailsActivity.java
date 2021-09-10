package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.PipedReader;
import java.util.HashMap;

import mkademghofrane.tn.prevalent.Prevalent;

public class ProductDetailsActivity extends AppCompatActivity {
    private ImageView productImage;
    private TextView productName,productDescription,productPrice;
    private Button addToCartBtn;
    String name,price,description;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        final DatabaseReference cartListRef=FirebaseDatabase.getInstance().getReference().child("Cart List");
        productName=(TextView) findViewById(R.id.product_name_details);
        productDescription=(TextView) findViewById(R.id.description_product_details);
        productPrice=(TextView) findViewById(R.id.product_price_details);
        productImage=(ImageView) findViewById(R.id.image_product_details);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        image=intent.getIntExtra("image",R.drawable.confiture);
        price=intent.getStringExtra("price");
        description=intent.getStringExtra("description");
        productName.setText(name);
        productDescription.setText(description);
        productPrice.setText(price);
        productImage.setImageResource(image);
        addToCartBtn=(Button) findViewById(R.id.add_to_cart);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object> cartMap=new HashMap<>();
                cartMap.put("name",productName.getText().toString());
                cartMap.put("price",productPrice.getText().toString());
                cartMap.put("description",productDescription.getText().toString());
                cartListRef.child("User").child("Products").child(name).updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ProductDetailsActivity.this,"Add to cart",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ProductDetailsActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}