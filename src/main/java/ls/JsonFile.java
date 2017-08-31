package ls;

public class JsonFile {
    private String creationTime;
    private boolean isDirectory;
    private boolean isOther;
    private boolean isRegularFile;
    private boolean isSymbolicLink;
    private String lastAccessTime;
    private String lastModifiedTime;
    private String path;
    private long size;

    public JsonFile() {
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(final boolean directory) {
        isDirectory = directory;
    }

    public boolean isOther() {
        return isOther;
    }

    public void setOther(final boolean other) {
        isOther = other;
    }

    public boolean isRegularFile() {
        return isRegularFile;
    }

    public void setRegularFile(final boolean regularFile) {
        isRegularFile = regularFile;
    }

    public boolean isSymbolicLink() {
        return isSymbolicLink;
    }

    public void setSymbolicLink(final boolean symbolicLink) {
        isSymbolicLink = symbolicLink;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(final String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(final long size) {
        this.size = size;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(final String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(final String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}
