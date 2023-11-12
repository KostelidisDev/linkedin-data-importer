package gr.ihu.ict.linkedin.data.importer.model.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Profile {
    private String FirstName, LastName, MaidenName, Address, BirthDate, Headline, Summary, Industry, ZipCode, GeoLocation, TwitterHandles, Websites, InstantMessengers;
}
