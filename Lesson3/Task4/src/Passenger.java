public class Passenger {
    private int id;
    private Flight PassengerFlight;

    public Passenger(int id, Flight flight){
        this.id=id;
        this.PassengerFlight=flight;
    }

    public int getId() {
        return id;
    }

    public void setPassengerFlight(Flight passengerFlight) {
        PassengerFlight = passengerFlight;
    }
    public Flight getPassengerFlight(){
        return this.PassengerFlight;
    }
}
