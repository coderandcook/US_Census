import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Frame1b extends JFrame {
	
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
					Frame1b frame = new Frame1b();
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
	public Frame1b() {
		stateList=ReadFile.Read();
		
		frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheState = new JLabel("Enter state");
		lblEnterTheState.setBounds(35, 68, 146, 26);
		contentPane.add(lblEnterTheState);
		
		textField = new JTextField();
		textField.setBounds(45, 94, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterYear = new JLabel("Enter year (2011-2016)");
		lblEnterYear.setBounds(35, 132, 166, 16);
		contentPane.add(lblEnterYear);
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 154, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPickSortingAlgorithm = new JLabel("Pick sorting algorithm");
		lblPickSortingAlgorithm.setBounds(35, 219, 216, 16);
		contentPane.add(lblPickSortingAlgorithm);
		
		JRadioButton rdbtnBubbleSort = new JRadioButton("Bubble Sort");
		rdbtnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					ReadFile.setChoice(1);
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnBubbleSort.setBounds(35, 247, 141, 23);
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
		rdbtnMergeSort.setBounds(35, 282, 141, 23);
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
		rdbtnQuickSort.setBounds(35, 317, 141, 23);
		contentPane.add(rdbtnQuickSort);
		
		JRadioButton rdbtnEnhancedQuickSort = new JRadioButton("Enhanced Quick Sort");
		rdbtnEnhancedQuickSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					ReadFile.setChoice(4);
					
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		rdbtnEnhancedQuickSort.setBounds(35, 352, 195, 23);
		contentPane.add(rdbtnEnhancedQuickSort);
		
		JLabel lblDisplayTheMost = new JLabel("Display the most similar state to state X in terms of percentage change for a given year");
		lblDisplayTheMost.setBounds(19, 24, 594, 16);
		contentPane.add(lblDisplayTheMost);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String state1=null;
				int year=0;
				double time1=0,time2=0;
				try {
					//get state
					state1=textField.getText();
					String te=state1.substring(0, 1);
					if(te.equals(".")) {
						
					}
					
					//state1="."+state1;
					//get year
					year=Integer.parseInt(textField_1.getText());
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Error");
				}
				
				ReadFile.setYear1(year-1);
				ReadFile.setYear2(year);
				int choice=ReadFile.getChoice();
				
				for(int i=0; i<stateList.size(); i++) {
					//get population of year and year-1
					int pop=stateList.get(i).getPopByYear()[year-1-2010];
					int pop2=stateList.get(i).getPopByYear()[year-2010];
					stateList.get(i).setPer(pop, pop2);
				}
				
				//sort here
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
				for(int i=0; i<stateList.size();i++) {
					String temp=stateList.get(i).getName();
					if(state1.equals(temp) || state1.equals(temp.substring(1, temp.length()))) {
						ReadFile.setListIndex(i);
						System.out.println(i);
						break;
					}/**
					if(state1.equals(stateList.get(i).getName()) || state1.equals("."+stateList.get(i).getName())) {
						//index=i; break;
						ReadFile.setListIndex(i);
						System.out.println(i);
						break;
					}*/
				}
				
				//setTime
				ReadFile.setTime(time1, time2);
				int listIndex=ReadFile.getListIndex();
				/**
				stateList.get(listIndex+1).getName();
				System.out.println("listIndex+1: "+(listIndex+1));*/
				
				String answer=null;
				System.out.println("listIndex: "+listIndex);
				if(listIndex==0) {
					String period=stateList.get(1).getName().substring(0, 1);
					String temp=stateList.get(1).getName();
					
					
					if(period.equals(".")) {
						answer="The most similar state: "+temp.substring(1,temp.length());
					}
					else {
						answer="The most similar region: "+stateList.get(1).getName();
					}
				}
				
				else if(listIndex==stateList.size()-1) {
					System.out.println("yes");
					String period=stateList.get(listIndex-1).getName().substring(0, 1);
					String temp=stateList.get(listIndex-1).getName();
					if(period.equals(".")) {
						answer="The most similar state: "+temp.substring(1,temp.length());
					}
					else {
						answer="The most similar region: "+stateList.get(listIndex-1).getName();
					}
				}
				else {
					double per0=stateList.get(listIndex).getPer();
					double per2=stateList.get(listIndex+1).getPer();
					double per1=stateList.get(listIndex-1).getPer();
					//string
					String temp1=stateList.get(listIndex-1).getName(); int size1=temp1.length();
					String period1=temp1.substring(0, 1);
					temp1=temp1.substring(1,size1); 
					//
					String temp2=stateList.get(listIndex+1).getName(); int size2=temp2.length();String period2=temp2.substring(0, 1);
					temp2=temp2.substring(1,size2);
					
					if (per0-per1<per2-per0 || per0-per1>per2-per0) {
						
						if(per0-per1<per2-per0) {
							if(period1.equals(".")) {
								answer="The most similar state is: "+temp1;
							}
							else {
								answer="The most similar is: "+stateList.get(listIndex-1).getName();
							}
						}
						else if(per0-per1>per2-per0) {
							if(period2.equals(".")) {
								answer="The most similar state is: "+temp2;
							}
							else {
								answer="The most similar is: "+stateList.get(listIndex+1).getName();
							}
						}
					}
					else {
						if(period1.equals(".") && period2.equals(".")) {
							answer="Both "+temp1+" and "+temp2+" are similar to this state";
						}
						else if(period1.equals(".")) {
							answer="Both "+temp1+" and "+stateList.get(listIndex+1).getName()+" are similar to this state";
						}
						else if(period2.equals(".")) {
							answer="Both "+stateList.get(listIndex-1).getName()+" and "+temp2+" are similar to this state";
						}
						else {
							answer="Both "+stateList.get(listIndex-1).getName()+" and "+stateList.get(listIndex+1).getName()+" are similar to this state";
						}	
					}
				}
				//print result in Dialog box:)
				double time=ReadFile.getTime(); System.out.println(time);
				String timeS=Double.toString(time);
				String timeMessage=answer+"\n"+"Run time for "+title+": "+timeS+" milliseconds";
				JOptionPane.showMessageDialog(null,timeMessage);
				frame.dispose();
				
				
			}
		});
		btnCalculate.setBounds(245, 386, 117, 29);
		contentPane.add(btnCalculate);
	}

}
