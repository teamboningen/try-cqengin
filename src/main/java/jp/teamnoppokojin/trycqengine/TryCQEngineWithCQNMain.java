package jp.teamnoppokojin.trycqengine;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.*;

import java.util.Arrays;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.codegen.MemberFilters;
import com.googlecode.cqengine.query.parser.cqn.CQNParser;
import com.googlecode.cqengine.resultset.ResultSet;

import jp.teamnoppokojin.trycqengine.model.Car;

/***
 * TryCQEngineWithCQN
 * @author teamnoppokojin
 */
public class TryCQEngineWithCQNMain {

	public static void main(String[] args) {

		// generate Attribute
		CQNParser<Car> parser = CQNParser.forPojoWithAttributes(Car.class, createAttributes(Car.class, MemberFilters.GETTER_METHODS_ONLY));

		// create car collection
		IndexedCollection<Car> cars = new ConcurrentIndexedCollection<>();
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
		ResultSet<Car> results = parser.retrieve(cars,
										"and("
											+ "equal(\"getName\",\"AAACar\"),"
											+ "equal(\"getDiscription\", \"brandNew\")"
										+ " )"
											 );

		for (Car car : results ) {
			System.out.println(car.toString());
		}

	}

}
