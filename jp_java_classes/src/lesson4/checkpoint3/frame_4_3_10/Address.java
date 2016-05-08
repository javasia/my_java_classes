package lesson4.checkpoint3.frame_4_3_10;

public class Address {

	public String city;
	public String street;
	public int house;

	public Address(String city, String street, int house) {

		if (city == null || street == null || house <= 0) {
			throw new IllegalStateException();
		}

		this.city = city;
		this.street = street;
		this.house = house;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Address) {
			Address address = (Address) obj;
			if (city.equals(address.city) && street.equals(address.street) && house == address.house) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int res = 25;

		Object[] fields = new Object[3];

		fields[0] = city;
		fields[1] = street;
		fields[2] = new Integer(house);

		for (Object o : fields) {
			if (o != null) {
				res = 37 * res + o.hashCode();
			}
		}

		return res;

	}

	@Override
	public String toString() {
		return city + ", " + street + ", " + house;
	}

}
