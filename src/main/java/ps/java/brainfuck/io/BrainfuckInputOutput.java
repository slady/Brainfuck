package ps.java.brainfuck.io;

/**
 * Interface for input and output of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public interface BrainfuckInputOutput {

    void output(int output);

    int input();

}
