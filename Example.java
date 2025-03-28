public class ExampleUsage {
    public static void main(String[] args) {
        // Obtain the single AppCache instance.
        AppCache cache = AppCache.getInstance();
        
        // Assume EnhancementId and ConfigurationData have proper constructors.
        EnhancementId enhId = new EnhancementId(...); // Replace with actual instantiation.
        ConfigurationData configData = new ConfigurationData(...); // Replace with actual instantiation.
        
        // Add or update cached data.
        cache.set(enhId, configData);
        
        // Retrieve the cached data.
        ConfigurationData retrievedData = cache.get(enhId);
        System.out.println("Retrieved Data: " + retrievedData);
    }
}

