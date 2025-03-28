public class Example {
    public static void main(String[] args) {
        // Obtain the single AppCache instance.
        AppCache cache = AppCache.getInstance();
        
        EnhancementId enhId = new EnhancementId("hi6922"); 
        ConfigurationData configData = new ConfigurationData("Config"); 
        // Add or update cached data.
        cache.set(enhId, configData);
        
        // Retrieve the cached data.
        ConfigurationData retrievedData = cache.get(enhId);
        System.out.println("Retrieved Data: " + retrievedData);
        
    }
}