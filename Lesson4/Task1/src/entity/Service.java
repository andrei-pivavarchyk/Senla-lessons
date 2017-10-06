package entity;

import java.util.Date;

public class Service extends Entity {

    private String name;
    private int cost;
    private ServiceType type;

    public Service(int id, ServiceType type, String name, int cost) {
        super(id);
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public ServiceType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Service:  %s cost: %s ", this.name, this.cost);
    }


}
