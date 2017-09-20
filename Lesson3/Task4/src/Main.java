public class Main {
    public static void main(String[] args){
        AirportSchedule bestAirportSchedule=new AirportSchedule(10);

        Flight firstFlight=new Flight(1,666);

        bestAirportSchedule.addFlight(firstFlight);
        bestAirportSchedule.getFlight(1).setStatusCanceled();
        bestAirportSchedule.getFlight(1).setStatusLate();


        Passenger firstPassenger=new Passenger(1,firstFlight);
        firstFlight.addPassenger(firstPassenger);
        firstFlight.removePassenger(1);

        bestAirportSchedule.printInfo();


    }
}
