package ps.java.brainfuck.data;

import ps.java.brainfuck.Brainfuck;

/**
 * This is an interface for the data storage
 * for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public interface BrainfuckDataStorage {

    void incrementPointer();

    void decrementPointer();

    void increaseValue();

    void decreaseValue();

    int getValue();

}
