package gr.ihu.ict.linkedin.data.importer.model.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Certification {
    private String Name, Url, Authority, StartedOn, FinishedOn, LicenseNumber;
}
