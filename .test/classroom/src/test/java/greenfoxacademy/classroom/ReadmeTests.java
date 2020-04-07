package greenfoxacademy.classroom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReadmeTests {

  private static List<String> content = new ArrayList<>();

  @BeforeAll
  public static void readFile() throws FileNotFoundException {
    String filePath = "../../README.md";
    Scanner input = new Scanner(new File(filePath));

    while (input.hasNextLine()) {
      content.add(input.nextLine());
    }
  }

  @Test
  public void readmeIsNotEmpty() {
    assertFalse(content.isEmpty());
  }

  @Test
  public void firstNameIsAdded() {
    assertFalse(content.get(1).endsWith(":"));
  }

  @Test
  public void lastNameIsAdded() {
    assertFalse(content.get(2).endsWith(":"));
  }

  @Test
  public void firstQuestion() {
    assertTrue(isCorrectAnswerThere("**Version control system**"));
  }

  @Test
  public void secondQuestion() {
    assertTrue(isCorrectAnswerThere("**clone**"));
  }

  @Test
  public void thirdQuestion() {
    assertTrue(isCorrectAnswerThere("**Staging area**"));
  }

  @Test
  public void fourthQuestion() {
    assertTrue(isCorrectAnswerThere("**Microsoft**"));
  }

  @Test
  public void fifthQuestion() {
    boolean firstCorrectAnswer = isCorrectAnswerThere("**Ctrl + Alt/Option + F**");
    boolean secondCorrectAnswer = isCorrectAnswerThere("**Ctrl + Shift + I**");

    assertTrue(firstCorrectAnswer || secondCorrectAnswer);
  }

  public boolean isCorrectAnswerThere(String s) {
    for (String line : content) {
      if (line.trim().contains(s)) {
        return true;
      }
    }
    return false;
  }
}


