package ls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Listing {
    private final String path;

    public Listing(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public JsonFile[] getFiles() {
        return readDirectory(path);
    }

    private JsonFile[] readDirectory(final String path) {
        final File folder = new File(path);
        final File[] files = folder.listFiles();

        JsonFile[] jsonFiles = new JsonFile[files.length];

        for (int i = 0; i < files.length; i++) {
            final File file = files[i];
            JsonFile jsonFile = new JsonFile();

            jsonFile.setPath(file.getPath());
            jsonFile.setSize(file.length());

            try {
                BasicFileAttributes attributes = Files.readAttributes(Paths.get(path), BasicFileAttributes.class);

                jsonFile.setCreationTime(attributes.creationTime().toString());
                jsonFile.setLastAccessTime(attributes.lastAccessTime().toString());
                jsonFile.setLastModifiedTime(attributes.lastModifiedTime().toString());
                jsonFile.setRegularFile(attributes.isRegularFile());
                jsonFile.setDirectory(attributes.isDirectory());
                jsonFile.setSymbolicLink(attributes.isSymbolicLink());
                jsonFile.setOther(attributes.isOther());
            } catch (IOException e) {
                e.printStackTrace();
            }
            jsonFiles[i] = jsonFile;
        }

        return jsonFiles;
    }
}