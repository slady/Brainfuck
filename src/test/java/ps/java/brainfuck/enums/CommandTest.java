package ps.java.brainfuck.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ps.java.brainfuck.enums.Command.*;

/**
 * Test the {@link Command} class.
 *
 * @author slady@slady.net
 */
public class CommandTest {

    @Test
    public void testCommandCount() {
        assertEquals(8 + 1, Command.values().length);
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
