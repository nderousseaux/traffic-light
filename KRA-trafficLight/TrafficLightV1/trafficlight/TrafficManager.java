package trafficlight;

public class TrafficManager {

	public TrafficManager() {
		TrafficLight tl = new TrafficLight();
		TextualLight view1 = new TextualLight( tl );
		GraphicalLight view2 = new GraphicalLight( tl );
		GraphicalLight view3 = new GraphicalLight( tl );
		tl.add( view1 );
		tl.add( view2 );
		tl.add( view3 );
	}

	public static void main(String[] args) {
		new TrafficManager();
	}

}
