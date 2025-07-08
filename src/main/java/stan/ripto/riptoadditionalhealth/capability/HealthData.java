package stan.ripto.riptoadditionalhealth.capability;

public class HealthData implements IHealthData {
    private int health;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void addHealth(int value) {
        health += value;
    }

    @Override
    public void setHealth(int value) {
        health = value;
    }
}
