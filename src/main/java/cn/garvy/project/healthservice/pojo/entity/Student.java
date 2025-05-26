package cn.garvy.project.healthservice.pojo.entity;

import lombok.Data;

@Data
public class Student extends User{
    private Integer studentId;
    private String college;
    private String major;
    private HealthStatus healthStatus;

    public enum HealthStatus { health, following, high_risk }

}