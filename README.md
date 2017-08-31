# lsdir

Note: this was written for Docker 1.12. Results may vary for other versions.

1. `./gradlew build` - compiles the app
2. `docker build -t lsdir .` - builds the image
3. `docker run --rm -t -i -p 8080:8080 -v /:/filesystem lsdir` - runs the image & the app
4. GET `localhost:8080/listing` (with optional `path` query param)
5. Observe JSON result!

## URL params

### path

Specify the path to list. Defaults to `/` of the host system.

### size

Specify how many files to show at once. Defaults to 100.

### page

Specify which set of files to show. `page=0` shows the first `size` files, `page=1` shows the second `size` files, and so on. Defaults to 0.
