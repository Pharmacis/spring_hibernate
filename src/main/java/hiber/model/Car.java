package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int series;



    @OneToOne(mappedBy = "car")
   // @JoinColumn (name = "fk",referencedColumnName = "user_id")
    private User user;

    public Car(){}

    public Car (String name, int series){
        this.name = name;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
