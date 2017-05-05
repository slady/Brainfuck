package ps.java.brainfuck.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ps.java.brainfuck.enums.BrainfuckCommand.*;

/**
 * Test the {@link BrainfuckCommand} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckCommandTest {

    @Test
    public void testCommandCount() {
        assertEquals(8 + 1, BrainfuckCommand.values().length);
    }

    @Test
    public void testValidCommands() {
        assertEquals(INCREMENT_POINTER, getCommand('>'));
        assertEquals(INCREASE_VALUE, getCommand('+'));
    }

    @Test
    public void testInalidCommand() {
        assertEquals(NO_OPERATION, getCommand('?'));
        assertEquals(NO_OPERATION, getCommand('X'));
    }

}
