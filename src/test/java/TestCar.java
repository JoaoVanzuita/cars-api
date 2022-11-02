import java.util.List;

import com.joaovanzuita.domain.Car;
import com.joaovanzuita.domain.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCar {
	private CarService carService;

	public TestCar() {
	}

	@Before
	public void setUp() throws Exception {
		carService = (CarService) SpringUtil.getInstance().getBeans(CarService.class);
	}

	@Test
	public void testGet() {

		List<Car> cars = carService.getCars();

		Assert.assertNotNull(cars);

		Assert.assertTrue(cars.size() > 0);

		Car tucker = carService.findByName("Tucker 1948").get(0);

		Assert.assertEquals("Tucker 1948", tucker.getName());
	}

	@Test
	public void testSaveDelete() {
		Car car = new Car();

		car.setName("name");
		car.setDescription("description");
		car.setUrlImage("url_image");
		car.setUrlVideo("url_video");
		car.setLatitude("latitude");
		car.setLongitude("longitude");
		car.setType("type");
		carService.saveCar(car);
		Long id = car.getIdCar();

		Assert.assertNotNull(id);

		car = carService.getCar(id);
		Assert.assertEquals("name", car.getName());
		Assert.assertEquals("description", car.getDescription());
		Assert.assertEquals("url_image", car.getUrlImage());
		Assert.assertEquals("url_video", car.getUrlVideo());
		Assert.assertEquals("latitude", car.getLatitude());
		Assert.assertEquals("longitude", car.getLongitude());
		Assert.assertEquals("type", car.getType());

		car.setName("test Update");
		carService.saveCar(car);

		car = carService.getCar(id);
		Assert.assertEquals("test Update", car.getName());

		carService.deleteCar(id);

		car = carService.getCar(id);

		Assert.assertNull(car);
	}
}
