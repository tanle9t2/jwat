package com.jwat.jwat_assgiment.jwat_assgiment.utils;

public enum Message {
    CREATE_SUCCESS("Successfully created %s"),
    CREATE_ERROR("Failed to create %s"),
    UPDATE_SUCCESS("Successfully updated %s"),
    UPDATE_ERROR("Failed to update %s"),
    DELETE_SUCCESS("Successfully deleted %s"),
    DELETE_ERROR("Failed to delete %s"),
    NOT_FOUND("Not found %s");

    private final String template;

    Message(String template) {
        this.template = template;
    }

    public String format(String entityName) {
        return String.format(template, entityName);
    }
}
