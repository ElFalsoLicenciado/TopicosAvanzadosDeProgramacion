package proyecto.models;

import proyecto.enums.RequestStatus;


public class Request implements java.io.Serializable {
    private String id_request;
    private String id_record;
    private int record_number;
    private String id_author;
    private RequestStatus request_status;
    private String reason = "";
    private Record record;


    public Request() {
    }

    public Request(String id_request, String id_record, int record_number, String id_author, RequestStatus request_status, String reason) {
        this.id_request = id_request;
        this.id_record = id_record;
        this.record_number = record_number;
        this.id_author = id_author;
        this.request_status = request_status;
        this.reason = reason;
    }

    public Request(String id_request, String id_record, int record_number, String id_author, RequestStatus request_status, String reason, Record record) {
        this.id_request = id_request;
        this.id_record = id_record;
        this.record_number = record_number;
        this.id_author = id_author;
        this.request_status = request_status;
        this.reason = reason;
        this.record = record;
    }

    public String getId_request() {
        return id_request;
    }

    public void setId_request(String id_request) {
        this.id_request = id_request;
    }

    public String getId_record() {
        return id_record;
    }

    public void setId_record(String id_record) {
        this.id_record = id_record;
    }

    public int getRecord_number() {
        return record_number;
    }

    public void setRecord_number(int record_number) {
        this.record_number = record_number;
    }

    public String getId_author() {
        return id_author;
    }

    public void setId_author(String id_author) {
        this.id_author = id_author;
    }

    public RequestStatus getRequest_status() {
        return request_status;
    }

    public void setRequest_status(RequestStatus request_status) {
        this.request_status = request_status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}