package trafficlight.view.decorator;

import trafficlight.model.LightColor;
import trafficlight.view.TextualLight;
import trafficlight.view.TrafficLightView;

import javax.swing.*;

public class TextualDecorated extends ViewDecorator {

    //Constructeurs
    public TextualDecorated(TrafficLightView v) {
        super(v);
    }

    //Update de la couleur affichée
    public void update(LightColor color, Boolean isOn){

        JTextArea t = ((TextualLight)_decorated).getTextArea();
        t.append(
                "State: "+(isOn ? "On, Color: "+_decorated.getTrafficLight().getColor() : "Off")+"\n"
        );
    }





}
