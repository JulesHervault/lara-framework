/* Generated By:JJTree: Do not edit this line. ASTFunctionDeclaration.java Version 4.3 */
/*
 * JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,
 * NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true
 */
package org.dojo.jsl.parser.ast;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import larac.LaraC;
import larac.objects.Enums.Types;
import larac.objects.Variable;

public class ASTFunctionDeclaration extends SimpleNode {
    private LinkedHashMap<String, Variable> args = new LinkedHashMap<>();
    private String funcName = "";

    public ASTFunctionDeclaration(int id) {
        super(id);
    }

    public ASTFunctionDeclaration(LARAEcmaScript p, int id) {
        super(p, id);
    }

    @Override
    public void declareGlobal(LaraC lara) {

        funcName = ((ASTIdentifier) children[0]).value.toString();

        getLara().aspectIR().addGlobalElement(funcName, this);
        organizeParams(this);
    }

    @Override
    public Object organize(Object obj) {
        funcName = ((ASTIdentifier) children[0]).value.toString();

        final Variable var = new Variable(funcName);// , this);
        final HashMap<String, Variable> parentVars = ((SimpleNode) parent).getHMVars();
        if (parentVars.containsKey(funcName)) {
            throw newException("Identifier '" + funcName + "' already in use");
        }
        parentVars.put(funcName, var);

        organizeParams(obj);
        return obj;
    }

    private void organizeParams(Object obj) {
        final ASTFormalParameterList paramList = ((ASTFormalParameterList) children[1]);
        if (paramList.children != null) {
            for (final Node argChild : paramList.children) {
                final String argName = ((ASTIdentifier) argChild).value.toString();
                if (args.containsKey(argName)) {
                    throw newException(
                            "Function \"" + funcName + "\" contains variables with the same name: " + argName);
                }
                final Variable argVar = new Variable(argName);
                args.put(argName, argVar);
            }
        }
        ((SimpleNode) children[2]).organize(obj);
        ((SimpleNode) children[2]).insertTag = false;
    }

    @Override
    public void globalToXML(Document doc, Element parent) {
        toXML(doc, parent, "declaration");
    }

    @Override
    public void toXML(Document doc, Element parent) {
        toXML(doc, parent, "statement");

    }

    private void toXML(Document doc, Element parent, String elementType) {
        final Element statEl = doc.createElement(elementType);
        statEl.setAttribute("name", "fndecl");
        statEl.setAttribute("coord", getCoords());
        addXMLComent(statEl);
        parent.appendChild(statEl);
        final Element exprEl = doc.createElement("expression");
        statEl.appendChild(exprEl);
        final Element opEl = doc.createElement("op");
        opEl.setAttribute("name", "FN");
        exprEl.appendChild(opEl);
        Element litEl = doc.createElement("literal");
        litEl.setAttribute("value", funcName);
        litEl.setAttribute("type", Types.String.toString());
        opEl.appendChild(litEl);

        final ASTFormalParameterList paramList = ((ASTFormalParameterList) children[1]);
        if (paramList.children != null) {
            for (final Node argChild : paramList.children) {
                final String argName = ((ASTIdentifier) argChild).value.toString();
                litEl = doc.createElement("literal");
                litEl.setAttribute("value", argName);
                litEl.setAttribute("type", Types.String.toString());

                opEl.appendChild(litEl);
            }
        }

        // for (final String id : args.keySet()) {
        // litEl = doc.createElement("literal");
        // litEl.setAttribute("value", id);
        // litEl.setAttribute("type", Types.String.toString());
        //
        // opEl.appendChild(litEl);
        // }
        ((SimpleNode) children[2]).toXML(doc, opEl);
    }

    @Override
    public Types getExpressionType() {
        return Types.FNDecl;
    }

    /**
     * @param args
     *            the args to set
     */
    public void setArgs(LinkedHashMap<String, Variable> args) {
        this.args = args;
    }

    /**
     * @return the args
     */
    public LinkedHashMap<String, Variable> getArgs() {
        return args;
    }

    @Override
    public Variable lookup(String var) {
        if (args.containsKey(var)) {
            return args.get(var);
        }
        return ((SimpleNode) parent).lookup(var);
    }

    @Override
    public Variable lookupNoError(String var) {
        if (args.containsKey(var)) {
            return args.get(var);
        }
        return ((SimpleNode) parent).lookupNoError(var);
    }

    @Override
    public HashMap<String, Variable> getHMVars() {
        return args;
    }

    public String getFuncName() {
        return ((ASTIdentifier) children[0]).value.toString();
    }
}

/*
 * JavaCC - OriginalChecksum=6ad6228c0375726db657af81111aa7b8 (do not edit this
 * line)
 */
