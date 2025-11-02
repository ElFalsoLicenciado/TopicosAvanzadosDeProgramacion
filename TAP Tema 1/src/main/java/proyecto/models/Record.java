package proyecto.models;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import java.util.UUID;

public class Record implements java.io.Serializable {
    private final String recordId;
    private final String authorId;
    private StateNames stateNames;
    private RecordType recordType;
    private boolean isPublic = false;
    private String title;
    private String description;
    private String imageUrl;

    public Record(String authorId, StateNames stateNames, RecordType recordType, boolean isPublic, String title, String description, String imageUrl) {
        recordId = "R" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        this.authorId = authorId;
        this.stateNames = stateNames;
        this.recordType = recordType;
        this.isPublic = isPublic;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Record(String recordId, String authorId, StateNames stateNames, RecordType recordType, boolean isPublic, String title, String description, String imageUrl) {
        this.recordId = recordId;
        this.authorId = authorId;
        this.stateNames = stateNames;
        this.recordType = recordType;
        this.isPublic = isPublic;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getRecordId() {
        return recordId;
    }

    public StateNames getState() {
        return stateNames;
    }

    public void setState(StateNames stateNames) {
        this.stateNames = stateNames;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}