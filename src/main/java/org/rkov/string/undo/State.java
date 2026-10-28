package org.rkov.string.undo;

public final class State {

    public final char[] content;
    public final int count;

    public State(char[] content, int count) {
        this.content = content;
        this.count = count;
    }
}
