package by.boiko.erizo.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import by.boiko.erizo.domain.entity.JunoEntity;
import by.boiko.erizo.domain.executor.PostExecutionThread;
import by.boiko.erizo.domain.repositories.JunoRepository;
import io.reactivex.Observable;

public class GetAllJunoRepoUseCase extends BaseUseCase {

    private JunoRepository junoRepository;

    @Inject
    public GetAllJunoRepoUseCase(PostExecutionThread postExecutionThread, JunoRepository junoRepository) {
        super(postExecutionThread);
        this.junoRepository = junoRepository;
    }

    public Observable<List<JunoEntity>> getAllRepo() {
        return junoRepository.getAllRepo().subscribeOn(threadExecution).observeOn(postExecutionThread);
    }
}
