package LanguageModel;

<<<<<<< HEAD
public class Requirement {
    public Item item;
    public int quantity;

    public Requirement(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
     
    }

=======
import java.lang.IllegalStateException;

public class Requirement {

    protected String item;
    protected int amount;
    protected String relationalOperator;
    protected String booleanOperator;

    protected final String validOperators[] = {">=", "<=", "=", ">", "<",};
    

    public Requirement(String item, int amount, String operator, String booleanOperator) {
        this.item = item;
        this.amount = amount;
        this.relationalOperator = operator;
        this.booleanOperator = booleanOperator;

    }
    
    public Requirement(String operantString, String booleanOperator) {
        this.relationalOperator = findRelationalOpperat(operantString);
        if (this.relationalOperator.isEmpty()) {
            throw new IllegalStateException("Missing or wrong operand in operand string: \"" + operantString + "\"");
        }
        String elements[] = operantString.split(relationalOperator);
        if (!findRelationalOpperat(elements[0].trim()).isEmpty() || elements[0].trim().contains(" ") ||
            !findRelationalOpperat(elements[1].trim()).isEmpty() || elements[0].trim().contains(" ")   ) {
            throw new IllegalStateException("Too many relational operands in operand string: \"" + operantString + "\"");      
        } 
        if (elements.length != 2) {
            throw new IllegalStateException("Invalid operand string: \"" + operantString + "\"");
        }
        this.item = elements[0].trim();
        this.amount = Integer.parseInt(elements[1].trim());
        this.booleanOperator = booleanOperator;
    }

    private String findRelationalOpperat(String operantString) {
        for (String vo : validOperators) {
            if (operantString.contains(vo)) {
                return vo;
            }
        }
        return "";
    }

    public boolean isSatisfied(SystemState systemState) {
        int currentAmount = systemState.getItemValue(item);
        switch (relationalOperator) {
            case ">=":
                return currentAmount >= amount;
            case "<=":
                return currentAmount <= amount;
            case "=":
                return currentAmount == amount;
            case ">":
                return currentAmount > amount;
            case "<":
                return currentAmount < amount;
            default:
                throw new IllegalStateException("Invalid operator: " + relationalOperator);
        }
    }  
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
}
