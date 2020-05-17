/* Java program to Construct K-Map of degree 3 */
public class kmapSoln {

	static String kmap_result = "";

	/* Evaluate function simplifies the in to 8,4,2,1 groups */
	public static void evaluate(int[][] in, int[][] ve) {
		if (!group8(in)) {
			kmap_result = "1";
		} else {
			/* Evaluate for 4, 2 and 1 group */
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					if (in[i][j] == 1 && ve[i][j] == 0) {
						if (group4(i, j, in, ve)) {
							if (group2(i, j, in, ve)) {
								group1(i, j, ve);
							}
						}
					}
				}
			}
		}
		System.out.println("\nThe final expression after resolving K-Map is " + kmap_result);
	}

	public static boolean group8(int[][] in) {
		/* to find out the groups */
		boolean flag = false;

		outer: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (in[i][j] == 1) {
					flag = false;
				} else {
					flag = true;
					break outer;
				}
			}
		}
		return flag;
	}

	public static boolean group4(int r, int c, int[][] in, int[][] ve) {
		boolean flag = true;
		String curr = "";

		if (in[r][0] == 1 && in[r][1] == 1 && in[r][2] == 1 && in[r][3] == 1) {
			if (r == 0)
				curr = "X'";
			if (r == 1)
				curr = "X";
			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}
			flag = false;
			ve[r][0] = ve[r][1] = ve[r][2] = ve[r][3] = 1;
		} 
		else if (in[0][c] == 1 && in[0][(c + 1) % 4] == 1 && in[1][c] == 1 && in[1][(c + 1) % 4] == 1) {
			if (c == 0)
				curr = "Y'";
			if (c == 1)
				curr = "Z";
			if (c == 2)
				curr = "Y";
			if (c == 3)
				curr = "Z'";

			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}

			flag = false;
			ve[0][c] = 1;
			ve[0][(c + 1) % 4] = 1;
			ve[1][c] = 1;
			ve[1][(c + 1) % 4] = 1;
		} 
		else if (in[0][c] == 1 && in[0][(4 + (c - 1)) % 4] == 1 && in[1][c] == 1
				&& in[1][(4 + (c - 1)) % 4] == 1) {
			if (c == 0)
				curr = "Z'";
			if (c == 1)
				curr = "Y'";
			if (c == 2)
				curr = "Z";
			if (c == 3)
				curr = "Y";
			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}

			flag = false;
			ve[0][c] = 1;
			ve[0][(4 + (c - 1)) % 4] = 1;
			ve[1][c] = 1;
			ve[1][(4 + (c - 1)) % 4] = 1;
		}
		return flag;
	}

	public static boolean group2(int r, int c, int[][] in, int[][] ve) {
		boolean flag = true;
		String curr = "";

		if (in[r][c] == 1 && in[r][(c + 1) % 4] == 1) {
			if (r == 0)
				curr = "X'";
			if (r == 1)
				curr = "X";
			if (c == 0)
				curr = curr + "Y'";
			if (c == 1)
				curr = curr + "Z";
			if (c == 2)
				curr = curr + "Y";
			if (c == 3)
				curr = curr + "Z'";

			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}
			flag = false;
			ve[r][c] = 1;
			ve[r][(c + 1) % 4] = 1;
		} 
		else if (in[r][(4 + (c - 1)) % 4] == 1 && in[r][c] == 1) {
			if (r == 0)
				curr = "X'";
			if (r == 1)
				curr = "X";
			if (c == 0)
				curr = curr + "Z'";
			if (c == 1)
				curr = curr + "Y'";
			if (c == 2)
				curr = curr + "Z";
			if (c == 3)
				curr = curr + "Y";

			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}
			flag = false;
			ve[r][(4 + (c - 1)) % 4] = 1;
			ve[r][c] = 1;
		} 
		else if (in[r][c] == 1 && in[(r + 1) % 2][c] == 1) {
			if (c == 0)
				curr = "Y'Z'";
			if (c == 1)
				curr = "Y'Z";
			if (c == 2)
				curr = "YZ";
			if (c == 3)
				curr = "YZ'";

			if (kmap_result.matches("")) {
				kmap_result = kmap_result + curr;
			} else {
				kmap_result = kmap_result + " + " + curr;
			}

			flag = false;
			ve[r][c] = 1;
			ve[(r + 1) % 2][c] = 1;
		}
		return flag;
	}

	public static void group1(int r, int c, int[][] ve) {
		String curr = "";

		if (r == 0)
			curr = "X'";
		if (r == 1)
			curr = "X";
		if (c == 0)
			curr = curr + "Y'Z'";
		if (c == 1)
			curr = curr + "Y'Z";
		if (c == 2)
			curr = curr + "YZ";
		if (c == 3)
			curr = curr + "YZ'";

		if (kmap_result.matches("")) {
			kmap_result = kmap_result + curr;
		} else {
			kmap_result = kmap_result + " + " + curr;
		}

		ve[r][c] = 1;
	}
	
	public static void print(int[] arr) {
		for(int i=0; i<8;i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		/* t is input value */
		int[] t = { 0, 1, 1, 0, 1, 1, 1, 0 };
		int input[][] = new int[2][4];
		int verify[][] = new int[2][4];
		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				input[i][j] = t[count++];
				verify[i][j] = 0;
			}
		}

		System.out.print("K-MAP of Degree 3 for the input " );
		print(t);
		System.out.print("\n\nX/YZ" + "	| " + "Y'Z'   Y'Z   YZ    YZ'\n");
		System.out.print("------------------------------------------\n");
		System.out.println(" 0  " + "	| " + t[0] + "      " + t[1] + "      " + t[2] + "      " + t[3]);
		System.out.println(" 1  " + "	| " + t[4] + "      " + t[5] + "      " + t[6] + "      " + t[7]);
		evaluate(input, verify);
	}

}