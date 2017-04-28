package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.Command;

/**
 * This is the class holding metadata for the {@link ps.java.brainfuck.enums.Command}
 * of the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckJumpCommandInfo extends BrainfuckCommandInfo {

    private int jumpPosition;

    public BrainfuckJumpCommandInfo(final Command command) {
        super(command);
    }

    public BrainfuckJumpCommandInfo(final Command command, final int jumpPosition) {
        super(command);
        setJumpPosition(jumpPosition);
    }

    public int getJumpPosition() {
        return jumpPosition;
    }

    public void setJumpPosition(int jumpPosition) {
        this.jumpPosition = jumpPosition;
    }

}
