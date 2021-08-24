package trafficlight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicalLight extends JFrame implements TrafficLightObserver {

	private TrafficLight _trafficLight;

	private JPanel _colorPanel;

	public GraphicalLight( TrafficLight trafficLight ) {
		_trafficLight = trafficLight;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Graphical trafficlight.view");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());

		_colorPanel = new JPanel();
		_colorPanel.setBackground(Color.RED);
		this.getContentPane().add(_colorPanel, BorderLayout.CENTER);

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
	
		this.setVisible(true);
	}

	@Override
	public void update() {
		if ( _trafficLight.getIsOn() ) {
			switch (_trafficLight.getColor()) {
				case RED:
					_colorPanel.setBackground(Color.RED);
					break;
				case GREEN:
					_colorPanel.setBackground(Color.GREEN);
					break;
				case ORANGE:
					_colorPanel.setBackground(Color.ORANGE);
					break;
				default:
					break;
			}
		}
		else {
			_colorPanel.setBackground(Color.GRAY);
		}
	}

}

