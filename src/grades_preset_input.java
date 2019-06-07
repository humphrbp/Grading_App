import java.util.Scanner;

public class grades_preset_input {

	public static void main(String[] args) {

		/* preset input to test logic */
		int score_sum[] = new int[] { 400, 450, 470, 180, 300, 270, 310, 340, 350, 330 };

//Calculate the Average

		int sum = 0;

		for (int i = 0; i < score_sum.length; i++) {

			sum = sum + score_sum[i];

		}

		double average = sum / score_sum.length;

		double a = 450; // Predefined A Cutoff

		double b = 400; // Predefined B Cutoff

		double c = 350; // Predefined C Cutoff

		double d = 300; // Predefined D Cutoff

//Calculate Standard deviation

		double sd = 0;

		for (int i = 0; i < score_sum.length; i++) {

			sd += ((score_sum[i] - average) * (score_sum[i] - average)) / (score_sum.length - 1);

		}

		double standardDeviation = Math.sqrt(sd);

//Calculate Grade Cutoff Based on Standard Deviation and Mean

		int newA = (int) Math.round(2 * standardDeviation + average);

		int newB = (int) Math.round(1 * standardDeviation + average);

		int newC = (int) Math.round(0 * standardDeviation + average);

		int newD = (int) Math.round(-1 * standardDeviation + average);

//Print Original Grade Cutoffs

		System.out.println("Orgional Grade Cutoffs");

		System.out.println("A>=" + a);

		System.out.println("B>=" + b);

		System.out.println("C>=" + c);

		System.out.println("D>=" + d);

		System.out.println("F<" + d);

//Print Cutoff based on Mean and Standard Deviation

		System.out.println("Grades based on Mean and STDEV");

		System.out.println("Class Average = " + average + "; Standard Deviation = " + standardDeviation);

		System.out.println("A>=" + newA);

		System.out.println("B>=" + newB);

		System.out.println("C>=" + newC);

		System.out.println("D>=" + newD);

		System.out.println("F<" + newD);

// Pick whether to keep the new grade or the old

		if (a > newA) {

			a = newA;

		}

		if (b > newB) {

			b = newB;

		}

		if (c > newC) {

			c = newC;

		}

		if (d > newD) {

			d = newD;

		}

		// Create Final Grade Values

		int finalA = (int) Math.round(a);

		int finalB = (int) Math.round(b);

		int finalC = (int) Math.round(c);

		int finalD = (int) Math.round(d);

		System.out.println("Final Grade Cutoffs");

		System.out.println("A>=" + finalA);

		System.out.println("B>=" + finalB);

		System.out.println("C>=" + finalC);

		System.out.println("D>=" + finalD);

		System.out.println("F<" + finalD);

		String grades[] = new String[score_sum.length];

		for (int i = 0; i < score_sum.length; i++) {

			if (score_sum[i] >= finalA) {

				grades[i] = "A";

			} else if (score_sum[i] >= finalB) {

				grades[i] = "B";

			} else if (score_sum[i] >= finalC) {

				grades[i] = "C";

			} else if (score_sum[i] >= finalD) {

				grades[i] = "D";

			} else {

				grades[i] = "F";

			}

		}

		// Print Grades

		System.out.println("Students Grades");

		for (int i = 0; i < score_sum.length; i++) {

			System.out.println("Student " + (i + 1) + " - " + score_sum[i] + " - " + grades[i]);

		}

	}

	// Input Scores Code//

	public static void EnterStudentScores(Scanner scan, int[][] scores, int students, int gradecol, int j) {

		for (int i = 0; i < 4; i++)

		{

			System.out.println("Enter Exam " + (i + 1) + " for Student:" + (j + 1));

			do {

				System.out.println("Please enter grade between 0-50");

				while (!scan.hasNextInt())

				{

					scan.nextInt();

				}

				scores[i][j] = scan.nextInt();

			}

			while (scores[i][j] > 50 || scores[i][j] < 0);

		}

		for (int k = 4; k < gradecol; k++)

		{

			System.out.println("Enter Assignment " + (k - 3) + " for Student:" + (j + 1));

			do {

				System.out.println("Please enter grade between 0-75");

				while (!scan.hasNextInt())

				{

					scan.nextInt();

				}

				scores[k][j] = scan.nextInt();
				;

			}

			while (scores[k][j] > 75 || scores[k][j] < 0);

		}

	}

}
 