/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 *
 * @modifiedby  Achintha Gunasekara
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
import java.text.MessageFormat;

public class UI implements ActionListener {
   private JComboBox<String> themeSelector;

   private final JFrame frame;

   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   private final JPanel panelSub6;
   private final JPanel panelSub7;
   private final JPanel panelSub8;

   private final JPanel panelSub9;
   private final JPanel panelSub10;


   public final JTextArea text;

   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
           butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy,
           butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary, butln, butEmpt, butEmpt2;
   private final JButton butacos, butasin, butatan;

   private final JButton butCot, butCsc;

   private final JButton butpi;
   private final JButton buteuler;

   private final JButton butFact;

   private final JButton butPerm;

   private final JButton butComb;
   
   private final JButton butdot;
   private final Calculator calc;

   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
           "7", "8", "9"};


   private final Font font;
   private final Font textFont;
   private ImageIcon image;
   private BufferedImageCustom imageReturn;

   public UI() throws IOException {
      frame = new JFrame("Calculator PH");

      imageReturn = new BufferedImageCustom();
      image = new ImageIcon(imageReturn.imageReturn());

      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());
      panelSub9 = new JPanel(new FlowLayout());
      panelSub10 = new JPanel(new FlowLayout());



      font = new Font("Consolas",Font.PLAIN, 18);

      text = new JTextArea(1, 15);

      textFont = new Font("Consolas",Font.BOLD, 24);

      but = new JButton[10];
      for (int i = 0; i < 10; i++) {
         but[i] = new JButton(String.valueOf(i));
      }
      butAdd = new JButton("+");
      butMinus = new JButton("-");
      butMultiply = new JButton("*");
      butDivide = new JButton("/");
      butEqual = new JButton("=");
      butSquareRoot = new JButton("<html>&#8730;x</html>");
      butSquare = new JButton("<html>x<sup>2</sup></html>");
      butOneDividedBy = new JButton("<html>1 &#8260; x</html>");
      butCos = new JButton("Cos");
      butSin = new JButton("Sin");
      butTan = new JButton("Tan");
      butln = new JButton("ln");
      butCot = new JButton("Cot");
      butCsc = new JButton("Csc");
      butxpowerofy = new JButton("<html>x<sup>y</sup></html>");
      butlog = new JButton("log10(x)");
      butrate = new JButton("x%");
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");
      butacos = new JButton("<html>cos<sup>-1</sup>(x)</html>");
      butasin= new JButton("<html>sin<sup>-1</sup>(x)</html>");
      butatan= new JButton("<html>tan<sup>-1</sup>(x)</html>");
      butdot = new JButton(".");
      butEmpt = new JButton(" ");
      butEmpt2 = new JButton(" ");
      butpi = new JButton("π");
      buteuler = new JButton("e");
      butFact = new JButton("n!");
      butPerm = new JButton("nPr");
      butComb =new JButton("nCr");
      calc = new Calculator();

   }

   public void init() {
      String[] themeOptions = {"Light", "Dark"};
      themeSelector = new JComboBox<>(themeOptions);
      themeSelector.addActionListener(this);
      panel.add(themeSelector);
      frame.setVisible(true);

      frame.setSize(450, 600);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(image.getImage());

      text.setFont(textFont);
      text.setEditable(false);

      for (int i = 0; i < 10; i++) {
         but[i].setFont(font);
      }
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDividedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butln.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font);
      butacos.setFont(font);
      butasin.setFont(font);
      butatan.setFont(font);
      butdot.setFont(font);
      butEmpt.setFont(font);
      butEmpt2.setFont(font);
      butpi.setFont(font);
      buteuler.setFont(font);


      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);

      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);

      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);
      panel.add(panelSub3);

      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);

      butEmpt2.setOpaque(false);
      butEmpt2.setContentAreaFilled(false);
      butEmpt2.setBorderPainted(false);
      butEmpt2.setEnabled(false);
      butEmpt.setOpaque(false);
      butEmpt.setContentAreaFilled(false);
      butEmpt.setBorderPainted(false);
      butEmpt.setEnabled(false);
      panelSub5.add(butEmpt);
      panelSub5.add(but[0]);
      panelSub5.add(butEmpt2);
      panelSub5.add(Box.createHorizontalStrut(15));
      panelSub5.add(butdot);
      panelSub5.add(butln);
      panel.add(panelSub5);

      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDividedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);

      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panelSub7.add(butCot);
      panelSub7.add(butCsc);
      panel.add(panelSub7);

      panelSub9.add(butacos);
      panelSub9.add(butasin);
      panelSub9.add(butatan);
      panel.add(panelSub9);

      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);

      panelSub10.add(butpi);
      panelSub10.add(buteuler);
      panelSub10.add(butFact);
      panelSub10.add(butPerm);
      panelSub10.add(butComb);
      panel.add(panelSub10);


      for (int i = 0; i < 10; i++) {
         but[i].addActionListener(this);
      }
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDividedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butCot.addActionListener(this);
      butCsc.addActionListener(this);
      butln.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      butacos.addActionListener(this);
      butasin.addActionListener(this);
      butatan.addActionListener(this);
      butdot.addActionListener(this);
      butpi.addActionListener(this);
      buteuler.addActionListener(this);
      butFact.addActionListener(this);
      butPerm.addActionListener(this);
      butComb.addActionListener(this);


      butEqual.addActionListener(this);
      butCancel.addActionListener(this);

      frame.add(panel);
      frame.setVisible(true);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();
      Double checkNum = null;

      for (int i = 0; i < 10; i++) {
         if (source == but[i]) {
            butpi.setEnabled(false);
            if(text.getText().contains(".")){
               text.append(buttonValue[i]);
               return;
            }
            text.replaceSelection(buttonValue[i]);
            return;
         }else{
            butpi.setEnabled(true);
         }
      }
      if (source == butpi) {
         text.replaceSelection(Double.toString(Math.PI));
      }
      if (source == buteuler) {
         text.replaceSelection(Double.toString(Math.E));
      }

      try {
         checkNum = Double.parseDouble(text.getText());
      } catch(NumberFormatException k) {

      }
      if (source == butdot) {
         butdot.setEnabled(false);
         butpi.setEnabled(false);
         text.append(butdot.getText());
      }
      if(checkNum == null && source == butpi){
         text.append(Double.toString(Math.PI));
      }
      for (int i = 0; i < 10; i++) {
         if(source == butpi) {
            but[i].setEnabled(false);
         }else{
            but[i].setEnabled(true);
         }
      }

      if (checkNum != null || source == butCancel) {


         if (source == butAdd) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()),false);
            text.replaceSelection(butAdd.getText());
         }

         if (source == butMinus) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()),false);
            text.replaceSelection(butMinus.getText());
         }

         if (source == butPerm) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.nPr, reader()),false);
            text.replaceSelection(butPerm.getText());
         }

         if (source == butComb) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.nCr, reader()),false);
            text.replaceSelection(butComb.getText());
         }

         if (source == butMultiply) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()),false);
            text.replaceSelection(butMultiply.getText());
         }

         if (source == butDivide) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()),false);
            text.replaceSelection(butDivide.getText());
         }

         if (source == butxpowerofy) {
            butdot.setEnabled(true);
            writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()),false);
         }

         if (source == butSquare) {
            butdot.setEnabled(true);
            writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()),false);
         }

         if (source == butSquareRoot)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()),false);

         if (source == butOneDividedBy)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()),false);

         if (source == butCos)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()),false);

         if (source == butSin)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()),false);

         if (source == butTan)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()),false);

         if (source == butCot)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cot, reader()),false);

         if (source == butCsc)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.csc, reader()),false);

         if (source == butlog)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()),false);

         if (source == butln)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.ln, reader()),false);

         if (source == butrate)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()),false);

         if (source == butabs)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()),false);

         if (source == butacos)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.acos, reader()),false);

         if (source == butasin)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.asin, reader()),false);

         if (source == butatan)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.atan, reader()),false);

         if (source == butEqual)
            writer(calc.calculateEqual(reader()),true);

         if (source == butCancel){
            butdot.setEnabled(true);
            butpi.setEnabled(true);
            writer(calc.reset(),false);
         }

         if (source == butFact)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.fact, reader()),false);

         if (source == butBinary)
            parsetoBinary();
      }
      if (e.getSource() == themeSelector) {
         // Get the selected theme from the themeSelector
         String selectedTheme = (String) themeSelector.getSelectedItem();

         // Check if the selected theme is "Dark"
         if (selectedTheme.equals("Dark")) {
            // Set the UI components to the dark theme
            frame.setBackground(Color.DARK_GRAY);
            panel.setBackground(Color.DARK_GRAY);
            panelSub1.setBackground(Color.DARK_GRAY);
            panelSub2.setBackground(Color.DARK_GRAY);
            panelSub3.setBackground(Color.DARK_GRAY);
            panelSub4.setBackground(Color.DARK_GRAY);
            panelSub5.setBackground(Color.DARK_GRAY);
            panelSub6.setBackground(Color.DARK_GRAY);
            panelSub7.setBackground(Color.DARK_GRAY);
            panelSub8.setBackground(Color.DARK_GRAY);
            panelSub9.setBackground(Color.DARK_GRAY);
            panelSub10.setBackground(Color.DARK_GRAY);
            // Add more UI components here...
         }
         if  (selectedTheme.equals("Light")) {
            // Set the UI components to the light theme
            frame.setBackground(Color.lightGray);
            panel.setBackground(Color.lightGray);
            text.setBackground(Color.WHITE);
            panelSub1.setBackground(Color.lightGray);
            panelSub2.setBackground(Color.lightGray);
            panelSub3.setBackground(Color.lightGray);
            panelSub4.setBackground(Color.lightGray);
            panelSub5.setBackground(Color.lightGray);
            panelSub6.setBackground(Color.lightGray);
            panelSub7.setBackground(Color.lightGray);
            panelSub8.setBackground(Color.lightGray);
            panelSub9.setBackground(Color.lightGray);
            panelSub10.setBackground(Color.lightGray);
            // Add more UI components here...
         }
      }
      text.selectAll();
   }

   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }

   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);

      return num;
   }

   public void writer(final Double num, boolean bool) {
      if (Double.isNaN(num)) {
         if(bool == true){
            text.setText("undefined");
         }else {
            text.setText("");
         }
      } else {
         text.setText(Double.toString(num));
      }
   }

}