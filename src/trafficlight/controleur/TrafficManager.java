package trafficlight.controleur;

import trafficlight.model.TrafficLight;
import trafficlight.view.ViewManager;

public class TrafficManager {

	public TrafficManager() {

		//On crée un feu
		TrafficLight tl = new TrafficLight();

		//On affiche le feu
		ViewManager.newViewManager(tl);

	}

	public static void main(String[] args) {
		new TrafficManager();
	}

}
