package proyecto.models;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;

public class Record implements java.io.Serializable {
    private String id_record;
    private String id_author;
    private StateNames state_name;
    private RecordType record_type;
    private String title;
    private String description;
    private byte[] image;
    private boolean is_deleted;
    private boolean is_public;
    private User author;

    public Record() {
    }

    public Record(String id_record, String id_author, StateNames state_name, RecordType record_type, String title, String description, byte[] image, boolean is_deleted, boolean is_public) {
        this.id_record = id_record;
        this.id_author = id_author;
        this.state_name = state_name;
        this.record_type = record_type;
        this.title = title;
        this.description = description;
        this.image = image;
        this.is_deleted = is_deleted;
        this.is_public = is_public;
    }

    public Record(String id_record, String id_author, StateNames state_name, RecordType record_type, String title, String description, byte[] image, boolean is_deleted, boolean is_public, User author) {
        this.id_record = id_record;
        this.id_author = id_author;
        this.state_name = state_name;
        this.record_type = record_type;
        this.title = title;
        this.description = description;
        this.image = image;
        this.is_deleted = is_deleted;
        this.is_public = is_public;
        this.author = author;
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

    public StateNames getState_name() {
        return state_name;
    }

    public void setState_name(StateNames state_name) {
        this.state_name = state_name;
    }

    public RecordType getRecord_type() {
        return record_type;
    }

    public void setRecord_type(RecordType record_type) {
        this.record_type = record_type;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}