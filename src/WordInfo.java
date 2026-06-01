import java.util.HashSet;
import java.util.Set;

public class WordInfo {
    private int frequency;
    private Set<Integer> lineNumbers;

    public WordInfo() {
        frequency = 0;
        lineNumbers = new HashSet<>();
    }
    public void addOccurrence(int lineNumber) {
        frequency++;
        lineNumbers.add(lineNumber);
    }
    public int getFrequency() {
        return frequency;
    }

    public Set<Integer> getLineNumbers() {
        return lineNumbers;
    }

    @Override
    public String toString() {
        return "Frequency = " + frequency +
                ", Lines = " + lineNumbers;
    }
}