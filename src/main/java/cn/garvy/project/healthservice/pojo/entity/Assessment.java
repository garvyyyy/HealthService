package cn.garvy.project.healthservice.pojo.entity;

import lombok.Data;

@Data
public class Assessment {
    private Integer assessmentId;
    private Integer studentId;
    private Integer rating;

}
