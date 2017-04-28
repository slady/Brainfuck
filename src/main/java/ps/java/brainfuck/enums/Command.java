package ps.java.brainfuck.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    private static final Map<Character, Command> MAP = Arrays.stream(values()).collect(Collectors.toMap(Command::getDefChar, x -> x));

    private final Character defChar;

    Command(final Character ch) {
        this.defChar = ch;
    }

    private Character getDefChar() {
        return defChar;
    }

    public static Command getCommand(final char ch) {
        if (!MAP.containsKey(ch)) {
            return NO_OPERATION;
        }

        return MAP.get(ch);
    }

}
