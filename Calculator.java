package lecture11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*Implement a calculator and it's add, minus, multiply and divide operations.*/

public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton numbers[] = new JButton[10];
	private JButton add, minus, multiply, divide, point, equal;
	private JTextArea textArea;
	private double temp=0;
	private double result=0;
	private boolean havePoint=false;
	private String operation=null;
	private int tempcount=0;
	private int resultcount=0;
	
	public Calculator(){
		create();
		setFonts();
		add();
		addListener();
		display();
	}
	private void display() {
		setSize(250,300);
		setVisible(true);		
	}	
	private void addListener() {
		for(int i=0;i<10;i++){
			int num=i;
			numbers[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!havePoint){
						temp=temp*10+num;
					}else{
						temp=temp*10+num;
						tempcount++;
					}
					textArea.append(""+num);
				}
				
			});
		}
		point.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(havePoint){
					JOptionPane.showMessageDialog(null, "ERROR: Cannot have two points here");
				}else{
					havePoint=true;
					textArea.append(".");
				}
			}
			
		});
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(operation!=null){
					JOptionPane.showMessageDialog(null, "ERROR: Cannot have two operations here");
				}else{
					operation="+";
					textArea.append("+");
					result=temp;
					resultcount=tempcount;
					temp=0;
					tempcount=0;
					havePoint=false;
				}
			}
			
		});
		minus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(operation!=null){
					JOptionPane.showMessageDialog(null, "ERROR: Cannot have two operations here");
				}else{
					operation="-";
					textArea.append("-");
					result=temp;
					resultcount=tempcount;
					temp=0;
					tempcount=0;
					havePoint=false;
				}
			}
			
		});
		multiply.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(operation!=null){
					JOptionPane.showMessageDialog(null, "ERROR: Cannot have two operations here");
				}else{
					operation="*";
					textArea.append("*");
					result=temp;
					resultcount=tempcount;
					temp=0;
					tempcount=0;
					havePoint=false;
				}
			}
			
		});
		divide.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(operation!=null){
					JOptionPane.showMessageDialog(null, "ERROR: Cannot have two operations here");
				}else{
					operation="/";
					textArea.append("/");
					result=temp;
					resultcount=tempcount;
					tempcount=0;
					temp=0;
					havePoint=false;
				}
			}
			
		});
		
		equal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//clean calculator
				if(operation==null){     
					textArea.setText("");
					result=0;
					temp=0;
					tempcount=0;
					resultcount=0;
					havePoint = false;
					operation = null;
					return;
				}
				if(operation.equals("+")){
					if(tempcount<resultcount){
						temp=temp*Math.pow(10, resultcount-tempcount);
						result=(result+temp)*Math.pow(0.1, resultcount);
					}else{
						result=result*Math.pow(10, tempcount-resultcount);
						result=(result+temp)*Math.pow(0.1, tempcount);
					}
					
				}
				if(operation.equals("-")){
					if(tempcount<resultcount){
						temp=temp*Math.pow(10, resultcount-tempcount);
						result=(result-temp)*Math.pow(0.1, resultcount);
					}else{
						result=result*Math.pow(10, tempcount-resultcount);
						result=(result-temp)*Math.pow(0.1, tempcount);
					}
					
				}
				if(operation.equals("*")){
					result=result*temp;
					resultcount=resultcount+tempcount;
					result=Math.pow(0.1, resultcount)*result;
				}
				if(operation.equals("/")){
					if(temp==0){
						JOptionPane.showMessageDialog(null, "ERROR: Number cannot divide by 0");
					}else{
						result=result/temp;
						resultcount=resultcount-tempcount;
						result=result*Math.pow(0.1, resultcount);
					}
				}
				textArea.setText(""+result);
				temp=0;
				result=0;
				tempcount=0;
				resultcount=0;
				havePoint=false;
				operation=null;
			}
			
		});
	}
	private void add(){
		BorderLayout bl = new BorderLayout();
		Container con = getContentPane();
		con.setLayout(bl);
		con.add("North",textArea);
		JPanel grid = new JPanel();
		GridLayout gl = new GridLayout(4,4);
		grid.setLayout(gl);
		grid.add(numbers[7]);
		grid.add(numbers[8]);
		grid.add(numbers[9]);
		grid.add(add);
		grid.add(numbers[4]);
		grid.add(numbers[5]);
		grid.add(numbers[6]);
		grid.add(minus);
		grid.add(numbers[1]);
		grid.add(numbers[2]);
		grid.add(numbers[3]);
		grid.add(multiply);
		grid.add(numbers[0]);
		grid.add(point);
		grid.add(divide);
		grid.add(equal);
		con.add("Center",grid);
	}
	private void setFonts() {
		textArea.setFont(new Font("Arial", Font.BOLD, 50));
		Font font = new Font("Arial", Font.BOLD, 24);
		add.setFont(font);
		minus.setFont(font);
		multiply.setFont(font); 
		divide.setFont(font); 
		point.setFont(font); 
		equal.setFont(font);
	}
	private void create(){
		setTitle("Calc2");
		for(int i=0;i<10;i++){
			numbers[i] = new JButton(""+i);
			numbers[i].setFont(new Font("Arial", Font.BOLD, 30));
		}
		add = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		point = new JButton(".");
		equal = new JButton("=");
		textArea = new JTextArea(1,4);
	}
	public static void main(String[] args) {
		new Calculator();
	}

}
