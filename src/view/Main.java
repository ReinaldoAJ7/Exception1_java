package view;

import model.Reservation;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = input.nextInt();
        System.out.print("Check in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(input.next());
        System.out.print("Check out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error reservation: Check-out date must be after check-in date. ");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(MessageFormat.format("Reservation: ", reservation));

            System.out.println();
            System.out.print("Enter with data to update the reservation: ");
            System.out.print("Check in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(input.next());
            System.out.print("Check out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.print("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error reservation: Check-out date must be after check-in date. ");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(MessageFormat.format("Reservation: ", reservation));
            }
        }

    }
}
