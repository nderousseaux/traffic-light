package trafficlight;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextualLight extends JFrame implements TrafficLightObserver {

	private TrafficLight _trafficLight;

	private JTextArea _textArea;

	public TextualLight(TrafficLight trafficLight) {
		_trafficLight = trafficLight;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Textual trafficlight.view");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());

		_textArea = new JTextArea();
		_textArea.setEditable(false);
		this.getContentPane().add(_textArea, BorderLayout.CENTER);

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
		this.getContentPane().add(buttons, BorderLayout.NORTH);

		this.setVisible(true);
	}

	@Override
	public void update() {
		_textArea.append(_trafficLight.toString());
	}

}
