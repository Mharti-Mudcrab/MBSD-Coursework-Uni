package LanguageModel;

import java.util.ArrayList;
import java.lang.Integer;
import java.lang.IllegalStateException;
import java.util.regex.Pattern;

public class SystemStateChangeNode extends Node {

    private static class SystemStateChangeItem {
        String itemName;
        String operator;
        Integer value;

        public SystemStateChangeItem(String itemName, String operator, Integer value) {
            this.itemName = itemName;
            this.operator = operator;
            this.value = value;
        }
    }

    private ArrayList<SystemStateChangeItem> stateChangeItems;

    public SystemStateChangeNode(String name, String displayText, String stateChangeExpression) {
        super(name, displayText);
        stateChangeItems = parseStateChangeExpression(stateChangeExpression);
    }

    private ArrayList<SystemStateChangeItem> parseStateChangeExpression(String stateChangeExpression) {
        ArrayList<SystemStateChangeItem> returnList = new ArrayList<>();
        for(String stateChangeItem : stateChangeExpression.trim().split(",")) {
            String operatorType = findOperatorType(stateChangeItem);
            String keyValuePair[] = stateChangeItem.trim().split(Pattern.quote(operatorType)); // To handle metacharacters like + in +=
            String key = keyValuePair[0].trim();
            String value = keyValuePair[1].trim();
            returnList.add(new SystemStateChangeItem(key, operatorType, Integer.parseInt(value)));
        }
        return returnList;
    }

    private String findOperatorType(String stateChangeItem) {
        if (stateChangeItem.contains("+=")) {
            return "+=";
        }
        else if (stateChangeItem.contains("-=")) {
            return "-=";
        }
        else if (stateChangeItem.contains("=")) {
            return "=";
        }
        else {
            throw new IllegalArgumentException("Invalid operator in state change item: " + stateChangeItem);
        }
    }
    
    @Override
    public void execute(SystemState systemState) {
        displayText();

        for (SystemStateChangeItem item : stateChangeItems) {
            String itemName = item.itemName;
            String operator = item.operator;
            Integer value = item.value;

            switch (operator) {
                case "+=":
                    systemState.setItemValue(itemName, systemState.getItemValue(itemName) + value);
                    break;
                case "-=":
                    systemState.setItemValue(itemName, systemState.getItemValue(itemName) - value);
                    break;
                case "=":
                    systemState.setItemValue(itemName, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator in state change item: " + item);
            }
        }

        if (transition != null) {
            transition.performTransition(systemState);
        }
        else {
            throw new IllegalStateException("SystemStateChangeNode has no transition");
        }   
    }

}
