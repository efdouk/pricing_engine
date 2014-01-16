/**
 * @author Konrad Zdanowicz (zdanowicz.konrad@gmail.com)
 * 
 */
package softcomputing.task2.carpurchase.console;

import java.util.Scanner;

/**
 * 
 */
public class ConsoleHumanizer {

	public static final int LINE_CHARS = 80;
	private static int tab = 0;
	private static final int TAB_WIDTH = 3;

	public static void sysout(String text) {
		tabulate();
		System.out.println(text);
	}

	public static void sysline() {
		for (int i = 0; i < LINE_CHARS; i++)
			System.out.print("-");
		System.out.println();
	}

	public static String sysin() throws ExitInputedException, RestartInputedException, FinishInputedException {
		tabulate();
		System.out.print("> ");
		Scanner scanIn = new Scanner(System.in);
		String out = "";
		out = scanIn.nextLine();
		if (out.trim().equalsIgnoreCase("exit"))
			throw new ExitInputedException();
		else if (out.trim().equalsIgnoreCase("restart"))
			throw new RestartInputedException();
		else if (out.trim().equalsIgnoreCase("finish"))
			throw new FinishInputedException();
		else
			return out;
	}

	private static void tabulate() {
		for (int i = 0; i < tab; i++) {
			for (int j = 0; j < TAB_WIDTH; j++)
				System.out.print(" ");
		}
	}

	public static void tab() {
		tab++;
	}

	public static void untab() {
		tab--;
		if (tab < 0)
			tab = 0;
	}
}
