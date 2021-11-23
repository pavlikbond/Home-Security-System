package application;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Display {

	private JFrame frame;
	private final JTextField txtReady = new JTextField();
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JCheckBox zone1;
	private JCheckBox zone2;
	private JCheckBox zone3;
	private JButton btnStay;
	private JButton btnAway;
	private JButton btnCancel;
	private JButton btnMotionDetector;
	private JLabel statusLabel;

	public Display() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		Dimension screenSize = new Dimension(625, 300);
		frame.setPreferredSize(screenSize);

		btn1 = new JButton("1");
		btn1.setBounds(10, 0, 42, 39);
		frame.getContentPane().add(btn1);

		btn2 = new JButton("2");
		btn2.setBounds(52, 0, 42, 39);
		frame.getContentPane().add(btn2);

		btn3 = new JButton("3");
		btn3.setBounds(90, 0, 42, 39);
		frame.getContentPane().add(btn3);

		btn4 = new JButton("4");
		btn4.setBounds(10, 38, 42, 39);
		frame.getContentPane().add(btn4);

		btn5 = new JButton("5");
		btn5.setBounds(52, 38, 42, 39);
		frame.getContentPane().add(btn5);

		btn6 = new JButton("6");
		btn6.setBounds(90, 38, 42, 39);
		frame.getContentPane().add(btn6);

		btn7 = new JButton("7");
		btn7.setBounds(10, 76, 42, 39);
		frame.getContentPane().add(btn7);

		btn8 = new JButton("8");
		btn8.setBounds(52, 76, 42, 39);
		frame.getContentPane().add(btn8);

		btn9 = new JButton("9");
		btn9.setBounds(90, 76, 42, 39);
		frame.getContentPane().add(btn9);

		btn0 = new JButton("0");
		btn0.setBounds(52, 113, 42, 39);
		frame.getContentPane().add(btn0);
		txtReady.setText("Ready");
		txtReady.setBounds(147, 0, 462, 160);
		frame.getContentPane().add(txtReady);
		txtReady.setColumns(10);

		zone1 = new JCheckBox("Zone 1");
		zone1.setBounds(10, 177, 70, 23);
		frame.getContentPane().add(zone1);

		zone2 = new JCheckBox("Zone 2");
		zone2.setBounds(78, 177, 70, 23);
		frame.getContentPane().add(zone2);

		zone3 = new JCheckBox("Zone 3");
		zone3.setBounds(150, 177, 70, 23);
		frame.getContentPane().add(zone3);

		btnStay = new JButton("Stay");
		btnStay.setBounds(246, 177, 89, 23);
		frame.getContentPane().add(btnStay);

		btnAway = new JButton("Away");
		btnAway.setBounds(345, 177, 89, 23);
		frame.getContentPane().add(btnAway);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(497, 177, 89, 23);
		frame.getContentPane().add(btnCancel);

		btnMotionDetector = new JButton("Motion Detector");
		btnMotionDetector.setBounds(10, 227, 138, 23);
		frame.getContentPane().add(btnMotionDetector);

		statusLabel = new JLabel("Status: Ready");
		statusLabel.setBounds(10, 207, 151, 14);
		frame.getContentPane().add(statusLabel);

		frame.setTitle("Home Security System");
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}