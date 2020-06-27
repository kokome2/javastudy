package academy.pocu.comp2500.lab3;
import java.util.ArrayList;
public class ListItem {
    private String text;
    private final ArrayList<ListItem> sublistItems;
    private char bulletStyle;
    private static final String SPACE = "    ";

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.sublistItems = new ArrayList<>();
        this.bulletStyle = bulletStyle;
    }
​
    public ListItem(String text) {
        this(text, '*');
    }
​
    public String getText() {
        return this.text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }
​
    public void setText(String text) {
        this.text = text;
    }
​
    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public ListItem getSublistItem(int index) {
        return this.sublistItems.get(index);
    }

    public void addSublistItem(ListItem item) {
        this.sublistItems.add(item);
    }
​
    public void removeSublistItem(int index) {
        this.sublistItems.remove(index);
    }
​
    public String toString() {
        StringBuilder sb = new StringBuilder(4096);
        appendStringRecursive(sb, this, 0);
        return sb.toString();
    }
​
    private void appendStringRecursive(StringBuilder sb, ListItem item, int level) {
        sb.append(String.format("%s%c %s%s", SPACE.repeat(level), item.getBulletStyle(), item.getText(), System.lineSeparator()));
        for (ListItem sublistItem : item.sublistItems) {
            appendStringRecursive(sb, sublistItem, level + 1);
        }
    }
}