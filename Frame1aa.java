import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Frame1aa extends JFrame {

	private JPanel contentPane;

	private JFrame frome;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1aa frame = new Frame1aa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int year1=0, year2=0;
	/**
	 * Create the frame.
	 */
	public Frame1aa() {
		frome = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		double time=ReadFile.getTime();
		JLabel lblNewLabel = new JLabel("It took "+time+" milliseconds to sort");
		lblNewLabel.setBounds(97, 112, 335, 16);
		contentPane.add(lblNewLabel);
		
	}

}
