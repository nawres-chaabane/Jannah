package mkademghofrane.tn.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mkademghofrane.tn.CartActivity;
import mkademghofrane.tn.DeliveryActivity;
import mkademghofrane.tn.HelpActivity;
import mkademghofrane.tn.MainActivity;
import mkademghofrane.tn.ProfileActivity;
import mkademghofrane.tn.R;
import mkademghofrane.tn.model.ProductCategory;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductViewHolder>{
    Context context;
    List<ProductCategory> productCategoryList;

    public ProductCategoryAdapter(Context context, List<ProductCategory> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.product_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.categoryName.setText(productCategoryList.get(position).getProductName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent intent=new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
                else if (position==1){
                    Intent intent=new Intent(context, DeliveryActivity.class);
                    context.startActivity(intent);



                }
                else if (position==2){
                    Intent intent=new Intent(context, ProfileActivity.class);
                    context.startActivity(intent);
                }
                else if(position==3) {
                    Intent intent=new Intent(context, HelpActivity.class);
                    context.startActivity(intent);

                }
                else {
                    Intent intent=new Intent(context, CartActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName ;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName= itemView.findViewById(R.id.cat_name);
        }
    }
}