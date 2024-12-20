package jar;
public class ActivityRecommendation {

	public static String recommendActivity(Weather weather, HealthStatus healthStatus,
			SpaceConstraint spaceConstraint) {
		if (!healthStatus.isHealthy() || !healthStatus.hasValidVaccinationCard()) {
			return "No activity recommended.";
		}

		if (weather.getTemperature() < 0) {
			if (weather.getHumidity() < 15) {
				if (weather.isPrecipitation()) {
					return "Stay home.";
				} else if (spaceConstraint.isWithinCapacity()) {
					return "Go skiing.";
				}
			}
		} else if (weather.getTemperature() < 15 && !weather.isPrecipitation()) {
			if (spaceConstraint.isWithinCapacity()) {
				return "Go hiking.";
			}
		} else if (weather.getTemperature() <= 25 && !weather.isPrecipitation() && !weather.isCloudy()
				&& weather.getHumidity() > 60) {
			return "Outdoor tourism.";
		} else if (weather.getTemperature() > 25 && weather.getTemperature() <= 35 && !weather.isPrecipitation() && spaceConstraint.isWithinCapacity()) {
			return "Go for drinks.";
		} else if (weather.getTemperature() > 30 && !weather.isPrecipitation() && spaceConstraint.isWithinCapacity()) {
			return "Go to the beach or pool.";
		}

		return "No specific recommendation.";
	}

	public static void main(String[] args) {
		// Example data
		Weather weather = new Weather(20, 70, false, false);
		HealthStatus healthStatus = new HealthStatus(true, true);
		SpaceConstraint spaceConstraint = new SpaceConstraint(5, 10);

		String recommendation = recommendActivity(weather, healthStatus, spaceConstraint);

		System.out.println("Recommendation: " + recommendation);
	}
}