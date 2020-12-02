
import com.antr.ExprLexer;
import com.antr.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestClass {
    public static void main(String[] args) {
        String text = "5 + 3 * 2 - 1 + 10 // 2";
        ExprLexer lexer = new ExprLexer(CharStreams.fromString(text));
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
        ExprParser.ExprContext ctx = parser.expr();
        TestClass testClass = new TestClass();
          ExprNode root = testClass.visitExpr(ctx);
          System.out.println(root);
         System.out.println(eval(root));
    }
    public ExprNode visitMul(ExprParser.MulContext ctx) {
        if (ctx.num != null) {
            return new NumberExpr(ctx.num);
        }
        else {
            return visitExpr(ctx.expr());
        }
    }
    public ExprNode visitExpr (ExprParser.ExprContext ctx) {
        ExprNode left = visitAdd(ctx.left);
        for (int i = 0; i < ctx.right.size(); i++) {
            ExprParser.AddContext rightNode = ctx.right.get(i);
            Token op = ctx.op.get(i);
            ExprNode right = visitAdd(rightNode);
            left = new BinOpExpr(left, op, right);
        }
        return left;
    }
    public ExprNode visitAdd(ExprParser.AddContext ctx) {
        ExprNode left = visitMul(ctx.left);
        for (int i = 0; i < ctx.right.size(); i++) {
            ExprParser.MulContext rightNode = ctx.right.get(i);
            Token op = ctx.op.get(i);
            ExprNode right = visitMul(rightNode);
            left = new BinOpExpr(left, op, right);
        }
        return left;
    }
    private static double eval(ExprNode expr) {
        if (expr instanceof NumberExpr) {
            NumberExpr num = (NumberExpr) expr;
            String text = num.number.getText();
            return Double.parseDouble(text);
        } else if (expr instanceof BinOpExpr) {
            BinOpExpr bin = (BinOpExpr) expr;
            double leftValue = eval(bin.left);
            double rightValue = eval(bin.right);
            switch (bin.op.getType()) {
                case ExprLexer.ADD: return leftValue + rightValue;
                case ExprLexer.SUB: return leftValue - rightValue;
                case ExprLexer.MUL: return leftValue * rightValue;
                case ExprLexer.DIV: return leftValue / rightValue;
            }
        }
        throw new IllegalStateException();
    }
}
