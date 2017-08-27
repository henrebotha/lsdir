package ls;

public class JsonFile {
    private String path;
    private long size;
    private String creationTime;
    private String lastAccessTime;

    public JsonFile() {
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setSize(final long size) {
        this.size = size;
    }

    public void setCreationTime(final String creationTime) {
        this.creationTime = creationTime;
    }

    public void setLastAccessTime(final String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}
