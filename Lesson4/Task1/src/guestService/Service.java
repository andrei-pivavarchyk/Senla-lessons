package guestService;

import entity.Guest;

import java.util.Date;

public class Service {

    private String name;
    private Date date;
    private int cost;
    private Guest guest;
    private ServiceType type;

    public Service(String name,int cost,ServiceType type){
        this.name=name;
        this.cost=cost;
        this.type=type;
    }

    public String toString(){
      return  String.format("Service:  %s cost: %s %s ",this.name,this.cost,this.guest);

    }
public void setDate(Date date){
        this.date=date;
}
public Date getDate(){
    return this.date;
}
public void setGuest(Guest guest){
    this.guest=guest;
}
public void setType(ServiceType type){
    this.type=type;
}
public int getCost(){
return this.cost;
}

}
