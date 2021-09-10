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
import mkademghofrane.tn.model.ProductSpices;
public class ProductSpicesAdapter extends RecyclerView.Adapter<ProductSpicesAdapter.ProductViewHolder>{
    Context context;
    List<ProductSpices> productSpicesList;

    public ProductSpicesAdapter(Context context, List<ProductSpices> productSpicesList) {
        this.context = context;
        this.productSpicesList = productSpicesList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.product_spices_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodSpicesImage.setImageResource(productSpicesList.get(position).getImageSpicesUrl());
        holder.prodSpicesSize.setText(productSpicesList.get(position).getProductSpicesSize());
        holder.prodSpicesPrice.setText(productSpicesList.get(position).getProductSpicesPrice());
        holder.prodSpicesDescription.setText(productSpicesList.get(position).getProductSpicesDescription());
        holder.prodSpicesName.setText(productSpicesList.get(position).getProductSpicesName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productSpicesList.get(position).getProductSpicesName());
                intent.putExtra("price",productSpicesList.get(position).getProductSpicesPrice());
                intent.putExtra("description",productSpicesList.get(position).getProductSpicesDescription());
                intent.putExtra("image",productSpicesList.get(position).getImageSpicesUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productSpicesList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodSpicesImage;
        TextView prodSpicesPrice , prodSpicesSize, prodSpicesDescription,prodSpicesName;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodSpicesImage=itemView.findViewById(R.id.product_spices_image);
            prodSpicesPrice=itemView.findViewById(R.id.product_spices_price);
            prodSpicesSize=itemView.findViewById(R.id.product_spices_size);
            prodSpicesDescription=itemView.findViewById(R.id.product_spices_description);
            prodSpicesName=itemView.findViewById(R.id.product_spices_name);
        }
    }
}