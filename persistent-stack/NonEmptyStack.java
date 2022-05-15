import java.util.Optional;

public class NonEmptyStack<T> implements Stack<T> {

    private final T top;
    private final Stack<T> popped;

    public NonEmptyStack(T top, Stack<T> popped) {
        this.top = top;
        this.popped = popped;
    }

    @Override
    public Stack<T> pop() {
        return popped;
    }

    @Override
    public Optional<T> top() {
        return Optional.of(top);
    }

    @Override
    public Stack<T> push(T otherTop) {
        return new NonEmptyStack<>(otherTop, this);
    }
}
