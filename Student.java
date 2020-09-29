package A1;

/**
 * Representation of a student using an online voting service to answer a question.
 * @author Payton Perchez
 */
public class Student {

	private int ID;
	private String nickname;
	
	/**
	 * Initializes the student with a unique ID.
	 * @param ID Unique ID.
	 */
	public Student(int ID) {
		
		this.ID = ID;
		
	}//end constructor
	
	/**
	 * Initializes the student with a unique ID and a nickname.
	 * @param ID
	 * @param nickname
	 */
	public Student(int ID, String nickname) {
		
		this.ID = ID;
		this.nickname = nickname;
		
	}//end constructor
	
	/**
	 * Provides the unique ID of the student.
	 * @return The student's ID.
	 */
	public int getID() {
		
		return ID;
		
	}//end getID
	
	/**
	 * Returns the nickname of the student.
	 * @return The student's nickname.
	 */
	public String getNickname() {
		
		return nickname;
		
	}//end getNickname
	
}//end Student
