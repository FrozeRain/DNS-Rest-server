package net.frozerain.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DNSModel {
    private String domen;
    private String address;
    private int id;

    public void setDomen(String domen) {
        this.domen = domen;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomen() {
        return domen;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
