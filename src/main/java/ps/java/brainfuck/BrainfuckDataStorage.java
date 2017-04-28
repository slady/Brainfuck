package ps.java.brainfuck;

/**
 * This is the data storage for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckDataStorage {

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
