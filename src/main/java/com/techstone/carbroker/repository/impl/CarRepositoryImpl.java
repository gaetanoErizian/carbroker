package com.techstone.carbroker.repository.impl;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import com.techstone.carbroker.repository.custom.CarRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Car> findByFilters(Age age, FuelType fuelType, PriceRange priceRange,
                                   boolean automaticTransmission, boolean fourByFour) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> car = query.from(Car.class);

        List<Predicate> predicates = new ArrayList<>();

        if(age != null) {
            predicates.add(cb.equal(car.get("age"), age));
        }
        if(fuelType != null) {
            predicates.add(cb.equal(car.get("fuelType"), fuelType));
        }
        if(priceRange != null) {
            predicates.add(cb.equal(car.get("priceRange"), priceRange));
        }
        if(automaticTransmission) {
            predicates.add(cb.isTrue(car.get("automaticTransmission")));
        }
        if(fourByFour) {
            predicates.add(cb.isTrue(car.get("fourByFour")));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query).getResultList();
    }
}