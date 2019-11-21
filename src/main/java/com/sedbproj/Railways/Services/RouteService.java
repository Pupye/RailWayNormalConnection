package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.BookEntity;
import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Errors.TrainIsBusyException;
import com.sedbproj.Railways.Repositories.RouteRepository;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public void createNewInstanceRoute (RouteEntity route) throws RuntimeException{
        //TODO you may consider whether train is available
        Timestamp trainIsBusyBy = routeRepository.trainBusyDate(route.getTrainId());

        Timestamp departureDate = route.getDepDate();
        Timestamp arrivalDate = route.getArrDate();
        Boolean isDepNull = departureDate == null;
        Boolean isArrNull = arrivalDate == null;

        if (trainIsBusyBy == null){
            routeRepository.save(route);
        }else if ((!isArrNull && trainIsBusyBy.after(arrivalDate))
                || (!isDepNull && trainIsBusyBy.after(departureDate))){
            throw new TrainIsBusyException(route.getTrainId());
        }else {
            routeRepository.save(route);
        }
    }
    public Integer getOrderByRouteAndStationId(Integer routeId, Integer stationId){
        return routeRepository.findOrderingByRouteIdAndStationId(routeId, stationId);
    }

    public int getTrainIdByRouteId(int routeId) {
        return routeRepository.getTrainIdByRouteId(routeId);
    }

    public String getDepartureTimeByRouteIdAndStationId(int routeId, int departStationId1) {
        Timestamp depTime = routeRepository.getDepartureTimeByStationAndRouteId(routeId, departStationId1);
        return depTime == null? null: depTime.toString();
    }

    public String getArrivalTimeByRouteIdAndStationId(int routeId, int arriveStationId) {
        Timestamp arrivalDate = routeRepository.getArrivalTimeByStationAndRouteId(routeId, arriveStationId);
        return arrivalDate == null ? null : arrivalDate.toString();
    }
}
