package gr.ihu.ict.linkedin.data.importer;

import io.vavr.control.Try;

import java.io.File;

public abstract class AbstractTest {
    protected Try<File> getFileFromResources(final String fileName) {
        return Try.of(this::getClass)
                .flatMap(aClass -> Try.of(aClass::getClassLoader))
                .flatMap(classLoader -> Try.of(() -> classLoader.getResource(fileName)))
                .flatMap(url -> Try.of(() -> new File(url.getFile())));
    }
}
