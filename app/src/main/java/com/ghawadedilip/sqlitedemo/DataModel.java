package com.ghawadedilip.sqlitedemo;

/**
 * Created by Dilip on 03-Dec-17.
 */

public class DataModel {
  String name;
  String email;
  String mobno;
  String password;
  String city;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobno() {
    return mobno;
  }

  public void setMobno(String mobno) {
    this.mobno = mobno;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  String address;
}
