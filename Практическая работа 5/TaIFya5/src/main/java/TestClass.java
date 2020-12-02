
import com.antr.ExprLexer;
import com.antr.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
public class TestClass {
    public static void main(String[] args) {
        String text = "5 + 3 * 2v - 1c + 10x / 2a";
        ExprLexer lexer = new ExprLexer(CharStreams.fromString(text));
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));

        String str=lexer.getAllTokens().toString();
        str=str.replace("<1>","<(>");
        str=str.replace("<2>","<)>");
        str=str.replace("<3>","<NUMBER>");
        str=str.replace("<4>","<WHITESPACE>");
        str=str.replace("<5>","<ADD>");
        str=str.replace("<6>","<SUB>");
        str=str.replace("<7>","<MUL>");
        str=str.replace("<8>","<DIV>");
        System.out.println(str);
    }

}
