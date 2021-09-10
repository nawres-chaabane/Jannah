package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductDairyAdapter;
import mkademghofrane.tn.model.ProductDairy;

public class DairyMain2Activity extends AppCompatActivity {
    ProductDairyAdapter productDairyAdapter;
    RecyclerView productDairyRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dairy_main2);
        List<ProductDairy> productDairyList=new ArrayList<>();
        productDairyList.add(new ProductDairy(1,"1 Litre","1.5DT","Milk Mart","much Vitamins",R.drawable.dairy1));
        productDairyList.add((new ProductDairy(1,"1 Litre","1.2Dt","Milk Mart","much vitamins",R.drawable.dairy2)));
        productDairyList.add((new ProductDairy(1,"0.5 Litre","2Dt","La Lechera","much vitamins",R.drawable.dairy3)));
        productDairyList.add((new ProductDairy(1,"0.5 Litre","1.65Dt","Dolait","much vitamins",R.drawable.dairy4)));
        productDairyList.add((new ProductDairy(1,"0.5 Litre","1.2Dt","Dolaita","much vitamins",R.drawable.dairy5)));
        productDairyList.add((new ProductDairy(1,"250g","45Dt","Balanced","much vitamins",R.drawable.dairy6)));
        productDairyList.add((new ProductDairy(1,"250g","50Dt","American Slices","much vitamins",R.drawable.dairy7)));
        productDairyList.add((new ProductDairy(1,"250g","60Dt","Sweetend Milk","much vitamins",R.drawable.dairy8)));
        productDairyList.add((new ProductDairy(1,"0.75 Litre","1.8Dt","Velveeta","much vitamins",R.drawable.dairy9)));
        setProductDairyRecycler(productDairyList);
    }
    private void setProductDairyRecycler(List<ProductDairy> productDairyList) {
        productDairyRecycler=findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        productDairyRecycler.setLayoutManager(layoutManager);
        productDairyAdapter=new ProductDairyAdapter(this,productDairyList);
        productDairyRecycler.setAdapter(productDairyAdapter);
    }
}