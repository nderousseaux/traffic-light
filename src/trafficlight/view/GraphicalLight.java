package trafficlight.view;


import trafficlight.model.TrafficLight;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class GraphicalLight extends TrafficLightView {

	//Attributs
	private JPanel _colorPanel;

	//Constructeur
	public GraphicalLight( TrafficLight trafficLight, String name) {
		//On crée un Traffic light view
		super(trafficLight, name);
		_colorPanel = new JPanel();

		//Par défaut, le fond est gris
		_colorPanel.setBackground(Color.GRAY);

		//On le place au centre
		super.getContentPane().add(_colorPanel, BorderLayout.CENTER);
		super.setVisible(true);

	}

	//Accesseurs
	public JPanel getColorPanel() {
		return _colorPanel;
	}


}

