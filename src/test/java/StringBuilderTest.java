import org.rkov.string.undo.StringBuilder;

import junit.framework.TestCase;

/**
 *
 * @author yakov
 */
public class StringBuilderTest extends TestCase {

    public void testSusscessUndo() {
        var customSB = new StringBuilder();

        customSB.append("old text");

        customSB.append(" new text");

        assertEquals("old text new text", customSB.toString());

        customSB.undo();

        assertEquals("old text", customSB.toString());
    }

}
