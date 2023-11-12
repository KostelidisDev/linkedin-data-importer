package gr.ihu.ict.linkedin.data.importer.service;

import java.io.File;
import java.nio.file.Path;

import gr.ihu.ict.linkedin.data.importer.model.LinkedInData;

public interface LinkedInDataImporter {
    LinkedInData parseZip(File zipFile);

    LinkedInData parsePath(Path folder);
}
