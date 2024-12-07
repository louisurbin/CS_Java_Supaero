package meteo;

public class MeteoSample {
	private double temperature;
	private double pressure;
	private double humidity;

	public MeteoSample(double t, double p, double h) {
		if (t> 60||t<-273.15){
			throw new IllegalArgumentException("Température non valide");
		}
		if (p> 1086.8||p<870){
			throw new IllegalArgumentException("Pression non valide");
		}
		if (h> 100||h<0){
			throw new IllegalArgumentException("Humidité non valide");
		}
		this.humidity = h;
		this.pressure = p;
		this.temperature = t;
	}
	
	public String toString(){
		return temperature + "°C, " + pressure + " hPa, " + humidity + "% humidity";
	}
}
