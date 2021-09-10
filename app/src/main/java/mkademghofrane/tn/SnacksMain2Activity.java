package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductSnacksAdapter;
import mkademghofrane.tn.model.ProductSnacks;

public class SnacksMain2Activity extends AppCompatActivity {
    ProductSnacksAdapter productSnacksAdapter;
    RecyclerView productSnacksRecycler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks_main2);
        List<ProductSnacks> productSnacksList=new ArrayList<>();
        productSnacksList.add(new ProductSnacks(1,"500g","50DT","Sweety Snacks Home Made","zrire",R.drawable.snacks1));
        productSnacksList.add(new ProductSnacks(1,"500g","45DT","Sweety Snacks Home Made","cachuette",R.drawable.snacks2));
        productSnacksList.add(new ProductSnacks(1,"500g","30DT","Sweety Snacks Home Made","bghBssissa",R.drawable.snacks3));
        productSnacksList.add(new ProductSnacks(1,"500g","20DT","Sweety Snacks Home Made","bssissa de blé",R.drawable.snacks4));
        productSnacksList.add(new ProductSnacks(1,"500g","25DT","Sweety Snacks Home Made","bssissa au fruit sec",R.drawable.snacks5));
        productSnacksList.add(new ProductSnacks(1,"500g","8DT","Sweety Snacks Home Made","bssissa Dor",R.drawable.snacks6));
        productSnacksList.add(new ProductSnacks(1,"500g","9DT","Sweety Snacks Home Made","zrirh",R.drawable.snacks7));
        setProductSweetRecycler(productSnacksList);
    }
    private void setProductSweetRecycler(List<ProductSnacks> productSweetList) {
        productSnacksRecycler=findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        productSnacksRecycler.setLayoutManager(layoutManager);
        productSnacksAdapter=new ProductSnacksAdapter(this,productSweetList);
        productSnacksRecycler.setAdapter(productSnacksAdapter);
    }
}