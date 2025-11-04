package proyecto.models;


import java.util.UUID;

public class Request implements java.io.Serializable {
    private final String  requestId;
    private final String authorId;
    private final String recordId;
    private String reason = "";

    public Request(String authorId, String recordId) {
        this.requestId = "A" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);;
        this.authorId = authorId;
        this.recordId = recordId;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getReason() { return reason; }
}