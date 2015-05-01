package V1;

public class Management {
	String mID;
	String name;
	String address;
	String phone;
	
	//Note** Let's try to make a string ID auto-generate on each creation 
	//of a management profile. Same goes for Apartment(aID).
	public Management(String id, String name, String address, String phone){
		this.mID = id;
		this.name = name;
		this.address = address;
		this.phone = phone; 
	}
	
	//getters for management, so that you can access the global variables 
	public String getID(){
		return this.mID;
	}
	public String getName(){
		return this.name;
	}
	public String getPhone(){
		return this.phone; 
	}
	public String getAdd(){
		return this.address;
	}
	
	
	//setters for management, in case you want to save changes to information
	public void setName(String newName){
		this.name = newName;
	}
	public void setAddress(String newAdd){
		this.address = newAdd;
	}
	public void setPhone(String newPhone){
		this.phone = newPhone;
	}
	public void getAdd(String newAdd){
		this.address = newAdd;
	}
	
	public String getManagementInfo(){
		return "Management Name: " + getName() + "\nOffice Address: " + getAdd() +
				"\nOffice Phone: " + getPhone();
	}
	
	
	public static void main(String[] args){
		Management a = new Management("000001","Blue Stone Lofts", "101 Summit St, Duluth, MN 55803", "(218) 724-3505");
		
		Management b = new Management("000002","Fire House Flats", "152 East 3rd St, Duluth, MN 55805", "(218) 784-6456");
		
		Management c = new Management("000003","Example Management Lofts", "123 Fake St, Duluth, MN 55811", "(218) 125-4529");
		
		System.out.println(a.getManagementInfo());
		
	}
}



