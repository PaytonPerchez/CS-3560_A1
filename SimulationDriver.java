package A1;

import java.util.Random;

/**
 * Simulates students using a voting service to answer questions.
 * @author Payton Perchez
 */
public class SimulationDriver {

	public static void main(String[] args) {
		
		Random generator = new Random();
		Question question;
		String allMcChoices = "ABCD";
		
		boolean questionIsMC = generator.nextBoolean();
		if(questionIsMC) {
			
			MultipleChoiceQuestion mcQuestion = new MultipleChoiceQuestion();
			
			//Configure question choices
			String[] choices = new String[allMcChoices.length()];
			for(int index = 0;index < choices.length;index++) {
				
				choices[index] = allMcChoices.charAt(index) + "";
				
			}//end for
			mcQuestion.setChoices(choices);
			
			//Configure question answers
			String answer = "";
			for(int index = 0;index < choices.length;index++) {
				
				if(generator.nextBoolean()) {
					
					answer += choices[index];
					
				}//end if
				
			}//end for
			
			//If there are no answers yet, choose a random one
			if(answer.length() == 0) {
				
				answer = choices[generator.nextInt(choices.length)];
				
			}//end if
			
			//Set question answers
			String[] answers = new String[answer.length()];
			for(int index = 0;index < answers.length;index++) {
				
				answers[index] = answer.charAt(index) + "";
				
			}//end for
			mcQuestion.setAnswers(answers);
			
			question = mcQuestion;
			
		}else {
			
			TrueFalseQuestion tfQuestion = new TrueFalseQuestion();
			
			//Set question answer
			boolean answer = generator.nextBoolean();
			if(answer) {
				
				tfQuestion.setAnswers("true");
				
			}else {
				
				tfQuestion.setAnswers("false");
				
			}//end if
			
			question = tfQuestion;
			
		}//end if
		
		//Configure voting service
		VotingService service = new VotingService();
		service.setQuestion(question);
		
		//Create students and simulate the voting process
		Student[] students = new Student[generator.nextInt(20)+20];
		for(int index = 0;index < students.length;index++) {
			
			//Create new student
			students[index] = new Student(index);
			
			//Answer question
			service.documentVote(students[index].getID(), question.getChoices()[generator.nextInt(question.getChoices().length)]);
			
			if(generator.nextBoolean()) {
				
				int randomStudent = generator.nextInt(index+1);
				
				//Choose another answer
				service.documentVote(students[randomStudent].getID(), question.getChoices()[generator.nextInt(question.getChoices().length)]);
				
			}//end if
			
		}//end for
		
		System.out.println("Voting complete!");
		System.out.println("Results:");
		System.out.println("-------------------------");
		service.printResults();
		System.out.println("\nExit!");
		
	}//end main
	
}//end SimulationDriver
