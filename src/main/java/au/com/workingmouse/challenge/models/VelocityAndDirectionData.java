package au.com.workingmouse.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VelocityAndDirectionData {

    private Timestamp timestamp;

    private Integer record;

    private Integer dcsModel;

    private Integer dcsSerial;

    private Double dcsAbsspdAvg;

    private Double dcsDirectionAvg;

    private Double dcsNorthCurAvg;

    private Double dcsEastCurAvg;

    private Double dcsHeadingAvg;

    private Double dcsTiltXAvg;

    private Double dcsTiltYAvg;

    private Double dcsSpStdAvg;

    private Double dcsSigStrengthAvg;

    private Double dcsPingCntAvg;

    private Double dcsAbsTiltAvg;

    private Double dscMaxTiltAvg;

    private Double dcsStdTiltAvg;
}
