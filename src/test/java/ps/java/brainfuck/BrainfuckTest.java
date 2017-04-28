package ps.java.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckTest {

    @Test
    public void main() throws Exception {
        assertEquals("8", Brainfuck.run("++>+++++[<+>-]++++++++[<++++++>-]<."));
    }

}
