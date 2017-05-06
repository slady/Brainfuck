package ps.java.brainfuck.data;

import ps.java.brainfuck.Brainfuck;

/**
 * This is a runtime State class
 * for the {@link Brainfuck} esoteric programming language.
 *
 * @author slady@slady.net
 */
public class BrainfuckState {

    private int pointer = 0;

    private boolean running = true;

    private int instructionCounter;

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

}
