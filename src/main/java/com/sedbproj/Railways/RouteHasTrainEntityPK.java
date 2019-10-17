package com.sedbproj.Railways;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RouteHasTrainEntityPK implements Serializable {
    private int routeIdRoute;
    private int trainIdTrain;

    @Column(name = "ROUTE_idROUTE", nullable = false)
    @Id
    public int getRouteIdRoute() {
        return routeIdRoute;
    }

    public void setRouteIdRoute(int routeIdRoute) {
        this.routeIdRoute = routeIdRoute;
    }

    @Column(name = "TRAIN_idTRAIN", nullable = false)
    @Id
    public int getTrainIdTrain() {
        return trainIdTrain;
    }

    public void setTrainIdTrain(int trainIdTrain) {
        this.trainIdTrain = trainIdTrain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteHasTrainEntityPK that = (RouteHasTrainEntityPK) o;
        return routeIdRoute == that.routeIdRoute &&
                trainIdTrain == that.trainIdTrain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeIdRoute, trainIdTrain);
    }
}
