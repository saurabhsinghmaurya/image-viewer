package image;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Viewer {

	private JFrame frmImageViewer;

	/**
	 * Launch the application.
	 */
	JPanel jPanel1 = new JPanel();
	JPanel panel = null;
	static File file = null;
	JButton openButton, saveButton;
	JFileChooser fc, fc1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Viewer window = new Viewer();
					//UIManager.put("nimbusBase", new Color(100,50,200));
					//UIManager.put("nimbusBlueGrey", new Color(15,200,15));
					//UIManager.put("control", new Color(200,200,15));
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					           UIManager.setLookAndFeel(info.getClassName());
					          // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//new About().setVisible(true);
					            break;
					        }
					    }
					} catch (Exception e) {
					    // If Nimbus is not available, you can set the GUI to another look and feel.
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					}
					window.frmImageViewer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Viewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			frmImageViewer = new JFrame();
			frmImageViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(Viewer.class.getResource("/img/favicon.ico")));
			frmImageViewer.setUndecorated(true);

			// frmImageViewer.setUndecorated(true);
			// frmImageViewer.setOpacity(0.9f);
			frmImageViewer.setTitle("Image Viewer");
			frmImageViewer.getContentPane().setBackground(
					new Color(74, 204, 56));
			
			frmImageViewer.getContentPane().setLayout(null);

			JButton btnNewButton = new JButton("Previous");
			btnNewButton.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {

					if (arg0.getExtendedKeyCode() == 37) {
						System.gc();
						doPri();
					}
					if (arg0.getExtendedKeyCode() == 39) {
						System.gc();
						doNext();
					}

				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					doPri();
				}
			});
			btnNewButton.setBounds(125, 638, 89, 23);
			frmImageViewer.getContentPane().add(btnNewButton);

			JButton btnNewButton_1 = new JButton("Next");
			btnNewButton_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (arg0.getExtendedKeyCode() == 37) {
						System.gc();
						doPri();
					}
					if (arg0.getExtendedKeyCode() == 39) {
						System.gc();
						doNext();
					}
				}
			});
			btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					doNext();
					System.gc();
				}
			});
			btnNewButton_1.setBounds(999, 638, 89, 23);
			frmImageViewer.getContentPane().add(btnNewButton_1);

			JButton button = new JButton("close");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// frmImageViewer.setState(Frame.ICONIFIED);
					System.exit(0);
				}
			});
			button.setForeground(new Color(255, 255, 204));
			button.setBorder(new LineBorder(new Color(0, 0, 0)));
			button.setBackground(new Color(204, 0, 51));
			button.setBounds(1271, 0, 95, 25);
			frmImageViewer.getContentPane().add(button);

			// JPanel panel = new JPanel();
			// panel.setBounds(52, 66, 1266, 582);
			// frmImageViewer.getContentPane().add(panel);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 1370, 21);

			frmImageViewer.getContentPane().add(menuBar);
			JMenu mnNewMenu = new JMenu("File       ");
			menuBar.add(mnNewMenu);
			final JMenuItem item = new JMenuItem("Open                                          ");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (panel != null) {
						frmImageViewer.getContentPane().remove(panel);
						
						frmImageViewer.repaint();
					}
					fc = new JFileChooser("E:/photos/Bollywood");
					fc.setDragEnabled(true);
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"JPG & GIF Images", "jpg", "gif");
					fc.setFileFilter(filter);

					int returnVal = fc.showOpenDialog(item);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						file = fc.getSelectedFile();

						// System.out.println(23);

						ImageFileFilter fileFilter = new ImageFileFilter();

						if (fileFilter.accept(file)) {
							panel = new image.Image();
							// panel.setBounds(10, 11, 813, 366);

							panel.setBounds(0, 0, 1366, 682);
							frmImageViewer.getContentPane().add(panel);

							frmImageViewer.repaint();

						} else {
							JOptionPane.showMessageDialog(item,
									"File Should be an image");
						}
					}
				}
			});
			JMenuItem item1 = new JMenuItem("Exit");
			item1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					System.exit(0);
				}
			});

			mnNewMenu.add(item);
			mnNewMenu.add(item1);

			JMenu mnAction = new JMenu("Action      ");
			JMenuItem item2 = new JMenuItem("Scan                        ");
			JMenuItem item3 = new JMenuItem("Delete                      ");
			item3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

				}
			});
			mnAction.add(item2);
			mnAction.add(item3);
			menuBar.add(mnAction);

			JMenu mnNewMenu_1 = new JMenu("Help   ");
			JMenuItem item4 = new JMenuItem("About                          ");
			item4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			new About().setVisible(true);		
					
				}
			});
			mnNewMenu_1.add(item4);

			menuBar.add(mnNewMenu_1);
//			JPanel panel_1 = new Authors();
//			panel_1.setBounds(350, 83, 647, 415);
//			frmImageViewer.getContentPane().add(panel_1);
//			
		
			frmImageViewer.setBounds(0, 0, 1366, 728);
			frmImageViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage() + e.getClass());
		}
	}

	public void doPri() {
		if (panel != null) {
			frmImageViewer.getContentPane().remove(panel);
			frmImageViewer.repaint();
		}
		if (file == null) {
			fc = new JFileChooser("E:/photos/Bollywood");
			fc.setDragEnabled(true);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images", "jpg", "gif");
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				ImageFileFilter fileFilter = new ImageFileFilter();

				if (fileFilter.accept(file)) {
					panel = new image.Image();
					// panel.setBounds(10, 11, 813, 366);

					panel.setBounds(0, 0, 1366, 682);
					panel.setOpaque(true);
		
					frmImageViewer.getContentPane().add(panel);

					frmImageViewer.repaint();

				} else {
					JOptionPane.showMessageDialog(jPanel1,
							"File Should be an image");
				}
			}
		} else {
			file = new Dg().priFile(file);
			ImageFileFilter fileFilter = new ImageFileFilter();

			if (fileFilter.accept(file)) {
				panel = new image.Image();
				// panel.setBounds(10, 11, 813, 366);

				panel.setBounds(0, 0, 1366, 682);
				panel.setOpaque(true);
				frmImageViewer.getContentPane().add(panel);

				frmImageViewer.repaint();

			} else {
				JOptionPane.showMessageDialog(jPanel1,
						"File Should be an image");
			}
		}

		// System.out.println(23);

	}

	public void doNext() {
		if (panel != null) {
			frmImageViewer.getContentPane().remove(panel);
			frmImageViewer.repaint();
		}

		if (file == null) {
			fc = new JFileChooser("E:/photos/Bollywood");
			fc.setDragEnabled(true);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images", "jpg", "gif");
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				ImageFileFilter fileFilter = new ImageFileFilter();

				if (fileFilter.accept(file)) {

					panel = new image.Image();
					// panel.setBounds(10, 11, 813, 366);
					panel.repaint();
					panel.setBounds(0, 0, 1366, 682);
					frmImageViewer.getContentPane().add(panel);

					frmImageViewer.repaint();

				} else {
					JOptionPane.showMessageDialog(jPanel1,
							"File Should be an image");
				}
			}
		} else {

			file = new Dg().nextFile(file);
			ImageFileFilter fileFilter = new ImageFileFilter();

			if (fileFilter.accept(file)) {

				panel = new image.Image();
				// panel.setBounds(10, 11, 813, 366);

				panel.setBounds(0, 0, 1366, 682);

				panel.repaint();
				frmImageViewer.getContentPane().add(panel);

				frmImageViewer.repaint();

			} else {

				JOptionPane.showMessageDialog(jPanel1,
						"File Should be an image");
			}
		}

		// System.out.println(23);

	}
}
