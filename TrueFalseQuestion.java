package A1;

/**
 * True or false questions only have one answer and two choices.
 * @author Payton Perchez
 */
public class TrueFalseQuestion extends Question {

	private String prompt;
	private String answer;
	
	/**
	 * Sets the answer to the question.
	 * @param answers The answer to the question (true or false).
	 */
	@Override
	public void setAnswers(String ... answers) {
		
		if(answers.length > 1) {
			
			throw new IllegalArgumentException("Can only have one answer for true or false questions");
			
		}else {
			
			if(answers[0].equals("true") || answers[0].equals("false")) {
				
				this.answer = answers[0];
				
			}else {
				
				throw new IllegalArgumentException("This questions can only have answers \"true\" or \"false\"");
				
			}//end if
			
		}//end if
		
	}//end setAnswers
	
	/**
	 * Returns the answer to the question.
	 */
	@Override
	public String[] getAnswers() {
		
		return new String[] {answer};
		
	}//end getAnswers
	
	/**
	 * Returns the choices available for students to choose.
	 */
	@Override
	public String[] getChoices() {
		
		return new String[] {"true", "false"};
		
	}//end getChoices
	
	/**
	 * Does nothing for true or false questions.
	 */
	@Override
	public void setChoices(String... choices) {
	}//end setChoices
	
	/**
	 * Sets the prompt for students to answer.
	 * @param prompt The prompt of the question.
	 */
	@Override
	public void setPrompt(String prompt) {
		
		this.prompt = prompt;
		
	}//end setPrompt
	
	/**
	 * Returns the question's prompt.
	 * @return The prompt of the question.
	 */
	@Override
	public String getPrompt() {

		return prompt;
		
	}//end getPrompt
	
}//end TrueFalseQuestion
