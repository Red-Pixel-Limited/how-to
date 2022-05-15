import java.util.Optional;

/**
 * Persistent stack.
 * Please check {@link "https://codurance.com/2018/12/04/the-functional-style-part-8/"} for details.
 * @param <T> Any type to hold
 */
public interface Stack<T> {

    Stack<T> pop();

    Optional<T> top();

    Stack<T> push(T top);

    static <T> Stack<T> create() {
        return new EmptyStack<>();
    }
}

