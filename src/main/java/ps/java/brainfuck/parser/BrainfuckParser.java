package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.BrainfuckCommand;
import ps.java.brainfuck.exceptions.BrainfuckInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This is the parser for the {@link ps.java.brainfuck.Brainfuck} programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckParser {

    private static final int TAB_SIZE = 8;

    private final List<BrainfuckCommandInfo> COMMANDS = new ArrayList<>();

    public BrainfuckParser(final String program) {
        final Stack<Integer> stack = new Stack<>();
        int line = 1;
        int position = 0;

        for (final char ch : program.toCharArray()) {
            if (ch >= ' ') {
                position++;
            }

            final BrainfuckCommand command = BrainfuckCommand.getCommand(ch);
            final BrainfuckTokenPosition tokenPosition = new BrainfuckTokenPosition(line, position);

            if (command == BrainfuckCommand.JUMP_FORWARD) {
                stack.push(COMMANDS.size());
                COMMANDS.add(new BrainfuckJumpCommandInfo(command, tokenPosition));
            } else if (command == BrainfuckCommand.JUMP_BACKWARD) {
                if (stack.isEmpty()) {
                    throw new BrainfuckInputException("Unmatched closing bracket, line " + line + ", position " + position);
                }

                final int forwardPosition = stack.pop();
                final int backwardPosition = getCommandInfoCount();
                ((BrainfuckJumpCommandInfo) COMMANDS.get(forwardPosition)).setJumpPosition(backwardPosition);
                COMMANDS.add(new BrainfuckJumpCommandInfo(command, tokenPosition, forwardPosition));
            } else if (command != BrainfuckCommand.NO_OPERATION) {
                COMMANDS.add(new BrainfuckCommandInfo(command, tokenPosition));
            } else if (ch == '\n') {
                line++;
                position = 0;
            } else if (ch == '\t') {
                position += TAB_SIZE;
                position /= TAB_SIZE;
                position *= TAB_SIZE;
            }
        }

        if (!stack.isEmpty()) {
            if (stack.size() == 1) {
                final Integer forwardPosition = stack.pop();
                final BrainfuckJumpCommandInfo forwardCommand = (BrainfuckJumpCommandInfo) COMMANDS.get(forwardPosition);
                final BrainfuckTokenPosition tokenPosition = forwardCommand.getTokenPosition();
                throw new BrainfuckInputException("Unmatched opening bracket, line " + tokenPosition.getLine() + ", position " + tokenPosition.getPosition());
            }

            throw new BrainfuckInputException("Unmatched opening brackets, count: " + stack.size());
        }
    }

    public int getCommandInfoCount() {
        return COMMANDS.size();
    }

    public BrainfuckCommandInfo getCommandInfo(final int position) {
        return COMMANDS.get(position);
    }

}
