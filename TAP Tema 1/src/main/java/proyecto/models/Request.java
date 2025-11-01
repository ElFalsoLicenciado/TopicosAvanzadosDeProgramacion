package proyecto.models;


public class Request implements java.io.Serializable {
    private final String  requestId;
    private final String authorId;
    private final String recordId;

    public Request(String requestId, String authorId, String recordId) {
        this.requestId = requestId;
        this.authorId = authorId;
        this.recordId = recordId;
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
}