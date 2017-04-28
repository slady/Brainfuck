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

    public BrainfuckCommandInfo(final Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

}
