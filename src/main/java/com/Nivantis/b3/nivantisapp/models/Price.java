package com.Nivantis.b3.nivantisapp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document(collection = "medicament")
public class Price {

    @Id
    public ObjectId _id;
    protected double price ;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.getPrice(), getPrice()) == 0 &&
                Objects.equals(get_id(), price1.get_id()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getPrice() );
    }

    @Override
    public String toString() {
        return "Price{" +
                "_id=" + _id +
                ", price=" + price + '\'' +
                '}';
    }
}
