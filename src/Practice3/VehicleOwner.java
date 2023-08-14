package Practice3;

public class VehicleOwner {
    protected String cmndNumber;
    protected String fullName;
    protected String email;

    public VehicleOwner(String cmndNumber, String fullName, String email) {
        if (!isValidIdNumber(cmndNumber)) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.cmndNumber = cmndNumber;
        this.fullName = fullName;
        this.email = email;
    }

    private boolean isValidIdNumber(String cmndNumber) {
        return cmndNumber.matches("\\d{12}"); // Matches exactly 12 digits
    }

    private boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }

}
