public class Main {
    public static void main(String[] args){
        AirportSchedule bestAirportSchedule=new AirportSchedule(10);

        //new flights
        Flight firstFlight=new Flight(1,666);
        Flight secondFlight=new Flight(2,666);
        Flight thirdFlight=new Flight(3,666);

        //adding flights into schedule
        bestAirportSchedule.addFlight(firstFlight);
        bestAirportSchedule.addFlight(secondFlight);
        bestAirportSchedule.addFlight(thirdFlight);

        //set flight status
        bestAirportSchedule.getFlight(1).setStatusCanceled();
        bestAirportSchedule.getFlight(1).setStatusLate();


        Passenger firstPassenger=new Passenger(1,firstFlight);

        firstFlight.addPassenger(firstPassenger);
        firstFlight.removePassenger(1);
        secondFlight.addPassenger(firstPassenger);

        bestAirportSchedule.printInfo();


    }
}
