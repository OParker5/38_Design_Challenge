
public class EnhancementId {
    private String id;

    public EnhancementId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EnhancementId that = (EnhancementId) obj;
        return id != null ? id.equals(that.id) : that.id == null;
    }
}
