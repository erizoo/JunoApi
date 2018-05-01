package by.boiko.erizo.domain.interactors;
import by.boiko.erizo.domain.executor.PostExecutionThread;
import by.boiko.erizo.domain.executor.ThreadExecutor;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class BaseUseCase {

    protected Scheduler postExecutionThread;
    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
