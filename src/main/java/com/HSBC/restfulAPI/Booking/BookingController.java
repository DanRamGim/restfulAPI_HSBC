// package com.HSBC.restfulAPI.Booking;

// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.List;

// import org.springframework.web.bind.annotation.PostMapping;





// @RestController
// @RequestMapping("/booking")

// @RequiredArgsConstructor
// public class BookingController {

//     private final BookingService bookingService;

//     @PostMapping("/create")    
//     public String createBooking(@RequestBody Booking booking)
//     {
//         return bookingService.createBooking(booking);
//     }

//     @PostMapping("/obtain")    
//     public String obtainBooking(@RequestBody Booking daytoobtain)
//     {
//         return bookingService.obtainBooking(daytoobtain);
//     }
// }
