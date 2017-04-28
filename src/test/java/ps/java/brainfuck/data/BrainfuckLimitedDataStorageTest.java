package ps.java.brainfuck.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckLimitedDataStorage} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckLimitedDataStorageTest {

    @Test
    public void incrementPointer() {
        final BrainfuckLimitedDataStorage storage = new BrainfuckLimitedDataStorage();
        storage.incrementPointer();
    }

    @Test
    public void decrementPointer() {
        final BrainfuckLimitedDataStorage storage = new BrainfuckLimitedDataStorage();
        storage.incrementPointer();
        storage.decrementPointer();
    }

    @Test
    public void increaseValue() {
        final BrainfuckLimitedDataStorage storage = new BrainfuckLimitedDataStorage();
        storage.increaseValue();
        assertEquals(1, storage.getValue());
    }

    @Test
    public void decreaseValue() {
        final BrainfuckLimitedDataStorage storage = new BrainfuckLimitedDataStorage();
        storage.decreaseValue();
        storage.incrementPointer();
        storage.increaseValue();
        storage.increaseValue();
        storage.decreaseValue();
        assertEquals(1, storage.getValue());
    }

}