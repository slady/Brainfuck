package ps.java.brainfuck;

import ps.java.brainfuck.data.BrainfuckDataStorage;
import ps.java.brainfuck.data.BrainfuckLimitedDataStorage;
import ps.java.brainfuck.io.BrainfuckInputOutput;
import ps.java.brainfuck.io.BrainfuckStringInputOutput;

/**
 * This is an interpreter for the Brainfuck esoteric programming language.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Brainfuck">Brainfuck from Wikipedia</a>
 * @author slady@slady.net
 */
public class Brainfuck {

    public static void run(final BrainfuckDataStorage dataStorage, final BrainfuckInputOutput inputOutput) {
        inputOutput.output('8');
    }

    public static String run(final String program, final String input) {
        final BrainfuckLimitedDataStorage dataStorage = new BrainfuckLimitedDataStorage();
        final BrainfuckStringInputOutput inputOutput = new BrainfuckStringInputOutput(input);
        run(dataStorage, inputOutput);
        return inputOutput.getOutput();
    }

}
