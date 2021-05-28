package frayme.cherry;

import java.util.ArrayList;
import java.util.List;

public class ListExecutor implements Executor {
    private final List<Executable> executables;

    public ListExecutor() {
        this(new ArrayList<>());
    }

    public ListExecutor(List<Executable> executables) {
        this.executables = executables;
    }

    @Override
    public void execute() {
        List<Executable> toRemove = new ArrayList<>();

        for (Executable e : this.executables) {
            e.execute();

            if (e.isDone()) {
                toRemove.add(e);
            }
        }

        for (Executable e : toRemove) {
            this.executables.remove(e);
        }
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public void add(Executable executable) {
        this.executables.add(executable);
    }

    @Override
    public void remove(Executable executable) {
        this.executables.remove(executable);
    }
}
