package A1;

/**
 * Multiple choice questions have many choices, but may have one or more answers.
 * @author Payton Perchez
 */
public class MultipleChoiceQuestion extends Question {

	private String prompt;
	private String[] choices;
	private String[] answers;
	
	/**
	 * Sets the answers to the question.
	 * @param answers The question's answers.
	 */
	@Override
	public void setAnswers(String ... answers) {
		
		if(contains(choices, answers)) {
			
			this.answers = answers;
			
		}else {
			
			throw new IllegalArgumentException("The specified answers are not valid options");
			
		}//end if
		
	}//end setAnswers
	
	/**
	 * Returns the answers to the question.
	 */
	@Override
	public String[] getAnswers() {
		
		return answers;
		
	}//end getAnswers
	
	/**
	 * Sets the choices available to students answering the question.
	 */
	@Override
	public void setChoices(String ... choices) {

		this.choices = choices;
		
	}//end setChoices
	
	/**
	 * Returns the choices available for students to choose.
	 */
	@Override
	public String[] getChoices() {
		
		return choices;
	
	}//end getChoices
	
	/**
	 * Sets the prompt for the question.
	 * @param prompt The question's prompt.
	 */
	@Override
	public void setPrompt(String prompt) {
		
		this.prompt = prompt;
		
	}//end setPrompt
	
	/**
	 * Returns the question's prompt.
	 */
	@Override
	public String getPrompt() {
		
		return prompt;
		
	}//end getPrompt
	
	/**
	 * Determines whether or not a given String array contains the given targets.
	 * @param array The array being searched.
	 * @param targets The targets.
	 * @return True if the targets have been found, false otherwise.
	 */
	private boolean contains(String[] array, String[] targets) {
		
		int targetIndex = 0;
		for(int index = 0;index < array.length;index++) {
			
			if(array[index].equals(targets[targetIndex])) {
				
				targetIndex++;
				if(targetIndex == targets.length) {
					
					return true;
					
				}else {
					
					index = 0;
					
				}//end if
				
			}//end if
			
		}//end for
		
		return false;
		
	}//end contains

}//end MultipleChoiceQuestion
