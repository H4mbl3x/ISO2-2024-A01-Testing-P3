public class Weather {
    private float temperature;
    private float humidity;
    private boolean precipitation;
    private boolean isCloudy;

    public Weather(float temperature, float humidity, boolean precipitation, boolean isCloudy) {
        setTemperature(temperature);
        setHumidity(humidity);
        setPrecipitation(precipitation);
        setCloudy(isCloudy);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public boolean isPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(boolean precipitation) {
        this.precipitation = precipitation;
    }

    public boolean isCloudy() {
        return isCloudy;
    }

    public void setCloudy(boolean isCloudy) {
        this.isCloudy = isCloudy;
    }
}