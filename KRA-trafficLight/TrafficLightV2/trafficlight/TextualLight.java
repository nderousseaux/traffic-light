package trafficlight;

import java.awt.BorderLayout;

import javax.swing.JTextArea;

public class TextualLight extends TrafficLightView {

	private JTextArea _textArea;

	public TextualLight(TrafficLight trafficLight) {
		super(trafficLight);

		this.setTitle("Textual trafficlight.view");

		_textArea = new JTextArea();
		_textArea.setEditable(false);
		this.getContentPane().add(_textArea, BorderLayout.CENTER);

		this.setVisible(true);
	}

	@Override
	public void update( LightColor color, Boolean isOn ) {
		_textArea.append(
			"State: "+(isOn ? "On, Color: "+color : "Off")+"\n"
		);
	}

}
