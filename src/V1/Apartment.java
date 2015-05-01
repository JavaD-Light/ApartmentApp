package V1;

public class Apartment {
	public String aID;
	public int rent;
	public int secDeposit;
	public int bedrooms;
	public int bathrooms;
	public Boolean balcony;
	public Boolean laundry;
	public int leaseLength;
	public Boolean garage;
	public String location;
	public String availability;
	public Boolean loft;

	
	//Instance constructor for passing the input values into Apartment class. 
	//Input will be retrieved from the Management. They put the input in. 
	public Apartment(String aid, int rent, int secD, int beds, int baths, Boolean bal, Boolean laun, int lease,
			Boolean gar, String loc, String avail, Boolean loft){
		this.aID = aid;
		this.rent = rent;
		this.secDeposit = secD;
		this.bedrooms = beds;
		this.bathrooms = baths;
		this.balcony = bal;
		this.laundry = laun;
		this.leaseLength = lease;
		this.garage = gar;
		this.location = loc;
		this.availability = avail;
		this.loft = loft;
	}
	
	//The next blocks of code are the getters, so that Customer is able
	//to view the information of the apartments
	public String getAID(){
		return this.aID;
	}
	public int getRent(){
		return this.rent;
	}
	public int getSecDeposit(){
		return this.secDeposit;
	}
	public int getBedrooms(){
		return this.bedrooms;
	}
	public int getBathrooms(){
		return this.bathrooms;
	}
	public String getBalcony(){
		if (this.balcony == true){
			return "yes";
		}
		else{return "no";}
		
	}
	public String getLaundry(){
		if (this.laundry == true){
			return "yes";
		}
		else{return "no";}
	}
	public int getLeaseLength(){
		return this.leaseLength;
	}
	public String getGarage(){
		if (this.garage == true){
			return "yes";
		}
		else{return "no";}
	}
	public String getLocation(){
		return this.location;
	}
	public String getAvailability(){
		return this.availability;
	}
	public String getLoft(){
		if (this.loft == true){
			return "yes";
		}
		else{return "no";}
	}
	
	
	//The next blocks of code are the setters, in case Management 
	//wants to update their apartment
	public void setRent(int newRent){
		this.rent = newRent;
	}
	public void setDepost(int newDeposit){
		this.secDeposit = newDeposit;
	}
	public void setBed(int newBed){
		this.bedrooms = newBed;
	}
	public void setBath(int newBath){
		this.bathrooms = newBath;
	}
	//I highly doubt that we will need this here, but just putting
	//it here in case management decides to add a balcony to apartment
	public void setBal(Boolean newBal){ 
		this.balcony = newBal;
	}
	public void setLaun(Boolean newLaun){ 
		this.laundry = newLaun;
	}
	public void setLease(int newLength){
		this.leaseLength = newLength;
	}
	public void setGar(Boolean newGar){
		this.garage = newGar;
	}
	public void setLoc(String newLoc){
		this.location = newLoc;
	}
	public void setAvail(String newAvail){
		this.availability = newAvail;
	}
	public void setLoft(Boolean newLoft){
		this.loft = newLoft;
	}
	
	
	//This method is for the Customer trying to find an apartment
	//It returns the information of the listing. 
	public String returnDetails(){
		return ("Reference ID: " + getAID() + "\nRent: $" + getRent() + 
				"\nDeposit: $" + getSecDeposit() + "\nBedrooms: " + getBedrooms() + 
				"\nBathrooms: " + getBathrooms() + "\nBalcony: " + getBalcony() + 
				"\nLaundry on site: " + getLaundry() + "\nLease Length: " + getLeaseLength() + " year" + 
				"\nGarage: " + getGarage() + "\nLocation: " + getLocation() + 
				"\nDate available: " + getAvailability() + "\nLoft: " + getLoft());
	}
	
	
	public static void main(String[] args) {
		Apartment a = new Apartment("1000000", 500, 
				500, 2, 1, 
				false, false, 1,
				false, "Cloquet, MN","June, 01, 2015", true);
		Apartment b = new Apartment("2000000", 550, 
				550, 1, 1, 
				false, false, 1,
				false, "Duluth, MN","June, 01, 2015", true);
		Apartment c = new Apartment("3000000", 600, 
				650, 2, 2, 
				false, false, 1,
				false, "Virginia, MN","June, 01, 2015", true);
		Apartment d = new Apartment("4000000", 650, 
				750, 3, 1, 
				false, false, 1,
				false, "Duluth, MN","June, 01, 2015", true);
		
		System.out.println(b.returnDetails());
		
	}

}
