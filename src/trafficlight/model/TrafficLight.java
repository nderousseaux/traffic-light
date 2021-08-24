package trafficlight.model;

import trafficlight.model.observer.Observable;
import trafficlight.model.strategy.Localisation;
import trafficlight.model.strategy.Strasbourg;

public class TrafficLight extends Observable {

	//Attributs
	private Localisation _loc = new Strasbourg();
	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;
	private LightColor _lastColor = LightColor.GREEN;

	//Constructeurs
	public TrafficLight() {}

	//Accesseurs
	public Boolean getIsOn() {
		return _isOn;
	}
	public void setIsOn(Boolean _isOn) {
		this._isOn = _isOn;
	}
	public LightColor getColor() {
		return _color;
	}
	public void setColor(LightColor color) {
		this._color = color;
	}
	public LightColor getLastColor() {
		return _lastColor;
	}
	public void setLastColor(LightColor lastColor) {
		this._lastColor = lastColor;
	}
	public Localisation getLoc() {
		return _loc;
	}
	public void setLoc(Localisation loc) {
		_loc = loc;
	}

	//Méthodes d'instance
	//On allume ou eteint le feu
	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers( _color, _isOn );
	}

	//Changement de couleur
	public void swicthColor() {
		_loc.switchColor(this);
	}

}

