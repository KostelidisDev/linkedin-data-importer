package gr.ihu.ict.linkedin.data.importer.model.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Position {
    private String CompanyName, Title, Description, Location, StartedOn, FinishedOn;
}
