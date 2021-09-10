package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import mkademghofrane.tn.adapter.ProductHoneyAdapter;
import mkademghofrane.tn.model.ProductHoney;

public class HoneyMain2Activity extends AppCompatActivity {
    ProductHoneyAdapter productHoneyAdapter;
    RecyclerView productHoneyRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honey_main2);
        List<ProductHoney>productHoneyList=new ArrayList<>();
        productHoneyList.add(new ProductHoney(1,"500g","50DT","Sage Honey","Best flavor",R.drawable.honey1));
        productHoneyList.add((new ProductHoney(1,"250g","45Dt","Rowse Honey","sweety flavor",R.drawable.honey2)));
        productHoneyList.add((new ProductHoney(1,"350g","55Dt","Kamah Honey","sweety flavor",R.drawable.honey3)));
        productHoneyList.add((new ProductHoney(1,"500g","80Dt","Ginger Honey","sweety flavor",R.drawable.honey4)));
        productHoneyList.add((new ProductHoney(1,"250g","20Dt","Australien Honey","sweety flavor",R.drawable.honey5)));
        productHoneyList.add((new ProductHoney(1,"1Kg","120Dt","Greek Honey","sweety flavor",R.drawable.honey6)));
        setProductHoneyRecycler(productHoneyList);
    }

    private void setProductHoneyRecycler(List<ProductHoney> productHoneyList) {
        productHoneyRecycler=findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        productHoneyRecycler.setLayoutManager(layoutManager);
        productHoneyAdapter=new ProductHoneyAdapter(this,productHoneyList);
        productHoneyRecycler.setAdapter(productHoneyAdapter);
    }
}