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
import com.example.hamrobaraz.module.Category;

import java.util.List;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
  List<Category>categoryList;
  Context context;

  public CategoryAdapter (List<Category> categoryList, Context context) {
    this. categoryList = categoryList;
    this.context = context;

  }

  @NonNull
  @Override
  public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
    return new CategoryViewHolder(view);
  }


  @Override
  public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
    final Category category = categoryList.get(position);

    holder.imgCatIcon.setImageResource(category.getIcons());
    holder.tvCategory.setText(category.getCategory());

  }

  @Override
  public int getItemCount() { return categoryList.size();}



  public class CategoryViewHolder extends RecyclerView.ViewHolder {
    ImageView imgCatIcon;
    TextView tvCategory;

    public CategoryViewHolder(@NonNull View itemView) {
      super(itemView);

      imgCatIcon= itemView.findViewById(R.id.imgCatIcon);
      tvCategory= itemView.findViewById(R.id.tvCategory);
    }
  }
}
