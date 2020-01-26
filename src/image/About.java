package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	private JTextPane txtpnFranchiseSolutionIs;
	private JButton button;

	/**
	 * Create the dialog.
	 */
	public About() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setUndecorated(true);
		setOpacity(0.95f);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBounds(400, 100, 550, 543);
		getContentPane().setLayout(null);
	 txtpnFranchiseSolutionIs = new JTextPane();
		txtpnFranchiseSolutionIs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				txtpnFranchiseSolutionIs.setForeground(new Color(0, 26, 128));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				txtpnFranchiseSolutionIs.setForeground(new Color(0, 0, 0));
			}
		});
		txtpnFranchiseSolutionIs.setEditable(false);
		txtpnFranchiseSolutionIs.setText("SARC IMAGE VIEWER is the desktop application made by the software development team popularly known as SARC team comprises of their initials.");
		txtpnFranchiseSolutionIs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtpnFranchiseSolutionIs.setBounds(387, 67, 45, 30);
		
		button = new JButton("close");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// frmImageViewer.setState(Frame.ICONIFIED);
			
				dispose();
			}
		});
		button.setForeground(new Color(255, 255, 204));
	
		button.setBackground(new Color(204, 0, 51));
		button.setBounds(450, 0,100, 25);
		getContentPane().add(button);
	
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 22, 536, 542);
		tabbedPane.addTab("About", txtpnFranchiseSolutionIs);
		JScrollPane jsp=new JScrollPane();
		jsp.setViewportView(new Authors());
		
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		tabbedPane.addTab("Authors", jsp);
		getContentPane().add(tabbedPane);
		
		

	}
}
