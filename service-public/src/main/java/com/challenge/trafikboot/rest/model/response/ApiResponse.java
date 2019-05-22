package com.challenge.trafikboot.rest.model.response;


/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public class ApiResponse {

    private String ExecutionTime;

    private String Message;

    private ResponseData ResponseData;

    private String StatusCode;

    public String getExecutionTime ()
    {
        return ExecutionTime;
    }

    public void setExecutionTime (String ExecutionTime)
    {
        this.ExecutionTime = ExecutionTime;
    }

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public ResponseData getResponseData ()
    {
        return ResponseData;
    }

    public void setResponseData (ResponseData ResponseData)
    {
        this.ResponseData = ResponseData;
    }

    public String getStatusCode ()
    {
        return StatusCode;
    }

    public void setStatusCode (String StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ExecutionTime = "+ExecutionTime+", Message = "+Message+", ResponseData = "+ResponseData+", StatusCode = "+StatusCode+"]";
    }
}
