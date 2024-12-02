public class Weather {
    private float temperature;
    private float humidity;
    private boolean precipitation;
    private boolean isCloudy;

    public Weather(float temperature, float humidity, boolean precipitation, boolean isCloudy) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.isCloudy = isCloudy;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public boolean isPrecipitation() {
        return precipitation;
    }

    public boolean isCloudy() {
        return isCloudy;
    }
}