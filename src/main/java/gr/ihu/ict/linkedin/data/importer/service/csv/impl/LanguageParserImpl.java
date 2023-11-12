package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Language;
import gr.ihu.ict.linkedin.data.importer.service.csv.LanguageParser;
import io.vavr.control.Try;

import java.util.List;
import java.util.stream.Collectors;

public class LanguageParserImpl implements LanguageParser {
    @Override
    public Try<List<Language>> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Language(
                                record[0],
                                record[1]
                        ))
                        .collect(Collectors.toList())));

    }
}
