package gr.ihu.ict.linkedin.data.importer.constants;

public enum CsvFile {
    CERTIFICATION("Certifications"),
    EDUCATION("Education"),
    LANGUAGE("Languages"),
    POSITION("Positions"),
    PROFILE("Profile"),
    PROJECT("Projects"),
    PUBLICATION("Publications"),
    SKILL("Skills");

    private final String fileNameWithoutExtension;

    CsvFile(final String fileNameWithoutExtension) {
        this.fileNameWithoutExtension = fileNameWithoutExtension;
    }

    public String getFileNameWithoutExtension() {
        return fileNameWithoutExtension;
    }

    public String getFileName() {
        return String.format("%s.%s", getFileNameWithoutExtension(), "csv");
    }
}
