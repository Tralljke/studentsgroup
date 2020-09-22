package com.testwebapp.studentsgroup.domain;
import com.sun.istack.NotNull;
import com.testwebapp.studentsgroup.domain.Person;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class StudentsGroup {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String groupnumber;
    @NotNull
    private long quantity;


    public StudentsGroup()
    {

    }


    public StudentsGroup(String groupnumber, long quantity) {
        this.groupnumber = groupnumber;
        this.quantity = quantity;
    }
    public String getGroupnumber(){
        return groupnumber;
    }
    public void setGroupnumber(String groupnumber){
        this.groupnumber = groupnumber;
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

}
