import java.util.HashMap;
import java.util.Map;

public class AppCache {
    // 1. A private field to store the mapping from EnhancementId to ConfigurationData.
    private Map<EnhancementId, ConfigurationData> cache;
    
    // 2. A private static instance of AppCache to ensure only one instance exists.
    private static AppCache instance;
    
    // 3. Private constructor prevents external instantiation.
    private AppCache() {
        // Initialize the cache.
        cache = new HashMap<>();
    }
    
    // 4. Public static method to provide access to the single instance.
    // Synchronized to ensure thread safety in a multi-threaded environment.
    public static synchronized AppCache getInstance() {
        if (instance == null) {
            instance = new AppCache();
        }
        return instance;
    }
    
    // 5. Method to add or update cached data.
    public void set(EnhancementId enhancementId, ConfigurationData configurationData) {
        cache.put(enhancementId, configurationData);
    }
    
    // 6. Method to retrieve cached data.
    public ConfigurationData get(EnhancementId enhancementId) {
        return cache.get(enhancementId);
    }
}
