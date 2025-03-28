import java.util.HashMap;
import java.util.Map;

public class AppCache {
    // Store the mapping from EnhancementId to ConfigurationData.
    private Map<EnhancementId, ConfigurationData> cache;
    
    // Instance of AppCache to ensure only one instance exists.
    private static AppCache instance;
    
    
    private AppCache() {
        // Initialize the cache.
        cache = new HashMap<>();
    }
    
    // Method to provide access to the single instance.
    // Synchronized to ensure thread safety in a multi-threaded environment.
    public static synchronized AppCache getInstance() {
        if (instance == null) {
            instance = new AppCache();
        }
        return instance;
    }
    
    // Method to add or update cached data.
    public void set(EnhancementId enhancementId, ConfigurationData configurationData) {
        cache.put(enhancementId, configurationData);
    }
    
    // Method to retrieve cached data.
    public ConfigurationData get(EnhancementId enhancementId) {
        return cache.get(enhancementId);
    }
}
