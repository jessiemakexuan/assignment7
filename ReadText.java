package lecture11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*Based on problem 1, create a button and textarea on the same layout. 
 * Each time you click the button, it will read a string from ArrayList in order and show it in the textarea. 
 * When number of clicks beyond the ArrayList, pop up an alert menu.*/

public class ReadText extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JButton ReadButton;
	private JTextArea LineText;
	private ArrayList<String> list;
	private int count;
	
	public ReadText() throws IOException{
		setTitle("Read Next Line");
		create();
		add();
		addListeners();
		display();
		list=new ReadLineByLine().readlinebyline();
		count=0;
	}
	public void create(){
		ReadButton = new JButton("Next Line=>");
		LineText = new JTextArea();
		scroll=new JScrollPane();
		scroll.setViewportView(LineText);
	}
	

	public void add(){
		Container con = getContentPane();
		getContentPane().setLayout(new BorderLayout());
		con.add("North",ReadButton );
		con.add("Center", scroll);
	}
	
	class ReadButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(count!=list.size()){
				LineText.append(list.get(count)+"\n");
				count++;
			}else{
				JOptionPane.showMessageDialog(null, "Cannot continue");
			}
		}
		
	} 

	public void addListeners(){
		ReadButton rb = new ReadButton();
		ReadButton.addActionListener(rb);
	}

	public void display() {
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		new ReadText();

	}
}