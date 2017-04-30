package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.Command;

/**
 * This is the class holding metadata for the {@link ps.java.brainfuck.enums.Command}
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckCommandInfo {

    private final Command command;

    private final BrainfuckTokenPosition tokenPosition;

    public BrainfuckCommandInfo(final Command command, final BrainfuckTokenPosition tokenPosition) {
        this.command = command;
        this.tokenPosition = tokenPosition;
    }

    public Command getCommand() {
        return command;
    }

    public BrainfuckTokenPosition getTokenPosition() {
        return tokenPosition;
    }

}
