package sms.model;

public class Register {
    private String RegisterCode;
    private boolean success;

    public void setRegisterCode(String registerCode) {
        RegisterCode = registerCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRegisterCode() {
        return RegisterCode;
    }

    public boolean isSuccess() {
        return success;
    }
}
