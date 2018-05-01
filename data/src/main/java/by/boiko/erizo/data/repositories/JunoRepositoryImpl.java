package by.boiko.erizo.data.repositories;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.boiko.erizo.data.model.JunoModel;
import by.boiko.erizo.data.net.RestService;
import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.domain.repositories.JunoRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class JunoRepositoryImpl implements JunoRepository {

    private Context context;
    private RestService restService;

    @Inject
    public JunoRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<List<JunoEntity>> getAllRepo() {
        return restService.loadRepo(80).map(new Function<List<JunoModel>, List<JunoEntity>>() {
            @Override
            public List<JunoEntity> apply(List<JunoModel> junoModels) throws Exception {
                List<JunoEntity> junoEntities = new ArrayList<>();
                for (JunoModel item: junoModels) {
                    junoEntities.add(new JunoEntity(item.getName()));
                }
                return junoEntities;
            }
        });
    }
}
