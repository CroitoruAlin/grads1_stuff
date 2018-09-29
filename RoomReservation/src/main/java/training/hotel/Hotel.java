package training.hotel;

import training.address.Address;
import training.building.Room;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stars;
    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms;
    @Transient
    private Long addressId;

    public Hotel(Long id,String name, int stars,Long addressId) {
        this.id=id;
        this.name = name;
        this.stars = stars;
        this.addressId=addressId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Hotel(Long id, String name, int stars, Address address) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.address = address;
    }

    public Hotel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars &&
                address.equals(hotel.address)  &&
                Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stars, address);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", addressId=" + address +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
