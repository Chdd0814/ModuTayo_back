package com.group.express.service;

import com.group.express.domain.BusBooking;
import com.group.express.domain.TrainBooking;
import com.group.express.repository.TrainBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainBookingService {
    private final TrainBookingRepository trainBookingRepository;

    @Autowired
    TrainBookingService(TrainBookingRepository trainBookingRepository){this.trainBookingRepository=trainBookingRepository;}

    public List<TrainBooking> getTrainBookingList(String id ){
        return trainBookingRepository.findBookingsById(id);
    }

        public void trainTicketSuccess(TrainBooking trainBooking) throws Exception {
            // 결제 정보를 데이터베이스에 저장

                trainBookingRepository.save(trainBooking);

        }

    public List<TrainBooking> getSearchTrainBookingListall(String start,String end,String startDay,String endDay){
        return trainBookingRepository.getSearchTrainBookingListall(start,end,startDay,endDay);
    }
    public List<TrainBooking> getSearchTrainBookingListDay(String startDay,String endDay){
        return trainBookingRepository.getSearchTrainBookingListDay(startDay,endDay);
    }

}
