package frayme.cherry;

public interface Executor extends Executable {
    void add(Executable executable);
    void remove(Executable executable);
}
