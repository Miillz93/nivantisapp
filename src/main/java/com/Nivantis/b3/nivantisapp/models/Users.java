package com.Nivantis.b3.nivantisapp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Users {

    @Id
  public ObjectId _id;

    public String name;
    public String lastname;
    public String Address;
    public Number Zip;


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public Number getZip() {
        return Zip;
    }

    public void setZip(Number zip) { this.Zip = zip; }


    @Override
    public String toString() {
        return "Users{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", Address='" + Address + '\'' +
                ", Zip=" + Zip +
                '}';
    }
}
