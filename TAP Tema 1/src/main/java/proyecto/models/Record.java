package proyecto.models;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import java.util.UUID;

public class Record implements java.io.Serializable {
    private final String recordId;
    private final String authorId;
    private StateNames stateName;
    private RecordType recordType;
    private boolean isPublic;
    private String title;
    private String description;
    private String imageUrl;
    private boolean deleted;

    public Record(String authorId, StateNames stateName, RecordType recordType, boolean isPublic, String title, String description, String imageUrl) {
        recordId = "R" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        this.authorId = authorId;
        this.stateName = stateName;
        this.recordType = recordType;
        this.isPublic = isPublic;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.deleted = false;
    }

    public Record(String recordId, String authorId, StateNames stateName, RecordType recordType, boolean isPublic, String title, String description, String imageUrl, boolean deleted) {
        this.recordId = recordId;
        this.authorId = authorId;
        this.stateName = stateName;
        this.recordType = recordType;
        this.isPublic = isPublic;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.deleted = deleted;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getRecordId() {
        return recordId;
    }

    public StateNames getState() {
        return stateName;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        this.isPublic = aPublic;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted() {
        deleted = true;
    }
}