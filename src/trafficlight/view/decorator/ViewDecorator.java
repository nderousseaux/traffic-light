package trafficlight.view.decorator;

import trafficlight.model.LightColor;
import trafficlight.view.TrafficLightView;

public abstract class ViewDecorator {

    //Attributs
    TrafficLightView _decorated;

    //Constructeurs
    public ViewDecorator(TrafficLightView v){
        _decorated = v;
    }

    //Accesseurs
    public TrafficLightView getView() {
        return _decorated;
    }

    //Méthodes d'instances
    public abstract void update(LightColor color, Boolean isOn);

}
