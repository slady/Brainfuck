package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.BrainfuckCommand;

/**
 * This is the class holding the token position for the {@link BrainfuckCommand}
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckTokenPosition {

    private final int line;

    private final int position;

    public BrainfuckTokenPosition(final int line, final int position) {
        this.line = line;
        this.position = position;
    }

    public int getLine() {
        return line;
    }

    public int getPosition() {
        return position;
    }

}
