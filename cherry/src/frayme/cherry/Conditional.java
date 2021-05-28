package frayme.cherry;

/**
 * An implementation of the {@code Executable} interface that requires a set
 * of conditions in order to execute.
 *
 * @author Colin Robertson
 */
public class Conditional implements Executable {
    private final ConditionSet conditions;
    private final Executable executable;

    public Conditional(ConditionSet conditions,
                       Executable executable) {
        this.conditions = conditions;
        this.executable = executable;
    }

    public ConditionSet getConditions() {
        return this.conditions;
    }

    public Executable getExecutable() {
        return this.executable;
    }

    @Override
    public void execute() {
        if (this.conditions.doesPass()) {
            executable.execute();
        }
    }

    @Override
    public boolean isDone() {
        return this.executable.isDone();
    }
}
