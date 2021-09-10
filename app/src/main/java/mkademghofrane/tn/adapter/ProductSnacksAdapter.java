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
import mkademghofrane.tn.model.ProductSnacks;

public class ProductSnacksAdapter extends RecyclerView.Adapter<ProductSnacksAdapter.ProductViewHolder> {
    Context context;
    List<ProductSnacks>productSnacksList;

    public ProductSnacksAdapter(Context context, List<ProductSnacks> productSnacksList) {
        this.context = context;
        this.productSnacksList = productSnacksList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.product_snacks_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodSweetImage.setImageResource(productSnacksList.get(position).getImageSweetUrl());
        holder.prodSweetSize.setText(productSnacksList.get(position).getProductSweetSize());
        holder.prodSweetPrice.setText(productSnacksList.get(position).getProductSweetPrice());
        holder.prodSweetDescription.setText(productSnacksList.get(position).getProductSweetDescription());
        holder.prodSweetName.setText(productSnacksList.get(position).getProductSweetName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productSnacksList.get(position).getProductSweetName());
                intent.putExtra("price",productSnacksList.get(position).getProductSweetPrice());
                intent.putExtra("description",productSnacksList.get(position).getProductSweetDescription());
                intent.putExtra("image",productSnacksList.get(position).getImageSweetUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productSnacksList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodSweetImage;
        TextView prodSweetSize,prodSweetPrice,prodSweetName,prodSweetDescription;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodSweetImage=itemView.findViewById(R.id.product_sweet_image);
            prodSweetPrice=itemView.findViewById(R.id.product_sweet_price);
            prodSweetSize=itemView.findViewById(R.id.product_sweet_size);
            prodSweetDescription=itemView.findViewById(R.id.product_sweet_description);
            prodSweetName=itemView.findViewById(R.id.product_sweet_name);
        }
    }
}