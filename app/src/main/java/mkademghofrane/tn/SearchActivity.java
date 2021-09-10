package mkademghofrane.tn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;

import mkademghofrane.tn.model.Products;

public class SearchActivity extends AppCompatActivity {
    ListView listView;
    SearchView searchView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView= (SearchView) findViewById(R.id.searchview);
        listView=(ListView) findViewById(R.id.listview);
        list=new ArrayList<String>();
        list.add("Delice");
        list.add("zriry");
        list.add("Garam masala");
        list.add("sage Honey");
        list.add("Rowse Honey");
        list.add("Kamahi Honey");
        list.add("Giner Honey");
        list.add("Australien Honey");
        list.add("Greek Honey");
        list.add("Extra Vergin");
        list.add("Merdiane");
        list.add("WilDoats");
        list.add("Zrire");
        list.add("Cachuette");
        list.add("Bssissa D'or");
        list.add("Cacahuetes");
        list.add("Bgh Bssissa");
        list.add("Bssissa de blé");
        list.add("Bssissa au fruit sec");
        list.add("SMOKY BBQ");
        list.add("Honey Garuc");
        list.add("Tassayam");
        list.add("Garam");
        list.add("Sandiwch Masala");
        list.add("Milk Mart");
        list.add("Milky");
        list.add("LA LECHERA");
        list.add("DOLAT");
        list.add("DOLAIT ANANAS");
        list.add("VELVETA CHEESE");
        list.add("BALANCED CHEESE");
        list.add("AMERICAN SLICES");
        list.add("Confiture");
        list.add("SWEETEND CONDESED MILK");

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i=0;
                while(i<33){
                    Intent intent=new Intent(view.getContext(),ProductDetailsActivity.class);
                    startActivity(intent);
                    i++;
                }
            }
        });
    }
}