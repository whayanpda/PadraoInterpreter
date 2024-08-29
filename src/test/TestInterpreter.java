import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInterpreter {

    @Test
    public void testConstInterpret() {
        AbstractExpression constExpr = new Const(5);
        int result = constExpr.interpret();
        System.out.println("Resultado de Const: " + result);
        assertEquals(5, result);
    }

    @Test
    public void testExpressionInterpret() {
        AbstractExpression expr1 = new Const(5);
        AbstractExpression expr2 = new Const(3);
        AbstractExpression expression = new Expression(expr1, expr2);
        int result = expression.interpret();
        System.out.println("Resultado de Expression (5 + 3): " + result);
        assertEquals(8, result);
    }

    @Test
    public void testTermInterpret() {
        AbstractExpression term1 = new Const(5);
        AbstractExpression term2 = new Const(3);
        AbstractExpression term = new Term(term1, term2);
        int result = term.interpret();
        System.out.println("Resultado de Term (5 * 3): " + result);
        assertEquals(15, result);
    }

    @Test
    public void testComplexExpressionInterpret() {
        AbstractExpression const1 = new Const(5);
        AbstractExpression const2 = new Const(3);
        AbstractExpression term = new Term(const1, const2);
        AbstractExpression const3 = new Const(2);
        AbstractExpression expression = new Expression(term, const3);
        int result = expression.interpret();
        System.out.println("Resultado de Expression ((5 * 3) + 2): " + result);
        assertEquals(17, result);
    }
}

