import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class FindReplaceTest {

  // @Test
  // public void checkWinner_returnsString_true() {
  //   FindReplace testFindReplace = new FindReplace();
  //   assertEquals(newPhrase, testFindReplace.replaceWord("rock", "scissors", "blah"));
  // }

  @Test
  public void checkWinner_returnsNewPhrase_true() {
    FindReplace testFindReplace = new FindReplace();
    assertEquals("hello universe", testFindReplace.replaceWord("hello world", "world", "universe"));
  }

  @Test
  public void checkWinner_returnsNewWordinAsentence() {
    FindReplace testFindReplace = new FindReplace();
    assertEquals("my dog went to cathedral", testFindReplace.replaceWord("my cat went to cathedral", "cat", "dog"));
  }
}
