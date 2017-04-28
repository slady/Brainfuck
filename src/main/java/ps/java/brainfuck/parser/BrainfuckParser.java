package ps.java.brainfuck.parser;

import ps.java.brainfuck.enums.Command;
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

    private final List<BrainfuckCommandInfo> COMMANDS = new ArrayList<>();

    public BrainfuckParser(final String program) {
        final Stack<Integer> stack = new Stack<>();

        for (final char ch : program.toCharArray()) {
            final Command command = Command.getCommand(ch);

            if (command == Command.JUMP_FORWARD) {
                stack.push(COMMANDS.size());
                COMMANDS.add(new BrainfuckJumpCommandInfo(command));
            } else if (command == Command.JUMP_BACKWARD) {
                if (stack.isEmpty()) {
                    throw new BrainfuckInputException("Unmatched closing bracket");
                }

                final int forwardPosition = stack.pop();
                final int backwardPosition = getCommandInfoCount();
                ((BrainfuckJumpCommandInfo) COMMANDS.get(forwardPosition)).setJumpPosition(backwardPosition);
                COMMANDS.add(new BrainfuckJumpCommandInfo(command, forwardPosition));
            } else if (command != Command.NO_OPERATION) {
                COMMANDS.add(new BrainfuckCommandInfo(command));
            }
        }

        if (!stack.isEmpty()) {
            throw new BrainfuckInputException("Unmatched opening brackets: " + stack.size());
        }
    }

    public int getCommandInfoCount() {
        return COMMANDS.size();
    }

    public BrainfuckCommandInfo getCommandInfo(final int position) {
        return COMMANDS.get(position);
    }

}
