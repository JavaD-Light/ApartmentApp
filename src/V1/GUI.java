package V1;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class GUI {

	public static void main(String[] args) {
//		//this is the sample data to be used
//		Apartment a = new Apartment("1000000", 500, 500, 2, 1, false, false, 1,false, "Cloquet, MN","June, 01, 2015", true);
//		Apartment b = new Apartment("2000000", 550, 550, 1, 1, false, false, 1,false, "Duluth, MN","June, 01, 2015", true);
//		Apartment c = new Apartment("3000000", 600, 650, 2, 2, false, false, 1,false, "Virginia, MN","June, 01, 2015", true);
//		Apartment d = new Apartment("4000000", 650, 750, 3, 1, false, false, 1,false, "Duluth, MN","June, 01, 2015", true);
//		Management ma = new Management("000001","Blue Stone Lofts", "101 Summit St, Duluth, MN 55803", "(218) 724-3505");
//		Management mb = new Management("000002","Fire House Flats", "152 East 3rd St, Duluth, MN 55805", "(218) 784-6456");
//		Management mc = new Management("000003","Example Management Lofts", "123 Fake St, Duluth, MN 55811", "(218) 125-4529");
//		
//		//used to put the apartment listings into a list
//		ArrayList<Apartment> aptList = new ArrayList<Apartment>();
//		aptList.add(a);
//		aptList.add(b);
//		aptList.add(c);
//		aptList.add(d);
		
		
	   // Recommended to run the GUI construction in
	   // Event dispatching thread for thread-safe operations.
	   // Anonymous class.
	   SwingUtilities.invokeLater(new Runnable() {
	      @Override
	      public void run() {
	    	  JFrameContainer mf = new JFrameContainer();
	          mf.createAndShowGUI();
	      }
	   });
	}
}
