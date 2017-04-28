package ps.java.brainfuck.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckUnlimitedDataStorage} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckUnlimitedDataStorageTest {

    @Test
    public void incrementPointer() {
        final BrainfuckUnlimitedDataStorage storage = new BrainfuckUnlimitedDataStorage();
        storage.incrementPointer();
    }

    @Test
    public void decrementPointer() {
        final BrainfuckUnlimitedDataStorage storage = new BrainfuckUnlimitedDataStorage();
        storage.incrementPointer();
        storage.decrementPointer();
    }

    @Test
    public void increaseValue() {
        final BrainfuckUnlimitedDataStorage storage = new BrainfuckUnlimitedDataStorage();
        storage.increaseValue();
        assertEquals(1, storage.getValue());
    }

    @Test
    public void decreaseValue() {
        final BrainfuckUnlimitedDataStorage storage = new BrainfuckUnlimitedDataStorage();
        storage.decreaseValue();
        storage.incrementPointer();
        storage.increaseValue();
        storage.increaseValue();
        storage.decreaseValue();
        assertEquals(1, storage.getValue());
    }

}
