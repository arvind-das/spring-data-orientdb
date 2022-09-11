package org.springframework.data.orient.commons.repository.config;

import org.junit.Test;
import org.springframework.data.orient.commons.repository.config.scanner.test.EntitiesMarker;
import org.springframework.data.orient.commons.repository.config.scanner.test.SimpleEdgeEntity;
import org.springframework.data.orient.commons.repository.config.scanner.test.SimpleVertexEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


/**
 * @author saljuama
 * @since 6th February 2016
 */
public class OrientPackageScannerTest {

    private final String testBasePackage = "org.springframework.data.orient.commons.repository.config.scanner.test";
    private final Class testBasePackageClass = EntitiesMarker.class;

    private static Set<Class<?>> expectedResult() {
        Set<Class<?>> expected = new HashSet<>();
        expected.add(SimpleVertexEntity.class);
        expected.add(SimpleEdgeEntity.class);
        return expected;
    }


    @Test
    public void testScanBasePackagesForClasses_withString() throws Exception {

        Set<? extends Class<?>> result = OrientPackageScanner.scanBasePackagesForClasses(testBasePackage);

        assertEquals(result, expectedResult());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testScanBasePackagesForClasses_withClass() throws Exception {

        Set<? extends Class<?>> result = OrientPackageScanner.scanBasePackagesForClasses(testBasePackageClass);

        assertEquals(result, expectedResult());
    }
}