package gr.ihu.ict.linkedin.data.importer.service.csv.impl;

import com.opencsv.CSVReader;

import gr.ihu.ict.linkedin.data.importer.model.csv.Skill;
import gr.ihu.ict.linkedin.data.importer.service.csv.SkillParser;
import io.vavr.control.Try;

import java.util.List;
import java.util.stream.Collectors;

public class SkillParserImpl implements SkillParser {
    @Override
    public Try<List<Skill>> implementedParse(CSVReader csvReader) {
        return Try.of(csvReader::readAll)
                .map(records -> records.subList(1, records.size()))
                .flatMap(records -> Try.of(() -> records.stream()
                        .map(record -> new Skill(
                                record[0]
                        ))
                        .collect(Collectors.toList())));
    }
}
