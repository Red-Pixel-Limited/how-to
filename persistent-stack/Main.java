public class Main {

    public static void main(String[] args) {
        final var empty = Stack.create();
        final var nonEmpty = empty
                .push(1)
                .push(2);
        System.out.println(nonEmpty.top().orElse("No value")); // prints 2
        final var previous = nonEmpty.pop();
        System.out.println(previous.top().orElse("No value")); // prints 1
    }
}
