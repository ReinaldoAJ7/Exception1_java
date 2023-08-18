package view;

import exceptions.DomainException;
import model.Reservation;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = input.nextInt();
            System.out.print("Check in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(input.next());
            System.out.print("Check out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(input.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.print("Enter with data to update the reservation: ");
            System.out.print("Check in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(input.next());
            System.out.print("Check out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: \n" + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid format.");
            //e.getMessage();
        }
        catch (DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unespected error ");
        }

       input.close();
    }
}
