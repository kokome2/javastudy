package academy.pocu.comp2500.lab3;
​
import java.util.ArrayList;
import java.util.List;
​
public class ListItem2 {
    private String text;
    private char bulletStyle;
    private final ArrayList<ListItem2> sublistItem;
    private final StringBuilder stringBuilder;
​

    public ListItem2(String text) {
        this(text, '*');
    }
​

    public ListItem2(String text, char bulletStyle) {
        this.text = text;
        this.sublistItem = new ArrayList<ListItem2>();
        this.stringBuilder = new StringBuilder();
        this.stringBuilder.ensureCapacity(1024);
        this.bulletStyle = bulletStyle;
    }
​

    public String getText() {
        return this.text;
    }
​

    public void setText(String text) {
        this.text = text;
    }
​

    public char getBulletStyle() {
        return this.bulletStyle;
    }
​

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }
​

    public void addSublistItem(ListItem sublist) {
        this.sublistItem.add(sublist);
    }
​

    public void removeSublistItem(int index) {
        this.sublistItem.remove(index);
    }
​

    public ListItem2 getSublistItem(int index) {
        return this.sublistItem.get(index);
    }
​

    public String toString() {
        if (this.stringBuilder.length() != 0) {
            this.stringBuilder.setLength(0);
        }
​
        int subLevel = 0;
        checkBulletStyleToString(this, subLevel);
        checkSublistRecursive(this.sublistItem, ++subLevel);
​
        return this.stringBuilder.toString();
    }
​

    private void checkSublistRecursive(ArrayList<ListItem2> listItems, int subLevel) {
        if (0 == listItems.size()) {
            return;
        }
​
        for (ListItem2 sublistItemObj : listItems) {
            checkBulletStyleToString(sublistItemObj, subLevel);
            checkSublistRecursive(sublistItemObj.sublistItem, ++subLevel);
            --subLevel;
        }
    }

    private void checkBulletStyleToString(ListItem2 listItem, int subLevel) {
        for (int i = 0; i < subLevel; ++i) {
            this.stringBuilder.append("    ");
        }
        this.stringBuilder.append(listItem.bulletStyle);
        this.stringBuilder.append(' ');
        this.stringBuilder.append(listItem.text);
        this.stringBuilder.append(System.lineSeparator());
    }
}
