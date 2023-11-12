package gr.ihu.ict.linkedin.data.importer.util;

import io.vavr.control.Try;
import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.nio.file.Path;

public abstract class ZipUtil {
    public static Try<Path> unzipInTempPath(final File zipFile) {
        return FileUtils.getTempFile()
                .flatMap(tempFile -> Try.of(() -> {
                    String tmpFileName = tempFile.getName();
                    String tmpFileParentPath = tempFile.getParentFile().getAbsolutePath();
                    String zipFileName = zipFile.getName();

                    return String.format(
                            "%s%s%s_%s",
                            tmpFileParentPath,
                            File.separator,
                            zipFileName,
                            tmpFileName
                    );
                }))
                .flatMap(tmpPath -> unzipInPath(zipFile, tmpPath));
    }

    private static Try<Path> unzipInPath(final File zipFile, final String tmpPath) {
        return Try.of(() -> new File(tmpPath))
                .flatMap(file -> Try.of(file::mkdir))
                .flatMap(unused -> Try.of(() -> new ZipFile(zipFile)))
                .flatMap(zip -> Try.run(() -> zip.extractAll(tmpPath))
                        .flatMap(unused -> Try.of(() -> new File(tmpPath))))
                .map(File::toPath);
    }
}
