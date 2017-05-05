package ps.java.brainfuck.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Brainfuck Commands.
 * @author slady@slady.net
 */
public enum BrainfuckCommand {

    INCREMENT_POINTER('>'),
    DECREMENT_POINTER('<'),
    INCREASE_VALUE('+'),
    DECREASE_VALUE('-'),
    OUTPUT('.'),
    INPUT(','),
    JUMP_FORWARD('['),
    JUMP_BACKWARD(']'),
    NO_OPERATION(null);

    private static final Map<Character, BrainfuckCommand> MAP = Arrays.stream(values()).collect(Collectors.toMap(BrainfuckCommand::getDefChar, x -> x));

    private final Character defChar;

    BrainfuckCommand(final Character ch) {
        this.defChar = ch;
    }

    private Character getDefChar() {
        return defChar;
    }

    public static BrainfuckCommand getCommand(final char ch) {
        if (!MAP.containsKey(ch)) {
            return NO_OPERATION;
        }

        return MAP.get(ch);
    }

}
