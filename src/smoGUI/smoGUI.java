package smoGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class smoGUI {

	private JFrame frmTasGui;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField FrameSelect;
	private JTextField polarMagnitude_L;
	private JTextField polarAngle_L;
	private JTextField cartesianX_L;
	private JTextField cartesianY_L;

	ArrayList<ScriptLine> scriptLines = new ArrayList<ScriptLine>();
	private JTextField polarMagnitude_R;
	private JTextField polarAngle_R;
	private JTextField cartesianX_R;
	private JTextField cartesianY_R;
	private JTextField repeatFrames;
	private JTextField shiftFrames;
	int lastFrameEntered;
	private JTextField frameDelete;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					smoGUI window = new smoGUI();
					window.frmTasGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public smoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTasGui = new JFrame();
		frmTasGui.setResizable(false);
		frmTasGui.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programming\\Eclipse\\Workspace\\smoGUI\\cappyImage.png"));;
		frmTasGui.setTitle("TAS-nx Script Generator by Dethstroek");
		frmTasGui.setBounds(100, 100, 800, 480);
		frmTasGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTasGui.getContentPane().setLayout(null);

		JToggleButton Key_A = new JToggleButton("A");
		Key_A.setBounds(10, 10, 82, 23);
		frmTasGui.getContentPane().add(Key_A);

		JToggleButton Key_B = new JToggleButton("B");
		Key_B.setBounds(10, 44, 82, 23);
		frmTasGui.getContentPane().add(Key_B);

		JToggleButton Key_X = new JToggleButton("X");
		Key_X.setBounds(10, 78, 82, 23);
		frmTasGui.getContentPane().add(Key_X);

		JToggleButton Key_Y = new JToggleButton("Y");
		Key_Y.setBounds(10, 112, 82, 23);
		frmTasGui.getContentPane().add(Key_Y);

		JToggleButton Key_RIGHT = new JToggleButton("Right");
		Key_RIGHT.setBounds(102, 112, 86, 23);
		frmTasGui.getContentPane().add(Key_RIGHT);

		JToggleButton Key_DOWN = new JToggleButton("Down");
		Key_DOWN.setBounds(102, 78, 86, 23);
		frmTasGui.getContentPane().add(Key_DOWN);

		JToggleButton Key_LEFT = new JToggleButton("Left");
		Key_LEFT.setBounds(102, 44, 86, 23);
		frmTasGui.getContentPane().add(Key_LEFT);

		JToggleButton Key_UP = new JToggleButton("Up");
		Key_UP.setBounds(102, 10, 86, 23);
		frmTasGui.getContentPane().add(Key_UP);

		JToggleButton Key_ZL = new JToggleButton("ZL");
		Key_ZL.setBounds(10, 146, 82, 23);
		frmTasGui.getContentPane().add(Key_ZL);

		JToggleButton Key_ZR = new JToggleButton("ZR");
		Key_ZR.setBounds(102, 146, 86, 23);
		frmTasGui.getContentPane().add(Key_ZR);

		JToggleButton Key_L = new JToggleButton("L");
		Key_L.setBounds(10, 180, 82, 23);
		frmTasGui.getContentPane().add(Key_L);

		JToggleButton Key_R = new JToggleButton("R");
		Key_R.setBounds(102, 180, 86, 23);
		frmTasGui.getContentPane().add(Key_R);

		JToggleButton Key_PLUS = new JToggleButton("+");
		Key_PLUS.setBounds(10, 214, 82, 23);
		frmTasGui.getContentPane().add(Key_PLUS);

		JToggleButton Key_MINUS = new JToggleButton("-");
		Key_MINUS.setBounds(102, 214, 86, 23);
		frmTasGui.getContentPane().add(Key_MINUS);

		JToggleButton Key_RSTICK = new JToggleButton("RSTICK");
		Key_RSTICK.setBounds(102, 248, 86, 23);
		frmTasGui.getContentPane().add(Key_RSTICK);
		
		JToggleButton Key_LSTICK = new JToggleButton("LSTICK");
		Key_LSTICK.setBounds(10, 248, 82, 23);
		frmTasGui.getContentPane().add(Key_LSTICK);

		JRadioButton Coord_POLAR = new JRadioButton("Polar Coordinates");
		Coord_POLAR.setBounds(206, 247, 148, 23);

		buttonGroup.add(Coord_POLAR);
		Coord_POLAR.setSelected(true);
		frmTasGui.getContentPane().add(Coord_POLAR);
		Coord_POLAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Coord_POLAR.isSelected()) {
					polarMagnitude_L.setEnabled(true); // Sets the state of the Polar Magnitude textfield to allow entry
					polarAngle_L.setEnabled(true); // Sets the state of the Polar Angle textfield to allow entry
					polarMagnitude_R.setEnabled(true); // Sets the state of the Polar Magnitude textfield to allow entry
					polarAngle_R.setEnabled(true); // Sets the state of the Polar Angle textfield to allow entry
					polarMagnitude_R.setText("0");
					polarAngle_R.setText("0");
					polarMagnitude_L.setText("0");
					polarAngle_L.setText("0");
					cartesianX_L.setText(null);
					cartesianY_L.setText(null);
					cartesianX_R.setText(null);
					cartesianY_R.setText(null);
					cartesianX_L.setEnabled(false); // Sets the state of the Cartesian X textfield to deny entry
					cartesianY_L.setEnabled(false); // Sets the state of the Cartesian Y textfield to deny entry
					cartesianX_R.setEnabled(false); // Sets the state of the Cartesian X textfield to deny entry
					cartesianY_R.setEnabled(false); // Sets the state of the Cartesian Y textfield to deny entry
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 11, 403, 396);
		frmTasGui.getContentPane().add(scrollPane);

		JTextArea scriptDisplay = new JTextArea();
		scriptDisplay.setEditable(false);
		scrollPane.setViewportView(scriptDisplay);

		FrameSelect = new JTextField();
		FrameSelect.setBounds(198, 30, 118, 20);
		FrameSelect.setToolTipText("Enter Frame Here");
		frmTasGui.getContentPane().add(FrameSelect);
		FrameSelect.setColumns(10);

		JLabel FrameSelect_Label = new JLabel("Enter Desired Frame:");
		FrameSelect_Label.setBounds(200, 10, 148, 14);
		frmTasGui.getContentPane().add(FrameSelect_Label);

		JLabel Polar_Label = new JLabel("Magnitude @ Angle");
		Polar_Label.setBounds(206, 269, 148, 14);
		frmTasGui.getContentPane().add(Polar_Label);

		JLabel atSymbol_POLAR = new JLabel("@");
		atSymbol_POLAR.setBounds(269, 281, 20, 23);
		frmTasGui.getContentPane().add(atSymbol_POLAR);

		polarMagnitude_L = new JTextField();
		polarMagnitude_L.setText("0");
		polarMagnitude_L.setBounds(216, 284, 50, 20);
		frmTasGui.getContentPane().add(polarMagnitude_L);
		polarMagnitude_L.setColumns(10);

		polarAngle_L = new JTextField();
		polarAngle_L.setText("0");
		polarAngle_L.setBounds(284, 284, 50, 20);
		polarAngle_L.setColumns(10);
		frmTasGui.getContentPane().add(polarAngle_L);

		cartesianX_L = new JTextField();
		cartesianX_L.setBounds(219, 360, 50, 20);
		cartesianX_L.setColumns(10);
		frmTasGui.getContentPane().add(cartesianX_L);
		cartesianX_L.setEnabled(false); // Sets the state of the Cartesian X textfield to deny entry by default

		JLabel cartX_L = new JLabel("LX:");
		cartX_L.setBounds(202, 363, 20, 14);
		frmTasGui.getContentPane().add(cartX_L);

		cartesianY_L = new JTextField();
		cartesianY_L.setBounds(292, 360, 50, 20);
		cartesianY_L.setColumns(10);
		frmTasGui.getContentPane().add(cartesianY_L);
		cartesianY_L.setEnabled(false); // Sets the state of the Cartesian Y textfield to deny entry by default

		JLabel cartY_L = new JLabel("LY:");
		cartY_L.setBounds(274, 363, 20, 14);
		frmTasGui.getContentPane().add(cartY_L);

		JLabel cartX_R = new JLabel("RX:");
		cartX_R.setBounds(202, 391, 20, 14);
		frmTasGui.getContentPane().add(cartX_R);

		cartesianX_R = new JTextField();
		cartesianX_R.setBounds(219, 387, 50, 20);
		cartesianX_R.setEnabled(false);
		cartesianX_R.setColumns(10);
		frmTasGui.getContentPane().add(cartesianX_R);
		cartesianX_R.setEnabled(false); // Sets the state of the Cartesian X textfield to deny entry by default

		JLabel cartY_R = new JLabel("RY:");
		cartY_R.setBounds(274, 390, 20, 14);
		frmTasGui.getContentPane().add(cartY_R);

		cartesianY_R = new JTextField();
		cartesianY_R.setBounds(292, 387, 50, 20);
		cartesianY_R.setEnabled(false);
		cartesianY_R.setColumns(10);
		frmTasGui.getContentPane().add(cartesianY_R);
		cartesianY_R.setEnabled(false); // Sets the state of the Cartesian Y textfield to deny entry by default

		JButton frameCommit = new JButton("Enter Frame");
		frameCommit.setBounds(10, 282, 178, 23);
		frmTasGui.getContentPane().add(frameCommit);

		JRadioButton Coord_CARTESIAN = new JRadioButton("Cartesian Coordinates");
		Coord_CARTESIAN.setBounds(206, 336, 155, 23);
		buttonGroup.add(Coord_CARTESIAN);
		frmTasGui.getContentPane().add(Coord_CARTESIAN);

		JButton importScript = new JButton("Import Script");
		importScript.setBounds(10, 316, 178, 23);
		frmTasGui.getContentPane().add(importScript);

		JButton exportScript = new JButton("Export Script");
		exportScript.setBounds(10, 350, 178, 23);
		frmTasGui.getContentPane().add(exportScript);

		JLabel LPolar = new JLabel("L:");
		LPolar.setBounds(204, 285, 20, 14);
		frmTasGui.getContentPane().add(LPolar);

		JLabel RPolar = new JLabel("R:");
		RPolar.setBounds(204, 315, 20, 14);
		frmTasGui.getContentPane().add(RPolar);

		polarMagnitude_R = new JTextField();
		polarMagnitude_R.setBounds(217, 313, 50, 20);
		polarMagnitude_R.setText("0");
		polarMagnitude_R.setColumns(10);
		frmTasGui.getContentPane().add(polarMagnitude_R);

		JLabel label = new JLabel("@");
		label.setBounds(270, 310, 20, 23);
		frmTasGui.getContentPane().add(label);

		polarAngle_R = new JTextField();
		polarAngle_R.setBounds(285, 313, 50, 20);
		polarAngle_R.setText("0");
		polarAngle_R.setColumns(10);
		frmTasGui.getContentPane().add(polarAngle_R);

		JLabel frameRepeat = new JLabel("Repeat:");
		frameRepeat.setBounds(198, 61, 148, 14);
		frmTasGui.getContentPane().add(frameRepeat);

		repeatFrames = new JTextField();
		repeatFrames.setText("0");
		repeatFrames.setBounds(196, 81, 118, 20);
		repeatFrames.setToolTipText("Number of times frame should repeat");
		repeatFrames.setColumns(10);
		frmTasGui.getContentPane().add(repeatFrames);

		JLabel Shift_Label = new JLabel("Shift Frames:");
		Shift_Label.setBounds(200, 112, 148, 14);
		frmTasGui.getContentPane().add(Shift_Label);

		shiftFrames = new JTextField();
		shiftFrames.setToolTipText("Number of times frame should repeat");
		shiftFrames.setText("0");
		shiftFrames.setColumns(10);
		shiftFrames.setBounds(198, 132, 95, 20);
		frmTasGui.getContentPane().add(shiftFrames);

		JButton shiftCommit = new JButton("OK");
		shiftCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (ScriptLine s : scriptLines) {
					int frame = Integer.parseInt(s.getFrame());
					frame += Integer.parseInt(shiftFrames.getText());
					System.out.println(frame);
					s.setFrame("" + frame);
				}

				scriptDisplay.setText(null);
				scriptLines = cleanForPrint(scriptLines);
				for (ScriptLine s : scriptLines) {
					scriptDisplay.append(s + "\n");
				}
			}

			private ArrayList<ScriptLine> cleanForPrint(ArrayList<ScriptLine> scriptLines) {
				// Deletes duplicates in case of overriding
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					if (scriptLines.get(i).getFrame()
							.equalsIgnoreCase(scriptLines.get(scriptLines.size() - 1).getFrame())) {
						scriptLines.remove(i);
					}
				}

				// Resorts just in case frames added out of order
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					for (int j = 0; j < scriptLines.size() - i - 1; j++) {
						if (Integer.parseInt(scriptLines.get(j).getFrame()) > Integer
								.parseInt(scriptLines.get(j + 1).getFrame())) {
							ScriptLine temp = scriptLines.get(j);
							scriptLines.set(j, scriptLines.get(j + 1));
							scriptLines.set(j + 1, temp);
						}
					}
				}

				return scriptLines;

			}

		});
		shiftCommit.setBounds(300, 131, 61, 23);
		frmTasGui.getContentPane().add(shiftCommit);
		
		JButton resetButtons = new JButton("RESET BUTTONS");
		resetButtons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Key_A.setSelected(false);
				Key_B.setSelected(false);
				Key_X.setSelected(false);
				Key_Y.setSelected(false);
				Key_UP.setSelected(false);
				Key_LEFT.setSelected(false);
				Key_DOWN.setSelected(false);
				Key_RIGHT.setSelected(false);
				Key_L.setSelected(false);
				Key_R.setSelected(false);
				Key_ZL.setSelected(false);
				Key_ZR.setSelected(false);
				Key_PLUS.setSelected(false);
				Key_MINUS.setSelected(false);
				Key_LSTICK.setSelected(false);
				Key_RSTICK.setSelected(false);
			}
		});
		resetButtons.setToolTipText("Will reset all the buttons on the GUI");
		resetButtons.setBounds(10, 384, 178, 23);
		frmTasGui.getContentPane().add(resetButtons);
		
		JButton resetScripts = new JButton("RESET SCRIPTS");
		resetScripts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scriptLines.removeAll(scriptLines);
				
				scriptDisplay.setText(null);
				scriptLines = cleanForPrint(scriptLines);
				for (ScriptLine s : scriptLines) {
					scriptDisplay.append(s + "\n");
				}
				
			}
			
			private ArrayList<ScriptLine> cleanForPrint(ArrayList<ScriptLine> scriptLines) {
				// Deletes duplicates in case of overriding
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					if (scriptLines.get(i).getFrame()
							.equalsIgnoreCase(scriptLines.get(scriptLines.size() - 1).getFrame())) {
						scriptLines.remove(i);
					}
				}

				// Resorts just in case frames added out of order
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					for (int j = 0; j < scriptLines.size() - i - 1; j++) {
						if (Integer.parseInt(scriptLines.get(j).getFrame()) > Integer
								.parseInt(scriptLines.get(j + 1).getFrame())) {
							ScriptLine temp = scriptLines.get(j);
							scriptLines.set(j, scriptLines.get(j + 1));
							scriptLines.set(j + 1, temp);
						}
					}
				}

				return scriptLines;

			}
			
		});
		resetScripts.setToolTipText("Will clear all the scripts out of the list");
		resetScripts.setBounds(10, 417, 178, 23);
		frmTasGui.getContentPane().add(resetScripts);
		
		JLabel deleteLabel = new JLabel("Delete Frame:");
		deleteLabel.setBounds(201, 162, 148, 14);
		frmTasGui.getContentPane().add(deleteLabel);
		
		frameDelete = new JTextField();
		frameDelete.setToolTipText("Enter the frame to be deleted");
		frameDelete.setText("0");
		frameDelete.setColumns(10);
		frameDelete.setBounds(198, 183, 95, 20);
		frmTasGui.getContentPane().add(frameDelete);
		
		JButton deleteButton = new JButton("OK");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int frameToDelete = Integer.parseInt(frameDelete.getText());
				for(int i = 0; i < scriptLines.size(); i++) {
					if(frameToDelete == Integer.parseInt(scriptLines.get(i).getFrame())) {
						scriptLines.remove(i);
					}
				}
				scriptDisplay.setText(null);
				scriptLines = cleanForPrint(scriptLines);
				for (ScriptLine s : scriptLines) {
					scriptDisplay.append(s + "\n");
				}
			}
			
			private ArrayList<ScriptLine> cleanForPrint(ArrayList<ScriptLine> scriptLines) {
				// Deletes duplicates in case of overriding
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					if (scriptLines.get(i).getFrame()
							.equalsIgnoreCase(scriptLines.get(scriptLines.size() - 1).getFrame())) {
						scriptLines.remove(i);
					}
				}

				// Resorts just in case frames added out of order
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					for (int j = 0; j < scriptLines.size() - i - 1; j++) {
						if (Integer.parseInt(scriptLines.get(j).getFrame()) > Integer
								.parseInt(scriptLines.get(j + 1).getFrame())) {
							ScriptLine temp = scriptLines.get(j);
							scriptLines.set(j, scriptLines.get(j + 1));
							scriptLines.set(j + 1, temp);
						}
					}
				}

				return scriptLines;

			}
		});
		deleteButton.setBounds(301, 182, 61, 23);
		frmTasGui.getContentPane().add(deleteButton);

		// ********************FILES EXPORTED HERE********************
		exportScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser saveFile = new JFileChooser();
				saveFile.showSaveDialog(null);
				try (FileWriter fw = new FileWriter(saveFile.getSelectedFile())) {
					for (ScriptLine script : scriptLines) {
						fw.write(script.toString() + "\n");
					}
					fw.close();
				} catch (IOException e) {

				}
			}
		});

		Coord_CARTESIAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Coord_CARTESIAN.isSelected()) {
					polarMagnitude_L.setText(null);
					polarAngle_L.setText(null);
					polarMagnitude_R.setText(null);
					polarAngle_R.setText(null);
					polarMagnitude_L.setEnabled(false); // Sets the state of the Polar Magnitude textfield to deny entry
					polarAngle_L.setEnabled(false); // Sets the state of the Polar Magnitude textfield to deny entry
					polarMagnitude_R.setEnabled(false); // Sets the state of the Polar Magnitude textfield to deny entry
					polarAngle_R.setEnabled(false); // Sets the state of the Polar Magnitude textfield to deny entry
					cartesianX_L.setEnabled(true); // Sets the state of the Cartesian X textfield to allow entry
					cartesianY_L.setEnabled(true); // Sets the state of the Cartesian Y textfield to allow entry
					cartesianX_R.setEnabled(true); // Sets the state of the Cartesian X textfield to allow entry
					cartesianY_R.setEnabled(true); // Sets the state of the Cartesian Y textfield to allow entry
					cartesianX_R.setText("0");
					cartesianY_R.setText("0");
					cartesianX_L.setText("0");
					cartesianY_L.setText("0");

				}
			}
		});

		// BIG MEATY UPDATER
		frameCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int coordX_L, coordY_L, coordX_R, coordY_R;

				// Converts polar coord to Cartesian coord
				if (Coord_POLAR.isSelected()) {

					int radius_L = Integer.parseInt(polarMagnitude_L.getText());
					double theta_L = Double.parseDouble(polarAngle_L.getText());
					theta_L = theta_L * (Math.PI / 180);

					int radius_R = Integer.parseInt(polarMagnitude_R.getText());
					double theta_R = Double.parseDouble(polarAngle_R.getText());
					theta_R = theta_R * (Math.PI / 180);

					coordX_L = (int) (radius_L * Math.cos(theta_L));
					coordY_L = (int) (radius_L * Math.sin(theta_L));
					coordX_R = (int) (radius_R * Math.cos(theta_R));
					coordY_R = (int) (radius_R * Math.sin(theta_R));

				} else {
					coordX_L = Integer.parseInt(cartesianX_L.getText());
					coordY_L = Integer.parseInt(cartesianY_L.getText());
					coordX_R = Integer.parseInt(cartesianX_R.getText());
					coordY_R = Integer.parseInt(cartesianY_R.getText());
				}

				if (Integer.parseInt(repeatFrames.getText()) > 0) {
					for (int i = Integer.parseInt(repeatFrames.getText())
							+ Integer.parseInt(FrameSelect.getText()); i > Integer.parseInt(FrameSelect.getText())
									- 1; i--) {
						String frame = "" + i;
						ScriptLine newScript = new ScriptLine(frame, Key_A.isSelected(), Key_B.isSelected(),
								Key_X.isSelected(), Key_Y.isSelected(), Key_ZL.isSelected(), Key_ZR.isSelected(),
								Key_L.isSelected(), Key_R.isSelected(), Key_UP.isSelected(), Key_LEFT.isSelected(),
								Key_DOWN.isSelected(), Key_RIGHT.isSelected(), Key_PLUS.isSelected(),
								Key_MINUS.isSelected(), Key_LSTICK.isSelected(), Key_RSTICK.isSelected(), coordX_L,
								coordY_L, coordX_R, coordY_R);
						scriptLines.add(newScript);
						scriptDisplay.setText(null);
						scriptLines = cleanForPrint(scriptLines);
						for (ScriptLine s : scriptLines) {
							scriptDisplay.append(s + "\n");
						}
					}
				} else {
					// Sends all the boolean values to the object for display
					ScriptLine newScript = new ScriptLine(FrameSelect.getText(), Key_A.isSelected(), Key_B.isSelected(),
							Key_X.isSelected(), Key_Y.isSelected(), Key_ZL.isSelected(), Key_ZR.isSelected(),
							Key_L.isSelected(), Key_R.isSelected(), Key_UP.isSelected(), Key_LEFT.isSelected(),
							Key_DOWN.isSelected(), Key_RIGHT.isSelected(), Key_PLUS.isSelected(),
							Key_MINUS.isSelected(), Key_LSTICK.isSelected(), Key_RSTICK.isSelected(), coordX_L,
							coordY_L, coordX_R, coordY_R);

					// System.out.println(newScript);

					scriptLines.add(newScript); // Adds to the list of completed lines
				}
				scriptDisplay.setText(null);
				scriptLines = cleanForPrint(scriptLines);
				for (ScriptLine s : scriptLines) {
					scriptDisplay.append(s + "\n");
				}
			}

			private ArrayList<ScriptLine> cleanForPrint(ArrayList<ScriptLine> scriptLines) {
				// Deletes duplicates in case of overriding
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					if (scriptLines.get(i).getFrame()
							.equalsIgnoreCase(scriptLines.get(scriptLines.size() - 1).getFrame())) {
						scriptLines.remove(i);
					}
				}

				// Resorts just in case frames added out of order
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					for (int j = 0; j < scriptLines.size() - i - 1; j++) {
						if (Integer.parseInt(scriptLines.get(j).getFrame()) > Integer
								.parseInt(scriptLines.get(j + 1).getFrame())) {
							ScriptLine temp = scriptLines.get(j);
							scriptLines.set(j, scriptLines.get(j + 1));
							scriptLines.set(j + 1, temp);
						}
					}
				}

				return scriptLines;

			}
		});

		// ********************FILES IMPORTED HERE********************
		importScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser openFile = new JFileChooser();
				openFile.showOpenDialog(null);

				try (BufferedReader bReader = new BufferedReader(new FileReader(openFile.getSelectedFile()))) {
					String line = "";
					String csvSplitBy = " ";

					ArrayList<ScriptLine> scriptValues = new ArrayList<ScriptLine>();
					int counter = 0;
					while ((line = bReader.readLine()) != null) {

						// Split on the comma
						String[] importLines = line.split(csvSplitBy);
						System.out.println(
								importLines[0] + " " + importLines[1] + " " + importLines[2] + " " + importLines[3]);

						ScriptLine newScriptLine = new ScriptLine(importLines[0], // Frame number
								importLines[1].contains("KEY_A"), // If contains KEY_A
								importLines[1].contains("KEY_B"), // If contains KEY_B
								importLines[1].contains("KEY_X"), // If contains KEY_X
								importLines[1].contains("KEY_Y"), // If contains KEY_Y
								importLines[1].contains("KEY_ZL"), // If contains KEY_ZL
								importLines[1].contains("KEY_ZR"), // If contains KEY_ZR
								importLines[1].contains("KEY_L"), // If contains KEY_L
								importLines[1].contains("KEY_R"), // If contains KEY_R
								importLines[1].contains("KEY_DUP"), // If contains KEY_DUP
								importLines[1].contains("KEY_DLEFT"), // If contains KEY_DLEFT
								importLines[1].contains("KEY_DDOWN"), // If contains KEY_DDOWN
								importLines[1].contains("KEY_DRIGHT"), // If contains KEY_DRIGHT
								importLines[1].contains("KEY_PLUS"), // If contains KEY_PLUS
								importLines[1].contains("KEY_MINUS"), // If contains KEY_MINUS
								importLines[1].contains("KEY_LSTICK"), // If contains KEY_LSTICK
								importLines[1].contains("KEY_RSTICK"), // If contains KEY_RSTICK
								Integer.parseInt(importLines[2].substring(0, importLines[2].indexOf(";"))),
								Integer.parseInt(importLines[2].substring(importLines[2].indexOf(";") + 1)),
								Integer.parseInt(importLines[3].substring(0, importLines[3].indexOf(";"))),
								Integer.parseInt(importLines[3].substring(importLines[3].indexOf(";") + 1)));
						scriptValues.add(newScriptLine);

						counter++;

					}

					scriptLines = scriptValues;

					scriptDisplay.setText(null);
					scriptLines = cleanForPrint(scriptLines);
					for (ScriptLine s : scriptLines) {
						scriptDisplay.append(s + "\n");
						// System.out.println(s);
					}

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block\
				}

			}

			private ArrayList<ScriptLine> cleanForPrint(ArrayList<ScriptLine> scriptLines) {
				// Deletes duplicates in case of overriding
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					if (scriptLines.get(i).getFrame()
							.equalsIgnoreCase(scriptLines.get(scriptLines.size() - 1).getFrame())) {
						scriptLines.remove(i);
					}
				}

				// Resorts just in case frames added out of order
				for (int i = 0; i < scriptLines.size() - 1; i++) {
					for (int j = 0; j < scriptLines.size() - i - 1; j++) {
						if (Integer.parseInt(scriptLines.get(j).getFrame()) > Integer
								.parseInt(scriptLines.get(j + 1).getFrame())) {
							ScriptLine temp = scriptLines.get(j);
							scriptLines.set(j, scriptLines.get(j + 1));
							scriptLines.set(j + 1, temp);
						}
					}
				}

				return scriptLines;

			}

		});

	}
}
