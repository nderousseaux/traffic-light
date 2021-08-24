package trafficlight;

public interface TrafficLightObserver {
	public abstract void update( LightColor color, Boolean isOn );
}

