package gr.ihu.ict.linkedin.data.importer.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import gr.ihu.ict.linkedin.data.importer.model.csv.*;

@Builder
@Getter
public class LinkedInData {
    private List<Certification> certifications;
    private List<Education> educations;
    private List<Language> languages;
    private List<Position> positions;
    private Profile profile;
    private List<Project> projects;
    private List<Publication> publications;
    private List<Skill> skills;
}
