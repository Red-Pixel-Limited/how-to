import java.util.Optional;

public final class EmptyStack<T> implements Stack<T> {

    @Override
    public Stack<T> pop() {
        throw new IllegalStateException();
    }

    @Override
    public Optional<T> top() {
        return Optional.empty();
    }

    @Override
    public Stack<T> push(T top) {
        return new NonEmptyStack<>(top, this);
    }
}
