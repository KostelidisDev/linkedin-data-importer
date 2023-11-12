package gr.ihu.ict.linkedin.data.importer.model.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Education {
    private String SchoolName, StartDate, EndDate, Notes, DegreeName, Activities;
}
