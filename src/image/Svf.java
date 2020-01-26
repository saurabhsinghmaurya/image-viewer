package image;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class Svf {

	private JFrame frame;
	private JPanel panel;
	private int i;
	private JScrollPane jsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Svf window = new Svf();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Svf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 panel = new JPanel();
		  jsp=new JScrollPane();
		 
		  i=100;
		panel.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				System.out.println(arg0.getWheelRotation());
				i++;
				jsp.setBounds(49,55,50,144);
				panel.setPreferredSize(new Dimension(i,i));
				panel.repaint();
				frame.repaint();
			}
		});
		panel.setBackground(Color.BLUE);
		
		panel.setBounds(49, 55, 50, 144);
		
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		jsp.getViewport().add(panel);
		frame.getContentPane().add(jsp);
	}
}
