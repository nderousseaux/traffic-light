package trafficlight.view.decorator;

import trafficlight.model.LightColor;
import trafficlight.view.GraphicalLight;
import trafficlight.view.TrafficLightView;

import javax.swing.*;
import java.awt.*;

public class NormalDecorated extends ViewDecorator {

    //Constructeur
    public NormalDecorated(TrafficLightView v) {
        super(v);
    }

    //Méthodes d'instance

    //Update de la couleur affichée
    public void update(LightColor color, Boolean isOn){

        JPanel p = ((GraphicalLight)_decorated).getColorPanel();
        if ( isOn ) {
            switch ( color ) {
                case RED:
                    p.setBackground(Color.RED);
                    break;
                case GREEN:
                    p.setBackground(Color.GREEN);
                    break;
                case ORANGE:
                    p.setBackground(Color.ORANGE);
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
