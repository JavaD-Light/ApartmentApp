package V1;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JFrameContainer {

	private JFrame frame = new JFrame();
	
	
	
	public void createAndShowGUI() {
		frame.setLayout(new FlowLayout());
		
		JPanelSubcontainer1 mp1 = new JPanelSubcontainer1();
		JPanelSubcontainer2 mp2 = new JPanelSubcontainer2();
		
		JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Search", null, mp1, "Increment");
        tabbedPane.addTab("Requisite Number", null, mp2, "Decrement");
        
        frame.setContentPane(tabbedPane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setTitle("Swing Counter");
		frame.setVisible(true);    
	}
}
