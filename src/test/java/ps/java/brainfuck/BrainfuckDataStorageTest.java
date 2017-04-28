package ps.java.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckDataStorage} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckDataStorageTest {

    @Test
    public void incrementPointer() {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.incrementPointer();
    }

    @Test
    public void decrementPointer() {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.incrementPointer();
        storage.decrementPointer();
    }

    @Test
    public void increaseValue() {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.increaseValue();
        assertEquals(1, storage.getValue());
    }

    @Test
    public void decreaseValue() {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.decreaseValue();
        storage.incrementPointer();
        storage.increaseValue();
        storage.increaseValue();
        storage.decreaseValue();
        assertEquals(1, storage.getValue());
    }

}
