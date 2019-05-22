package com.challenge.trafikboot.rest.model.response;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public class Result {
    private String LineDesignation;

    private String ExistsFromDate;

    private String DefaultTransportMode;

    private String DefaultTransportModeCode;

    private String LastModifiedUtcDateTime;

    private String LineNumber;

    private String DirectionCode;

    private String JourneyPatternPointNumber;

    private String StopPointNumber;

    private String StopPointName;

    private String StopAreaNumber;

    private String LocationNorthingCoordinate;

    private String LocationEastingCoordinate;

    private String ZoneShortName;

    private String StopAreaTypeCode;


    public String getLineDesignation ()
    {
        return LineDesignation;
    }

    public void setLineDesignation (String LineDesignation)
    {
        this.LineDesignation = LineDesignation;
    }

    public String getExistsFromDate ()
    {
        return ExistsFromDate;
    }

    public void setExistsFromDate (String ExistsFromDate)
    {
        this.ExistsFromDate = ExistsFromDate;
    }

    public String getDefaultTransportMode ()
    {
        return DefaultTransportMode;
    }

    public void setDefaultTransportMode (String DefaultTransportMode)
    {
        this.DefaultTransportMode = DefaultTransportMode;
    }

    public String getDefaultTransportModeCode ()
    {
        return DefaultTransportModeCode;
    }

    public void setDefaultTransportModeCode (String DefaultTransportModeCode)
    {
        this.DefaultTransportModeCode = DefaultTransportModeCode;
    }

    public String getLastModifiedUtcDateTime ()
    {
        return LastModifiedUtcDateTime;
    }

    public void setLastModifiedUtcDateTime (String LastModifiedUtcDateTime)
    {
        this.LastModifiedUtcDateTime = LastModifiedUtcDateTime;
    }

    public String getLineNumber ()
    {
        return LineNumber;
    }

    public void setLineNumber (String LineNumber)
    {
        this.LineNumber = LineNumber;
    }

    public String getDirectionCode() {
        return DirectionCode;
    }

    public void setDirectionCode(String directionCode) {
        DirectionCode = directionCode;
    }

    public String getJourneyPatternPointNumber() {
        return JourneyPatternPointNumber;
    }

    public void setJourneyPatternPointNumber(String journeyPatternPointNumber) {
        JourneyPatternPointNumber = journeyPatternPointNumber;
    }

    public String getStopPointNumber() {
        return StopPointNumber;
    }

    public void setStopPointNumber(String stopPointNumber) {
        StopPointNumber = stopPointNumber;
    }

    public String getStopPointName() {
        return StopPointName;
    }

    public void setStopPointName(String stopPointName) {
        StopPointName = stopPointName;
    }

    public String getStopAreaNumber() {
        return StopAreaNumber;
    }

    public void setStopAreaNumber(String stopAreaNumber) {
        StopAreaNumber = stopAreaNumber;
    }

    public String getLocationNorthingCoordinate() {
        return LocationNorthingCoordinate;
    }

    public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
        LocationNorthingCoordinate = locationNorthingCoordinate;
    }

    public String getLocationEastingCoordinate() {
        return LocationEastingCoordinate;
    }

    public void setLocationEastingCoordinate(String locationEastingCoordinate) {
        LocationEastingCoordinate = locationEastingCoordinate;
    }

    public String getZoneShortName() {
        return ZoneShortName;
    }

    public void setZoneShortName(String zoneShortName) {
        ZoneShortName = zoneShortName;
    }

    public String getStopAreaTypeCode() {
        return StopAreaTypeCode;
    }

    public void setStopAreaTypeCode(String stopAreaTypeCode) {
        StopAreaTypeCode = stopAreaTypeCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LineDesignation = "+LineDesignation+", ExistsFromDate = "+ExistsFromDate+", DefaultTransportMode = "+DefaultTransportMode+", JourneyPatternPointNumber = "+JourneyPatternPointNumber+", StopPointName = "+StopPointName+", StopAreaNumber = "+StopAreaNumber+", DefaultTransportModeCode = "+DefaultTransportModeCode+", LastModifiedUtcDateTime = "+LastModifiedUtcDateTime+", LineNumber = "+LineNumber+"]";
    }
}
