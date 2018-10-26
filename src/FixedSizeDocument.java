import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FixedSizeDocument extends PlainDocument {

    private int max = 10;

    public FixedSizeDocument(int paramInt) {
        max = paramInt;
    }

    public void insertString(int paramInt, String paramString, AttributeSet paramAttributeSet)
            throws BadLocationException {
        if (getLength() + paramString.length() > max) {

            paramString = paramString.substring(0, max - getLength());
        }
        super.insertString(paramInt, paramString, paramAttributeSet);
    }
}
