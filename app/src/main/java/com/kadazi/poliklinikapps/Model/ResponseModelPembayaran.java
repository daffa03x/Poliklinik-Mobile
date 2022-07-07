package com.kadazi.poliklinikapps.Model;

import java.util.List;

public class ResponseModelPembayaran {
    private boolean success;
    private String message;
    private List<DataModelPembayaran> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataModelPembayaran> getData() {
        return data;
    }

    public void setData(List<DataModelPembayaran> data) {
        this.data = data;
    }
}
