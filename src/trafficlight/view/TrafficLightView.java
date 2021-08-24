package trafficlight.view;

import trafficlight.model.TrafficLight;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public abstract class TrafficLightView extends JInternalFrame {

	//Attributs
	private String _name;
	private TrafficLight _trafficLight;

	//Accesseurs
	public TrafficLight getTrafficLight() {
		return _trafficLight;
	}
	public String getName() {
		return _name;
	}

	//Constructeur
	public TrafficLightView(TrafficLight trafficLight, String name) {

		//On crée une trafficLightView (InternalFrame)
		super(name, false, false, false, false);
		_name = name;
		_trafficLight = trafficLight;
		this.setTitle(_name);

		//Bouttons on/off et change color
		JPanel buttons = new JPanel();
		buttons.add( new JButton( new AbstractAction("On/Off") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_trafficLight.onOff();
			}
		}));
		buttons.add( new JButton( new AbstractAction("Change color") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_trafficLight.swicthColor();
			}
		}));

		//On ajoute les boutons sur l' InternalFrame
		this.getContentPane().add(buttons, BorderLayout.SOUTH);

	}






}

