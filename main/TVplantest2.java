package main;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TVplantest2 {

    @ParameterizedTest
    @MethodSource("testCasesProvider")
    void testPricePerMonth(TVPlan.TVPackage plan, boolean offline, boolean live, boolean discount, double expected) {
        TVPlan tvPlan = new TVPlan(offline, live, discount);
        double actual = tvPlan.pricePerMonth(plan);
        assertEquals(expected, actual, 0.0001, 
            String.format("ผิดที่ package=%s offline=%b live=%b discount=%b", plan, offline, live, discount));
    }

    static Stream<Arguments> testCasesProvider() {
        return Stream.of(
            Arguments.of(TVPlan.TVPackage.STANDARD, false, false, false, 150),
            Arguments.of(TVPlan.TVPackage.STANDARD, true,  false, false, 250),
            Arguments.of(TVPlan.TVPackage.STANDARD, false, true,  false, 250),
            Arguments.of(TVPlan.TVPackage.STANDARD, true,  true,  false, 350),
            Arguments.of(TVPlan.TVPackage.STANDARD, false, false, true,  100),
            Arguments.of(TVPlan.TVPackage.STANDARD, true,  false, true,  200),
            Arguments.of(TVPlan.TVPackage.STANDARD, false, true,  true,  200),
            Arguments.of(TVPlan.TVPackage.STANDARD, true,  true,  true,  300),
            
            Arguments.of(TVPlan.TVPackage.PREMIUM,  false, false, false, 350),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  true,  false, false, 450),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  false, true,  false, 450),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  true,  true,  false, 550),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  false, false, true,  300),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  true,  false, true,  400),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  false, true,  true,  400),
            Arguments.of(TVPlan.TVPackage.PREMIUM,  true,  true,  true,  500),

            Arguments.of(TVPlan.TVPackage.FAMILY, false, false, false, 450),
            Arguments.of(TVPlan.TVPackage.FAMILY, true,  false, false, 550),
            Arguments.of(TVPlan.TVPackage.FAMILY, false, true,  false, 550),
            Arguments.of(TVPlan.TVPackage.FAMILY, true,  true,  false, 650),
            Arguments.of(TVPlan.TVPackage.FAMILY, false, false, true,  400),
            Arguments.of(TVPlan.TVPackage.FAMILY, true,  false, true,  500),
            Arguments.of(TVPlan.TVPackage.FAMILY, false, true,  true,  500),
            Arguments.of(TVPlan.TVPackage.FAMILY, true,  true,  true,  600)
        );
    }
}