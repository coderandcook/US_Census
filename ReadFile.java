import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
public class ReadFile{
	private static int yearone;
	private static int yeartwo;
	private static int choice;
	private static double time;
	private static int listIndex;
	
	public static void setYear1(int year1) {
		yearone=year1;
	}
	public static int getYear1() {
		return yearone;
	}
	public static void setYear2(int year2) {
		yeartwo=year2;
	}
	public static int getYear2() {
		return yeartwo;
	}
	public static void setChoice(int c) {
		choice=c;
	}
	public static int getChoice() {
		return choice;
	}
	
	public static void setTime(double time1,double time2) {
		double answer=time2-time1;
		time=answer;
	}
	public static double getTime() {
		return time;
	}
	public static void setListIndex(int index) {
		listIndex=index;
	}
	public static int getListIndex() {
		return listIndex;
	}


	public static void BubbleSort(ArrayList<State> arr, int low, int high) {
		if(low>=high) {
			return;
		}
		else {
			State temp=new State();
			for(int i=0; i<high-1; i++) {
				//compare element at i and at i+1
				double p1=arr.get(i).getPer();
				double p2=arr.get(i+1).getPer();
				if(p1>p2) {
					//switch arr(i) and arr(i+1)
					temp=arr.get(i);
					arr.set(i, null);
					arr.set(i, arr.get(i+1));
					arr.set(i+1, null);
					arr.set(i+1, temp);
				}
			}
			BubbleSort(arr,low,high-=1);
		}
	
	}
	public static void MergeSort(ArrayList<State> arr, int low, int high) {
		if(low<high)  {
			int mid=(low+high)/2;
			MergeSort(arr,low,mid);
			MergeSort(arr,mid+1,high);
			Merge(arr,low,mid,high);
		}
	}
	public static void Merge(ArrayList<State> arr,int low,int mid,int high) {
		int size1=mid-low+1;
		int size2=high-(mid+1)+1;
		//copy each half
		ArrayList<State> left=new ArrayList<State>();
		ArrayList<State> right=new ArrayList<State>();
		
		for(int i=0; i<size1; i++) {
			left.add(arr.get(low+i));
		}
		for(int i=0; i<size2; i++) {
			right.add(arr.get(mid+1+i));
		}
		int index1=0, index2=0, index3=low;
		while(index1<size1 && index2<size2) {
			//Merges two ArrayList<State> according to % change in int[] popByYear
			//compare different states in the same two years
			double per1=left.get(index1).getPer();
			double per2=right.get(index2).getPer();

			if(per1<=per2) {
				arr.set(index3, null);
				arr.set(index3, left.get(index1));
				index1++;
			}
			else {
				arr.set(index3, null);
				arr.set(index3, right.get(index2));
				index2++;
			}
			index3++;	
		}
		while(index1<size1 && index3<arr.size()) {
			arr.set(index3, null);
			arr.set(index3, left.get(index1));
			index1++; index3++;
		}
		while(index2<size2 && index3<arr.size()) {
			arr.set(index3, null);
			arr.set(index3, right.get(index2));
			index2++; index3++;
		}
		
	}
	public static void QuickSort(ArrayList<State> list, int low, int high) {
		if(low<high) {
			int part=partition(list,low,high);
			QuickSort(list,low,part-1);
			QuickSort(list,part+1,high);
		}
	}
	public static int partition(ArrayList<State> list, int low, int high) {
		//pick pivot (the right most). Must be a number
		double pivot=list.get(high).getPer();
		//index of smaller element
		int index=(low-1);
		for(int i=low; i<high; i++) {
			//compare element in list to the pivot
			double num=list.get(i).getPer();
			if(num<=pivot) {
				index++;
				//swap arr(index) and arr(i)
				State temp=list.get(index);
				list.set(index, null);
				list.set(index, list.get(i));
				list.set(i, null);
				list.set(i, temp);
			}
		}
		State temp=list.get(index+1);
		list.set(index+1, null);
		list.set(index+1, list.get(high));
		list.set(high, null);
		list.set(high, temp);
		return index+1;
	}
	public static void QuickSort2(ArrayList<State> list, int low, int high) {
		if(low<high) {
			int part=partition2(list,low,high);
			QuickSort2(list,low,part-1);
			QuickSort2(list,part+1,high);
		}
	}
	public static int partition2(ArrayList<State> list, int low, int high) {
		//if size is bigger than or equal to 3, get the median value
		double pivot=0;
		int pIndex=0;
		if(high-low>=3) {
			double num1=list.get(high).getPer();
			double num2=list.get(high-1).getPer();
			double num3=list.get(high-2).getPer();

			if(num1>=num2) {
				if(num2>=num3) {pIndex=high-1;}
				else if(num1>=num3) {pIndex=high-2;}
				else if(num1<num3) {pIndex=high;}
			}
			else {
				if(num1>=num3) {pIndex=high;}
				else if(num2>=num3) {pIndex=high-2;}
				else if(num2<num3) {pIndex=high-1;}
			}
			
			//move pivot to the very end
			State temp=list.get(pIndex);
			pivot=list.get(pIndex).getPer();
			list.set(pIndex, null);
			list.set(pIndex, list.get(high));
			list.set(high, null);
			list.set(high, temp);
			
		}
		else {
			pivot=list.get(high).getPer();
		}
		int index=low-1;
		for(int i=low; i<high; i++) {
			double num=list.get(i).getPer();
			if(num<=pivot) {
				index++;
				State temp=list.get(index);
				list.set(index, null);
				list.set(index, list.get(i));
				list.set(i, null);
				list.set(i, temp);
			}
		}
		State temp=list.get(index+1);
		list.set(index+1, null);
		list.set(index+1, list.get(high));
		list.set(high, null);
		list.set(high, temp);
		return index+1;
	}
	
	

	public ReadFile() {
		Read();
	}
	public static ArrayList<State> Read() {
		Scanner input1;
		State state;
		ArrayList<State> stateList=new ArrayList<State>();
		//read csv
		try {
			File file=new File("Census.csv");
			input1=new Scanner(file);
			String line;
			int count=0;
			while(input1.hasNextLine()) {
				state=new State();
				count++;
				line=input1.nextLine(); //System.out.println(line);
				String[] biglist=line.split(",\"");
				
				if(count>4 && count!=61 && count<63) {
					String temp1=biglist[0];
					temp1=temp1.substring(0);
					if(temp1.equals(".")) {
						temp1=temp1.replaceAll(".","");
					}
					state.setName(temp1);
					
					int[] popList=new int[7];
					for(int i=3; i<10; i++) {
						String temp=biglist[i];
						//take out comma and quote from data
						 temp=temp.replaceAll(",", "");
						 temp=temp.replaceAll("\"", "");
						 //System.out.println(temp);
						
						int pop=Integer.parseInt(temp);
						popList[i-3]=pop;
					}
					state.setPopByYear(popList);
					double[] percentage=new double[6];
					//testing purposes
					//calculate % change in popList, and copy this in "percentage" list in State class

					for(int i=1; i<popList.length; i++) {
						double year1=popList[i-1];
						double year2=popList[i];
						state.setPer(year1, year2);
						percentage[i-1]=state.getPer();
					}
					
					state.setPercentage(percentage);
					
					stateList.add(state); 
					
				}
			}
			JOptionPane.showMessageDialog(null,"File read successfully");
			return stateList;
		}
		catch(FileNotFoundException fn) {
			JOptionPane.showMessageDialog(null,"error");
			return null;
		}
	}

}
