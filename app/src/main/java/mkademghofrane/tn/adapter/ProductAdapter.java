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
import mkademghofrane.tn.model.Products;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.products_items, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodSize.setText(productsList.get(position).getProductSize());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());
        holder.prodDescription.setText(productsList.get(position).getProductDescription());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productsList.get(position).getProductName());
                intent.putExtra("price",productsList.get(position).getProductPrice());
                intent.putExtra("description",productsList.get(position).getProductDescription());
                intent.putExtra("image",productsList.get(position).getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodImage;
        TextView prodSize, prodPrice,prodDescription,prodName;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImage = itemView.findViewById(R.id.product_image);
            prodPrice = itemView.findViewById(R.id.product_price);
            prodSize = itemView.findViewById(R.id.product_size);
            prodDescription = itemView.findViewById(R.id.product_name);
            prodName = itemView.findViewById(R.id.product_description);

        }
    }
}
