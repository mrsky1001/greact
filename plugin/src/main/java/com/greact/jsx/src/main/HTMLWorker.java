package main;

import antlr4.html.HTMLParser;
import antlr4.html.HTMLParser.HtmlTagNameContext;
import antlr4.html.HTMLParserBaseListener;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.Iterator;
import java.util.List;

public class HTMLWorker extends HTMLParserBaseListener {

    public void enterHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        Iterator iterator = ctx.children.iterator();

        while (iterator.hasNext()) {
            Object elem = iterator.next();
            try {
                System.out.println(((TerminalNodeImpl) elem).getText());
            } catch (Exception e) {

            }

            try {
                System.out.println(((HtmlTagNameContext) elem).getText());
            } catch (Exception e) {

            }

            try {
                System.out.println(((HTMLParser.HtmlAttributeContext) elem).getText());
            } catch (Exception e) {

            }

            Iterator iterator2 = ((HTMLParser.HtmlElementsContext) elem).children.iterator();
            while (iterator2.hasNext()) {
                Object elem2 = iterator2.next();

                try {
                    System.out.println(((TerminalNodeImpl) elem2).getText());
                } catch (Exception e) {

                }

                try {
                    System.out.println(((HtmlTagNameContext) elem2).getText());
                } catch (Exception e) {

                }

                try {
                    System.out.println(((HTMLParser.HtmlAttributeContext) elem2).getText());
                } catch (Exception e) {

                }

                Iterator iterator3 = ((HTMLParser.HtmlElementContext) elem2).children.iterator();
                while (iterator3.hasNext()) {
                    Object elem3 = iterator3.next();
                    try {
                        System.out.println(((TerminalNodeImpl) elem3).getText());
                    } catch (Exception e) {

                    }

                    try {
                        System.out.println(((HtmlTagNameContext) elem3).getText());
                    } catch (Exception e) {

                    }

                    try {
                        System.out.println(((HTMLParser.HtmlAttributeContext) elem3).getText());
                    } catch (Exception e) {

                    }
//                    System.out.println(( (HTMLParser.HtmlElementContext) elem3).getStart().getText());
                }
            }

            System.out.println(elem);
        }

        System.out.println(ctx);
        System.out.println("Entering: " + ctx.getText());
    }

    public void exitHtmlDocument(HTMLParser.HtmlDocumentContext ctx) {
        System.out.println("Exiting:" + ctx.getText());
    }
}