package trafficlight;

public class TrafficLight extends Observable {

	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;

	public TrafficLight() {}

	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers( _color, _isOn );
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
		notifyObservers( _color, _isOn ) ;
	}

}

