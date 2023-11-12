package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Publication;
import gr.ihu.ict.linkedin.data.importer.service.csv.PublicationParser;
import io.vavr.control.Try;

import java.util.List;
import java.util.stream.Collectors;

public class PublicationParserImpl implements PublicationParser {
    @Override
    public Try<List<Publication>> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Publication(
                                record[0],
                                record[1],
                                record[2],
                                record[3],
                                record[4]
                        ))
                        .collect(Collectors.toList())));
    }
}
