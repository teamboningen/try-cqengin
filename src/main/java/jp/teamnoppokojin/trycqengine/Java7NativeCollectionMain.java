package jp.teamnoppokojin.trycqengine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jp.teamnoppokojin.trycqengine.model.Car;

/***
 * Java7 native
 * @author teamnoppokojin
 */
public class Java7NativeCollectionMain {

	public static void main(String[] args) {

		// create car collection
		Set<Car> cars = new HashSet<>();
		cars.add( Car.builder().carId(0).name("AAACar").discription("brandNew").features( Arrays.asList("spare tyre", "sunroof")).build() );
		cars.add( Car.builder().carId(1).name("BBBCar").discription("used").features( Arrays.asList("spare tyre", "radio")).build() );
		cars.add( Car.builder().carId(2).name("CCCCar").discription("used").features( Arrays.asList("radio", "sunroof")).build() );
		cars.add( Car.builder().carId(3).name("DDDCar").discription("brandNew").features( Arrays.asList("spare tyre", "sunroof")).build() );
		cars.add( Car.builder().carId(4).name("AAACar").discription("used").features( Arrays.asList("radio", "sunroof")).build() );
		cars.add( Car.builder().carId(5).name("BBBCar").discription("brandNew").features( Arrays.asList("spare tyre", "radio")).build() );
		cars.add( Car.builder().carId(6).name("CCCCar").discription("brandNew").features( Arrays.asList("spare tyre", "sunroof")).build() );
		cars.add( Car.builder().carId(7).name("DDDCar").discription("used").features( Arrays.asList("radio", "sunroof")).build() );
		cars.add( Car.builder().carId(8).name("AAACar").discription("used").features( Arrays.asList("spare tyre", "sunroof")).build() );
		cars.add( Car.builder().carId(9).name("BBBCar").discription("used").features( Arrays.asList("spare tyre", "radio")).build() );
		cars.add( Car.builder().carId(10).name("CCCCar").discription("brandNew").features( Arrays.asList("spare tyre", "sunroof")).build() );

		// search brand-new AAACar
		Set<Car> results = new HashSet<>();
		for (Car car : cars) {
			if ( Objects.equals(car.getName(), "AAACar")
					&& Objects.equals(car.getDiscription(), "brandNew") ) {
				results.add(car);
			}
		}

		for (Car car : results ) {
			System.out.println(car.toString());
		}


		//if using Java8 Stream API
		/*
 			Set<Car> results =  cars.stream()
								.filter(car -> Objects.equals(car.getName(), "AAACar")
										&& Objects.equals(car.getDiscription(), "brandNew") )
								.collect(Collectors.toSet());

			for (Car car : results ) {
				System.out.println(car.toString());
			}
		 */

	}

}
