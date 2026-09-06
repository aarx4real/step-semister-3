package week5.practice_problems;

public class P4_MovieBookingProfileJavaBean {
    public static void main(String[] args) {
        MovieBookingProfile profile = new MovieBookingProfile("Rahul Dev");
        profile.setConfirmed(true);
        profile.setOtp("4471");
        System.out.println(profile.getName());
        System.out.println(profile.isConfirmed());
    }
}

class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otpHash;

    public MovieBookingProfile() {
        this.name = "";
        this.confirmed = false;
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp.length() >= 4 && otp.length() <= 6) {
            boolean numeric = true;
            for (int i = 0; i < otp.length(); i++) {
                if (!Character.isDigit(otp.charAt(i))) {
                    numeric = false;
                }
            }
            if (numeric) {
                otpHash = Integer.toHexString(otp.hashCode());
            }
        }
    }
}
