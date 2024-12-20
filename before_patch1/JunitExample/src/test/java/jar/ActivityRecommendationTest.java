package jar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ActivityRecommendationTest {
	@Test
	public final void testDecisions() {
		// Test case 1
		Weather weather1 = new Weather(10, 50, false, false);
		HealthStatus healthStatus1 = new HealthStatus(false, true);
		SpaceConstraint spaceConstraint1 = new SpaceConstraint(5, 10);
		assertEquals("No activity recommended.", ActivityRecommendation.recommendActivity(weather1, healthStatus1, spaceConstraint1));

		// Test case 2
		Weather weather2 = new Weather(10, 50, false, false);
		HealthStatus healthStatus2 = new HealthStatus(true, false);
		SpaceConstraint spaceConstraint2 = new SpaceConstraint(5, 10);
		assertEquals("No activity recommended.", ActivityRecommendation.recommendActivity(weather2, healthStatus2, spaceConstraint2));

		// Test case 3
		Weather weather3 = new Weather(-5, 10, true, false);
		HealthStatus healthStatus3 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint3 = new SpaceConstraint(5, 10);
		assertEquals("Stay home.", ActivityRecommendation.recommendActivity(weather3, healthStatus3, spaceConstraint3));

		// Test case 4
		Weather weather4 = new Weather(-5, 10, false, false);
		HealthStatus healthStatus4 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint4 = new SpaceConstraint(5, 10);
		assertEquals("Go skiing.", ActivityRecommendation.recommendActivity(weather4, healthStatus4, spaceConstraint4));

		// Test case 5
		Weather weather5 = new Weather(10, 50, false, false);
		HealthStatus healthStatus5 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint5 = new SpaceConstraint(5, 10);
		assertEquals("Go hiking.", ActivityRecommendation.recommendActivity(weather5, healthStatus5, spaceConstraint5));

		// Test case 6
		Weather weather6 = new Weather(25, 70, false, false);
		HealthStatus healthStatus6 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint6 = new SpaceConstraint(5, 10);
		assertEquals("Outdoor tourism.", ActivityRecommendation.recommendActivity(weather6, healthStatus6, spaceConstraint6));

		// Test case 7
		Weather weather7 = new Weather(25, 70, true, false);
		HealthStatus healthStatus7 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint7 = new SpaceConstraint(5, 10);
		assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather7, healthStatus7, spaceConstraint7));

		// Test case 8
		Weather weather8 = new Weather(35, 50, false, false);
		HealthStatus healthStatus8 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint8 = new SpaceConstraint(5, 10);
		assertEquals("Go for drinks.", ActivityRecommendation.recommendActivity(weather8, healthStatus8, spaceConstraint8));

		// Test case 9
		Weather weather9 = new Weather(40, 50, false, false);
		HealthStatus healthStatus9 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint9 = new SpaceConstraint(5, 10);
		assertEquals("Go to the beach or pool.", ActivityRecommendation.recommendActivity(weather9, healthStatus9, spaceConstraint9));

		// Test case 10
		Weather weather10 = new Weather(31, 50, false, false);
		HealthStatus healthStatus10 = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint10 = new SpaceConstraint(10, 10);
		assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather10, healthStatus10, spaceConstraint10));
	}

	@Test
	public final void testDecisionMCDC1() {
	    // Case 1: isHealthy = false, hasValidVaccinationCard = true
	    Weather weather = new Weather(40, 50, true, false);
	    HealthStatus healthStatus = new HealthStatus(false, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("No activity recommended.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 2: isHealthy = true, hasValidVaccinationCard = false
	    healthStatus = new HealthStatus(true, false);
	    assertEquals("No activity recommended.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 3: isHealthy = true, hasValidVaccinationCard = true
	    healthStatus = new HealthStatus(true, true);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC2() {
	    // Case 4: Temperature < 0
	    Weather weather = new Weather(-5, 50, true, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 5: Temperature >= 0
	    weather = new Weather(10, 50, true, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC3() {
	    // Case 6: Humidity < 15
	    Weather weather = new Weather(-5, 10, true, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("Stay home.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 7: Humidity >= 15
	    weather = new Weather(-5, 20, true, false);
	    assertEquals("Go skiing.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC4() {
	    // Case 8: isPrecipitation = true
	    Weather weather = new Weather(-5, 10, true, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("Stay home.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 9: isPrecipitation = false
	    weather = new Weather(-5, 10, false, false);
	    assertEquals("Go skiing.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC5() {
	    // Case 10: currentCapacity < maxCapacity
	    Weather weather = new Weather(-5, 10, false, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("Go skiing.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 11: currentCapacity >= maxCapacity
	    spaceConstraint = new SpaceConstraint(10, 10);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC6() {
	    // Case 12: Temperature < 15, isPrecipitation = false
	    Weather weather = new Weather(5, 50, false, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("Go hiking.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 13: Temperature < 15, isPrecipitation = true
	    weather = new Weather(10, 50, true, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 14: Temperature >= 15
	    weather = new Weather(20, 50, false, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}

	@Test
	public final void testDecisionMCDC7() {
	    // Case 15: Temperature <= 25, isPrecipitation = false, isCloudy = false, Humidity > 60
	    Weather weather = new Weather(25, 70, false, false);
	    HealthStatus healthStatus = new HealthStatus(true, true);
	    SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);
	    assertEquals("Outdoor tourism.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 16: Humidity <= 60
	    weather = new Weather(25, 50, false, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 17: isPrecipitation = true
	    weather = new Weather(25, 70, true, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 18: isCloudy = true
	    weather = new Weather(25, 70, false, true);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));

	    // Case 19: Temperature < 25
	    weather = new Weather(20, 70, false, false);
	    assertEquals("No specific recommendation.", ActivityRecommendation.recommendActivity(weather, healthStatus, spaceConstraint));
	}
}
