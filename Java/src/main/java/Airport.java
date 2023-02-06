import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;
/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */
public class Airport {
    private final List<? extends Plane> planes;
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }
    @Override
    public String toString() {
        return "Airport{Planes=" + planes.toString() + "}";
    }
    /**
     * Gets planes
     * @return List<? extends Plane>
     */
    public List<? extends Plane> getPlanes() {
        return planes;
    }
    /**
     * Gets passenger planes
     * @return List<PassengerPlane>
     */
    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneList;
    }
    /**
     * Gets military planes
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlaneList.add((MilitaryPlane) plane);
            }
        }
        return militaryPlaneList;
    }
    /**
     * Gets passenger plane with max passenger capacity
     * @return Passenger plane
     */
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane passengerPlaneWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > passengerPlaneWithMaxCapacity.getPassengersCapacity()) {
                passengerPlaneWithMaxCapacity = passengerPlane;
            }
        }
        return passengerPlaneWithMaxCapacity;
    }
    /**
     * Gets military planes type transport
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getMilitaryPlanesTypeTransport() {
    List<MilitaryPlane> militaryPlanesTypeTransport = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
                militaryPlanesTypeTransport.add(plane);
            }
        }
    return militaryPlanesTypeTransport;
    }
    /**
     * Gets military planes type bomber
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getMilitaryPlanesTypeBomber() {
        List<MilitaryPlane> militaryPlanesTypeBomber = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.BOMBER) {
                militaryPlanesTypeBomber.add(plane);
            }
        }
        return militaryPlanesTypeBomber;
    }
    /**
     * Gets experimental planes
     * @return List<ExperimentalPlane>
     */
    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }
    /**
     * Sorts by max flight distance
     * @return Airport
     */
    public Airport sortByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }
    /**
     * Sorts by max load capacity
     * @return Airport
     */
    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }
}
