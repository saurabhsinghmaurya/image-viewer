package image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Font;

public class Authors extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Authors() {
		setLayout(null);
		setPreferredSize(new Dimension(500,850));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Authors.class.getResource("/img/DSC_0025.JPG")));
		lblNewLabel.setBounds(39, 30, 117, 153);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Authors.class.getResource("/img/DSC_0026.JPG")));
		label.setBounds(39, 230, 117, 153);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Authors.class.getResource("/img/DSCF0862 copy.jpg")));
		label_1.setBounds(39, 430, 117, 153);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Authors.class.getResource("/img/DSC_0010.jpg")));
		label_2.setBounds(39, 630, 117, 153);
		add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("Saurabh Singh Maurya");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(202, 83, 273, 43);
		add(lblNewLabel_1);
		
		JLabel lblChandraSekharSoni = new JLabel("Chandra Shekhar Soni");
		lblChandraSekharSoni.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChandraSekharSoni.setBounds(202, 271, 273, 43);
		add(lblChandraSekharSoni);
		
		JLabel lblRahulMishra = new JLabel("Rahul Mishra");
		lblRahulMishra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblRahulMishra.setBounds(202, 478, 273, 43);
		add(lblRahulMishra);
		
		JLabel lblAmitKumar = new JLabel("Amit kumar");
		lblAmitKumar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAmitKumar.setBounds(202, 658, 273, 43);
		add(lblAmitKumar);
		

	}

}
