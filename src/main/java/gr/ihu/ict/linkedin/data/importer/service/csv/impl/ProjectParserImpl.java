package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Project;
import gr.ihu.ict.linkedin.data.importer.service.csv.ProjectParser;
import io.vavr.control.Try;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectParserImpl implements ProjectParser {
    @Override
    public Try<List<Project>> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Project(
                                record[0],
                                record[1],
                                record[2],
                                record[3],
                                record[4]
                        ))
                        .collect(Collectors.toList())));

    }
}
