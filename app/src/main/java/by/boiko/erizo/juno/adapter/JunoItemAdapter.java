package by.boiko.erizo.juno.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.juno.base.BaseAdapter;
import by.boiko.erizo.juno.base.BaseItemViewHolder;
import by.boiko.erizo.juno.screens.ItemsJunoViewModel;

public class JunoItemAdapter extends BaseAdapter<JunoEntity, ItemsJunoViewModel> {

    @NonNull
    @Override
    public BaseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return JunoItemHolder.create(parent, new ItemsJunoViewModel());
    }

}