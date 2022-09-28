package com.backend.holydaystravel.scheduler;

import com.backend.holydaystravel.config.AdminConfig;
import com.backend.holydaystravel.domain.Mail;
import com.backend.holydaystravel.facade.FlightFacade;
import com.backend.holydaystravel.facade.HotelFacade;
import com.backend.holydaystravel.facade.TourFacade;
import com.backend.holydaystravel.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "Once a day email";
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;
    private final TourFacade tourFacade;
    private final HotelFacade hotelFacade;
    private final FlightFacade flightFacade;

    @Scheduled(cron = "24 0 0 * * *")
    public void sendInformationEmail() {
        long tourSize = tourFacade.getAllTours().size();
        long hotelSize = hotelFacade.getAllHotels().size();
        long flightSize = flightFacade.getAllFlights().size();
        String tourWord;
        String hotelWord;
        String flightWord;

        tourWord = tourSize == 1 ? " tour" : " tours";
        hotelWord = hotelSize == 1 ? " hotel" : " hotels";
        flightWord = flightSize == 1 ? " flight" : " flights";
        emailService.send(
                new Mail(
                        adminConfig.getAdminEmail(),
                        SUBJECT,
                        "Currently in database you got: " + tourSize + tourWord +
                                ", " + hotelSize + hotelWord + ", " + flightSize + flightWord
                )
        );
    }
}
