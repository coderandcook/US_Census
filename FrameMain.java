import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FrameMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain window = new FrameMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	//ReadFile file=null;
	//ArrayList<State> stateList=null;
	/**
	 * Create the application.
	 */
	public FrameMain() {
		initialize();
		//stateList=ReadFile.Read();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(186, 24, 130, 27);
		frame.getContentPane().add(lblMainMenu);
		
		JButton btnDisplayAll = new JButton("(1) Compare percentage change of US population in a time period");
		btnDisplayAll.setHorizontalAlignment(SwingConstants.LEFT);
		btnDisplayAll.setBounds(6, 58, 427, 36);
		frame.getContentPane().add(btnDisplayAll);
		
		btnDisplayAll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"error");
				}
				frame.dispose();
				Frame1a oneA=new Frame1a();
				oneA.setVisible(true);
			}
			
		
		});
		
		
		JButton btncomparePercentageChange = new JButton("(2) Compare percentage change between two states");
		btncomparePercentageChange.setHorizontalAlignment(SwingConstants.LEFT);
		btncomparePercentageChange.setBounds(6, 155, 427, 36);
		frame.getContentPane().add(btncomparePercentageChange);
		btncomparePercentageChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
						
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"error");
				}
				frame.dispose();
				Frame1b oneB=new Frame1b();
				oneB.setVisible(true);
				
			}
		});
	}

}
