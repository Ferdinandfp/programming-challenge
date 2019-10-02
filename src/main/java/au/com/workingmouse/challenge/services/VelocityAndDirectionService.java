package au.com.workingmouse.challenge.services;

import au.com.workingmouse.challenge.models.VelocityAndDirectionData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class VelocityAndDirectionService {

    public static VelocityAndDirectionData parseLine(String line) {
        // NOTE: This CSV parsing is not fully inclusive
        String[] parts = line.split(",");

        VelocityAndDirectionData velocityAndDirectionData = new VelocityAndDirectionData();

        velocityAndDirectionData.setTimestamp(Timestamp.valueOf(parts[0]));
        velocityAndDirectionData.setRecord(Integer.parseInt(parts[1]));
        velocityAndDirectionData.setDcsModel(Integer.parseInt(parts[2]));
        velocityAndDirectionData.setDcsSerial(Integer.parseInt(parts[3]));
        velocityAndDirectionData.setDcsAbsspdAvg(Double.parseDouble(parts[4]));
        velocityAndDirectionData.setDcsDirectionAvg(Double.parseDouble(parts[5]));
        velocityAndDirectionData.setDcsNorthCurAvg(Double.parseDouble(parts[6]));
        velocityAndDirectionData.setDcsEastCurAvg(Double.parseDouble(parts[7]));
        velocityAndDirectionData.setDcsHeadingAvg(Double.parseDouble(parts[8]));
        velocityAndDirectionData.setDcsTiltXAvg(Double.parseDouble(parts[9]));
        velocityAndDirectionData.setDcsTiltYAvg(Double.parseDouble(parts[10]));
        velocityAndDirectionData.setDcsSpStdAvg(Double.parseDouble(parts[11]));
        velocityAndDirectionData.setDcsSigStrengthAvg(Double.parseDouble(parts[12]));
        velocityAndDirectionData.setDcsPingCntAvg(Double.parseDouble(parts[13]));
        velocityAndDirectionData.setDcsAbsTiltAvg(Double.parseDouble(parts[14]));
        velocityAndDirectionData.setDscMaxTiltAvg(Double.parseDouble(parts[15]));
        velocityAndDirectionData.setDcsStdTiltAvg(Double.parseDouble(parts[16]));

        return velocityAndDirectionData;
    }

    /**
     * Takes the given ordered list of VelocityAndDirectionData properties and initialises a new
     * VelocityAndDirectionData object.
     * @param line - row to parse
     * @return VelocityAndDirectionData
     */
    public static VelocityAndDirectionData parseLine(List<String> line) {

        if (line.size() != 17) {
            throw new IllegalArgumentException("VelocityAndDirectionData Objects require 17 input arguments.");
        }

        return new VelocityAndDirectionData(
                Timestamp.valueOf(line.get(0)),
                Integer.parseInt(line.get(1)),
                Integer.parseInt(line.get(2)),
                Integer.parseInt(line.get(3)),
                Double.parseDouble(line.get(4)),
                Double.parseDouble(line.get(5)),
                Double.parseDouble(line.get(6)),
                Double.parseDouble(line.get(7)),
                Double.parseDouble(line.get(8)),
                Double.parseDouble(line.get(9)),
                Double.parseDouble(line.get(10)),
                Double.parseDouble(line.get(11)),
                Double.parseDouble(line.get(12)),
                Double.parseDouble(line.get(13)),
                Double.parseDouble(line.get(14)),
                Double.parseDouble(line.get(15)),
                Double.parseDouble(line.get(16))
        );
    }

    public static List<VelocityAndDirectionData> parseLines(List<String> lines) {
        var parsedLines = new ArrayList<VelocityAndDirectionData>();
        int count = 0;
        for (String line : lines) {
            if (count++ == 0) {
                 //Skip header
                continue;
            }
            parsedLines.add(VelocityAndDirectionService.parseLine(line));
        }
       
        return parsedLines;
    }


    public static String summarise(List<VelocityAndDirectionData> velocityAndDirectionDataset) {
        Integer totalLines = velocityAndDirectionDataset.size();
        var summaryBuilder = new StringBuilder() ;
        VelocityAndDirectionData velocityData = new VelocityAndDirectionData();
        velocityData.setRecord(0);
        velocityData.setDcsModel(0);
        velocityData.setDcsSerial(0);
        velocityData.setDcsAbsTiltAvg(0.0);
        velocityData.setDcsDirectionAvg(0.0);
        velocityData.setDcsNorthCurAvg(0.0);
        velocityData.setDcsEastCurAvg(0.0);
        velocityData.setDcsHeadingAvg(0.0);
        velocityData.setDcsTiltXAvg(0.0);
        velocityData.setDcsTiltYAvg(0.0);
        velocityData.setDcsSpStdAvg(0.0);
        velocityData.setDcsSigStrengthAvg(0.0);
        velocityData.setDcsPingCntAvg(0.0);
        velocityData.setDcsAbsTiltAvg(0.0);
        velocityData.setDscMaxTiltAvg(0.0);
        velocityData.setDcsStdTiltAvg(0.0);
        for ( int i = 0; i < totalLines; i++){
            velocityData.setRecord(velocityData.getRecord() + velocityAndDirectionDataset.get(i).getRecord());
            velocityData.setDcsModel(velocityData.getDcsModel() + velocityAndDirectionDataset.get(i).getDcsModel());
            velocityData.setDcsSerial(velocityData.getDcsSerial() + velocityAndDirectionDataset.get(i).getDcsSerial());
            velocityData.setDcsAbsTiltAvg(velocityData.getDcsAbsTiltAvg() + velocityAndDirectionDataset.get(i).getDcsAbsspdAvg());
            velocityData.setDcsDirectionAvg(velocityData.getDcsDirectionAvg() + velocityAndDirectionDataset.get(i).getDcsDirectionAvg());
            velocityData.setDcsNorthCurAvg(velocityData.getDcsNorthCurAvg() + velocityAndDirectionDataset.get(i).getDcsNorthCurAvg());
            velocityData.setDcsEastCurAvg(velocityData.getDcsEastCurAvg() + velocityAndDirectionDataset.get(i).getDcsEastCurAvg());
            velocityData.setDcsHeadingAvg(velocityData.getDcsHeadingAvg() + velocityAndDirectionDataset.get(i).getDcsHeadingAvg());
            velocityData.setDcsTiltXAvg(velocityData.getDcsTiltXAvg() + velocityAndDirectionDataset.get(i).getDcsTiltXAvg());
            velocityData.setDcsTiltYAvg(velocityData.getDcsTiltYAvg() + velocityAndDirectionDataset.get(i).getDcsTiltYAvg());
            velocityData.setDcsSpStdAvg(velocityData.getDcsSpStdAvg() + velocityAndDirectionDataset.get(i).getDcsSpStdAvg());
            velocityData.setDcsSigStrengthAvg(velocityData.getDcsSigStrengthAvg() + velocityAndDirectionDataset.get(i).getDcsSigStrengthAvg());
            velocityData.setDcsPingCntAvg(velocityData.getDcsPingCntAvg() + velocityAndDirectionDataset.get(i).getDcsPingCntAvg());
            velocityData.setDcsAbsTiltAvg(velocityData.getDcsAbsTiltAvg() + velocityAndDirectionDataset.get(i).getDcsAbsTiltAvg());
            velocityData.setDscMaxTiltAvg(velocityData.getDscMaxTiltAvg() + velocityAndDirectionDataset.get(i).getDscMaxTiltAvg());
            velocityData.setDcsStdTiltAvg(velocityData.getDcsStdTiltAvg() + velocityAndDirectionDataset.get(i).getDcsStdTiltAvg());
        }
       
        summaryBuilder.append("<head></head>")
                .append("<body>")
                .append("<h2>Summary</h2>")
                .append("<br />")
                .append("<strong>Total Lines:</strong>" + totalLines.toString())
                .append("<p>")  // Add p element to HTML for displaying averages
                .append("<div>Record avg: " + velocityData.getRecord()/totalLines
                        + "</div><div>Dcs Model avg: " + velocityData.getDcsModel()/totalLines
                        + "</div><div>Dcs Serial avg: " + velocityData.getDcsSerial()/totalLines
                        + "</div><div>Abs Tilt avg: " + velocityData.getDcsAbsTiltAvg()/totalLines
                        + "</div><div>Dcs Direction avg: " + velocityData.getDcsDirectionAvg()/totalLines
                        + "</div><div>Dcs North avg: " + velocityData.getDcsNorthCurAvg()/totalLines
                        + "</div><div>Dcs East avg: " + velocityData.getDcsEastCurAvg()/totalLines
                        + "</div><div>Dcs Heading avg: " + velocityData.getDcsHeadingAvg()/totalLines
                        + "</div><div>Dcs Tilt x avg: " + velocityData.getDcsTiltXAvg()/totalLines
                        + "</div><div>Dcs Tilt y avg: " + velocityData.getDcsTiltYAvg()/totalLines
                        + "</div><div>Dcs Sp Std avg: " + velocityData.getDcsSpStdAvg()/totalLines
                        + "</div><div>Dcs Sig Strength avg: " + velocityData.getDcsSigStrengthAvg()/totalLines
                        + "</div><div>Dcs Ping avg: " + velocityData.getDcsPingCntAvg()/totalLines
                        + "</div><div>Dcs Abs Tilt avg: " + velocityData.getDcsAbsTiltAvg()/totalLines
                        + "</div><div>Dcs Max Tilt avg: " + velocityData.getDscMaxTiltAvg()/totalLines
                        + "</div><div>Dcs Std Tilt avg: " + velocityData.getDcsStdTiltAvg()/totalLines);
               // )
        // TODO: You will also have to do some work here to ensure the details are complete.
        summaryBuilder.append("<div></p>")
                .append("</body>");

        return summaryBuilder.toString();
    }
}
