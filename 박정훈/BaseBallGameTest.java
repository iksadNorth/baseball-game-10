import java.util.Set;

public class BaseBallGameTest {

    public static void main(String[] args) {
        // getRandom Test
        String random = BaseBallGame.getRandom();
        System.out.println(random);

        // getTable Test
        Set<Character> table = BaseBallGame.getTable("173");
        System.out.println(table);

        // getResult Test
        table = BaseBallGame.getTable("123");

        Pair result = BaseBallGame.getResult("321", table, "321");
        System.out.println(result);
        result = BaseBallGame.getResult("123", table, "321");
        System.out.println(result);
    }
}
