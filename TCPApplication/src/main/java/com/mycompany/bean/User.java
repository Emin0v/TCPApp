package com.mycompany.bean;

/**
 *
 * @author Eminov
 */
public class User {

    private String name;
    private String surname;
    private String fileAddress;
    private String ip;
    private Integer port;

    private static User user = null;

    private User() {
    }

    public static User instance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public User(String name, String surname, String fileAddress, String ip, Integer port) {
        this.name = name;
        this.surname = surname;
        this.fileAddress = fileAddress;
        this.ip = ip;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", fileAddress=" + fileAddress + ", ip=" + ip + ", port=" + port + '}';
    }

    
}
