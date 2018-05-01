package by.boiko.erizo.juno.screens;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.juno.base.BaseItemViewModel;
import by.boiko.erizo.juno.base.BaseViewModel;

public class ItemsJunoViewModel extends BaseItemViewModel<JunoEntity> {

    public ObservableField<String> name = new ObservableField<>();


    @Override
    public void setItem(JunoEntity junoEntity, int position) {
        name.set(junoEntity.getText());
    }
}
