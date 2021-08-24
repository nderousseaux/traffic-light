package trafficlight.model.observer;

import trafficlight.model.LightColor;
import trafficlight.view.decorator.ViewDecorator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class
Observable {

	private Collection<ViewDecorator> _observers;

	public Observable() {
		_observers = new ArrayList<>();
	}

	public void add(ViewDecorator observer) {
		_observers.add(observer);
	}

	public void notifyObservers(LightColor color, Boolean isOn) {
		for (ViewDecorator observer : _observers)
			observer.update( color, isOn );
	}

}

