package academy.pocu.comp2500.lab4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MemoryCache {
    private static EvictionPolicy mPolicy;
    private static int mMaxSize = Integer.MAX_VALUE;
    private static int mMaxEntryCount = Integer.MAX_VALUE;
    private LinkedHashMap<String, String> cache = new LinkedHashMap<String, String>();
    private static LinkedHashMap<String, MemoryCache> mMemoryCache = new LinkedHashMap<String, MemoryCache>
            (1000, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry<String, MemoryCache> eldest) {
            return mMemoryCache.size() > mMaxSize;
        }
    };

    private MemoryCache() {
    }

    public static MemoryCache getInstance(String hardDisk) {
        if (mMemoryCache.size() > mMaxSize) {
            Iterator<String> it = mMemoryCache.keySet().iterator();
            for (int i = 1; i < mMemoryCache.size() - mMaxSize; i++) {
                String keys = it.next();
                mMemoryCache.remove(keys);
            }
        }
        if (!mMemoryCache.containsKey(hardDisk)) {
            mMemoryCache.put(hardDisk, new MemoryCache());
            return mMemoryCache.get(hardDisk);
        } else {
            return mMemoryCache.get(hardDisk);
        }
    }

    public static void setEvictionPolicy(EvictionPolicy policy) {
        if (policy == EvictionPolicy.FIRST_IN_FIRST_OUT) {
            mPolicy = EvictionPolicy.FIRST_IN_FIRST_OUT;
        } else if (policy == EvictionPolicy.LAST_IN_FIRST_OUT) {
            mPolicy = EvictionPolicy.LAST_IN_FIRST_OUT;
        } else {
            mPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        }
    }

    public void addEntry(String key, String value) {
        if (cache.size() > mMaxEntryCount) {
            Iterator<String> it = cache.keySet().iterator();
            for (int i = 1; i < cache.size() - mMaxEntryCount; i++) {
                String keys = it.next();
                cache.put(keys, null);
            }
        }

        cache.put(key, value);
    }

    public String getEntryOrNull(String key) {
        return this.cache.getOrDefault(key, null);
    }

    public static void clear() {
        mMemoryCache.clear();
    }

    public static void setMaxInstanceCount(int maxCount) {
        mMaxSize = maxCount;
        if (mMemoryCache.size() > mMaxSize) {
            Iterator<String> it = mMemoryCache.keySet().iterator();
            for (int i = 1; i < mMemoryCache.size() - mMaxSize; i++) {
                String keys = it.next();
                mMemoryCache.remove(keys);
            }
        }
    }

    public void setMaxEntryCount(int maxCount) {
        mMaxEntryCount = maxCount;
        if (cache.size() > mMaxEntryCount) {
            Iterator<String> it = cache.keySet().iterator();
            for (int i = 1; i < cache.size() - mMaxEntryCount; i++) {
                String keys = it.next();
                cache.put(keys, null);
            }
        }
    }
}