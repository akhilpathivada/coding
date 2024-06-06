/**
 * author: akhilpathivada
 * time: 06/06/24 16:00
 *
 * https://leetcode.com/problems/design-a-text-editor/
 *
 */
package design;

public class TextEditor {

    private final StringBuilder text;

    private int cursor;

    public TextEditor() {
        this.text = new StringBuilder();
        this.cursor = 0;
    }

    public void addText(String text) {
        this.text.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int end = cursor;
        cursor = Math.max(cursor - k, 0);
        text.delete(cursor, end);
        return end - cursor;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(cursor - k, 0);
        return cursor < 10 ? text.substring(0, cursor) : text.substring(cursor - 10, cursor);
    }

    public String cursorRight(int k) {
        cursor = Math.min(cursor + k, text.length());
        return cursor < 10 ? text.substring(0, cursor) : text.substring(cursor - 10, cursor);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
        textEditor.addText("leetcode"); // The current text is "leetcode|".
        System.out.println(textEditor.deleteText(4)); // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        textEditor.addText("practice"); // The current text is "leetpractice|".
        System.out.println(textEditor.cursorRight(3)); // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(8)); // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.deleteText(10)); // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.cursorLeft(2)); // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(6)); // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.
    }
}
