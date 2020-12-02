import com.antr.ExprBaseListener;
import com.antr.ExprParser;

public class ExprWalker  extends ExprBaseListener {
        //public void enterR(ExprParser.RContext ctx ) {
       //     System.out.println( "Entering R : " + ctx.ID().getText() );
      //  }

        public void exitR(ExprParser ctx ) {
            System.out.println( "Exiting R" );
        }
}