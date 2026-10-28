package org.rkov.string.undo;

/**
 *
 * @author yakov
 */
public class StringBuilder {

    private char[] value;
    private int count;
    private final Memento memento = new Memento();

    public StringBuilder() {
        this.value = new char[16];
        this.count = 0;
    }

    public StringBuilder(String s) {
        this.value = s.toCharArray();
        this.count = s.length();
    }

    public StringBuilder append(char c) {
        makeMemento();

        ensureCapacity(count + 1);

        value[count++] = c;

        return this;
    }

    public StringBuilder append(String string) {
        makeMemento();

        ensureCapacity(string.length() + count);

        for (int index = 0; index < string.length(); index++) {
            value[count++] = string.charAt(index);
        }

        return this;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > value.length) {
            char[] newValue = new char[value.length * 2];

            System.arraycopy(value, 0, newValue, 0, value.length);

            value = newValue;
        }
    }

    public StringBuilder undo() {
        var lastState = memento.pop();

        value = lastState.content;
        count = lastState.count;

        return this;
    }

    @Override
    public String toString() {
        return new String(value).trim();
    }

    public char[] getValue() {
        return value;
    }

    private void makeMemento() {
        memento.add(new State(value, count));
    }
}
