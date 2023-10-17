package com.Proj.blogApp.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    String resoutceName;
    String fieldName;

    public String getResoutceName() {
        return resoutceName;
    }

    public void setResoutceName(String resoutceName) {
        this.resoutceName = resoutceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }

    long fieldValue;

    public ResourceNotFoundException(String resoutceName, String fieldName, long fieldValue) {
        super(String.format("%s is not found with %s : %s" ,resoutceName,fieldName,fieldValue));
        this.resoutceName = resoutceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
