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
import mkademghofrane.tn.model.ProductHoney;

public class ProductHoneyAdapter extends RecyclerView.Adapter<ProductHoneyAdapter.ProductViewHolder> {
    Context context;
    List<ProductHoney>productHoneyList;

    public ProductHoneyAdapter(Context context, List<ProductHoney> productHoneyList) {
        this.context = context;
        this.productHoneyList = productHoneyList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_honey_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.prodHoneyImage.setImageResource(productHoneyList.get(position).getImageHoneyUrl());
        holder.prodHoneySize.setText(productHoneyList.get(position).getProductHoneySize());
        holder.prodHoneyPrice.setText(productHoneyList.get(position).getProductHoneyPrice());
        holder.prodHoneyDescription.setText(productHoneyList.get(position).getProductHoneyDescription());
        holder.prodHoneyName.setText(productHoneyList.get(position).getProductHoneyName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name",productHoneyList.get(position).getProductHoneyName());
                intent.putExtra("price",productHoneyList.get(position).getProductHoneyPrice());
                intent.putExtra("description",productHoneyList.get(position).getProductHoneyDescription());
                intent.putExtra("image",productHoneyList.get(position).getImageHoneyUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productHoneyList.size() ;
    }

    public static final class  ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodHoneyImage;
        TextView prodHoneySize,prodHoneyPrice,prodHoneyName,prodHoneyDescription;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodHoneyImage=itemView.findViewById(R.id.product_honey_image);
            prodHoneyPrice=itemView.findViewById(R.id.product_honey_price);
            prodHoneySize=itemView.findViewById(R.id.product_honey_size);
            prodHoneyDescription=itemView.findViewById(R.id.product_honey_description);
            prodHoneyName=itemView.findViewById(R.id.product_honey_name);
        }
    }
}