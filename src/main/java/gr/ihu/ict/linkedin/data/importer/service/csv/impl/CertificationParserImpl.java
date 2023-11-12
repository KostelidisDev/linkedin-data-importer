package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Certification;
import gr.ihu.ict.linkedin.data.importer.service.csv.CertificationParser;
import io.vavr.control.Try;

import java.util.List;
import java.util.stream.Collectors;

public class CertificationParserImpl implements CertificationParser {
    @Override
    public Try<List<Certification>> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Certification(
                                record[0],
                                record[1],
                                record[2],
                                record[3],
                                record[4],
                                record[5]
                        ))
                        .collect(Collectors.toList())));
    }
}
