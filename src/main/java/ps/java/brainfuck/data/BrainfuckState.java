package ps.java.brainfuck.data;

import ps.java.brainfuck.Brainfuck;
import ps.java.brainfuck.io.BrainfuckInputOutput;
import ps.java.brainfuck.parser.BrainfuckParser;

/**
 * This is a runtime State class
 * for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckState {

    private final BrainfuckParser parser;

    private final BrainfuckDataStorage dataStorage;

    private final BrainfuckInputOutput inputOutput;

    private int pointer = 0;

    private boolean running = true;

    private int instructionCounter;

    public BrainfuckState(final BrainfuckParser parser, final BrainfuckDataStorage dataStorage, final BrainfuckInputOutput inputOutput) {
        this.parser = parser;
        this.dataStorage = dataStorage;
        this.inputOutput = inputOutput;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public void increasePointer() {
        pointer++;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(final boolean running) {
        this.running = running;
    }

    public int getInstructionCounter() {
        return instructionCounter;
    }

    public void increaseInstructionCounter() {
        this.instructionCounter++;
    }

    public BrainfuckParser getParser() {
        return parser;
    }

    public BrainfuckDataStorage getDataStorage() {
        return dataStorage;
    }

    public BrainfuckInputOutput getInputOutput() {
        return inputOutput;
    }

}
