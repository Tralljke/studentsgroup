package com.petrbel.studentsgroup.domain;
import javax.persistence.*;

@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue
    private int id;
    private String groupNumber;
    private long quantity;

    public StudentsGroup()
    {

    }

    public StudentsGroup(String groupNumber, long quantity) {
        this.groupNumber = groupNumber;
        this.quantity = quantity;
    }

    public String getGroupNumber(){
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber){
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void addQuantity()
    {
        this.quantity = this.quantity + 1;
    }

    public void deductQuantity()
    {
        this.quantity = this.quantity - 1;
    }
}
