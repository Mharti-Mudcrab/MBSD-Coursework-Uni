package LanguageModel;

import java.lang.IllegalStateException;

public class RequirementCondition extends Condition {

    protected String item;
    protected int amount;
    protected String operator;

    protected final String validOperators[] = {">=", "<=", "==", ">", "<", "!="};
    
    public RequirementCondition(String operandString) {

        while(operandString.startsWith("(") && operandString.endsWith(")")) {
            operandString = operandString.substring(1, operandString.length() - 1);
        }

        this.operator = findRelationalOpperat(operandString);
        if (this.operator.isEmpty()) {
            throw new IllegalStateException("Missing or unsupported operand in operand string: \"" + operandString + "\"");
        }
        String elements[] = operandString.split(operator);
        if (!findRelationalOpperat(elements[0].trim()).isEmpty() || elements[0].trim().contains(" ") ||
            !findRelationalOpperat(elements[1].trim()).isEmpty() || elements[0].trim().contains(" ")   ) {
            throw new IllegalStateException("Too many relational operands in operand string: \"" + operandString + "\"");      
        } 
        if (elements.length != 2) {
            throw new IllegalStateException("Invalid operand string: \"" + operandString + "\"");
        }
        this.item = elements[0].trim();
        this.amount = Integer.parseInt(elements[1].trim());
    }

    private String findRelationalOpperat(String operandString) {
        for (String vo : validOperators) {
            if (operandString.contains(vo)) {
                return vo;
            }
        }
        return "";
    }

    @Override
    public boolean isSatisfied(SystemState systemState) {
        int currentAmount = systemState.getItemValue(item);
        switch (operator) {
            case ">=" -> {return currentAmount >= amount;}
            case "<=" -> {return currentAmount <= amount;}
            case "==" -> {return currentAmount == amount;}
            case "!=" -> {return currentAmount != amount;}
            case ">" -> {return currentAmount > amount;}
            case "<" -> {return currentAmount < amount;}
            
            default -> throw new IllegalStateException("Invalid operator: " + operator);
        }
    }  
}
