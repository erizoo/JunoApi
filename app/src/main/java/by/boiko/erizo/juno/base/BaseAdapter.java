package by.boiko.erizo.juno.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

public abstract class BaseAdapter<Model, ViewModel extends BaseItemViewModel<Model>>
        extends RecyclerView.Adapter<BaseItemViewHolder<Model, ViewModel, ?>> {

    private List<Model> items = new ArrayList<>();
    private PublishSubject<ItemEntity> clickSubject = PublishSubject.create();
    protected boolean isClickable = true;

    public void setItems(List<Model> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void filter(List<Model> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public PublishSubject<ItemEntity> observClick() {
        return clickSubject;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull BaseItemViewHolder<Model, ViewModel, ?> holder) {
        super.onViewAttachedToWindow(holder);

    }

    @Override
    public void onViewDetachedFromWindow(@NonNull BaseItemViewHolder<Model, ViewModel, ?> holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.setOnClickListener(null);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseItemViewHolder<Model, ViewModel, ?> holder, int position) {
        holder.bindTo(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemEntity<Model> {

        public Model model;
        public int position;

        public ItemEntity(Model model, int position) {
            this.model = model;
            this.position = position;
        }

        public Model getModel() {
            return model;
        }
    }


}
