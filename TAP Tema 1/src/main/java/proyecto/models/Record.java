package proyecto.models;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;

public class Record implements java.io.Serializable {
    private String id_record;
    private int record_number;
    private String id_author;
    private StateNames state_name;
    private RecordType record_type;
    private String title;
    private String description;
    private String image;
    private String image_name;
    private int is_hidden;
    private int is_public;
    private User author;

    public Record() {
    }

    public Record(String id_record, int record_number, String id_author, StateNames state_name, RecordType record_type, String title, String description, String image, String image_name, int is_hidden, int is_public) {
        this.id_record = id_record;
        this.record_number = record_number;
        this.id_author = id_author;
        this.state_name = state_name;
        this.record_type = record_type;
        this.title = title;
        this.description = description;
        this.image = image;
        this.image_name = image_name;
        this.is_hidden = is_hidden;
        this.is_public = is_public;
    }

    public Record(String id_record, int record_number, String id_author, StateNames state_name, RecordType record_type, String title, String description, String image, String image_name, int is_hidden, int is_public, User author) {
        this.id_record = id_record;
        this.record_number = record_number;
        this.id_author = id_author;
        this.state_name = state_name;
        this.record_type = record_type;
        this.title = title;
        this.description = description;
        this.image = image;
        this.image_name = image_name;
        this.is_hidden = is_hidden;
        this.is_public = is_public;
        this.author = author;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int is_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(int is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int is_public() {
        return is_public;
    }

    public boolean Is_public(){
        return is_public==1;
    }

    public void setIs_public(int is_public) {
        this.is_public = is_public;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}