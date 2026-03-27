package LanguageModel;

import java.util.LinkedHashMap;
import java.lang.Integer;
import java.lang.IllegalStateException;


public class SystemStateChangeNode extends Node {

    private LinkedHashMap<String, Integer> stateChangeItems;

    public SystemStateChangeNode(String name, String displayText, String stateChangeExpression) {
        super(name, displayText);
        stateChangeItems = parseStateChangeExpression(stateChangeExpression);
    }

    private LinkedHashMap<String, Integer> parseStateChangeExpression(String stateChangeExpression) {
        LinkedHashMap<String, Integer> returnList = new LinkedHashMap<>();
        for(String stateChangeItem : stateChangeExpression.trim().split(",")) {
            String keyValuePair[] = stateChangeItem.trim().split("=");
            String key = keyValuePair[0];
            String value = keyValuePair[1];
            returnList.put(key, Integer.parseInt(value));
        }
        return returnList;
    }

    @Override
    public void executeNode(SystemState systemState) {
        displayText();

        for (String item : stateChangeItems.keySet()) {
            systemState.setItemValue(item, stateChangeItems.get(item));
        }

        if (transition != null) {
            transition.performTransition(systemState);
        }
        else {
            throw new IllegalStateException("SystemStateChangeNode has no transition");
        }   
    }

}
