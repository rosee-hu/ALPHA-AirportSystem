package airportsystem;

public class Manger extends Person {

	private String workId;
	private String password;

	public Manger(String workId, String password) {
		super(); //to call (toString) methode in Object super-class
		this.workId = workId;
		this.password = password;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void printOptions() {//show options in manger list
                System.out.println("\n\t  *-------------------------------------* ");
		System.out.println("\n\t\tPress 1 to add new fligt");
		System.out.println("\n\t\tPress 2 to edit flight");
		System.out.println("\n\t\tPress 3 to delete flight");
		System.out.println("\n\t\tpress 4 to view flights");
		System.out.println("\n\t\tPress 0 to go back");
                System.out.println("\n\t  *-------------------------------------* ");
        }

	@Override
	public String toString() {//orgnize output
		return "Manger [workId=" + workId + "]";
	}
}