package academy.pocu.comp2500.lab4;
public class Program {

    public static void main(String[] args) {
        {
            //entry test
            MemoryCache memCache = MemoryCache.getInstance("A");
            memCache.setMaxEntryCount(5);
            memCache.addEntry("key1", "value1");
            memCache.addEntry("key2", "value2");
            memCache.addEntry("key3", "value3");
            memCache.addEntry("key4", "value4");
            memCache.addEntry("key5", "value5");
            memCache.addEntry("key6", "value6");
            assert memCache.getEntryOrNull("key1") == null;
            assert memCache.getEntryOrNull("key2").equals("value2");
            //LRU - set MaxEntryCont Test
            memCache.setMaxEntryCount(3);
            assert memCache.getEntryOrNull("key2").equals("value2");
            assert memCache.getEntryOrNull("key3") == null;
            assert memCache.getEntryOrNull("key4") == null;
            assert memCache.getEntryOrNull("key5").equals("value5");
            assert memCache.getEntryOrNull("key6").equals("value6");
            //FIFO - Set FIFO test;
            MemoryCache memCache2 = MemoryCache.getInstance("B");
            memCache2.setMaxEntryCount(5);
            memCache2.addEntry("key1", "value1");
            memCache2.addEntry("key2", "value2");
            memCache2.addEntry("key3", "value3");
            memCache2.addEntry("key4", "value4");
            assert memCache2.getEntryOrNull("key3").equals("value3");
            memCache2.addEntry("key5", "value5");
            memCache2.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);
            memCache2.setMaxEntryCount(3);
            assert memCache2.getEntryOrNull("key1") == null;
            assert memCache2.getEntryOrNull("key2") == null;
            assert memCache2.getEntryOrNull("key3").equals("value3");
            assert memCache2.getEntryOrNull("key4").equals("value4");
            assert memCache2.getEntryOrNull("key5").equals("value5");
            //LIFO - set LIFO test;
            MemoryCache memCache3 = MemoryCache.getInstance("C");
            memCache3.setMaxEntryCount(5);
            memCache3.addEntry("key1", "value1");
            memCache3.addEntry("key2", "value2");
            memCache3.addEntry("key3", "value3");
            memCache3.addEntry("key4", "value4");
            assert memCache3.getEntryOrNull("key3").equals("value3");
            memCache3.addEntry("key5", "value5");
            memCache3.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
            memCache3.setMaxEntryCount(3);
            assert memCache3.getEntryOrNull("key1").equals("value1");
            assert memCache3.getEntryOrNull("key2").equals("value2");
            assert memCache3.getEntryOrNull("key3").equals("value3");
            assert memCache3.getEntryOrNull("key4") == null;
            assert memCache3.getEntryOrNull("key5") == null;
        }

    }
}