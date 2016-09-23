/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance_checker;

/**
 *
 * @author diyanov-a
 */
class Coordinate {

    double LON;
    double LAT;

    Coordinate() {
    }

    Coordinate(double LAT, double LON) {
        this.LON = LON;
        this.LAT = LAT;
    }

    double getLON() {
        return LON;
    }

    double getLAT() {
        return LAT;
    }

}
