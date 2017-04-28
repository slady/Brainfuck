package ps.java.brainfuck;

import ps.java.brainfuck.data.BrainfuckDataStorage;
import ps.java.brainfuck.data.BrainfuckLimitedDataStorage;
import ps.java.brainfuck.io.BrainfuckInputOutput;
import ps.java.brainfuck.io.BrainfuckStringInputOutput;
import ps.java.brainfuck.parser.BrainfuckCommandInfo;
import ps.java.brainfuck.parser.BrainfuckJumpCommandInfo;
import ps.java.brainfuck.parser.BrainfuckParser;

/**
 * This is an interpreter for the Brainfuck esoteric programming language.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Brainfuck">Brainfuck from Wikipedia</a>
 * @author slady@slady.net
 */
public class Brainfuck {

    public static void run(final BrainfuckParser parser, final BrainfuckDataStorage dataStorage, final BrainfuckInputOutput inputOutput) {
        int pointer = 0;

        while (pointer < parser.getCommandInfoCount()) {
            final BrainfuckCommandInfo commandInfo = parser.getCommandInfo(pointer);
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
                    dataStorage.setValue(inputOutput.input());
                    break;

                case JUMP_FORWARD:
                    if (dataStorage.getValue() == 0) {
                        pointer = ((BrainfuckJumpCommandInfo) commandInfo).getJumpPosition();
                    }

                    break;

                case JUMP_BACKWARD:
                    if (dataStorage.getValue() != 0) {
                        pointer = ((BrainfuckJumpCommandInfo) commandInfo).getJumpPosition();
                    }

                    break;

                case NO_OPERATION:
                default:
                    break;
            }

            pointer++;
        }
    }

    public static String run(final String program, final String input) {
        final BrainfuckParser parser = new BrainfuckParser(program);
        final BrainfuckLimitedDataStorage dataStorage = new BrainfuckLimitedDataStorage();
        final BrainfuckStringInputOutput inputOutput = new BrainfuckStringInputOutput(input);
        run(parser, dataStorage, inputOutput);
        return inputOutput.getOutput();
    }

}
