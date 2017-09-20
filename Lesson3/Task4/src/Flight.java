public class Flight {
    private int id;
    private int maxCapacity;
    private int countPassengers = 0;
    private Passenger[] allPassengers;
    private FlightType type;

    public Flight(int id, int maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        allPassengers = new Passenger[maxCapacity];
    }

    public void setStatusLate() {
        this.type = FlightType.late;
        System.out.println("Status Late for Flight with id " + getId());
    }

    public void setStatusCanceled() {

        this.type = FlightType.canceled;
        System.out.println("Status Canceled for Flight with id " + getId());
    }

    public void setStatusNormal() {

        this.type = FlightType.normal;
    }

    public int getId() {
        return this.id;
    }

    public void addPassenger(Passenger passenger) {
        this.allPassengers[countPassengers++] = passenger;

        System.out.println("Passenger with id " + passenger.getId() + " was added");
    }

    public void removePassenger(int passengerId) {
        for (int i = 0; i < maxCapacity; i++) {
            if (this.allPassengers[i].getId() == passengerId) {
                removePassengerByPosition(i);
                break;

            }
        }

    }

    public String toString() {
        return " Flight id " + this.id + "Status " + this.type.toString();
    }

    private void removePassengerByPosition(int id) {

        for (int i = id; i < countPassengers; i++) {
            this.allPassengers[i] = this.allPassengers[i + 1];
        }
        this.allPassengers[countPassengers - 1] = null;
        countPassengers--;
        System.out.println("Passenger was removed");

    }

}
