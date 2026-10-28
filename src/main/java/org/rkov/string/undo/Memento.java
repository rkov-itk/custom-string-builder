package org.rkov.string.undo;

import java.util.Stack;

/**
 *
 * @author yakov
 */
final class Memento {

    private final Stack<State> states;

    public Memento() {
        this.states = new Stack<>();
    }

    public Memento(State state) {
        this.states = new Stack<>();

        this.states.add(state);
    }

    public Memento add(State state) {
        states.add(state);

        return this;
    }

    public State pop() {
        return states.pop();
    }
}
