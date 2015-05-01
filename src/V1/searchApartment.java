package V1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Panel;
import java.awt.List;
import java.awt.event.MouseEvent;

public class searchApartment {

	private JFrame frame;
	private JTextField textFieldMin;
	private JTextField textFieldMax;
	private JTextField textFieldCity;
	private JTextField textFieldBedrooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchApartment window = new searchApartment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//this part is required to make sure the connection is made
	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	public searchApartment() {
		initialize();
		//this line of code is to make sure the connection is made on initialization
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Min");
		lblNewLabel.setBounds(104, 78, 20, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Max");
		lblNewLabel_1.setBounds(93, 103, 31, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("City, State");
		lblNewLabel_2.setBounds(59, 128, 75, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bedrooms");
		lblNewLabel_3.setBounds(59, 153, 65, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFieldMin = new JTextField();
		textFieldMin.setBounds(134, 75, 86, 20);
		frame.getContentPane().add(textFieldMin);
		textFieldMin.setColumns(10);
		
		textFieldMax = new JTextField();
		textFieldMax.setBounds(134, 100, 86, 20);
		frame.getContentPane().add(textFieldMax);
		textFieldMax.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(134, 125, 86, 20);
		frame.getContentPane().add(textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldBedrooms = new JTextField();
		textFieldBedrooms.setBounds(134, 150, 86, 20);
		frame.getContentPane().add(textFieldBedrooms);
		textFieldBedrooms.setColumns(10);
		
		//we put the final in front of List list to make it a final variable and unable to be changed

		final List list = new List();

		list.setBounds(239, 73, 476, 147);
		frame.getContentPane().add(list);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//query is not case sensitive, but JAVA is.
					String query="select * from ApartmentData where Rent>? and Rent<? and location=? and bedrooms=?";
					
					//connection is from Connection connection = null;
					PreparedStatement pst = connection.prepareStatement(query); //we are passing query through the statement
					pst.setString(1, textFieldMin.getText()); //first value passed is from username=? which is at index [1]. password=? is at index [2].
					//second value of is the text field name, and we get the value inside the textbox with getText()
					pst.setString(2, textFieldMax.getText());
					pst.setString(3, textFieldCity.getText());
					pst.setString(4, textFieldBedrooms.getText());
				     					
					
					ResultSet rs = pst.executeQuery();
					
					while (rs.next())
				      {
				        int aid = rs.getInt("aID");
				        String rent = rs.getString("rent");
				        String add = rs.getString("address");
				        String location = rs.getString("location");
				        String br = rs.getString("bedrooms");
				        final int mID = rs.getInt("mID"); 
				        // print the results
				        //System.out.format("%s, %s, %s\n", aid, rent, location);
				        //textOutput.setText("ID: " + aid + "\nRent: " + rent + "\nLocation: " + add + " " + location + "\nBedrooms: " + br);
				        list.add("ID: " + aid + "|  Rent: " + rent + "|  Location: " + add + " " + location + "|  Bedrooms: " + br);
						
				        
						//we then add the .addMouseListener create the event that something on the list is double-clicked
						//which will then in turn trigger the JOptionPane to display the info from management.
				        list.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								String name;
								String mAdd;
								String mPhone;
								
								if (arg0.getClickCount() == 2) {
									
									try {
										String query2 ="select * from ManagementData where mID=?";
										PreparedStatement pst2 = connection.prepareStatement(query2);
										
										ResultSet rs2 = pst2.executeQuery();// <<<--- this is where the error occurs.
										
										
										pst2.setInt(2, mID);
										//JOptionPane.showMessageDialog(null, "We got to this step");//testing purpose
										while (rs2.next())
									      {
											int mid = rs2.getInt("mID");
											name = rs2.getString("name");
											mAdd = rs2.getString("address");
											mPhone = rs2.getString("phone");
											JOptionPane.showMessageDialog(null, "Management: " + name + "\nAddress: " + mAdd + "\nPhone: " + mPhone);
									      }
										
										rs2.close();
										pst2.close();
									} catch (SQLException e) {
										JOptionPane.showMessageDialog(null, e);
									}
									//JOptionPane.showMessageDialog(null, "Display the management data.");
									//JOptionPane.showMessageDialog(null, "Management: " + name + "\nAddress: " + mAdd + "\nPhone: " + mPhone);
									}
								else {
									};
								}
						});
				        	
				      }
					
					
					//textOutput.setText(rs.getString(query));
				
					//always close the connection for each query. it is a constraint with sqlite
					rs.close();
					pst.close();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSearch.setBounds(131, 192, 89, 23);
		frame.getContentPane().add(btnSearch);
		

	}
}
