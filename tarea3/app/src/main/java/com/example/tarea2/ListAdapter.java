package com.example.tarea2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<Tarea> lista;
    private Context context;
    public ListAdapter(List<Tarea> lista, Context context){
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_recyclerview_layout, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
//        String tarea = lista.get(position);
        Tarea tarea = lista.get(position);
        holder.textViewTarea.setText(tarea.getDescripcion());
        holder.radioButton.setChecked(tarea.isHecha());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmación de eliminación");
                builder.setMessage("¿Estás seguro de que deseas eliminar esta tarea?");

                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lista.remove(position);
                        notifyItemRemoved(position);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarea tarea1 = lista.get(position);
                tarea1.setHecha(!tarea1.isHecha());

                holder.textViewTarea.setEnabled(!tarea1.isHecha());

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTarea;
        public Button btnEliminar;
        public RadioButton radioButton;
        public ViewHolder(View itemView) {
            super(itemView);
            btnEliminar = itemView.findViewById(R.id.btnDelete);
            textViewTarea = itemView.findViewById(R.id.text);
            radioButton = itemView.findViewById(R.id.rdbtnCheck);
        }
    }
}
