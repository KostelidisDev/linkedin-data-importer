package gr.ihu.ict.linkedin.data.importer.util;

import gr.ihu.ict.linkedin.data.importer.AbstractTest;
import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;

public class ZipUtilTest extends AbstractTest {
    @Test
    public void unzipInTempFolder() {
        Try<Path> result = this.getFileFromResources("Basic_LinkedInDataExport_01-29-2022.zip")
                .flatMap(ZipUtil::unzipInTempPath);

        Assert.assertTrue(result.isSuccess());
    }
}