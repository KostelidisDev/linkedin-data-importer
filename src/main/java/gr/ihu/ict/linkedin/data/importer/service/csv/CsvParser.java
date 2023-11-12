package gr.ihu.ict.linkedin.data.importer.service.csv;

import com.opencsv.CSVReader;
import io.vavr.NotImplementedError;
import io.vavr.control.Try;

import java.io.File;
import java.io.FileReader;

public interface CsvParser<O> {
    default Try<O> implementedParse(final CSVReader csvReader) {
        return Try.failure(new NotImplementedError());
    }

    default Try<O> parse(File inputFile) {
        return Try.of(() -> new FileReader(inputFile))
                .flatMap(fileReader -> Try.of(() -> new CSVReader(fileReader)))
                .flatMap(this::implementedParse);
    }
}
