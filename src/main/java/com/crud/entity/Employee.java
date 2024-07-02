package com.crud.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name= "first_name")
    private String fistName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    //Contractors
    public Employee(){}
    public Employee(String fistName, String lastName, String email){
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
    }
    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFistName() {
        return fistName;
    }
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", fistName=" + fistName + ", lastName=" + lastName + ", email=" + email + "]";
    }


}
