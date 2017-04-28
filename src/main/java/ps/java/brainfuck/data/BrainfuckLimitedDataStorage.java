package ps.java.brainfuck.data;

import ps.java.brainfuck.Brainfuck;

/**
 * This is the limited data storage of the {@link BrainfuckDataStorage} interface
 * for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckLimitedDataStorage implements BrainfuckDataStorage {

    byte[] storage = new byte[100];

    int pointer;

    public void incrementPointer() {
        pointer++;
    }

    public void decrementPointer() {
        pointer--;
    }

    public void increaseValue() {
        storage[pointer]++;
    }

    public void decreaseValue() {
        storage[pointer]--;
    }

    public int getValue() {
        return storage[pointer];
    }

}
