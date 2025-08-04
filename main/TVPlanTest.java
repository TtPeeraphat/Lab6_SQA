package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TVPlanTest {

    @ParameterizedTest(name = "{index}: Package={0} Offline={1} Live={2} Discount={3} Expect={4}")
    @CsvSource({
        // TC001-TC008 : STANDARD
        "STANDARD, false, false, false, 150",
        "STANDARD, true,  false, false, 250",
        "STANDARD, false, true,  false, 250",
        "STANDARD, true,  true,  false, 350",
        "STANDARD, false, false, true,  100",
        "STANDARD, true,  false, true,  200",
        "STANDARD, true,  true,  true,  300",
        "STANDARD, false, true,  true,  200",
        // TC009-TC016 : PREMIUM
        "PREMIUM, false, false, false, 350",
        "PREMIUM, true,  false, false, 450",
        "PREMIUM, true,  true,  false, 550",
        "PREMIUM, false, true,  false, 450",
        "PREMIUM, false, false, true,  300",
        "PREMIUM, true,  false, true,  400",
        "PREMIUM, true,  true,  true,  500",
        "PREMIUM, false, true,  true,  400",
        // TC017-TC020 : FAMILY
        "FAMILY, true,  false, false, 550",
        "FAMILY, true,  true,  false, 650",
        "FAMILY, true,  true,  true,  600",
        "FAMILY, false, false, true,  400"
    })
    void testTVPlans(String packageName, boolean offline, boolean live, boolean discount, double expected) {
        TVPlan.TVPackage pkg = TVPlan.TVPackage.valueOf(packageName);
        TVPlan plan = new TVPlan(offline, live, discount);
        double result = plan.pricePerMonth(pkg);
        assertEquals(expected, result, 0.01);
    }
}