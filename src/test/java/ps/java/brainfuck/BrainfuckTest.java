package ps.java.brainfuck;

import org.junit.Test;
import ps.java.brainfuck.exceptions.BrainfuckInputException;

import static org.junit.Assert.*;

public class BrainfuckTest {

    @Test
    public void run7() {
        assertEquals("7", Brainfuck.run("++>+++++[<+>-]++++++++[<++++++>-]<.", ""));
    }

    @Test
    public void runHelloWorld1() {
        assertEquals("Hello World!\n", Brainfuck.run("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.", ""));
    }

    @Test
    public void runHelloWorld2() {
        assertEquals("Hello World!\n", Brainfuck.run(">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.[-]>++++++++[<++++>-]<.#>+++++++++++[<+++++>-]<.>++++++++[<+++>-]<.+++.------.--------.[-]>++++++++[<++++>-]<+.[-]++++++++++.", ""));
    }

    @Test
    public void runHelloWorld3() {
        assertEquals("Hello World!\n", Brainfuck.run("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.", ""));
    }

    @Test
    public void runInput1() {
        assertEquals("B", Brainfuck.run(",+.", "A"));
    }

    @Test
    public void runInput2() {
        assertEquals("Ps", Brainfuck.run("++++[->++++<],[->+<]>-.<++++++[->++++++<]>-.", "A"));
    }

    @Test
    public void runInputException() {
        try {
            Brainfuck.run(",,", "A");
            fail();
        } catch (final BrainfuckInputException e) {

        }
    }

    @Test
    public void testROT13() {
        final String program =
                "-,+[-[>>++++[>++++++++<-]<+<-[>+>+>-[>>>]<[[>+<-]>>+>]<<<<<-]]>>>[-]+" +
                        ">--[-[<->+++[-]]]<[++++++++++++<[>-[>+>>]>[+[<+>-]>+>>]<<<<<-]" +
                        ">>[<+>-]>[-[-<<[-]>>]<<[<<->>-]>>]<<[<<+>>-]]<[-]<.[-]<-,+]";
        assertEquals("Uryyb", Brainfuck.run(program, "Hello\uFFFF"));
    }

}
