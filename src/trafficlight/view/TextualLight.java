
package trafficlight.view;

import trafficlight.model.LightColor;
import trafficlight.model.TrafficLight;

import java.awt.BorderLayout;

import javax.swing.*;

public class TextualLight extends TrafficLightView {



	//Attributs
	private JTextArea _textArea;

	//Constructeur
	public TextualLight(TrafficLight trafficLight, String name) {
		//On crée la vue textuelle
		super(trafficLight, name);
		_textArea = new JTextArea();
		_textArea.setEditable(false);

		//On l'affiche
		super.getContentPane().add(_textArea, BorderLayout.CENTER);
		super.setVisible(true);

	}

	//Accesseurs
	public JTextArea getTextArea() {
		return _textArea;
	}
}
