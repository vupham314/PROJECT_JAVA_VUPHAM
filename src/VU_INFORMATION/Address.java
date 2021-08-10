package VU_INFORMATION;

public class Address {

    private String city;
    private String district;
    private String ward;
    private String detailedAddress;

    public Address() {
    }

    public Address(String city, String district, String ward, String detailedAddress) {
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.detailedAddress = detailedAddress;
    }

    @Override
    public String toString() {
        return "Address{" +"\n" +
                "     city='" + city + '\'' + "\n" +
                "     district='" + district + '\'' + "\n" +
                ",    ward='" + ward + '\'' +"\n" +
                "     detailedAddress='" + detailedAddress + '\'' +"\n" +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

}

