package by.boiko.erizo.data.net;

import java.util.List;

import by.boiko.erizo.data.model.JunoModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestApi {

    @Headers("user-agent: Awesome-Octocat-App")
    @GET("orgs/gojuno/repos")
    Observable<List<JunoModel>> loadRepo( @Query("per_page") int page);
}
