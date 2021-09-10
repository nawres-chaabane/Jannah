package mkademghofrane.tn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductAdapter;
import mkademghofrane.tn.adapter.ProductCategoryAdapter;
import mkademghofrane.tn.model.ProductCategory;
import mkademghofrane.tn.model.Products;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;
    TextView honeyButton, oilsButton , snacksButton, spicesButton,dairyButton;
    ImageView searchButton, settingsButton;
    RecyclerView.LayoutManager layoutManager;
    Button cartActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ProductCategory>productCategoryList=new ArrayList<>();
        productCategoryList.add(new ProductCategory(1,"Most Popular"));
        productCategoryList.add(new ProductCategory(1,"Delivery"));
        productCategoryList.add(new ProductCategory(1,"Profile"));
        productCategoryList.add(new ProductCategory(1,"Help"));
        productCategoryList.add(new ProductCategory(1,"Order"));

        setProductRecycler(productCategoryList);
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1,"35Dt","1Kg","Zrire","made in home",R.drawable.zrire1));
        productsList.add(new Products(1,"12Dt","500g","Confiture","Home Made",R.drawable.confiture));
        setProdItemRecycler(productsList);
        cartActivity=(Button) findViewById(R.id.button);
        cartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
        honeyButton=(TextView) findViewById(R.id.honey);
        honeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HoneyMain2Activity.class);
                startActivity(intent);
            }
        });
        dairyButton=(TextView) findViewById(R.id.dairy_products);
        dairyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,DairyMain2Activity.class);
                startActivity(intent);
            }
        });
        searchButton=(ImageView) findViewById(R.id.search_product);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        oilsButton=(TextView) findViewById(R.id.oils);
        oilsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OilsMain2Activity.class);
                startActivity(intent);
            }
        });
        snacksButton=(TextView) findViewById(R.id.sweet_snacks);
        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SnacksMain2Activity.class);
                startActivity(intent);
            }
        });
        spicesButton=(TextView) findViewById(R.id.spices);
        spicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SpicesMain2Activity.class);
                startActivity(intent);
            }
        });
        settingsButton=(ImageView) findViewById(R.id.settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
        recyclerView=findViewById(R.id.product_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}