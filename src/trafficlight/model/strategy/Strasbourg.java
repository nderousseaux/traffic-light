package trafficlight.model.strategy;

import trafficlight.model.LightColor;
import trafficlight.model.TrafficLight;

public class Strasbourg extends Localisation {

    //Constructeur
    public Strasbourg(){}

    //Algorithme de changement de couleur
    public void switchColor(TrafficLight t){

        //On change la couleur
        switch (t.getColor()) {
            case GREEN:
                t.setColor(LightColor.ORANGE);
                t.setLastColor(LightColor.GREEN);
                break;
            case ORANGE:
                t.setColor(LightColor.RED);
                break;
            case RED:
                t.setColor(LightColor.GREEN);
                t.setLastColor(LightColor.RED);
                break;
            default:
                return;
        }

        //On notifie les vues
        t.notifyObservers( t.getColor(), t.getIsOn() ) ;
        
    }
}
