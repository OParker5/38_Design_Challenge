
public class ConfigurationData {
    private String data;

    public ConfigurationData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}
