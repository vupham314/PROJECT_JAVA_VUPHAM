package VU_INFORMATION;

public class Information {
    private Profile profile;
    private Address address;

    public Information(Profile profile, Address address) {
        this.profile = profile;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Information{" + "\n" +
                "     profile=" + profile +"\n" +
                "     address=" + address +"\n" +
                '}';
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
