package ps.java.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckTest {

    @Test
    public void run8() {
        assertEquals("8", Brainfuck.run("++>+++++[<+>-]++++++++[<++++++>-]<.", ""));
    }

    @Test
    public void runA() {
        assertEquals("8", Brainfuck.run("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.", ""));
    }

    @Test
    public void runB() {
        assertEquals("8", Brainfuck.run(">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.[-]>++++++++[<++++>-]<.#>+++++++++++[<+++++>-]<.>++++++++[<+++>-]<.+++.------.--------.[-]>++++++++[<++++>-]<+.[-]++++++++++.", ""));
    }

}
