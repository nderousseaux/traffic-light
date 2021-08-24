package trafficlight;

public class TrafficManager {

	public TrafficManager() {
		TrafficLight tl = new TrafficLight();
		TrafficLightView view1 = new TextualLight( tl );
		TrafficLightView view2 = new GraphicalLight( tl );
		TrafficLightView view3 = new GraphicalLight( tl );
		tl.add( view1 );
		tl.add( view2 );
		tl.add( view3 );
	}

	public static void main(String[] args) {
		new TrafficManager();
	}

}
