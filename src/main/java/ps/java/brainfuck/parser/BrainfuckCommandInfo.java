package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.BrainfuckCommand;

/**
 * This is the class holding metadata for the {@link BrainfuckCommand}
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckCommandInfo {

    private final BrainfuckCommand command;

    private final BrainfuckTokenPosition tokenPosition;

    public BrainfuckCommandInfo(final BrainfuckCommand command, final BrainfuckTokenPosition tokenPosition) {
        this.command = command;
        this.tokenPosition = tokenPosition;
    }

    public BrainfuckCommand getCommand() {
        return command;
    }

    public BrainfuckTokenPosition getTokenPosition() {
        return tokenPosition;
    }

}
