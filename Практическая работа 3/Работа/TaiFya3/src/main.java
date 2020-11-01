import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class main {
    public static void main(String[] args) throws Lexer.ParseException {
        Lexer LEX= new Lexer("do a:=V; while a>V");
        List<Token> allTokens = new ArrayList<>();
        allTokens.addAll(LEX.getAllTokens());
        allTokens.forEach(new Consumer<Token>() {
            @Override
            public void accept(Token integer) {
                System.out.println(integer.toString());
            }
        });
    }
}
