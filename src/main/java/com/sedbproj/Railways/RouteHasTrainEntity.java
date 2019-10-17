package com.sedbproj.Railways;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROUTE_has_TRAIN", schema = "Railway", catalog = "")
@IdClass(RouteHasTrainEntityPK.class)
public class RouteHasTrainEntity {
    private int routeIdRoute;
    private int trainIdTrain;

    @Id
    @Column(name = "ROUTE_idROUTE", nullable = false)
    public int getRouteIdRoute() {
        return routeIdRoute;
    }

    public void setRouteIdRoute(int routeIdRoute) {
        this.routeIdRoute = routeIdRoute;
    }

    @Id
    @Column(name = "TRAIN_idTRAIN", nullable = false)
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
        RouteHasTrainEntity that = (RouteHasTrainEntity) o;
        return routeIdRoute == that.routeIdRoute &&
                trainIdTrain == that.trainIdTrain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeIdRoute, trainIdTrain);
    }
}
