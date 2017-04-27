package ps.java.brainfuck.enums;

import ps.java.brainfuck.Brainfuck;
import ps.java.brainfuck.exceptions.BrainfuckInputException;

import java.util.HashMap;
import java.util.Map;

/**
 * Brainfuck Commands.
 * @author slady@slady.net
 */
public enum Command {

    INCREMENT_POINTER('>'),
    DECREMENT_POINTER('<'),
    INCREASE_VALUE('+'),
    DECREASE_VALUE('-'),
    OUTPUT('.'),
    INPUT(','),
    JUMP_FORWARD('['),
    JUMP_BACKWARD(']'),
    NO_OPERATION(null);

    private static final Map<Character, Command> MAP = new HashMap<>();

    private final Character defChar;

    Command(final Character ch) {
        this.defChar = ch;
    }

    static {
        for (final Command command : values()) {
            MAP.put(command.defChar, command);
        }
    }

    public static Command getCommand(final char ch) {
        if (!MAP.containsKey(ch)) {
            return NO_OPERATION;
        }

        return MAP.get(ch);
    }

}
