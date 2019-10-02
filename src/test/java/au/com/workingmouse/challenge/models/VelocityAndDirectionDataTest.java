package au.com.workingmouse.challenge.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class VelocityAndDirectionDataTest {
	private VelocityAndDirectionData velocityAndDirectionData;

	@BeforeEach
	void setup() {

		velocityAndDirectionData = new VelocityAndDirectionData(
				Timestamp.valueOf("2019-02-15 08:10:00"),
				94765,
				420,
				720,
				12.86618,
				225.6384,
				-9.057814,
				-9.099508,
				230.1075,
				8.77677,
				-1.642109,
				4.367773,
				-39.38862,
				100.0,
				8.933828,
				9.770377,
				0.5512519
		);
	}

	@Test
	void getTimestamp() {
		assertEquals(Timestamp.valueOf("2019-02-15 08:10:00"), velocityAndDirectionData.getTimestamp());
	}

	@Test
	void getRecord() {
		assertEquals(94765, velocityAndDirectionData.getRecord());
	}

	@Test
	void getDcsModel() {
		assertEquals(420, velocityAndDirectionData.getDcsModel());
	}

	@Test
	void getDcsSerial() {
		assertEquals(720, velocityAndDirectionData.getDcsSerial());
	}

	@Test
	void getDcsAbsspdAvg() {
		assertEquals(12.86618, velocityAndDirectionData.getDcsAbsspdAvg());
	}

	@Test
	void getDcsDirectionAvg() {
		assertEquals(225.6384, velocityAndDirectionData.getDcsDirectionAvg());
	}

	@Test
	void getDcsNorthCurAvg() {
		assertEquals(-9.057814, velocityAndDirectionData.getDcsNorthCurAvg());
	}

	@Test
	void getDcsEastCurAvg() {
		assertEquals(-9.099508, velocityAndDirectionData.getDcsEastCurAvg());
	}

	@Test
	void getDcsHeadingAvg() {
		assertEquals( 230.1075, velocityAndDirectionData.getDcsHeadingAvg());
	}

	@Test
	void getDcsTiltXAvg() {
		assertEquals(8.77677, velocityAndDirectionData.getDcsTiltXAvg());
	}

	@Test
	void getDcsTiltYAvg() {
		assertEquals( -1.642109, velocityAndDirectionData.getDcsTiltYAvg());
	}

	@Test
	void getDcsSpStdAvg() {
		assertEquals( 4.367773, velocityAndDirectionData.getDcsSpStdAvg());
	}

	@Test
	void getDcsSigStrengthAvg() {
		assertEquals( -39.38862, velocityAndDirectionData.getDcsSigStrengthAvg());
	}

	@Test
	void getDcsPingCntAvg() {
		assertEquals(100.0, velocityAndDirectionData.getDcsPingCntAvg());
	}

	@Test
	void getDcsAbsTiltAvg() {
		assertEquals(8.933828, velocityAndDirectionData.getDcsAbsTiltAvg());
	}

	@Test
	void getDscMaxTiltAvg() {
		assertEquals(9.770377, velocityAndDirectionData.getDscMaxTiltAvg());
	}

	@Test
	void getDcsStdTiltAvg() {
		assertEquals(0.5512519, velocityAndDirectionData.getDcsStdTiltAvg());
	}

	@Test
	void setTimestamp() {
		final String timestampString = "2019-03-15 08:10:00";
		velocityAndDirectionData.setTimestamp(Timestamp.valueOf(timestampString));
		assertEquals(velocityAndDirectionData.getTimestamp(), Timestamp.valueOf(timestampString));
	}

	@Test
	void setRecord() {
		final Integer record = 2;
		velocityAndDirectionData.setRecord(record);
		assertEquals(velocityAndDirectionData.getRecord(), record);
	}

	@Test
	void setDcsModel() {
		final Integer model = 2;
		velocityAndDirectionData.setDcsModel(model);
		assertEquals(velocityAndDirectionData.getDcsModel(), model);
	}

	@Test
	void setDcsSerial() {
		final Integer serial = 2;
		velocityAndDirectionData.setDcsSerial(serial);
		assertEquals(velocityAndDirectionData.getDcsSerial(), serial);
	}

	@Test
	void setDcsAbsspdAvg() {
		final Double abssAvg = 2.0;
		velocityAndDirectionData.setDcsAbsspdAvg(abssAvg);
		assertEquals(velocityAndDirectionData.getDcsAbsspdAvg(), abssAvg);
	}

	@Test
	void setDcsDirectionAvg() {
		final Double direction = 2.0;
		velocityAndDirectionData.setDcsDirectionAvg(direction);
		assertEquals(velocityAndDirectionData.getDcsDirectionAvg(), direction);
	}

	@Test
	void setDcsNorthCurAvg() {
		final Double north = 2.0;
		velocityAndDirectionData.setDcsNorthCurAvg(north);
		assertEquals(velocityAndDirectionData.getDcsNorthCurAvg(), north);
	}

	@Test
	void setDcsEastCurAvg() {
		final Double east = 2.0;
		velocityAndDirectionData.setDcsEastCurAvg(east);
		assertEquals(velocityAndDirectionData.getDcsEastCurAvg(), east);
	}

	@Test
	void setDcsHeadingAvg() {
		final Double heading = 2.0;
		velocityAndDirectionData.setDcsHeadingAvg(heading);
		assertEquals(velocityAndDirectionData.getDcsHeadingAvg(), heading);
	}

	@Test
	void setDcsTiltXAvg() {
		final Double tiltX = 2.0;
		velocityAndDirectionData.setDcsTiltXAvg(tiltX);
		assertEquals(velocityAndDirectionData.getDcsTiltXAvg(), tiltX);
	}

	@Test
	void setDcsTiltYAvg() {
		final Double tiltY = 2.0;
		velocityAndDirectionData.setDcsTiltYAvg(tiltY);
		assertEquals(velocityAndDirectionData.getDcsTiltYAvg(), tiltY);
	}

	@Test
	void setDcsSpStdAvg() {
		final Double spStdAvg = 2.0;
		velocityAndDirectionData.setDcsSpStdAvg(spStdAvg);
		assertEquals(velocityAndDirectionData.getDcsSpStdAvg(), spStdAvg);
	}

	@Test
	void setDcsSigStrengthAvg() {
		final Double strength = 2.0;
		velocityAndDirectionData.setDcsSigStrengthAvg(strength);
		assertEquals(velocityAndDirectionData.getDcsSigStrengthAvg(), strength);
	}

	@Test
	void setDcsPingCntAvg() {
		final Double ping = 2.0;
		velocityAndDirectionData.setDcsPingCntAvg(ping);
		assertEquals(velocityAndDirectionData.getDcsPingCntAvg(), ping);
	}

	@Test
	void setDcsAbsTiltAvg() {
		final Double absTilt = 2.0;
		velocityAndDirectionData.setDcsAbsTiltAvg(absTilt);
		assertEquals(velocityAndDirectionData.getDcsAbsTiltAvg(), absTilt);
	}

	@Test
	void setDscMaxTiltAvg() {
		final Double maxTilt = 2.0;
		velocityAndDirectionData.setDscMaxTiltAvg(maxTilt);
		assertEquals(velocityAndDirectionData.getDscMaxTiltAvg(), maxTilt);
	}

	@Test
	void setDcsStdTiltAvg() {
		final Double stdTilt = 2.0;
		velocityAndDirectionData.setDcsStdTiltAvg(stdTilt);
		assertEquals(velocityAndDirectionData.getDcsStdTiltAvg(), stdTilt);
	}

}