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
import mkademghofrane.tn.model.ProductOils;

public class ProductOilsAdapter extends RecyclerView.Adapter<ProductOilsAdapter.ProductViewHolder> {
    Context context;
    List<ProductOils> productOilsList;

    public ProductOilsAdapter(Context context, List<ProductOils> productOilsList) {
        this.context = context;
        this.productOilsList = productOilsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_oils_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodOilsImage.setImageResource(productOilsList.get(position).getImageOilsUrl());
        holder.prodOilsSize.setText(productOilsList.get(position).getProductOilsSize());
        holder.prodOilsPrice.setText(productOilsList.get(position).getProductOilsPrice());
        holder.prodOilsDescription.setText(productOilsList.get(position).getProductOilsDescription());
        holder.prodOilsName.setText(productOilsList.get(position).getProductOilsName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productOilsList.get(position).getProductOilsName());
                intent.putExtra("price",productOilsList.get(position).getProductOilsPrice());
                intent.putExtra("description",productOilsList.get(position).getProductOilsDescription());
                intent.putExtra("image",productOilsList.get(position).getImageOilsUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productOilsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView prodOilsImage ;
        TextView prodOilsSize,prodOilsPrice,prodOilsName,prodOilsDescription;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodOilsImage=itemView.findViewById(R.id.product_oils_image);
            prodOilsPrice=itemView.findViewById(R.id.product_oils_price);
            prodOilsSize=itemView.findViewById(R.id.product_oils_size);
            prodOilsDescription=itemView.findViewById(R.id.product_oils_description);
            prodOilsName=itemView.findViewById(R.id.product_oils_name);
        }
    }

}