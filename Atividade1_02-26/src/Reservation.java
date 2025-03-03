import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private static List<Reservation> reservations = new ArrayList<>();

    LocalDate checkIn, checkOut;
    int roomNumber;

    public Reservation(int roomNumber, String checkInStr, String checkOutStr) throws Exception {
        if (Reservation.findRoom(roomNumber) != null) {
            throw new Exception("Quarto com este numero ja foi reservado");
        }

        try {
            this.setDate(checkInStr, checkOutStr);
        } catch(DateTimeParseException e) {
            throw new Exception(e.getMessage());
        } 

        this.roomNumber = roomNumber;
        reservations.add(this);
    }

    public static LocalDate parseLocalDate(String dateString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public static Reservation findRoom(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.roomNumber == roomNumber) {
                return reservation;
            }
        }

        return null;
    }

    public void setDate(String checkInStr, String checkOutStr) {
        LocalDate checkIn, checkOut;

        try {
            checkIn = Reservation.parseLocalDate(checkInStr);
            checkOut = Reservation.parseLocalDate(checkOutStr);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Falha ao converter data: " + e.getMessage(),
                    checkInStr + ", " + checkOutStr,
                    e.getErrorIndex());
        }

        LocalDate now = LocalDate.now();

        if (!checkIn.isAfter(now) || !checkOut.isAfter(now)) {
            throw new DateTimeException("Check-out ou check-in ja passou");
        }

        if (checkIn.isAfter(checkOut)) {
            throw new DateTimeException("Check-out precisa ser depois do check-in");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getDuration() {
        long days = ChronoUnit.DAYS.between(this.checkIn, this.checkOut);

        if (days > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (days < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) days;
    }

    public void printData() {
        System.out.print(String.format("Quarto: %d, Check-in: %s, Check-out: %s, Duracao: %d dia",
                this.roomNumber, this.checkIn, this.checkOut, this.getDuration()));

        if (this.getDuration() != 1) {
            System.out.print("s");
        }

        System.out.println();
    }
}
