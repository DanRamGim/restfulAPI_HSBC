package com.HSBC.restfulAPI.Booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.gson.Gson;

import org.json.simple.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    
    private final BookingRepository bookingRepo;

    /**
     * This Method tells you if your Booking was successfull or not, 
     * it grabs all the existing bookings and checks for 2 hours in miliseconds before and after each.
     * @param book
     * @return
     */
    @SuppressWarnings("null")
    public String createBooking(Booking book)
    {
        
        var allDates = bookingRepo.findAll();
        boolean notbooked = true;
        if(!IsNullOrEmpty(allDates))
        {
        for(Booking b:allDates)
        {
            var difference = Math.abs(b.getBookedDate().getTimeInMillis()-book.getBookedDate().getTimeInMillis());
            if(difference < 7200000)
            {
                notbooked = false;
                return "The date and hour are already booked, please try with a different date";
            }
        }
        }
        else
        {
            bookingRepo.save(book);
            return "The Booking has been saved";
        }
        
        if(notbooked)
        {
        bookingRepo.save(book);
        return "The Booking has been saved";
        }
        else
        {
            return "The date and hour are already booked, please try with a different date";
        }

    }

    /**
     * First we grab all the records and then we validate each one for the year and day that the user want to obtain.
     * We are using the Booking object just to reutilize it.
     * @param daytoobtain
     * @return
     */
    public String obtainBooking(Booking daytoobtain)
    {
        java.util.Calendar day = daytoobtain.getBookedDate();
        var allDates = bookingRepo.findAll();
        List<Booking> withinoneday = new ArrayList<Booking>();
        
        for(Booking b:allDates)
        {
            if(b.getBookedDate().get(Calendar.DAY_OF_YEAR) == day.get(Calendar.DAY_OF_YEAR) && b.getBookedDate().get(Calendar.YEAR) == day.get(Calendar.YEAR))
            {
                withinoneday.add(b);
            }
        }

        Gson gson = new Gson();
        String jsonArray = gson.toJson(withinoneday);
        return jsonArray;
    }

    public static <T> boolean IsNullOrEmpty(Collection<T> list) {
        return list == null || list.isEmpty();
    }

}
