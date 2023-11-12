package gr.ihu.ict.linkedin.data.importer.util;

import io.vavr.control.Try;

import java.io.File;

public abstract class FileUtils {
    public static Try<File> getTempFile() {
        return Try.of(() -> File.createTempFile("linkedin-data-importer", "tmp"));
    }

    public static Try<File> getFileFromPath(final String fileName, final String filePath) {
        return Try.of(() -> String.format("%s%s%s", filePath, File.separator, fileName))
                .flatMap(fullFilePath -> Try.of(() -> new File(fullFilePath)));
    }
}
