package LanguageModel;

import java.lang.IllegalStateException;

public class Requirement {

    protected String item;
    protected int amount;
    protected String operator;

    protected final String validOperators[] = {">=", "<=", "=", ">", "<",};
    

    public Requirement(String item, int amount, String operator) {
        this.item = item;
        this.amount = amount;
        this.operator = operator;
    }
    
    public Requirement(String requirementOperantString) {
        this.operator = findOpperat(requirementOperantString);
        String elements[] = requirementOperantString.split(operator);
        this.item = elements[0].trim();
        this.amount = Integer.parseInt(elements[1]);
    }

    private String findOpperat(String requirementOperandString) {
        for (String vo : validOperators) {
            if (requirementOperandString.contains(vo)) {
                return vo;
            }
        }
        throw new IllegalStateException("Invalid operant in operant string: " + requirementOperandString);
    }

    public boolean isSatisfied(SystemState systemState) {
        int currentAmount = systemState.getItemValue(item);
        switch (operator) {
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
                throw new IllegalStateException("Invalid operator: " + operator);
        }
    }  
}
