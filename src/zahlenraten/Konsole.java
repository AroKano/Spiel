import java.io.*;

public class Konsole {

  //Klassenvariable, auf die von aussen nicht zugegriffen werden kann
  private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als String zurueck.
  */
  //gibt String zurueck
  public static String getInputString(String text) {
    //solange eine Eingabe erfolgt ...
    while (true) {
      System.out.print(text);
      try {
        return br.readLine();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als String zurueck.
   *
   *  @return Einen Wert vom Typ <tt>String</tt> der die Benutzereingabe enth�lt.
   */
  public static String getInputString() {
    while (true) {
      try {
        return br.readLine();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Integer zurueck.
   *
   *  @param text Enth?lt die Eingabeaufforderung f?r den Benutzer
   *  @return Einen Wert vom Typ <tt>int</tt> der die Benutzereingabe enth�lt.
   */
  public static int getInputInt(String text) {
    while (true) {
      System.out.print(text);
      try {
        return Integer.parseInt(br.readLine());
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Integer zurueck.
   *
   *  @return Einen Wert vom Typ <tt>int</tt> der die Benutzereingabe enth�lt.
   */
  public static int getInputInt() {
    while (true) {
      try {
        return Integer.parseInt(br.readLine());
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Float zurueck.
   *
   *  @param text Enth?lt die Eingabeaufforderung f?r den Benutzer
   *  @return Einen Wert vom Typ <tt>float</tt> der die Benutzereingabe enth�lt.
   */
  public static float getInputFloat(String text) {
    while (true) {
      System.out.print(text);
      try {
        return Float.parseFloat(br.readLine());
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Fehler bei der Verarbeitung der Eingabe: "
                           + nfe.getLocalizedMessage());
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Float zurueck.
   *
   *  @return Einen Wert vom Typ <tt>float</tt> der die Benutzereingabe enth�lt.
   */
  public static float getInputFloat() {
    while (true) {
      try {
        return Float.parseFloat(br.readLine());
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Fehler bei der Verarbeitung der Eingabe: "
                           + nfe.getLocalizedMessage());
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Double zurueck.
   *
   *  @param text Enth?lt die Eingabeaufforderung f?r den Benutzer
   *  @return Einen Wert vom Typ <tt>double</tt> der die Benutzereingabe enth�lt.
   */
  public static double getInputDouble(String text) {
    String x;
    while ( true ) {
      System.out.print(text);
      try {
        x = br.readLine();
        return Double.parseDouble(x);
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Fehler bei der Verarbeitung der Eingabe: "
                           + nfe.getLocalizedMessage());
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Double zurueck.
   *
   *  @return Einen Wert vom Typ <tt>double</tt> der die Benutzereingabe enth�lt.
   */
  public static double getInputDouble() {
    String x;
    while ( true ) {
      try {
        x = br.readLine();
        return Double.parseDouble(x);
      }
      catch (NumberFormatException nfe) {
         System.err.println();
         System.err.println("Fehler bei der Verarbeitung der Eingabe: "
                           + nfe.getLocalizedMessage());
         System.err.println("Eine Fliesskommazahl bitte mit Punkt als Dezimaltrenner eingeben.");
         System.err.println();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Char zurueck.
   *
   *  @param text Enth?lt die Eingabeaufforderung f?r den Benutzer
   *  @return Einen Wert vom Typ <tt>char</tt> der die Benutzereingabe enth�lt.
   */
  public static char getInputChar(String text) {
    String buffer;
    while (true) {
      System.out.print(text);
      try {
        buffer = br.readLine();
        return buffer.charAt(0);
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als Char zurueck.
   *
   *  @return Einen Wert vom Typ <tt>char</tt> der die Benutzereingabe enth�lt.
   */
  public static char getInputChar() {
    String buffer;
    while (true) {
      try {
        buffer = br.readLine();
        return buffer.charAt(0);
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als boolean zurueck.<br>
   *  Entspricht die Benutzereingabe dem Wort true, ohne Beruecksichtigung der
   *  Gross- und Kleinschreibung, dann wird der Wert true zurueckgegeben. In allen
   *  anderen F�llen wird False zurueckgegeben.
   *
   *  @param text Enth�lt die Eingabeaufforderung f?r den Benutzer
   *  @return Einen Wert vom Typ <tt>boolean</tt> der die Benutzereingabe enth�lt.
   */
  public static boolean getInputBoolean(String text) {
    String buffer;
    while (true) {
      System.out.print(text);
      try {
        buffer = br.readLine();
        return Boolean.valueOf(buffer).booleanValue();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }
  /** Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und gibt
   *  diese als boolean zurueck.<br>
   *  Entspricht die Benutzereingabe dem Wort true, ohne Beruecksichtigung der
   *  Gross- und Kleinschreibung, dann wird der Wert true zurueckgegeben. In allen
   *  anderen Faellen wird False zurueckgegeben.
   *
   *  @return Einen Wert vom Typ <tt>boolean</tt> der die Benutzereingabe enthaelt.
   */
  public static boolean getInputBoolean() {
    String buffer;
    while (true) {
      try {
        buffer = br.readLine();
        return Boolean.valueOf(buffer).booleanValue();
      }
      catch (Exception e) {
        System.err.println("Fehler bei der Verarbeitung: " + e.getLocalizedMessage());
      }
    }
  }

}