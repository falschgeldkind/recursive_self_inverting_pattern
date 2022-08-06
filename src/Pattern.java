import java.util.Iterator;
import java.util.LinkedList;

public class Pattern extends LinkedList<Boolean> {

    private String patternString;

    public Pattern(String patternString) throws ErroneousPatternException {
        this.patternString = patternString;
        producePattern();
    }

    public Pattern() {
    }

    private void producePattern() throws ErroneousPatternException {
        for(char c : patternString.toCharArray()) {
            switch (c) {
                case '0' -> this.add(Boolean.FALSE);
                case '1' -> this.add(Boolean.TRUE);
                default -> throw new ErroneousPatternException(c);
            }
        }
    }

    private Pattern invert() {
        Pattern inverted = new Pattern();
        for(Boolean b : this) {
            inverted.add(!b);
        }
        return inverted;
    }

    public Pattern iterate() throws ErroneousPatternException {
        Pattern newPattern = new Pattern();
        for (Boolean b : this) {
            // Invert pattern if true
            if(b) {
                newPattern.addAll(this.invert());
            } else {
                newPattern.addAll(this);
            }
        }
        return newPattern;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("[");
        for (Iterator<Boolean> i = this.iterator(); i.hasNext();) {
            if(i.next()) {
                toReturn.append("1");
            } else {
                toReturn.append("0");
            }
            if(i.hasNext()) {
                toReturn.append(", ");
            }
        }
        toReturn.append("]");
        return toReturn.toString();
    }
}
