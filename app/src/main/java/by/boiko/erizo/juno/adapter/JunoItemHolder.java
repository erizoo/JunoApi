package by.boiko.erizo.juno.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.juno.base.BaseItemViewHolder;
import by.boiko.erizo.juno.databinding.ItemsBinding;
import by.boiko.erizo.juno.screens.ItemsJunoViewModel;

public class JunoItemHolder extends BaseItemViewHolder<JunoEntity,
        ItemsJunoViewModel, ItemsBinding> {

    public JunoItemHolder(ItemsBinding binding, ItemsJunoViewModel viewModel) {
        super(binding, viewModel);
    }

    public static JunoItemHolder create(ViewGroup parent, ItemsJunoViewModel viewModel) {
        ItemsBinding binding = ItemsBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new JunoItemHolder(binding, new ItemsJunoViewModel());
    }

}
