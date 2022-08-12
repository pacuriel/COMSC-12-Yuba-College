public class Pet {

	public static void main(String[] args);
	
	//Instance variables	
	private String name;
	private String type;
	
	private int age;
	
	//Default Pet constructor	
	public Pet() {
	
		name="N/A";
		type="N/A";
		age=0;
	}
	
	//Mutator methods	
	public void setName(String name) {
	
		this.name=name;
	}
	
	public void setType(String type) {
	
		this.type=type;
	}
	
	public void setAge(int age) {
	
		this.age=age;	
	}
	
	//Accessor methods	
	public String getName() {
	
		return name;
	}
	
	public String getType() {
	
		return type;
	}
	
	public int getAge() {
	
		return age;
	}
	
	}
//End of Pet class
