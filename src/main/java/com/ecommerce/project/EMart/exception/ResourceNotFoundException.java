package com.ecommerce.project.EMart.exception;

public class ResourceNotFoundException extends RuntimeException{
    String fieldName;
    String field;
    String resourceName;
    Long fieldId;

    public ResourceNotFoundException( String fieldName, String field, String resourceName) {
        super(String.format("%s not found with %s : %s",resourceName,field,fieldName));
        this.fieldName = fieldName;
        this.field = field;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException(Long fieldId, String field, String resourceName) {
        super(String.format("%s  not found with %s : %s",resourceName,field,fieldId));
        this.fieldId = fieldId;
        this.field = field;
        this.fieldName = fieldName;
    }
}
