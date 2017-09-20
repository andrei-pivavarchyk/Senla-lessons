public class AirportSchedule {
    private int maxCapacity;
    private int countFlights = 0;
    private Flight[] allFlights;

    public AirportSchedule(int capacity) {

        this.maxCapacity = capacity;
        allFlights=new Flight[maxCapacity];

    }

    public void addFlight(Flight flight) {
        if (this.countFlights == maxCapacity) {
            System.out.println("Error Max capacity");
            return;
        }
        allFlights[countFlights] = flight;
        countFlights++;
        System.out.println("Flight "+flight.getId()+" was added into schedule");

    }

    public Flight getFlight(int id) {
        for (int i = 0; i < countFlights; i++) {
            if (this.allFlights[i].getId()== id) {
                return allFlights[i];
            }
        }
        return null;
    }

    public void printInfo() {
        for (int i = 0; i < countFlights; i++) {
            System.out.println(this.allFlights[i]);
        }


    }
}
