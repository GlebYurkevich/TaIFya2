// Generated from C:/Users/Admin/IdeaProjects/TaIFya6/src/main/java\Expr.g4 by ANTLR 4.8
package com.antr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(ExprParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(ExprParser.MulContext ctx);
}