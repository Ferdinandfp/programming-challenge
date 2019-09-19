package au.com.workingmouse.challenge.services;

import au.com.workingmouse.challenge.models.VelocityAndDirectionData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VelocityAndDirectionServiceTest {
    private static final String VALID_LINE = "2019-02-15 10:40:00,94780,420,720,15.36746,208.9371,-13.4357,-7.070466,"
        + "223.5234,13.6896,-6.570364,5.081869,-39.14706,100,15.29624,16.54015,0.9127843";

    private static final String VALID_LINE2 = "2019-02-15 10:40:00,47390,210,360,7.68373,104.46855,-6.71785,-3.535233,"
        + "111.7617,6.8448,-3.285182,2.5409345,-19.57353,50,7.64812,8.270075,0.45639215";

    private static final String VALID_LINE3 = "2019-02-15 10:40:00,47390,210,360,7.68373,104.46855,-6.71785,-3.535233,"
            + "111.7617,6.8448,-3.285182,2.5409345,-19.57353,50,7.64812,8.270075,0.45639215";

    private static final Double[] EXPECTED_AVERAGES = {
            94780.0 * 2 / 3,
            420.0 * 2 / 3,
            720.0 * 2 / 3,
            15.36746 * 2 / 3,
            208.9371 * 2 / 3,
            -13.4357 * 2 / 3,
            -7.070466 * 2 / 3,
            223.5234 * 2 / 3,
            13.6896 * 2 / 3,
            -6.570364 * 2 / 3,
            5.081869 * 2 / 3,
            -39.14706 * 2 / 3,
            100.0 * 2 / 3,
            15.29624 * 2 / 3,
            16.54015 * 2 / 3,
            0.9127843 * 2 / 3
    };

    private static final String INVALID_LINE = "12/01/1995,94780,dog,720,15.36746,208.9371,-13.4357,-7.070466,"
            + "223.5234,13.6896,-6.570364,5.081869,-39.14706,100,15.29624,16.54015,0.9127843";

    private static final String INVALID_LINE_TWO = "2019-02-15 10:40:00,dog,720,15.36746,208.9371,-13.4357,-7.070466,"
            + "223.5234,13.6896,-6.570364,5.081869,-39.14706,100,15.29624,16.54015,0.9127843";

    private VelocityAndDirectionData velocityAndDirectionData;

    @BeforeEach
    void setUp() {
        velocityAndDirectionData = new VelocityAndDirectionData(
                Timestamp.valueOf("2019-02-15 10:40:00"),
                94780,
                420,
                720,
                15.36746,
                208.9371,
                -13.4357,
                -7.070466,
                223.5234,
                13.6896,
                -6.570364,
                5.081869,
                -39.14706,
                100.0,
                15.29624,
                16.54015,
                0.9127843
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void parseValidLineTest() {
        VelocityAndDirectionData actualVelocityAndDirectionData = VelocityAndDirectionService.parseLine(VALID_LINE);
        assertEquals(velocityAndDirectionData, actualVelocityAndDirectionData);
    }

    @Test
    void parseInvalidLineTestTimeStamp() {
       Executable parseLineTest = () -> VelocityAndDirectionService.parseLine(INVALID_LINE);
        assertThrows(IllegalArgumentException.class, parseLineTest, "Invalid Timestamp");
    }


    @Test
    void parseInvalidLineTest() {
        Executable parseLineTest = () -> VelocityAndDirectionService.parseLine(INVALID_LINE_TWO);
        assertThrows(NumberFormatException.class, parseLineTest, "Dog is not a double");
    }

    @Test
    void parseMultipleLinesTest() {
       var lines = VelocityAndDirectionService.parseLines(Arrays.asList(
                VALID_LINE,
                VALID_LINE
        ));

       System.out.println(lines.toString());

       assertEquals(2, lines.size());
       assertTrue(lines.get(0).equals(lines.get(1)));
    }

    @Test
    void summeriseTest() {
        // Implementation instructions unclear. What should this test?
        // Summarise spelt wrong
        VelocityAndDirectionData actualVelocityAndDirectionData = VelocityAndDirectionService.parseLine(VALID_LINE);
        List<VelocityAndDirectionData> dataToSummarise = new ArrayList<>();
        List<VelocityAndDirectionData> actualDataToSummarise = new ArrayList<>();
        dataToSummarise.add(velocityAndDirectionData);
        actualDataToSummarise.add(actualVelocityAndDirectionData);

        assertEquals(VelocityAndDirectionService.summarise(dataToSummarise),
                VelocityAndDirectionService.summarise(actualDataToSummarise));
    }
}