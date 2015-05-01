package V1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPanelSubcontainer1 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int count = 0;
	private JTextField maxPrice;
	private JTextField test2;
	private JTextField minPrice;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public JPanelSubcontainer1(){
		
		//this is the sample data to be used
		Apartment a = new Apartment("1000000", 500, 500, 2, 1, false, false, 1,false, "Cloquet, MN","June, 01, 2015", true);
		Apartment b = new Apartment("2000000", 550, 550, 1, 1, false, false, 1,false, "Duluth, MN","June, 01, 2015", true);
		Apartment c = new Apartment("3000000", 600, 650, 2, 2, false, false, 1,false, "Virginia, MN","June, 01, 2015", true);
		Apartment d = new Apartment("4000000", 650, 750, 3, 1, false, false, 1,false, "Duluth, MN","June, 01, 2015", true);
		Management ma = new Management("000001","Blue Stone Lofts", "101 Summit St, Duluth, MN 55803", "(218) 724-3505");
		Management mb = new Management("000002","Fire House Flats", "152 East 3rd St, Duluth, MN 55805", "(218) 784-6456");
		Management mc = new Management("000003","Example Management Lofts", "123 Fake St, Duluth, MN 55811", "(218) 125-4529");
		
		//used to put the apartment listings into a list
		final ArrayList<Apartment> aptList = new ArrayList<Apartment>();
		aptList.add(a);
		aptList.add(b);
		aptList.add(c);
		aptList.add(d);
		
		this.setMaximumSize(new Dimension(400, 400));
		setLayout(null);
		
		JLabel label = new JLabel("Max");
		label.setBounds(112, 9, 20, 14);
		add(label);
		

		maxPrice = new JTextField(count + "", 10);  //10 columns
		maxPrice.setBounds(191, 11, 86, 20);
		maxPrice.setHorizontalAlignment(JTextField.RIGHT);	
		this.add(maxPrice);
		final int max = Integer.parseInt(maxPrice.getText());  //this method is used to convert the text into an integer
		
		JButton findApt = new JButton("Find");
		findApt.setBounds(366, 254, 61, 23);
		this.add(findApt);
		
		minPrice = new JTextField("0", 10);
		minPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		minPrice.setBounds(191, 42, 86, 20);
		add(minPrice);
		final int min = Integer.parseInt(minPrice.getText());  //this method is used to convert the text into an integer
		
		textField_1 = new JTextField("0", 10);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setEditable(false);
		textField_1.setBounds(191, 73, 86, 20);
		add(textField_1);
		
		textField_2 = new JTextField("0", 10);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setEditable(false);
		textField_2.setBounds(191, 104, 86, 20);
		add(textField_2);
		
		textField_3 = new JTextField("0", 10);
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setEditable(false);
		textField_3.setBounds(191, 137, 86, 20);
		add(textField_3);
		
		textField_4 = new JTextField("0", 10);
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setEditable(false);
		textField_4.setBounds(191, 168, 86, 20);
		add(textField_4);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(112, 34, 20, 14);
		add(lblMin);
		
		
		//===============================================
		// Register the listener to the button.
		findApt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				count+=10;
//				maxPrice.setText(count + "");
				JOptionPane.showMessageDialog (null, "Step 1 complete", "BMI", JOptionPane.INFORMATION_MESSAGE);
				for (Apartment listings : aptList){
					JOptionPane.showMessageDialog (null, "Step 2 complete", "BMI", JOptionPane.INFORMATION_MESSAGE);
					
					if((listings.rent < max) && (listings.rent > min)){
//						System.out.println(" ");
//						System.out.println(listings.returnDetails());
//						System.out.println("=============================");
						JOptionPane.showMessageDialog (null, listings.returnDetails(), "BMI", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
				
			}
		});
		//===============================================
	}
}
