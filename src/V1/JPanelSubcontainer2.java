package V1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelSubcontainer2 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int count = 100;
	private JTextField tfCount;
	
	public JPanelSubcontainer2(){
		//JPanel panel = new JPanel();
		this.setLayout(new FlowLayout());
		this.setMaximumSize(new Dimension(400, 400));
		
		add(new JLabel("Counter"));

		tfCount = new JTextField(count + "", 10);  //10 columns
		tfCount.setEditable(false);
		tfCount.setHorizontalAlignment(JTextField.RIGHT);
		tfCount.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		tfCount.setOpaque(true);
		tfCount.setBackground(Color.YELLOW);
		this.add(tfCount);
		
		JButton btnCount = new JButton("Count");
		this.add(btnCount);
		
		//===============================================
		// Register the listener to the button.
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				tfCount.setText(count + "");
			}
		});
		//===============================================
	}
}

