package alu;

//import com.sun.java_cup.internal.runtime.Scanner;
import java.util.Scanner;

public class ALU {

	public static void main(String[] args) {

		System.out.println("Input: ");
		System.out.print("1st Operand: ");
		Scanner Op1 = new Scanner(System.in);
		String sc_Op1 = Op1.nextLine();

		if (sc_Op1.length() != 32 || sc_Op1.isEmpty()) {
			System.out.print("Please enter a 32-bit binary Operand: ");
			Op1.nextLine();
			System.out.println("Wrong format, re-run");
			System.exit(0);
		}

		System.out.print("2nd Operand: ");
		Scanner Op2 = new Scanner(System.in);
		String sc_Op2 = Op2.nextLine();

		if (sc_Op2.length() != 32 || sc_Op1.isEmpty()) {
			System.out.print("Please enter a 32-bit binary Operand: ");
			Op2.nextLine();
			System.out.println("Wrong format, re-run");
			System.exit(0);
		}

		System.out.print("Operation: ");
		Scanner Op = new Scanner(System.in);
		String sc_Op = Op.nextLine();

		if (sc_Op.length() != 4 || sc_Op1.isEmpty()) {
			System.out.print("Please enter a 4-bit Operation: ");
			Op.nextLine();
		}

		ALUEvaluator(sc_Op, sc_Op1, sc_Op2);

		Op1.close();
		Op2.close();
		Op.close();
	}

	public static void ALUEvaluator(String Op, String Operand1, String Operand2) {

		int ALUResult = 0;
		int zeroFlag = 0;
		String Opname = "";
		boolean checker = true;

		switch (Op) {

		case "0000":
			ALUResult = Integer.parseInt(Operand1, 2) & Integer.parseInt(Operand2, 2);
			Opname = "ANDOp";
			break;
		case "0001":
			ALUResult = Integer.parseInt(Operand1, 2) | Integer.parseInt(Operand2, 2);
			Opname = "OROp";
			break;
		case "0010":
			ALUResult = Integer.parseInt(Operand1, 2) + Integer.parseInt(Operand2, 2);
			Opname = "addOp";
			break;
		case "0110":
			ALUResult = Integer.parseInt(Operand1, 2) - Integer.parseInt(Operand2, 2);
			Opname = "subOp";
			break;
		case "0111":
			ALUResult = (Integer.parseInt(Operand1, 2) < Integer.parseInt(Operand2, 2)) ? 1 : 0;
			Opname = "sltOp";
			break;
		case "1100":
			ALUResult = ~(Integer.parseInt(Operand1, 2) | Integer.parseInt(Operand2, 2));
			Opname = "NOR";
			break;
		default:
			checker = false;

		}

		if (checker == false) {
			System.out.println("Incorrect Operation Code");
			System.exit(0);
		} else {
			String ALUResult_S = Integer.toBinaryString(ALUResult);
			System.out.println('\n' + "Output: ");
			System.out.println("Operation Name: " + Opname);
			System.out.println("1st Operand: " + Operand1);
			System.out.println("2nd Operand: " + Operand2);

			System.out.print("Output: ");
			if ((ALUResult == 1))
				System.out.println("01111111111111111111111111111111");
			else if ((ALUResult == 0))
				zeroFlag = 1;
			else {
				for (int i = 0; i < 32 - ALUResult_S.length(); i++) {
					System.out.print(0);
				}
			}
			System.out.println(Integer.toBinaryString(ALUResult));
		}
		System.out.println("Z-Flag Value: " + zeroFlag);
	}
}
