package com.example.projeto_final.model;
import com.example.projeto_final.controller.PersonController;
import com.example.projeto_final.controller.interfaces.audit;
import com.example.projeto_final.model.ennumeration.*;

import java.time.LocalDateTime;
import java.util.Date;

public class Employee extends Person implements audit {
    private String RG;
    private MaritialStatus maritialStatus;
    private EducationLevel educationLevel;

    private Job job;
    private String workCardNumber;
    private Date hireDate;
    private Date fireDate;
    private boolean availability;
    private String createdBy;
    private LocalDateTime createdIn;
    private String updatedBy;
    private LocalDateTime updatedIn;


    public Employee(String name, String phone, LocalDateTime birth, String CPF, String address, String RG, MaritialStatus maritialStatus, EducationLevel educationLevel, Job job, int workCardNumber, Date hireDate, Date fireDate, boolean availability, boolean isActive) {
        super(name, phone, birth, CPF, address,isActive);
        this.RG = RG;
        this.maritialStatus = maritialStatus;
        this.educationLevel = educationLevel;
        this.job = job;
        this.workCardNumber = String.valueOf(workCardNumber);
        this.hireDate = hireDate;
        this.fireDate = fireDate;
        this.availability = availability;
        createdBy();
        createdIn();
    }
    public Employee(String name, String phone, LocalDateTime birth, String CPF, String address, String RG, MaritialStatus maritialStatus, EducationLevel educationLevel, Job job, int workCardNumber, Date hireDate, boolean availability, boolean isActive) throws Exception {
        super(name, phone, birth, CPF, address,isActive);
        this.RG = RG;
        this.maritialStatus = maritialStatus;
        this.educationLevel = educationLevel;
        this.job = job;
        this.workCardNumber = String.valueOf(workCardNumber);
        this.hireDate = hireDate;
        this.fireDate = null;
        this.availability = availability;
        createdBy();
        createdIn();
        System.out.println(PersonController.getInstance().getAll());
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
        audit();
    }

    public MaritialStatus getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(MaritialStatus maritialStatus) {
        this.maritialStatus = maritialStatus;
        audit();
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
        audit();
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        audit();
    }

    public String getWorkCardNumber() {
        return workCardNumber;
    }

    public void setWorkCardNumber(String workCardNumber) {
        this.workCardNumber = workCardNumber;
        audit();
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
        audit();
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
        audit();
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
        audit();
    }

    @Override
    public void createdIn() {
        this.createdIn = LocalDateTime.now();
    }

    @Override
    public void createdBy() {
        this.createdBy = "Admin";
    }

    @Override
    public void updatedIn() {
        this.updatedIn = LocalDateTime.now();
    }

    @Override
    public void updatedBy() {
        this.updatedBy = "Admin";
    }

    private void audit(){
        updatedBy();
        updatedIn();
    }

}
