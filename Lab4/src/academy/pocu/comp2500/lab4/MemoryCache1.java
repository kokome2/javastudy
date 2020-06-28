// MemoryCache.java
package academy.pocu.comp2500.lab4;
​
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
​
public class MemoryCache1 {
    private static HashMap<String, LinkedPairList.Node<MemoryCache1>> instances;
    private static LinkedPairList<MemoryCache1> recentlyUsedInstances;
    private static int maxInstanceCount;
​
    private final HashMap<String, LinkedPairList.Node<String>> entries;
    private final LinkedPairList<String> recentlyUsedEntries;
    private final Deque<LinkedPairList.Node<String>> sortedEntries;
    private int maxEntryCount;
    private EvictionPolicy evictionPolicy;
​
    private MemoryCache1() {
        this.entries = new HashMap<>();
        this.recentlyUsedEntries = new LinkedPairList<>();
        this.sortedEntries = new LinkedList<>();
        this.maxEntryCount = Integer.MAX_VALUE;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }
​
    public static MemoryCache1 getInstance(String drive) {
        if (instances == null) {
            instances = new HashMap<>();
            recentlyUsedInstances = new LinkedPairList<>();
            maxInstanceCount = Integer.MAX_VALUE;
        }
​
        assert (recentlyUsedInstances.getSize() <= maxInstanceCount) : "over max instance count";
​
        LinkedPairList.Node<MemoryCache1> node = instances.get(drive);
​
        // if not exists mapped instance node, create new node.
        if (node == null) {
            node = new LinkedPairList.Node<>(drive, new MemoryCache1());
            if (recentlyUsedInstances.getSize() == maxInstanceCount) {
                removeLruInstance();
            }
        } else {
            recentlyUsedInstances.remove(node);
        }
​
        recentlyUsedInstances.addFirst(node);
        instances.put(drive, node);
​
        return node.getValue();
    }
​
    public static void clear() {
        if (instances == null) {
            return;
        }
​
        instances.clear();
        recentlyUsedInstances.clear();
    }
​
    public static void setMaxInstanceCount(int maxInstanceCount) {
        if (instances == null) {
            return;
        }
​
        assert (maxInstanceCount > 0) : "instance count must be greater than 0.";
​
        MemoryCache1.maxInstanceCount = maxInstanceCount;
​
        while (recentlyUsedInstances.getSize() > maxInstanceCount) {
            removeLruInstance();
        }
    }
​
    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }
​
    public void addEntry(String key, String value) {
        assert (recentlyUsedEntries.getSize() <= maxEntryCount) : "over max entry count";
​
        LinkedPairList.Node<String> node = entries.get(key);
​
        // if not exists mapped entry node, create new node and add it to deque.
        if (node == null) {
            node = new LinkedPairList.Node<>(key, value);
            if (recentlyUsedEntries.getSize() == maxEntryCount) {
                removeEntry();
            }
            sortedEntries.addLast(node);
        } else {
            node.setValue(value);
            recentlyUsedEntries.remove(node);
        }
​
        recentlyUsedEntries.addFirst(node);
        entries.put(key, node);
    }
​
    public String getEntryOrNull(String key) {
        LinkedPairList.Node<String> node = entries.get(key);
​
        if (node == null) {
            return null;
        }
​
        // update MRU node.
        recentlyUsedEntries.remove(node);
        recentlyUsedEntries.addFirst(node);
​
        return node.getValue();
    }
​
    public void setMaxEntryCount(int maxEntryCount) {
        assert (maxEntryCount > 0) : "entry count must be greater than 0.";
​
        this.maxEntryCount = maxEntryCount;
​
        while (recentlyUsedEntries.getSize() > maxEntryCount) {
            removeEntry();
        }
    }
​
    private static void removeLruInstance() {
        assert (recentlyUsedInstances.getSize() > 0) : "list is empty";
​
        LinkedPairList.Node<MemoryCache1> tmp = recentlyUsedInstances.removeLast();
        instances.remove(tmp.getKey());
    }
​
    private void removeEntry() {
        assert (recentlyUsedEntries.getSize() > 0) : "list is empty";
        assert (recentlyUsedEntries.getSize() == sortedEntries.size()) : "list size is not match";
​
        LinkedPairList.Node<String> tmp = null;
​
        switch (evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                tmp = sortedEntries.removeFirst();
                recentlyUsedEntries.remove(tmp);
                break;
            case LAST_IN_FIRST_OUT:
                tmp = sortedEntries.removeLast();
                recentlyUsedEntries.remove(tmp);
                break;
            case LEAST_RECENTLY_USED:
                tmp = recentlyUsedEntries.removeLast();
                sortedEntries.remove(tmp);
                break;
            default:
                assert (false) : "unknown type";
                break;
        }
​
        assert (tmp != null) : "no entry removed";
        entries.remove(tmp.getKey());
    }
}
​
        // LinkedPairList.java
        package academy.pocu.comp2500.lab4;
        ​
public class LinkedPairList<T> {
    public static class Node<T> {
        private final String key;
        private T value;
        private Node<T> prev;
        private Node<T> next;
​
        public Node(String key, T value) {
            this.key = key;
            this.value = value;
        }
​
        public String getKey() {
            return key;
        }
​
        public T getValue() {
            return value;
        }
​
        public void setValue(T value) {
            this.value = value;
        }
    }
​
    private Node<T> head;
    private Node<T> tail;
    private int size;
​
    public LinkedPairList() {
    }
​
    public int getSize() {
        return size;
    }
​
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
​
    public void addFirst(Node<T> newNode) {
        assert (newNode != null) : "node is null";
​
        newNode.prev = null;
        newNode.next = head;
​
        if (size == 0) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
​
        head = newNode;
        size++;
    }
​
    public Node<T> removeLast() {
        assert (size > 0) : "list is empty";
​
        Node<T> tmp = tail;
​
        if (size == 1) {
            clear();
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
​
        return tmp;
    }
​
    public void remove(Node<T> node) {
        assert (size > 0) : "list is empty";
        assert (node != null) : "node is null";
        //assert (isExists(node)) : "node is not exists";
​
        if (size == 1) {
            clear();
            return;
        }
​
        Node<T> prev = node.prev;
        Node<T> next = node.next;
​
        if (node == head) {
            head = next;
            head.prev = null;
        } else if (node == tail) {
            tail = prev;
            tail.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
​
        size--;
    }
​
    private boolean isExists(Node<T> node) {
        Node<T> p = head;
​
        while (p != null) {
            if (p == node) {
                return true;
            }
            p = p.next;
        }
​
        return false;
    }
}