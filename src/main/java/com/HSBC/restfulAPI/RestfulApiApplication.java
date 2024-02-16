package com.HSBC.restfulAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HSBC.restfulAPI.Booking.Booking;
import com.HSBC.restfulAPI.Booking.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.muserver.*;
import io.muserver.handlers.ResourceHandlerBuilder;

@SpringBootApplication
public class RestfulApiApplication {

	/**
	 * We are using MuServer to manage the API calls.
	 * The calls are created using the Services that could be called by a controller since we are using MuServer the controllers are not needed
	 * @param args
	 */
	public static void main(String[] args) {

		
			MuServer server = MuServerBuilder.httpServer()
            .addHandler(ResourceHandlerBuilder.fileHandler("C:\\Users\\danra\\Documents\\Visual Studio Code\\restfulAPI\\src\\main\\resources\\templates"))
			.addHandler(Method.POST, "/obtain", (request, response, pathParams) -> {
				String jsonobtained = "";
				ObjectMapper objectMapper = new ObjectMapper();
				var applicationContext = SpringApplication.run(RestfulApiApplication.class, args);
				BookingService service = applicationContext.getBean(BookingService.class);
						jsonobtained = request.readBodyAsString();
						Booking booking = objectMapper.readValue(jsonobtained, Booking.class);
						response.write(service.obtainBooking(booking));
					})
			.addHandler(
				Method.POST, "/create", (request, response, pathParams) -> {
					String jsonobtained = "";
					ObjectMapper objectMapper = new ObjectMapper();
					var applicationContext = SpringApplication.run(RestfulApiApplication.class, args);
        			BookingService service = applicationContext.getBean(BookingService.class);
							jsonobtained = request.readBodyAsString();
							Booking booking = objectMapper.readValue(jsonobtained, Booking.class);
							response.write(service.createBooking(booking));
						}
				)
            .start();
			
			System.out.println("Started server at " + server.uri());

		
	}

}
