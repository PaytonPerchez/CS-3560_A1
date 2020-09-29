package A1;

/**
 * Describes required methods for question objects.
 * @author Payton Perchez
 */
public abstract class Question {
	
	/**
	 * Sets the answers to the question students are answering.
	 */
	public abstract void setAnswers(String ... answers);
	
	/**
	 * Returns the correct answers, if any.
	 * @return The correct answers.
	 */
	public abstract String[] getAnswers();
	
	/**
	 * Sets the choices available for students to choose.
	 * @param choices Available choices.
	 */
	public abstract void setChoices(String ... choices);
	
	/**
	 * Returns the choices, if any, students can choose.
	 * @return The choices.
	 */
	public abstract String[] getChoices();
	
	/**
	 * Sets the prompt for students to answer.
	 * @param prompt The prompt of the question.
	 */
	public abstract void setPrompt(String prompt);
	
	/**
	 * Returns the question's prompt.
	 * @return The prompt of the question.
	 */
	public abstract String getPrompt();
	
}//end Question
