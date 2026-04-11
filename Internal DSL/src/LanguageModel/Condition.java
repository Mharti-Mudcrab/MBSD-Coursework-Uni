package LanguageModel;

public abstract class Condition {

    public abstract boolean isSatisfied(SystemState systemState);

    public static Condition parseCondition(String condition) {
        if (condition == null || condition.isEmpty()) {
            return null; // No condition means always satisfied
        }
        if (condition.contains(" and ") || condition.contains(" or ")) {
            return new LogicCondition(condition);
        } else {
            return new RequirementCondition(condition);
        }
    }
}
