package trafficlight;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TrafficLightView extends JFrame implements TrafficLightObserver {

	private TrafficLight _trafficLight;

	public TrafficLightView( TrafficLight trafficLight ) {

		_trafficLight = trafficLight;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 480);
		this.setLayout(new BorderLayout());

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
		this.getContentPane().add(buttons, BorderLayout.SOUTH);
	}

}

