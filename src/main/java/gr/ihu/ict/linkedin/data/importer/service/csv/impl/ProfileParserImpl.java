package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Profile;
import gr.ihu.ict.linkedin.data.importer.service.csv.ProfileParser;
import io.vavr.control.Option;
import io.vavr.control.Try;

public class ProfileParserImpl implements ProfileParser {
    @Override
    public Try<Profile> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Profile(
                                record[0],
                                record[1],
                                record[2],
                                record[3],
                                record[4],
                                record[5],
                                record[6],
                                record[7],
                                record[8],
                                record[9],
                                record[10],
                                record[11],
                                record[12]
                        ))
                        .findFirst()))
                .flatMap(profile -> Option.ofOptional(profile).toTry());

    }
}
