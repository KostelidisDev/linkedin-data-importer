package gr.ihu.ict.linkedin.data.importer.service;

import io.vavr.control.Try;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import gr.ihu.ict.linkedin.data.importer.constants.CsvFile;
import gr.ihu.ict.linkedin.data.importer.model.LinkedInData;
import gr.ihu.ict.linkedin.data.importer.model.csv.*;
import gr.ihu.ict.linkedin.data.importer.service.csv.*;
import gr.ihu.ict.linkedin.data.importer.service.csv.impl.*;
import gr.ihu.ict.linkedin.data.importer.util.FileUtils;
import gr.ihu.ict.linkedin.data.importer.util.ZipUtil;

public class LinkedInDataImporterImpl implements LinkedInDataImporter {

    private final CertificationParser certificationParser;
    private final EducationParser educationParser;
    private final LanguageParser languageParser;
    private final PositionParser positionParser;
    private final ProfileParser profileParser;
    private final ProjectParser projectParser;
    private final PublicationParser publicationParser;
    private final SkillParser skillParser;

    public LinkedInDataImporterImpl(CertificationParser certificationParser,
                                   EducationParser educationParser,
                                   LanguageParser languageParser,
                                   PositionParser positionParser,
                                   ProfileParser profileParser,
                                   ProjectParser projectParser,
                                   PublicationParser publicationParser,
                                   SkillParser skillParser) {
        this.certificationParser = certificationParser;
        this.educationParser = educationParser;
        this.languageParser = languageParser;
        this.positionParser = positionParser;
        this.profileParser = profileParser;
        this.projectParser = projectParser;
        this.publicationParser = publicationParser;
        this.skillParser = skillParser;
    }

    public LinkedInDataImporterImpl() {
        this.certificationParser = new CertificationParserImpl();
        this.educationParser = new EducationParserImpl();
        this.languageParser = new LanguageParserImpl();
        this.positionParser = new PositionParserImpl();
        this.profileParser = new ProfileParserImpl();
        this.projectParser = new ProjectParserImpl();
        this.publicationParser = new PublicationParserImpl();
        this.skillParser = new SkillParserImpl();
    }

    @Override
    public LinkedInData parseZip(final File zipFile) {
        return ZipUtil.unzipInTempPath(zipFile)
                .map(this::parsePath)
                .get();
    }

    @Override
    public LinkedInData parsePath(final Path folder) {
        return Try.of(() -> {
            final List<Certification> certifications = certificationParser
                    .parse(getFileToParse(CsvFile.CERTIFICATION, folder))
                    .get();

            final List<Education> educations = educationParser
                    .parse(getFileToParse(CsvFile.EDUCATION, folder))
                    .get();

            final List<Language> languages = languageParser
                    .parse(getFileToParse(CsvFile.LANGUAGE, folder))
                    .get();

            final List<Position> positions = positionParser
                    .parse(getFileToParse(CsvFile.POSITION, folder))
                    .get();

            final Profile profile = profileParser
                    .parse(getFileToParse(CsvFile.PROFILE, folder))
                    .get();

            final List<Project> projects = projectParser
                    .parse(getFileToParse(CsvFile.PROJECT, folder))
                    .get();

            final List<Publication> publications = publicationParser
                    .parse(getFileToParse(CsvFile.PUBLICATION, folder))
                    .get();

            final List<Skill> skills = skillParser
                    .parse(getFileToParse(CsvFile.SKILL, folder))
                    .get();

            return LinkedInData.builder()
                    .certifications(certifications)
                    .educations(educations)
                    .languages(languages)
                    .positions(positions)
                    .profile(profile)
                    .projects(projects)
                    .publications(publications)
                    .skills(skills)
                    .build();
        }).get();
    }

    private static File getFileToParse(final CsvFile csvFile, Path folder) {
        return FileUtils.getFileFromPath(csvFile.getFileName(), folder.toString()).get();
    }
}
