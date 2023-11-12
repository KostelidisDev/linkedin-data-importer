package gr.ihu.ict.linkedin.data.importer.service;

import gr.ihu.ict.linkedin.data.importer.AbstractTest;
import gr.ihu.ict.linkedin.data.importer.model.LinkedInData;
import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedArchiveParserTest extends AbstractTest {

    private LinkedInDataImporter linkedArchiveParser;

    @Before
    public void setUp() throws Exception {
        this.linkedArchiveParser = new LinkedInDataImporterImpl();
    }

    @Test
    public void testParseZip() {
        Try<LinkedInData> result = this.getFileFromResources("Basic_LinkedInDataExport_01-29-2022.zip")
                .flatMap(file -> Try.of(() -> linkedArchiveParser.parseZip(file)));

        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void testParsePath() {
        Try<LinkedInData> result = this.getFileFromResources("Basic_LinkedInDataExport_01-29-2022_zip")
                .flatMap(file -> Try.of(file::toPath))
                .flatMap(path -> Try.of(() -> linkedArchiveParser.parsePath(path)));

        Assert.assertTrue(result.isSuccess());
    }
}