package com.example.tarea2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tarea2.Constantes.Accion;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class TaskAdapter extends ListAdapter<Tarea, TaskAdapter.TaskViewHolder> {

    private BiConsumer<Tarea, Accion> tareaConsumer;

    protected TaskAdapter(@NonNull @NotNull DiffUtil.ItemCallback<Tarea> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_recyclerview_layout, parent, false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskViewHolder holder, int position) {
        Tarea current = getItem(position);
        holder.bind(current);

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tareaConsumer != null){
                    tareaConsumer.accept(current, Accion.ELIMINAR);
                }
            }
        });

        holder.radioButton.setChecked(current.isHecha());
        holder.textViewTarea.setEnabled(!current.isHecha());

        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tareaConsumer != null){
                    tareaConsumer.accept(current, Accion.COMPLETAR);
                }
            }
        });

    }
    public static class TaskDiff extends DiffUtil.ItemCallback<Tarea> {

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Tarea oldItem, @NonNull @NotNull Tarea newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Tarea oldItem, @NonNull @NotNull Tarea newItem) {
            return oldItem.getDescripcion().equals(newItem.getDescripcion());
        }
    }
    static class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTarea;
        private final Button btnEliminar;
        private final RadioButton radioButton;

        private TaskViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewTarea = itemView.findViewById(R.id.text);
            btnEliminar = itemView.findViewById(R.id.btnDelete);
            radioButton = itemView.findViewById(R.id.rdbtnCheck);
        }

        public void bind(Tarea tarea){
                textViewTarea.setText(tarea.getDescripcion());
                radioButton.setChecked(tarea.isHecha());
        }

        static TaskViewHolder create(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);

            return new TaskViewHolder(view);
        }

    }

    public void setTareaConsumer(BiConsumer<Tarea, Accion> tareaConsumer) {
        this.tareaConsumer = tareaConsumer;
    }
}
