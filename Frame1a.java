import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Frame1a extends JFrame {
	
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1a frame = new Frame1a();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	ReadFile file=null;
	ArrayList<State> stateList=null;
	ArrayList<State> newList=null;
	
	/**
	 * Create the frame.
	 */
	public Frame1a() {
		stateList=ReadFile.Read();
		
		frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBetweenWhichTwo = new JLabel("From what year to what year do you want to see population change in percentage?");
		lblBetweenWhichTwo.setHorizontalAlignment(SwingConstants.LEFT);
		lblBetweenWhichTwo.setVerticalAlignment(SwingConstants.TOP);
		lblBetweenWhichTwo.setBounds(36, 81, 612, 51);
		contentPane.add(lblBetweenWhichTwo);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(64, 135, 61, 16);
		contentPane.add(lblFrom);
		
		textField = new JTextField();
		textField.setBounds(120, 130, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("(2010-2016)");
		label.setBounds(262, 135, 98, 16);
		contentPane.add(label);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(64, 188, 61, 16);
		contentPane.add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 183, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("(2010-2016)");
		label_1.setBounds(262, 188, 98, 16);
		contentPane.add(label_1);

		
		JLabel lblNewLabel = new JLabel("Pick a sorting algorithm");
		lblNewLabel.setBounds(36, 234, 528, 26);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnBubbleSort = new JRadioButton("Bubble Sort");
		rdbtnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ReadFile.setChoice(1);
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnBubbleSort.setBounds(46, 272, 141, 23);
		contentPane.add(rdbtnBubbleSort);
		
		JRadioButton rdbtnMergeSort = new JRadioButton("Merge Sort");
		rdbtnMergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					ReadFile.setChoice(2);
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnMergeSort.setBounds(46, 307, 141, 23);
		contentPane.add(rdbtnMergeSort);
		
		JRadioButton rdbtnQuickSort = new JRadioButton("Quick Sort");
		rdbtnQuickSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					ReadFile.setChoice(3);
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnQuickSort.setBounds(46, 342, 141, 23);
		contentPane.add(rdbtnQuickSort);
		
		JRadioButton rdbtnEnhancedQuicksort = new JRadioButton("Enhanced QuickSort");
		rdbtnEnhancedQuicksort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					ReadFile.setChoice(4);
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnEnhancedQuicksort.setBounds(46, 377, 209, 23);
		contentPane.add(rdbtnEnhancedQuicksort);
		
		JButton btnCalculate = new JButton("Calculate percentage change");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1=0,num2=0;
				double time1=0, time2=0;
				try {
					num1=Integer.parseInt(textField.getText());
					num2=Integer.parseInt(textField_1.getText());

				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Error");
				}
				ReadFile.setYear1(num1);
				ReadFile.setYear2(num2);
				int choice=ReadFile.getChoice();
				
				//calculate percentage change between entered years
				for(int i=0; i<stateList.size(); i++) {
					int pop=stateList.get(i).getPopByYear()[num1-2010];
					int pop2=stateList.get(i).getPopByYear()[num2-2010];
					stateList.get(i).setPer(pop, pop2);
				}
				String title=null;
				if(choice==1) {
					title="Bubble Sort";
					//calculate time before and after
					time1=System.currentTimeMillis();
					ReadFile.BubbleSort(stateList, 0, stateList.size());
					time2=System.currentTimeMillis();
				}
				else if(choice==2) {
					title="Merge Sort";
					time1=System.currentTimeMillis();
					ReadFile.MergeSort(stateList, 0, stateList.size()-1);
					time2=System.currentTimeMillis();
				}
				else if(choice==3) {
					title="Quick Sort";
					time1=System.currentTimeMillis();
					ReadFile.QuickSort(stateList, 0, stateList.size()-1);
					time2=System.currentTimeMillis();
				}
				else if(choice==4) {
					title="Enhanced Quick Sort";
					time1=System.currentTimeMillis();
					ReadFile.QuickSort2(stateList, 0, stateList.size()-1);
					time2=System.currentTimeMillis();
				}
				
				ReadFile.setTime(time1, time2);
				
				String[] [] rows=new String[stateList.size()][2];
				for(int i=0; i<stateList.size(); i++) {
					String[] tempList=new String[2];
					String temp=stateList.get(i).getName(); int tempSize=temp.length();
					
					String first=temp.substring(0,1);
					if(first.equals(".")) {
						temp=temp.substring(1, tempSize);
					}
					String formatP=String.format("%.2f", stateList.get(i).getPer());
					tempList[0]=temp;
					tempList[1]=formatP;
					rows[i]=tempList;
				}
				String[] cols= {"name of state or region","percentage change in population (%)"};
				JTable table=new JTable(rows,cols);
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				frame.dispose();
				/**
				Frame1aa oneAA=new Frame1aa();
				oneAA.setVisible(true);*/
				double time=ReadFile.getTime(); System.out.println(time);
				String timeS=Double.toString(time);
				String timeMessage="Run time for "+title+": "+timeS+" milliseconds";
				JOptionPane.showMessageDialog(null,timeMessage);
			}
		});
		
		btnCalculate.setBounds(204, 412, 218, 29);
		contentPane.add(btnCalculate);
		
		JLabel lblDisplayPercentageChange = new JLabel("Display percentage change of all states between year X and year Y");
		lblDisplayPercentageChange.setBounds(6, 37, 582, 16);
		contentPane.add(lblDisplayPercentageChange);
		
		
	}
}
