package mkademghofrane.tn.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mkademghofrane.tn.ProductDetailsActivity;
import mkademghofrane.tn.R;
import mkademghofrane.tn.model.ProductDairy;

public class ProductDairyAdapter extends RecyclerView.Adapter<ProductDairyAdapter.ProductViewHolder> {
    Context context;
    List<ProductDairy>productDairyList;

    public ProductDairyAdapter(Context context, List<ProductDairy> productDairyList) {
        this.context = context;
        this.productDairyList = productDairyList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.product_dairy_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodDairyImage.setImageResource(productDairyList.get(position).getImageDairyUrl());
        holder.prodDairySize.setText(productDairyList.get(position).getProductDairySize());
        holder.prodDairyPrice.setText(productDairyList.get(position).getProductDairyPrice());
        holder.prodDairyDescription.setText(productDairyList.get(position).getProductDairyDescription());
        holder.prodDairyName.setText(productDairyList.get(position).getProductDairyName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productDairyList.get(position).getProductDairyName());
                intent.putExtra("price",productDairyList.get(position).getProductDairyPrice());
                intent.putExtra("description",productDairyList.get(position).getProductDairyDescription());
                intent.putExtra("image",productDairyList.get(position).getImageDairyUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productDairyList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodDairyImage;
        TextView prodDairyPrice , prodDairySize,prodDairyName,prodDairyDescription;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodDairyImage=itemView.findViewById(R.id.product_dairy_image);
            prodDairyPrice=itemView.findViewById(R.id.product_price_price);
            prodDairySize=itemView.findViewById(R.id.product_dairy_size);
            prodDairyDescription=itemView.findViewById(R.id.product_dairy_description);
            prodDairyName=itemView.findViewById(R.id.product_dairy_name);
        }
    }

}