# lsdir

Note: this was written for Docker 1.12. Results may vary for other versions.

1. `./gradlew build` - compiles the app (add `--debug-jvm` for debugging)
2. `docker build -t lsdir .` - builds the image
3. `docker run --rm -d -p 8080:8080 v /:/filesystem lsdir` - runs the image & the app
4. GET `localhost:8080/listing` (with optional `path` query param)
5. Observe JSON result!
