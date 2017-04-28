package ps.java.brainfuck;

import org.junit.Test;
import ps.java.brainfuck.enums.Command;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckDataStorage} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckDataStorageTest {

    @Test
    public void incrementPointer() throws Exception {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.incrementPointer();
    }

    @Test
    public void decrementPointer() throws Exception {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.incrementPointer();
        storage.decrementPointer();
    }

    @Test
    public void increaseValue() throws Exception {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.increaseValue();
        assertEquals(1, storage.getValue());
    }

    @Test
    public void decreaseValue() throws Exception {
        final BrainfuckDataStorage storage = new BrainfuckDataStorage();
        storage.decreaseValue();
        storage.incrementPointer();
        storage.increaseValue();
        storage.increaseValue();
        storage.decreaseValue();
        assertEquals(1, storage.getValue());
    }

}
