package proyecto.models;

import proyecto.enums.RequestStatus;


public class Request implements java.io.Serializable {
    private String id_request;
    private String id_record;
    private String id_author;
    private RequestStatus status;
    private String reason = "";
    private Record record;
    private User author;


    public Request() {
    }

    public Request(String id_request, String id_author, String id_record, RequestStatus status, String reason) {
        this.id_request = id_request;
        this.id_author = id_author;
        this.id_record = id_record;
        this.status = status;
        this.reason = reason;
    }

    public Request(String id_request, String id_author, String id_record, RequestStatus status, String reason, Record record, User author) {
        this.id_request = id_request;
        this.id_author = id_author;
        this.id_record = id_record;
        this.status = status;
        this.reason = reason;
        this.record = record;
        this.author = author;
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

    public String getId_author() {
        return id_author;
    }

    public void setId_author(String id_author) {
        this.id_author = id_author;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}