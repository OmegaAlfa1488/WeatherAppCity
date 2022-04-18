package com.example.mvvmpattern.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmpattern.BR;
import com.example.mvvmpattern.R;
import com.example.mvvmpattern.databinding.TaskItemBinding;
import com.example.mvvmpattern.model.TaskItem;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<TaskItem> taskItemList;
    private final LayoutInflater inflater;
    private Context context;
    TaskItemBinding binding;

    public TaskAdapter(List<TaskItem> taskItemList, Context context) {
        inflater = LayoutInflater.from(context);
        this.taskItemList = taskItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskItem item = taskItemList.get(position);
        holder.takeItem(item);
    }

    @Override
    public int getItemCount() {
        if (taskItemList!=null){
            return taskItemList.size();
        } else {
        return 0;}
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
        }
        public ViewDataBinding getBinding(){
            return DataBindingUtil.getBinding(itemView);
        }
        public void takeItem(TaskItem item) {
            getBinding().setVariable(BR.taskItem,item);
            getBinding().executePendingBindings();
            itemView.setOnClickListener(view -> {
                if (item.state.get().equals("Отмена")){
                    item.state.set("Сделано");
                    item.checked.set(true);

                }else {
                    item.state.set("Отмена");
                    item.checked.set(false);
                }
            });
            itemView.setOnLongClickListener(view -> {
                taskItemList.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                return false;
            });
        }
    }
}
