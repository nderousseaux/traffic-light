package trafficlight.view.decorator;

import trafficlight.model.LightColor;
import trafficlight.view.GraphicalLight;
import trafficlight.view.TrafficLightView;

import javax.swing.*;
import java.awt.*;

public class PedestrianDecorated extends ViewDecorator {


    //Constructeurs
    public PedestrianDecorated(TrafficLightView v) {
        super(v);
    }


    //Update de la couleur affichée
    public void update(LightColor color, Boolean isOn){


        JPanel p = ((GraphicalLight)_decorated).getColorPanel();
        if ( isOn ) {
            switch ( color ) {
                case RED:
                    p.setBackground(Color.GREEN);
                    break;
                case GREEN:
                case ORANGE:
                    p.setBackground(Color.RED);
                    break;
                default:
                    break;
            }
        }
        else {
            p.setBackground(Color.GRAY);
        }

    }



}
