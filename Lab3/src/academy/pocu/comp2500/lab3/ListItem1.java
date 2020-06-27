package academy.pocu.comp2500.lab3;
​
import java.util.ArrayList;
​
public class ListItem1 {
    private String text;
    private char bulletStyle;
    private ArrayList<ListItem1> sublistItems = new ArrayList<>();
​
    public ListItem1(String text) {
        this(text, '*');
    }
​
    public ListItem1(String text, char bulletStyle) {
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
    public char getBulletStyle() {
        return bulletStyle;
    }
​
    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }
​
    public void addSublistItem(ListItem1 sublistItem) {
        sublistItems.add(sublistItem);
    }
​
    public ListItem1 getSublistItem(int index) {
        return sublistItems.get(index);
    }
​
    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }
​
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        toString(builder, 0);
        return builder.toString();
    }
​
    private void toString(StringBuilder builder, int level) {
        for (int i = 0; i < level; i++) {
            builder.append("    ");
        }
        builder.append(bulletStyle);
        builder.append(" ");
        builder.append(text);
        builder.append(System.lineSeparator());
​
        for (ListItem1 item : sublistItems) {
            item.toString(builder, level + 1);
        }
    }
}