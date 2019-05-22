package com.challenge.trafikboot.rest.model.response;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public class ResponseData {
    private String Type;

    private String Version;

    private Result[] Result;

    public String getType ()
    {
        return Type;
    }

    public void setType (String Type)
    {
        this.Type = Type;
    }

    public String getVersion ()
    {
        return Version;
    }

    public void setVersion (String Version)
    {
        this.Version = Version;
    }

    public Result[] getResult ()
    {
        return Result;
    }

    public void setResult (Result[] Result)
    {
        this.Result = Result;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Type = "+Type+", Version = "+Version+", Result = "+Result+"]";
    }
}
