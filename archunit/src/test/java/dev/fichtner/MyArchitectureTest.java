package dev.fichtner;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import org.junit.jupiter.api.Test;

public class MyArchitectureTest {


    @Test
    public void check_domainmodel_access() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("dev.fichtner");
 
        ArchRule rule = classes().
            that().
            resideInAPackage("dev.fichtner.wordsaurier.domain.model").
            should().
            onlyDependOnClassesThat().
            resideInAnyPackage("java..", "dev.fichtner.wordsaurier.domain.model", "dev.fichtner.wordsaurier.domain.support");

        rule.check(importedClasses);
    }

    @Test
    public void check_layers() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("dev.fichtner");

    ArchRule rule = layeredArchitecture()
        .consideringAllDependencies()
        .layer("Service").definedBy("dev.fichtner.wordsaurier.domain.service")
        .layer("Persistence").definedBy("dev.fichtner.wordsaurier.infrastructure.filesystem")

        .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

        rule.check(importedClasses);
    }

}