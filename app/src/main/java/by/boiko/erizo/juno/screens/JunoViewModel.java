package by.boiko.erizo.juno.screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.domain.interactors.GetAllJunoRepoUseCase;
import by.boiko.erizo.juno.adapter.JunoItemAdapter;
import by.boiko.erizo.juno.app.App;
import by.boiko.erizo.juno.base.BaseViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class JunoViewModel extends BaseViewModel {

    public ObservableBoolean loaded = new ObservableBoolean(false);

    private List<JunoEntity> junoEntityList = new ArrayList<>();
    private List<JunoEntity> junoSearchList = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    @Inject
    public Context context;

    @Inject
    public GetAllJunoRepoUseCase getAllJunoRepoUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    private JunoItemAdapter adapter = new JunoItemAdapter();

    public JunoItemAdapter getAdapter() {
        return adapter;
    }

    public JunoViewModel() {
        getRepo();
    }


    private void getRepo() {
        getAllJunoRepoUseCase.getAllRepo().subscribe(new Observer<List<JunoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<JunoEntity> junoEntities) {
                junoEntityList.addAll(junoEntities);
                adapter.setItems(junoEntityList);
                loaded.set(true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void search(String key) {
        junoSearchList.clear();
        if (!TextUtils.isEmpty(key)) {
            for (JunoEntity item : junoEntityList) {
                if (item.getText().toLowerCase().contains(key.toLowerCase())) {
                    junoSearchList.add(item);
                    adapter.filter(junoSearchList);
                }
            }
        } else {
            adapter.filter(junoEntityList);
        }
    }

}
