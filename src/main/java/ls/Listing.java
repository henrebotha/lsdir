package ls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Listing {
    private final String path;
    private final int page;
    private final int size;

    public Listing(String path, int page, int size) {
        this.path = path;
        this.page = page;
        this.size = size;
    }

    public String getPath() {
        return path.replaceFirst("/filesystem", "")
                .replaceFirst("^$", "/"); // Edge case - empty string
    }

    public JsonFile[] getFiles() {
        return readDirectory();
    }

    private JsonFile[] readDirectory() {
        final Path dir = Paths.get(path);
        Stream<Path> files = null;

        try {
            // Get a stream of files
            files = Files.list(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (files == null) {
            // Return early if we hit an exception previously
            return null;
        }

        final int start = page * size;

        // Slice the folder listing, and convert to array of Paths
        final Path[] filteredFiles = files.skip(start).limit(size).toArray(Path[]::new);

        final int filteredSize = Math.min(filteredFiles.length, size);
        JsonFile[] jsonFiles = new JsonFile[filteredSize];

        for (int i = 0; i < filteredSize; i++) {
            final Path filteredPath = filteredFiles[i];
            final File file = filteredPath.toFile();
            JsonFile jsonFile = new JsonFile();

            jsonFile.setPath(file.getPath().replaceFirst("/filesystem", ""));
            jsonFile.setSize(file.length());

            try {
                BasicFileAttributes attributes = Files.readAttributes(filteredPath, BasicFileAttributes.class);

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