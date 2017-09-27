package entity;

import java.util.Date;

public  class Service {

    private String name;
    private Date date;
    private int cost;
    private Guest guest;

    public Service(String name,int cost){
        this.name=name;
        this.cost=cost;
    }

    public String toString(){
      return  String.format("Service:  %s cost: %s %s ",this.name,this.cost,this.guest);

    }
public void setDate(Date date){
        this.date=date;
}
public void setGuest(Guest guest){
    this.guest=guest;
}
}
