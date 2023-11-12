package gr.ihu.ict.linkedin.data.importer.model.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Publication {
    private String Name, PublishedOn, Description, Publisher, Url;
}
