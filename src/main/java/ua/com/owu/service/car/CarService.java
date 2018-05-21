package ua.com.owu.service.car;

import ua.com.owu.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> findAll();

    Car findOne(int id);

}
