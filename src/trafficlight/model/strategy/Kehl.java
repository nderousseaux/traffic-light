package trafficlight.model.strategy;

import trafficlight.model.LightColor;
import trafficlight.model.TrafficLight;

public class Kehl extends Localisation {

    //Constructeur
    public Kehl(){}

    //Algorithme de changement de couleur
    public void switchColor(TrafficLight t){

        //On change la couleur
        switch (t.getColor()) {
            case GREEN:
                t.setColor(LightColor.ORANGE);
                t.setLastColor(LightColor.GREEN);
                break;
            case ORANGE:
                if(t.getLastColor() == LightColor.RED){
                    t.setColor(LightColor.GREEN);
                }
                if(t.getLastColor() == LightColor.GREEN){
                    t.setColor(LightColor.RED);
                }
                break;
            case RED:
                t.setColor(LightColor.ORANGE);
                t.setLastColor(LightColor.RED);
                break;
            default:
                return;
        }

        //On notifie les vues
        t.notifyObservers( t.getColor(), t.getIsOn() ) ;
        
    }
}
