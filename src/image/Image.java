package image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Image extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BufferedImage img = null;

	/**
	 * Create the panel.
	 */

	@SuppressWarnings("static-access")
	public Image() {
		
		
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
	

		try {
			Viewer ocr = new Viewer();
			img = ImageIO.read(ocr.file);
			JLabel lblNewLabel = new JLabel(Viewer.file.getName());
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel.setBounds(10, 25, 268, 24);
			add(lblNewLabel);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JPanel getPanel(File file) {
		JPanel p = new JPanel();
		BufferedImage b = null;

		try {
			b = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ImageIcon icon=new ImageIcon(b);
		// JLabel jLabel=new JLabel(icon);
		// jLabel.setBounds(0,0,600,500);
		// p.add(jLabel);
		Graphics g = b.getGraphics();
		Graphics2D gd = (Graphics2D) g;
		gd.drawImage(b, AffineTransform.getScaleInstance(.5, .5), null);

		return p;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		// System.out.println("getimage1");
		Graphics2D gd = (Graphics2D) g;
		int h = img.getHeight();
		int w = img.getWidth();
		int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
		if (h < 550 && w < 1250) {
			x1 =  (1250 - w) / 2;
			x2 =  (550 - h) / 2;
			x3 = w;
			x4 = h;
			
		} else if (h < 550 && w >= 1250) {
			x1 = 20;
			x2 =  (550 - h) / 2;
			x3 = 1250;
			x4 = (int) (h * (1250.0 / w));
			x2 =  (550 - x4) / 2;
		
		} else if (h >= 550 && w < 1250) {
			
			x1=(1250-w)/2;
			x2=50;
			x3=(int) (w*(550.0/h));
			x1=(1250-x3)/2;
			x4=550;
		
		} else {
			
			x3=(int) (w*(550.0/h));
			x4=550;
			if(x3>1250)
			{
				x3=1200;
					x4 = (int) (h * (1250.0 / x3));
			}
			x1 =  (1250 - x3) / 2;
			
			x2 =  (550 - x4) / 2;
			x2=50;
			//.out.println(x2);
			
		}
		// System.out.println(y1);
		// gd.drawImage(img, AffineTransform.getScaleInstance(x1, x1), null);
	
		gd.drawImage(img, x1, x2, x3, x4, null);
		
	
	}
}
