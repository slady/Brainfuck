package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.BrainfuckCommand;

/**
 * This is the class holding metadata for the {@link BrainfuckCommand}
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckJumpCommandInfo extends BrainfuckCommandInfo {

    private int jumpPosition;

    public BrainfuckJumpCommandInfo(final BrainfuckCommand command, final BrainfuckTokenPosition tokenPosition) {
        super(command, tokenPosition);
    }

    public BrainfuckJumpCommandInfo(final BrainfuckCommand command, final BrainfuckTokenPosition tokenPosition, final int jumpPosition) {
        this(command, tokenPosition);
        setJumpPosition(jumpPosition);
    }

    public int getJumpPosition() {
        return jumpPosition;
    }

    public void setJumpPosition(int jumpPosition) {
        this.jumpPosition = jumpPosition;
    }

}
