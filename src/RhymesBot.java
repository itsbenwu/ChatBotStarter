import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user about rhymes.
 * This version:
 * @author Abbdul Rafi
 * @version November 2018
 */
public class RhymesBot
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;


	/**
	 * Runs the conversation for this particular chatbot- the RhymeBot.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 *
	 * @return a greeting to the user and asks a general questions.
	 */	
	public String getGreeting()
	{
		return "Hello kids, ready to read some fun rhymes?";
	}
	
	/**
	 * Gives a response to a user statement.
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}

		else if (findKeyword(statement, "no", 0) >= 0)
		{
			response = "Why not? :(";
			emotion--;
			Scanner input = new Scanner(System.in);
			String reason = input.nextLine();

			if (reason.length() >= 0)
			{
				System.out.println(randomAngryResponses);
			}
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "Type in any popular rhyme names";
			emotion++;
		}
		else if (findKeyword(statement, "sure") >= 0)
		{
			response = "Type in any popular rhyme names";
			emotion++;
		}
		else if (findKeyword(statement, "yea") >= 0)
		{
			response = "Type in any popular rhyme names";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "twinkle", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "baa",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "row", 0) >= 0)
		{
			response = transformIYouStatement(statement);
		}
		else if (findKeyword(statement, "happy",0) >= 0)
		{
			response = transformRhyme4Statement(statement);
		}
		else if (findKeyword(statement, "mary", 0) >= 0)
		{
			response = transformRhymes5Statement(statement);
		}
		else
		{
			System.out.println("Sorry I don't recognize the rhyme: " + statement);
			System.out.println("Type in another rhyme. For example: Twinkle twinkle little star, baa baa black sheep, Row row row your boat, Happy and you know it clap your hands.");
		}

		return response;
	}
	
	/**
	 * Take a statement with the name of the rhyme and transform it into
	 * "Are you sure you want to read <statement>"
	 * @param statement the user statement, assumed to contain a rhymes song name
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "twinkle", 0);
		String restOfStatement = statement.substring(psn).trim();
		System.out.println("Do you want to read " + restOfStatement + "?");

		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		if (response.equals("yes")){
			System.out.println("Twinkle Twinkle Little Stars\n" + "How I wonder what you are\n" +  "Up above the world so high\n" + "Like a diamond in the sky");
			emotion ++;
		}
		else {
			System.out.println("Why not?");
			emotion--;
		}
		return "Do you want to read anything else?";
		}
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "baa", 0);
		String restOfStatement = statement.substring(psn).trim();
		System.out.println("Do you want to read " + restOfStatement + "?");

		Scanner input = new Scanner(System.in);
		String response = "";
		response = input.nextLine();
		if (response.equals("yes")){
			System.out.println("Baa, baa, black sheep\n" +
					"Have you any wool?\n" +
					"Yes sir, yes sir, three bags full.\n" +
					"One for the master,\n" +
					"And one for the dame,\n" +
					"And one for the little boy\n" +
					"Who lives down the lane.");
			emotion++;
		}
		else {
			System.out.println("Why not? :(");
			emotion--;
		}
		return "\nDo you want to read anything else?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "row", 0);
		String restOfStatement = statement.substring(psn).trim();
		System.out.println("Do you want to read " + restOfStatement + "?");

		Scanner input = new Scanner(System.in);
		String response = "";
		response = input.nextLine();
		if (response.equals("yes")){
			System.out.println("Row, row, row your boat\n" +
					"Gently down the stream\n" +
					"Merrily, merrily, merrily, merrily\n" +
					"Life is but a dream\n" +
					"\n" +
					"Row, row, row your boat\n" +
					"Gently up the creek If you see a little mouse\n" +
					"Don't forget to squeak!\n" +
					"\n" +
					"Row, row, row your boat\n" +
					"Gently down the stream If you see a crocodile\n" +
					"Don't forget to scream!\n" +
					"\n" +
					"Row, row, row your boat\n" +
					"Gently to the shore\n" +
					"If you see a lion\n" +
					"Don’t forget to roar!");
			emotion++;
		}
		else {
			System.out.println("Why not? :( Do you want to read anything else?");
			emotion--;
		}
		return "\nDo you want to read anything else?";
	}

	private String transformRhyme4Statement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "happy", 0);
		String restOfStatement = statement.substring(psn).trim();
		System.out.println("Do you want to read " + restOfStatement + "?");

		Scanner input = new Scanner(System.in);
		String response = "";
		response = input.nextLine();
		if (response.equals("yes")){
			System.out.println("If you're happy and you know it, clap your hands (clap clap)\n"+
			"If you're happy and you know it, clap your hands (clap clap)\n"+
			"If you're happy and you know it, then your face will surely show it\n"+
			"If you're happy and you know it, clap your hands. (clap clap)\n"+

			"If you're happy and you know it, stomp your feet (stomp stomp)\n"+
			"If you're happy and you know it, stomp your feet (stomp stomp)\n"+
			"If you're happy and you know it, then your face will surely show it\n"+
			"If you're happy and you know it, stomp your feet. (stomp stomp)\n"+

			"If you're happy and you know it, shout Hurray! (hoo-ray!)\n"+
			"If you're happy and you know it, shout Hurray! (hoo-ray!)\n"+
			"If you're happy and you know it, then your face will surely show it\n"+
			"If you're happy and you know it, shout Hurray! (hoo-ray!)\n"+

			"If you're happy and you know it, do all three (clap-clap, stomp-stomp, hoo-ray!)\n"+
			"If you're happy and you know it, do all three (clap-clap, stomp-stomp, hoo-ray!)\n"+
			"If you're happy and you know it, then your face will surely show it\n"+
			"If you're happy and you know it, do all three. (clap-clap, stomp-stomp, hoo-ray!)\n");
			emotion++;
		}
		else {
			System.out.println("Why not? :( Do you want to read anything else?");
			emotion--;
		}
		return "Do you want to read anything else?";
	}

	private String transformRhymes5Statement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "mary", 0);
		String restOfStatement = statement.substring(psn).trim();
		System.out.println("Do you want to read " + restOfStatement + "?");

		Scanner input = new Scanner(System.in);
		String response = "";
		response = input.nextLine();
		if (response.equals("yes")){
			System.out.println("Mary had a little lamb,\n" +
					"Its fleece was white as snow;\n" +
					"And everywhere that Mary went\n" +
					"The lamb was sure to go.\n" +
					"\n" +
					"It followed her to school one day,\n" +
					"Which was against the rule;\n" +
					"It made the children laugh and play\n" +
					"To see a lamb at school.\n" +
					"\n" +
					"And so the teacher turned it out,\n" +
					"But still it lingered near,\n" +
					"And waited patiently about\n" +
					"Till Mary did appear.\n" +
					"\n" +
					"Why does the lamb love Mary so?\n" +
					"The eager children cry;\n" +
					"Why, Mary loves the lamb, you know,\n" +
					"The teacher did reply.");
			emotion++;
		}
		else {
			System.out.println("Why not? :(");
			emotion--;
		}
		return "\nDo you want to read anything else?";
	}

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Why so serious?", "Rhymes are so fun!", "Come on you can do better", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "If your happy and you know it clap your hands", "Smiling is the best charity :)"};
}
