package proyecto.models;

import proyecto.enums.RequestStatus;

import java.util.UUID;

public class Request implements java.io.Serializable {
    private final String  requestId;
    private final String authorId;
    private final Record record;
    private RequestStatus status;
    private String reason = "";

    public Request(String authorId, Record record, RequestStatus status) {
        this.requestId = "A" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);;
        this.authorId = authorId;
        this.record = record;
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Record getRecord() {
        return record;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public String getReason() { return reason; }

}
