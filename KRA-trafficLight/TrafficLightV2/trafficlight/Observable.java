package trafficlight;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Observable {

	private Collection<TrafficLightObserver> _observers;

	public Observable() {
		_observers = new ArrayList<>();
	}

	public void add(TrafficLightObserver observer) {
		_observers.add(observer);
	}

	public void notifyObservers( LightColor color, Boolean isOn) {
		for (TrafficLightObserver observer : _observers)
			observer.update( color, isOn );
	}

}

