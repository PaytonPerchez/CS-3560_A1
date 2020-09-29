package A1;

import java.util.ArrayList;
import java.io.File;

/**
 * A voting service that can store a question which students can answer through this service.
 * @author Payton Perchez
 */
public class VotingService {

	private ArrayList<Integer> studentIDs;
	private ArrayList<ArrayList<String>> stringSubmissions;
	private ArrayList<File> fileSubmissions;
	private Question question;
	
	/**
	 * Instantiate string and file submission lists as well as the student list.
	 */
	public VotingService() {
		
		studentIDs = new ArrayList<>();
		stringSubmissions = new ArrayList<>();
		fileSubmissions = new ArrayList<>();
		
	}//end default constructor
	
	/**
	 * Set the questions students will be answering.
	 * @param question The question being answered.
	 */
	public void setQuestion(Question question) {
		
		//Ensure students have not began voting on another question before changing it
		if(studentIDs.isEmpty()) {
			
			this.question = question;
			
		}else {
			
			throw new IllegalStateException("Cannot change the question if voting has already started");
			
		}//end if
		
	}//end setQuestion
	
	/**
	 * Documents student string submissions.
	 * @param studentID The unique ID of the student.
	 * @param submission The student's string submission.
	 */
	public void documentVote(int studentID, String submission) {
		
		if(question != null) {
			
			//Multiple choice or true/false
			if(question.getChoices().length > 0) {
				
				//Multiple answers
				if(question.getAnswers().length > 1) {
					
					//Record the student's ID and submission if new
					if(!studentIDs.contains(studentID)) {
						
						studentIDs.add(studentID);
						stringSubmissions.add(new ArrayList<String>());
						stringSubmissions.get(studentIDs.indexOf(studentID)).add(submission);
						
					//Remove an identical submission or add another answer to their submission
					}else {
						
						if(stringSubmissions.get(studentIDs.indexOf(studentID)).contains(submission)) {
							
							stringSubmissions.get(studentIDs.indexOf(studentID)).remove(submission);
							
						}else {
							
							stringSubmissions.get(studentIDs.indexOf(studentID)).add(submission);
							
						}//end if
						
					}//end if
					
				//Single answer
				}else {
					
					//Record the student's ID and submission if new
					if(!studentIDs.contains(studentID)) {
						
						studentIDs.add(studentID);
						stringSubmissions.add(new ArrayList<String>());
						stringSubmissions.get(studentIDs.indexOf(studentID)).add(submission);
						
					//Replace the student's previous submission
					}else {
						
						stringSubmissions.get(studentIDs.indexOf(studentID)).remove(0);
						stringSubmissions.get(studentIDs.indexOf(studentID)).add(submission);
						
					}//end if
					
				}//end if
				
			//Free response
			}else {
				
				System.out.println("Thank you for your response " + studentID + ", your submission is being reviewed.");
				
			}//end if
			
		}else {
			
			throw new IllegalStateException("There must be a question to answer before voting occurs");
			
		}//end if
		
	}//end documentVote
	
	/**
	 * Documents student file submissions.
	 * @param studentID The unique ID of the student.
	 * @param submission The student's file submission.
	 */
	public void documentVote(int studentID, File submission) {
		
		if(question != null) {
			
			//Record the student's ID and submission if new
			if(!studentIDs.contains(studentID)) {
				
				studentIDs.add(studentID);
				fileSubmissions.add(submission);
				
			//Replace the student's previous submission
			}else {
				
				fileSubmissions.remove(studentIDs.indexOf(studentID));
				fileSubmissions.add(studentIDs.indexOf(studentID), submission);
				
			}//end if
			
			System.out.println("Thank you for your response " + studentID + ", your submission is being reviewed.");
			
		}else {
			
			throw new IllegalStateException("There must be a question to answer before voting occurs");
			
		}//end if
		
	}//end documentVote
	
	/**
	 * Prints the voting results.
	 */
	public void printResults() {
		
		//Multiple choice or true/false
		if(question.getChoices().length > 0) {
			
			//Display the statistics for each choice
			for(int index = 0;index < question.getChoices().length;index++) {
				
				System.out.println(question.getChoices()[index] + ": " + numOfInstances(stringSubmissions, question.getChoices()[index]));
				
			}//end for
			
			//Display the number of students who voted correctly
			System.out.print(numCorrect(stringSubmissions, question.getAnswers()) + "/" + studentIDs.size() + " student(s) chose the correct answer(s) \"");
			for(int index = 0;index < question.getAnswers().length;index++) {
				
				System.out.print(question.getAnswers()[index]);
				if((index + 1) < question.getAnswers().length) {
					
					System.out.print(", ");
					
				}//end if
				
			}//end for
			System.out.println("\"");
			
		//Free response or file submission
		}else {
			
			System.out.println("Students' answers are being reviewed, thank you for participating!");
			
		}//end if
		
	}//end printResults
	
	/**
	 * Searches a two dimensional array list for a specified target string.
	 * @param array The array list being searched.
	 * @param target The string being searched for.
	 * @return The number of times the target appears in the array.
	 */
	private int numOfInstances(ArrayList<ArrayList<String>> array, String target) {
		
		int counter = 0;
		
		//Students
		for(int i = 0;i < array.size();i++) {
			
			//Submissions
			for(int j = 0;j < array.get(i).size();j++) {
				
				//Check if the submissions containt the target
				if(array.get(i).get(j).equals(target)) {
					
					counter++;
					j = array.get(i).size();
					
				}//end if
				
			}//end if
			
		}//end for
		
		return counter;
		
	}//end numOfInstances
	
	/**
	 * Returns the number of correct answers found in a given array. (Note that the answers must be exact)
	 * @param array The array being searched.
	 * @param answers The correct answers.
	 * @return The number of correct answers found.
	 */
	private int numCorrect(ArrayList<ArrayList<String>> array, String[] answers) {
		
		int counter = 0;
		int answerIndex = 0;
		
		//Students
		for(int i = 0;i < array.size();i++) {
			
			//Submissions
			for(int j = 0;j < array.get(i).size();j++) {
				
				//Check if the submissions are exactly the same as the answers
				if(array.get(i).get(j).equals(answers[answerIndex])) {
					
					if(answerIndex == (answers.length - 1)) {
						
						counter++;
						j = array.get(i).size();
						answerIndex = 0;
						
					}else {
						
						j = 0;
						answerIndex++;
						
					}//end if
					
				}//end if
				
			}//end for
			
		}//end for
		
		return counter;
		
	}//end numCorrect
	
}//end VotingService
