package com.heshanthenura.crudapi.database;

import com.heshanthenura.crudapi.validation.ValidateAge;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "people")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fname")
    @NotBlank(message = "First name is required")
    private String fname;

    @Column(name = "lname")
    @NotBlank(message = "Last name is required")
    private String lname;

    @Column(name = "age")
    @Digits(integer = 2, fraction = 0, message = "Age must be a number")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 40, message = "Age must be below 40")
    @ValidateAge
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                '}';
    }
}
