package proyecto.models;

import proyecto.enums.RequestStatus;

import java.util.UUID;

public class Request implements java.io.Serializable {
    private final String  requestId;
    private final String authorId;
    private final String recordId;
    private RequestStatus status;
    private String reason = "";

    public Request(String authorId, String recordId, RequestStatus status) {
        this.requestId = "A" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);;
        this.authorId = authorId;
        this.recordId = recordId;
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

    public String getRecordId() {
        return recordId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public String getReason() { return reason; }

}
