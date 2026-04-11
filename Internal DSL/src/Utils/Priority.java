package Utils;

@Deprecated
public enum Priority {
    HIGH,
    MEDIUM,
    LOW;

    public int value() {
        switch (this) {
            case HIGH:
                return 3;
            case MEDIUM:
                return 2;
            case LOW:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.value());
    } 
}