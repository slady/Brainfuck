package ps.java.brainfuck.io;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the {@link BrainfuckStringInputOutput} class.
 *
 * @author slady@slady.net
 */
public class BrainfuckStringInputOutputTest {

    @Test
    public void output() throws Exception {
        final BrainfuckStringInputOutput io = new BrainfuckStringInputOutput(null);
        io.output('P');
        io.output('s');
        assertEquals("Ps", io.getOutput());
    }

    @Test
    public void input() throws Exception {
        final BrainfuckStringInputOutput io = new BrainfuckStringInputOutput("Ps");
        assertEquals('P', io.input());
        assertEquals('s', io.input());
    }

}
