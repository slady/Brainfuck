package ps.java.brainfuck.parser;

import org.junit.Test;
import ps.java.brainfuck.enums.BrainfuckCommand;
import ps.java.brainfuck.exceptions.BrainfuckInputException;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckParser} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckParserTest {

    @Test
    public void count() {
        final BrainfuckParser parser = new BrainfuckParser("x[->+<]x");
        assertEquals(6, parser.getCommandInfoCount());
    }

    @Test
    public void commands() {
        final BrainfuckParser parser = new BrainfuckParser("x[->+<]x");
        assertEquals(BrainfuckCommand.JUMP_FORWARD, parser.getCommandInfo(0).getCommand());
        assertEquals(BrainfuckCommand.DECREASE_VALUE, parser.getCommandInfo(1).getCommand());
        assertEquals(BrainfuckCommand.INCREMENT_POINTER, parser.getCommandInfo(2).getCommand());
        assertEquals(BrainfuckCommand.INCREASE_VALUE, parser.getCommandInfo(3).getCommand());
        assertEquals(BrainfuckCommand.DECREMENT_POINTER, parser.getCommandInfo(4).getCommand());
        assertEquals(BrainfuckCommand.JUMP_BACKWARD, parser.getCommandInfo(5).getCommand());
    }

    @Test
    public void matching() {
        final BrainfuckParser parser = new BrainfuckParser("[[][]]");

        final BrainfuckJumpCommandInfo jump0 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(0);
        assertEquals(BrainfuckCommand.JUMP_FORWARD, jump0.getCommand());
        assertEquals(5, jump0.getJumpPosition());

        final BrainfuckJumpCommandInfo jump1 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(1);
        assertEquals(BrainfuckCommand.JUMP_FORWARD, jump1.getCommand());
        assertEquals(2, jump1.getJumpPosition());

        final BrainfuckJumpCommandInfo jump2 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(2);
        assertEquals(BrainfuckCommand.JUMP_BACKWARD, jump2.getCommand());
        assertEquals(1, jump2.getJumpPosition());

        final BrainfuckJumpCommandInfo jump3 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(3);
        assertEquals(BrainfuckCommand.JUMP_FORWARD, jump3.getCommand());
        assertEquals(4, jump3.getJumpPosition());

        final BrainfuckJumpCommandInfo jump4 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(4);
        assertEquals(BrainfuckCommand.JUMP_BACKWARD, jump4.getCommand());
        assertEquals(3, jump4.getJumpPosition());

        final BrainfuckJumpCommandInfo jump5 = (BrainfuckJumpCommandInfo) parser.getCommandInfo(5);
        assertEquals(BrainfuckCommand.JUMP_BACKWARD, jump5.getCommand());
        assertEquals(0, jump5.getJumpPosition());
    }

    @Test
    public void unmatchedOpening1() {
        try {
            new BrainfuckParser("[");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched opening bracket, line 1, position 1", e.getMessage());
        }
    }

    @Test
    public void unmatchedOpening3() {
        try {
            new BrainfuckParser("[[[");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched opening brackets, count: 3", e.getMessage());
        }
    }

    @Test
    public void unmatchedClosing() {
        try {
            new BrainfuckParser("]");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched closing bracket, line 1, position 1", e.getMessage());
        }
    }

    @Test
    public void parserPosition() {
        try {
            new BrainfuckParser("xx]");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched closing bracket, line 1, position 3", e.getMessage());
        }
    }

    @Test
    public void parserNewLine() {
        try {
            new BrainfuckParser("\nx]");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched closing bracket, line 2, position 2", e.getMessage());
        }
    }

    @Test
    public void parserTabulator() {
        try {
            new BrainfuckParser("x\tx]");
            fail();
        } catch (final BrainfuckInputException e) {
            assertEquals("Unmatched closing bracket, line 1, position 10", e.getMessage());
        }
    }

}
