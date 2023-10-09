package com.example.examen.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.examen.R;
import com.example.examen.dto.Producto;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ProductoAdapter extends ListAdapter<Producto, ProductoAdapter.ProductoViewHolder> {

    private Consumer<Producto> productoConsumer;

    public ProductoAdapter(@NonNull @NotNull DiffUtil.ItemCallback<Producto> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return ProductoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductoViewHolder holder, int position) {
        Producto current = getItem(position);
        holder.bind(current);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productoConsumer != null) {
                    productoConsumer.accept(current);
                }
            }
        });
    }

    public static class ProductoDiff extends DiffUtil.ItemCallback<Producto> {

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Producto oldItem, @NonNull @NotNull Producto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Producto oldItem, @NonNull @NotNull Producto newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }

    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textViewTitulo;
        private final TextView textViewDescripcion;

        public ProductoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_imagen);
            this.textViewTitulo = itemView.findViewById(R.id.tv_titulo);
            this.textViewDescripcion = itemView.findViewById(R.id.tv_descripcion);
        }

        public void bind(Producto producto){
            Glide.with(itemView.getContext()).load(producto.getImages().get(0)).into(imageView);
            textViewTitulo.setText(producto.getTitle());
            textViewDescripcion.setText(producto.getDescription());
        }

        static ProductoViewHolder create(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_item_product, parent, false);

            return new ProductoViewHolder(view);
        }
    }

    public void setProductoConsumer(Consumer<Producto> productoConsumer) {
        this.productoConsumer = productoConsumer;
    }
}
