package academy.pocu.comp2500.lab3;
​
import java.util.ArrayList;
​
public class ListItem3 {
    private String text;
    private final ArrayList<ListItem3> sublistItems = new ArrayList<>();
    private char bulletStyle = '*';
​

    public ListItem3(String text) {
        this.text = text;
    }
​

    public ListItem3(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
    }
​

    public String getText() {
        return text;
    }
​

    public void setText(String text) {
        this.text = text;
    }
​

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }
​

    public char getBulletStyle() {
        return bulletStyle;
    }
​

    public ListItem3 getSublistItem(int index) {
        return sublistItems.get(index);
    }
​

    public void addSublistItem(ListItem3 sublistItem) {
        sublistItems.add(sublistItem);
    }
​

    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }
​

    private String toStringRecursive(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        sb.append(String.format("%c %s%s", bulletStyle, text, System.lineSeparator()));
​
        for (ListItem3 item : sublistItems) {
            sb.append(item.toStringRecursive(depth + 1));
        }
​
        return sb.toString();
    }
​

    public String toString() {
        return toStringRecursive(0);
    }
}