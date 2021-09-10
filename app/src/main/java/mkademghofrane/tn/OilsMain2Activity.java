package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductOilsAdapter;
import mkademghofrane.tn.model.ProductOils;

public class OilsMain2Activity extends AppCompatActivity {
    ProductOilsAdapter productOilsAdapter;
    RecyclerView productOilsRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oils_main2);

        List<ProductOils> productOilsList=new ArrayList<>();
        productOilsList.add(new ProductOils(1,"1Litre","5Dt","tunisian oils","Tunisian oils",R.drawable.oils1));
        productOilsList.add((new ProductOils(1,"2 Litre","20DT","Italien oils","Italian oils",R.drawable.oils2)));
        productOilsList.add((new ProductOils(1,"1.5 Litre","20DT","Spanish oils","Spanish Oils",R.drawable.oils3)));
        setProductOilsRecycler(productOilsList);
    }
    private void setProductOilsRecycler(List<ProductOils> productOilsList) {
        productOilsRecycler=findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        productOilsRecycler.setLayoutManager(layoutManager);
        productOilsAdapter=new ProductOilsAdapter(this,productOilsList);
        productOilsRecycler.setAdapter(productOilsAdapter);
    }
}