package com.Nivantis.b3.nivantisapp.models;

        import org.bson.types.ObjectId;
        import org.springframework.data.annotation.Id;
        import org.springframework.data.mongodb.core.mapping.Document;
        import java.util.Objects;

@Document(collection = "medicament")
public class Medicaments {

    @Id
    public String id;



    private String name;
    private Number price;
    private String category;
    private Number quantity;

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

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicaments that = (Medicaments) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(category, that.category) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, quantity);
    }

    @Override
    public String toString() {
        return "Medicaments{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
