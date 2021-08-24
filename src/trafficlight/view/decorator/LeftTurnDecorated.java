package trafficlight.view.decorator;

import trafficlight.model.LightColor;
import trafficlight.view.GraphicalLight;
import trafficlight.view.TrafficLightView;

import javax.swing.*;
import java.awt.*;


public class LeftTurnDecorated extends ViewDecorator {

    //Attributs
    private Timer t = new Timer(500, e -> {
        JPanel p = ((GraphicalLight)_decorated).getColorPanel();
        if(p.getBackground() == Color.GRAY){
            p.setBackground(Color.ORANGE);
        }
        else{
            p.setBackground(Color.GRAY);
        }
    });

    //Constructeurs
    public LeftTurnDecorated(TrafficLightView v) {
        super(v);
    }

    //Méthodes d'instance

    //Update de la couleur affichée
    public void update(LightColor color, Boolean isOn){

        JPanel p = ((GraphicalLight)_decorated).getColorPanel();
        if ( isOn ) {
            switch ( color ) {
                case RED:
                    t.start();
                    break;
                case GREEN:
                case ORANGE:
                    t.stop();
                    p.setBackground(Color.GRAY);
                    break;
                default:
                    break;
            }
        }
        else {
            t.stop();
            p.setBackground(Color.GRAY);
        }

    }
}
