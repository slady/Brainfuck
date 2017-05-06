package ps.java.brainfuck;

import ps.java.brainfuck.data.BrainfuckDataStorage;
import ps.java.brainfuck.data.BrainfuckLimitedDataStorage;
import ps.java.brainfuck.data.BrainfuckState;
import ps.java.brainfuck.exceptions.BrainfuckInputException;
import ps.java.brainfuck.io.BrainfuckInputOutput;
import ps.java.brainfuck.io.BrainfuckStringInputOutput;
import ps.java.brainfuck.parser.BrainfuckCommandInfo;
import ps.java.brainfuck.parser.BrainfuckJumpCommandInfo;
import ps.java.brainfuck.parser.BrainfuckParser;
import ps.java.brainfuck.parser.BrainfuckTokenPosition;

/**
 * This is an interpreter for the Brainfuck esoteric programming language.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Brainfuck">Brainfuck from Wikipedia</a>
 * @author slady@slady.net
 */
public class Brainfuck {

    public static void run(final BrainfuckParser parser, final BrainfuckDataStorage dataStorage, final BrainfuckInputOutput inputOutput) {
        final BrainfuckState state = new BrainfuckState(parser, dataStorage, inputOutput);

        while (state.getPointer() < parser.getCommandInfoCount()) {
            step(state);
        }
    }

    public static void step(final BrainfuckState state) {
        final BrainfuckParser parser = state.getParser();
        final BrainfuckDataStorage dataStorage = state.getDataStorage();
        final BrainfuckInputOutput inputOutput = state.getInputOutput();

        final BrainfuckCommandInfo commandInfo = parser.getCommandInfo(state.getPointer());
        switch (commandInfo.getCommand()) {
            case INCREMENT_POINTER:
                dataStorage.incrementPointer();
                break;

            case DECREMENT_POINTER:
                dataStorage.decrementPointer();
                break;

            case INCREASE_VALUE:
                dataStorage.increaseValue();
                break;

            case DECREASE_VALUE:
                dataStorage.decreaseValue();
                break;

            case OUTPUT:
                inputOutput.output(dataStorage.getValue());
                break;

            case INPUT:
                try {
                    dataStorage.setValue(inputOutput.input());
                } catch (final StringIndexOutOfBoundsException e) {
                    final BrainfuckTokenPosition tokenPosition = commandInfo.getTokenPosition();
                    throw new BrainfuckInputException("Reading after input ended, line " + tokenPosition.getLine() + ", position " + tokenPosition.getPosition());
                }
                break;

            case JUMP_FORWARD:
                if (dataStorage.getValue() == 0) {
                    state.setPointer(((BrainfuckJumpCommandInfo) commandInfo).getJumpPosition());
                }

                break;

            case JUMP_BACKWARD:
                if (dataStorage.getValue() != 0) {
                    state.setPointer(((BrainfuckJumpCommandInfo) commandInfo).getJumpPosition());
                }

                break;

            case NO_OPERATION:
            default:
                break;
        }

        state.increasePointer();
    }

    public static String run(final String program, final String input) {
        final BrainfuckParser parser = new BrainfuckParser(program);
        final BrainfuckLimitedDataStorage dataStorage = new BrainfuckLimitedDataStorage();
        final BrainfuckStringInputOutput inputOutput = new BrainfuckStringInputOutput(input);
        run(parser, dataStorage, inputOutput);
        return inputOutput.getOutput();
    }

}
