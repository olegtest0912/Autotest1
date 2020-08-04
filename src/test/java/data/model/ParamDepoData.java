package data.model;

import com.google.gson.annotations.SerializedName;

public class ParamDepoData {

    public static class Credencials {
        private String email;
        private String password;

        public Credencials() {
        }

        public Credencials(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private String country;
    private Credencials credencials;

    @SerializedName("payment_system")
    private String paymentSystem;

    private String amount;
    private String url;


    public ParamDepoData(String country, Credencials credencials, String paymentSystem, String amount, String url) {
        this.country = country;
        this.credencials = credencials;
        this.paymentSystem = paymentSystem;
        this.amount = amount;
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Credencials getCredencials() {
        return credencials;
    }

    public void setCredencials(Credencials credencials) {
        this.credencials = credencials;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

