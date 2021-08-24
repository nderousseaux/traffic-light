package trafficlight;

public class TrafficLight extends Observable {

	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;

	public TrafficLight() {}


	public Boolean getIsOn() {
		return _isOn;
	}

	public LightColor getColor() {
		return _color;
	}

	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers();
	}

	public void swicthColor() {
		switch (_color) {
			case GREEN:
				_color = LightColor.ORANGE;
				break;
			case ORANGE:
				_color = LightColor.RED;
				break;
			case RED:
				_color = LightColor.GREEN;
				break;
			default:
				return;
		}
		notifyObservers();
	}

	@Override
	public String toString() {
		return "State: "+(_isOn ? "On, Color: "+_color : "Off")+"\n";
	}
}

