package com.example.hamrobaraz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobaraz.R;
import com.example.hamrobaraz.module.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolders> {
List<Products> productsList;
Context context;

public ProductAdapter(List<Products> productsList,Context context) {
    this.productsList =productsList;
    this.context=context;
}

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.layout_product,parent, false);
    return new ProductViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolders holder, int position) {
    final Products products = productsList.get(position);

    holder.tvProductName.setText(products.getProductName());
    holder.tvPrice.setText(products.getProductPrice());
        holder.tvUserOrNot.setText(products.getProductUseOrNot());
        holder.imgProduct.setImageResource(products.getProductImage());

    }

    @Override
    public int getItemCount() { return productsList.size();
    }


    public class ProductViewHolders extends RecyclerView.ViewHolder {

    TextView tvProductName, tvPrice, tvUserOrNot;
    ImageView imgProduct;


        public ProductViewHolders(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvUserOrNot = itemView.findViewById(R.id.tvUserOrNot);

            imgProduct = itemView.findViewById(R.id.imgProduct);

        }
    }
}
