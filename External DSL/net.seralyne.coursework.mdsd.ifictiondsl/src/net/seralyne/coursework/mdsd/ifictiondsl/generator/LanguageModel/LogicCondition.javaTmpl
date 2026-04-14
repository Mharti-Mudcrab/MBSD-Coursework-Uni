package LanguageModel;

public class LogicCondition extends Condition {
    private Condition left;
    private Condition right;
    private String booleanOperator; // "and", "or", or null for leaf nodes

    // "Talisman=1 and Coins=5 or (Cucumber<10 and Favor>=15) or ((CancanDancers=1))"
    public LogicCondition(String condition) {
        
        condition = condition.trim();
        if(condition.startsWith("(") && condition.endsWith(")")) {
            condition = condition.substring(1, condition.length() - 1);
        }
        if(testForOperator("or", condition)) {}
        else if(testForOperator("and", condition)) {}
        else
            throw new IllegalStateException("Invalid logic condition: \"" + condition + "\"");
    }

    private boolean  testForOperator(String operator, String condition) {
        int plvl = 0;
        String spaceSeparated[] = condition.split(" ");
        for (int i = 0; i < spaceSeparated.length; i++) {
            String s = spaceSeparated[i];
            if (s.startsWith("(") || s.endsWith(")")) {
                for (char c : s.toCharArray()) {
                    if (c == '(') plvl++;
                    else if (c == ')') plvl--;
                }
            }
            if (plvl > 0) { // If we're inside parentheses, we ignore operators and deal with them later
                continue;    
            }
            if (s.equals(operator)) {
                this.booleanOperator = operator;
                createChildren(i, spaceSeparated);
                return true;
            }
        }
        return false;
    }

    private void createChildren(int i, String[] spaceSeparated) {
        String left = "";
        for (int j = 0; j < i; j++) {
            left += spaceSeparated[j] + " ";
        }
        String right = "";
        for (int j = i+1; j < spaceSeparated.length; j++) {
            right += spaceSeparated[j] + " ";
        }
        
        this.left = Condition.parseCondition(left.trim());
        this.right = Condition.parseCondition(right.trim()); 
    }

    @Override
    public boolean isSatisfied(SystemState systemState) {
        switch (booleanOperator) {
            case "or":
                return left.isSatisfied(systemState) || right.isSatisfied(systemState);
            case "and":
                return left.isSatisfied(systemState) && right.isSatisfied(systemState);
            default:
                throw new IllegalStateException("Invalid boolean operator: " + booleanOperator);
        }
    }
}