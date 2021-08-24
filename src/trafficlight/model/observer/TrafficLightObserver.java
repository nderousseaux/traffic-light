package trafficlight.model.observer;

import trafficlight.model.LightColor;

public interface TrafficLightObserver {
	public abstract void update(LightColor color, Boolean isOn );
}

