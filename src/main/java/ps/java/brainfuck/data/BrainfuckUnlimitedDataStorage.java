package ps.java.brainfuck.data;

import ps.java.brainfuck.Brainfuck;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the unlimited data storage of the {@} interface
 * for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckUnlimitedDataStorage {

    private final Map<Integer, BrainfuckCell> STORAGE = new HashMap<>();

    private int pointer;

    public void incrementPointer() {
        pointer++;
    }

    public void decrementPointer() {
        pointer--;
    }

    public void increaseValue() {
        getCell().value++;
    }

    public void decreaseValue() {
        getCell().value--;
    }

    public int getValue() {
        return getCell().value;
    }

    private BrainfuckCell getCell() {
        STORAGE.computeIfAbsent(pointer, x -> new BrainfuckCell());
        return STORAGE.get(pointer);
    }

    private class BrainfuckCell {

        private byte value;

    }

}
