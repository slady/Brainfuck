package ps.java.brainfuck.io;

/**
 * String implementation for input and output {@link BrainfuckInputOutput} interface
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckStringInputOutput implements BrainfuckInputOutput {

    final String input;

    int pointer;

    final StringBuilder buffer = new StringBuilder();

    public BrainfuckStringInputOutput(final String input) {
        this.input = input;
    }

    @Override
    public void output(final int output) {
        buffer.append((char) output);
    }

    @Override
    public int input() {
        return input.charAt(pointer++);
    }

    public String getOutput() {
        return buffer.toString();
    }

}
