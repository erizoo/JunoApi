package by.boiko.erizo.domain.repositories;

import java.util.List;

import by.boiko.erizo.domain.entity.JunoEntity;
import io.reactivex.Observable;

public interface JunoRepository {

    Observable<List<JunoEntity>> getAllRepo();
}
