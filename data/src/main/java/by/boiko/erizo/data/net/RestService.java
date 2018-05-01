package by.boiko.erizo.data.net;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.boiko.erizo.data.model.JunoModel;
import io.reactivex.Observable;


@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<List<JunoModel>> loadRepo(int page) {
        return restApi.loadRepo(page);
    }

}
