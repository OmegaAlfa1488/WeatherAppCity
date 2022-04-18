package com.example.photoearthobserver.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EpicModel implements Serializable {
    @SerializedName("identifier")
    @Expose
    public String identifier;
    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("version")
    @Expose
    public String version;
    @SerializedName("centroid_coordinates")
    @Expose
    public CentroidCoordinates centroid_coordinates;
    @SerializedName("dscovr_j2000_position")
    @Expose
    public DscovrJ2000Position dscovr_j2000_position;
    @SerializedName("lunar_j2000_position")
    @Expose
    public LunarJ2000Position lunar_j2000_position;
    @SerializedName("sun_j2000_position")
    @Expose
    public SunJ2000Position sun_j2000_position;
    @SerializedName("attitude_quaternions")
    @Expose
    public AttitudeQuaternions attitude_quaternions;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("coords")
    @Expose
    public Coords coords;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CentroidCoordinates getCentroid_coordinates() {
        return centroid_coordinates;
    }

    public void setCentroid_coordinates(CentroidCoordinates centroid_coordinates) {
        this.centroid_coordinates = centroid_coordinates;
    }

    public DscovrJ2000Position getDscovr_j2000_position() {
        return dscovr_j2000_position;
    }

    public void setDscovr_j2000_position(DscovrJ2000Position dscovr_j2000_position) {
        this.dscovr_j2000_position = dscovr_j2000_position;
    }

    public LunarJ2000Position getLunar_j2000_position() {
        return lunar_j2000_position;
    }

    public void setLunar_j2000_position(LunarJ2000Position lunar_j2000_position) {
        this.lunar_j2000_position = lunar_j2000_position;
    }

    public SunJ2000Position getSun_j2000_position() {
        return sun_j2000_position;
    }

    public void setSun_j2000_position(SunJ2000Position sun_j2000_position) {
        this.sun_j2000_position = sun_j2000_position;
    }

    public AttitudeQuaternions getAttitude_quaternions() {
        return attitude_quaternions;
    }

    public void setAttitude_quaternions(AttitudeQuaternions attitude_quaternions) {
        this.attitude_quaternions = attitude_quaternions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public class CentroidCoordinates{
        @SerializedName("lat")
        @Expose
        public double lat;
        @SerializedName("lon")
        @Expose
        public double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    public class DscovrJ2000Position{
        @SerializedName("x")
        @Expose
        public double x;
        @SerializedName("y")
        @Expose
        public double y;
        @SerializedName("z")
        @Expose
        public double z;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }
    }

    public class LunarJ2000Position{
        @SerializedName("x")
        @Expose
        public double x;
        @SerializedName("y")
        @Expose
        public double y;
        @SerializedName("z")
        @Expose
        public double z;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }
    }

    public class SunJ2000Position{
        @SerializedName("x")
        @Expose
        public double x;
        @SerializedName("y")
        @Expose
        public double y;
        @SerializedName("z")
        @Expose
        public double z;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }
    }

    public class AttitudeQuaternions{
        @SerializedName("q0")
        @Expose
        public double q0;
        @SerializedName("q1")
        @Expose
        public double q1;
        @SerializedName("q2")
        @Expose
        public double q2;
        @SerializedName("q3")
        @Expose
        public double q3;

        public double getQ0() {
            return q0;
        }

        public void setQ0(double q0) {
            this.q0 = q0;
        }

        public double getQ1() {
            return q1;
        }

        public void setQ1(double q1) {
            this.q1 = q1;
        }

        public double getQ2() {
            return q2;
        }

        public void setQ2(double q2) {
            this.q2 = q2;
        }

        public double getQ3() {
            return q3;
        }

        public void setQ3(double q3) {
            this.q3 = q3;
        }
    }

    public class Coords{
        @SerializedName("centroid_coordinates")
        @Expose
        public CentroidCoordinates centroid_coordinates;
        @SerializedName("dscovr_j2000_position")
        @Expose
        public DscovrJ2000Position dscovr_j2000_position;
        @SerializedName("lunar_j2000_position")
        @Expose
        public LunarJ2000Position lunar_j2000_position;
        @SerializedName("sun_j2000_position")
        @Expose
        public SunJ2000Position sun_j2000_position;
        @SerializedName("attitude_quaternions")
        @Expose
        public AttitudeQuaternions attitude_quaternions;

        public CentroidCoordinates getCentroid_coordinates() {
            return centroid_coordinates;
        }

        public void setCentroid_coordinates(CentroidCoordinates centroid_coordinates) {
            this.centroid_coordinates = centroid_coordinates;
        }

        public DscovrJ2000Position getDscovr_j2000_position() {
            return dscovr_j2000_position;
        }

        public void setDscovr_j2000_position(DscovrJ2000Position dscovr_j2000_position) {
            this.dscovr_j2000_position = dscovr_j2000_position;
        }

        public LunarJ2000Position getLunar_j2000_position() {
            return lunar_j2000_position;
        }

        public void setLunar_j2000_position(LunarJ2000Position lunar_j2000_position) {
            this.lunar_j2000_position = lunar_j2000_position;
        }

        public SunJ2000Position getSun_j2000_position() {
            return sun_j2000_position;
        }

        public void setSun_j2000_position(SunJ2000Position sun_j2000_position) {
            this.sun_j2000_position = sun_j2000_position;
        }

        public AttitudeQuaternions getAttitude_quaternions() {
            return attitude_quaternions;
        }

        public void setAttitude_quaternions(AttitudeQuaternions attitude_quaternions) {
            this.attitude_quaternions = attitude_quaternions;
        }
    }

}
