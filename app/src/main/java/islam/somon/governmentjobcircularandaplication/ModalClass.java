package islam.somon.governmentjobcircularandaplication;

public class ModalClass {

    String id, name, contact, service;

    public ModalClass() {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public ModalClass(String id, String name, String contact, String service) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.service = service;


    }
}



