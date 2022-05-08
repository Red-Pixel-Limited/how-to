/**
 *  node partial.js
 */

function add(a, b) {
    return a + b;
}

function partial(f, a) {
    return function (b) {
        return f(a, b);
    }
}

const addTwo = partial(add, 2);
const sum = addTwo(3);
console.log(sum);
