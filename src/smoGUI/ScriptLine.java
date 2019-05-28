package smoGUI;

public class ScriptLine {

	String frame;
	boolean[] buttonFlag = new boolean[17];
	int coordX_L, coordY_L, coordX_R, coordY_R;

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public ScriptLine(String frame, boolean aPress, boolean bPress, boolean xPress, boolean yPress, boolean zlPress,
			boolean zrPress, boolean lPress, boolean rPress, boolean upPress, boolean leftPress, boolean downPress,
			boolean rightPress, boolean plusPress, boolean minusPress, boolean lStickPress, boolean rStickPress,
			int coordX_L, int coordY_L, int coordX_R, int coordY_R) {

		this.frame = frame;
		buttonFlag[0] = aPress;
		buttonFlag[1] = bPress;
		buttonFlag[2] = xPress;
		buttonFlag[3] = yPress;
		buttonFlag[4] = zlPress;
		buttonFlag[5] = zrPress;
		buttonFlag[6] = lPress;
		buttonFlag[7] = rPress;
		buttonFlag[8] = upPress;
		buttonFlag[9] = leftPress;
		buttonFlag[10] = downPress;
		buttonFlag[11] = rightPress;
		buttonFlag[12] = plusPress;
		buttonFlag[13] = minusPress;
		buttonFlag[14] = lStickPress;
		buttonFlag[15] = rStickPress;

		this.coordX_L = coordX_L;
		this.coordY_L = coordY_L;
		this.coordX_R = coordX_R;
		this.coordY_R = coordY_R;
	}

	public String toString() {
		String outputString = "";

		// Adds the frame onto the output string
		outputString += frame + " ";

		int keyCount = 0; // Used to count backwards for number of keys pressed
		for (int i = 0; i < buttonFlag.length; i++) {
			if (buttonFlag[i])
				keyCount++;
		}
		if (keyCount != 0) {
			boolean runOnce = false;
			for (int i = 0; i < buttonFlag.length; i++) {
				if (buttonFlag[i] == true) {
					switch(i) {
					case 0: // A is pressed
						outputString += "KEY_A";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 1: // B is pressed
						outputString += "KEY_B";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 2: // X is pressed
						outputString += "KEY_X";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 3: // Y is pressed
						outputString += "KEY_Y";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 4: // ZL is pressed
						outputString += "KEY_ZL";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 5: // ZR is pressed
						outputString += "KEY_ZR";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 6: // L is pressed
						outputString += "KEY_L";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 7: // R is pressed
						outputString += "KEY_R";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 9: // UP is pressed
						outputString += "KEY_DUP";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 10:// LEFT is pressed
						outputString += "KEY_DLEFT";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 11:// DOWN is pressed
						outputString += "KEY_DDOWN";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 12:// RIGHT is pressed
						outputString += "KEY_DRIGHT";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 13:// PLUS is pressed
						outputString += "KEY_PLUS";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 14:// MINUS is pressed
						outputString += "KEY_MINUS";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 15:// LSTICK is pressed
						outputString += "KEY_LSTICK";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					case 16:// RSTICK is pressed
						outputString += "KEY_RSTICK";
						if (keyCount > 1) {
							outputString += ";";
						}
						break;
					}
					keyCount--;
				}
			}
		} else {
			outputString += "NONE";
		}

		outputString += " " + coordX_L + ";" + coordY_L;
		outputString += " " + coordX_R + ";" + coordY_R;
		
		return outputString;
	}

}
