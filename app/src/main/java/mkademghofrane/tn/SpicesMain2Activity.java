package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductSpicesAdapter;
import mkademghofrane.tn.model.ProductSpices;

public class SpicesMain2Activity extends AppCompatActivity {
    ProductSpicesAdapter productSpicesAdapter;
    RecyclerView productSpicesRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spices_main2);
        List<ProductSpices> productSpicesList=new ArrayList<>();
        productSpicesList.add(new ProductSpices(1,"100g","1DT","spanich product","Garam masala",R.drawable.spices1));
        productSpicesList.add((new ProductSpices(1,"200g","2.5DT","mexico product","smoky BBg",R.drawable.spices2)));
        productSpicesList.add((new ProductSpices(1,"200g","1.5DT","Hot product","Honey Garuc",R.drawable.spices3)));
        productSpicesList.add((new ProductSpices(1,"200g","1.2DT","perfect flavor","Taasyam",R.drawable.spices4)));
        productSpicesList.add((new ProductSpices(1,"200g","3.5DT","perfect flavor","Garam",R.drawable.spices5)));
        productSpicesList.add((new ProductSpices(1,"100g","4DT","Number one in India","Sandwich masala",R.drawable.spices6)));
        setProductSpicesRecycler(productSpicesList);
    }
    private void setProductSpicesRecycler(List<ProductSpices> productSpicesList){
        productSpicesRecycler=findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        productSpicesRecycler.setLayoutManager(layoutManager);
        productSpicesAdapter=new ProductSpicesAdapter(this,productSpicesList);
        productSpicesRecycler.setAdapter(productSpicesAdapter);
    }
}