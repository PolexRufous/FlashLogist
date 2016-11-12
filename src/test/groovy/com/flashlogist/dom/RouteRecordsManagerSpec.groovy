package com.flashlogist.dom

import com.flashlogist.rout.dao.repository.RoutRecordsRepository
import com.flashlogist.rout.dao.RoutRecord
import com.flashlogist.rout.domain.RouteRecordsManager
import com.flashlogist.vehicle.dao.Vehicle
import spock.lang.Specification

import java.time.LocalDate


class RouteRecordsManagerSpec extends Specification {
    private RouteRecordsManager manger
    private RoutRecordsRepository repository
    private Vehicle vehicle

    void setup() {
        repository = Mock(RoutRecordsRepository)
        manger = new RouteRecordsManager(repository)
        vehicle = new Vehicle()
    }

    def "should return empty collection of a blank vehicle"() {
        expect:
        Collections.emptyList() == manger.getRecordsByVehicle(vehicle, LocalDate.now(), LocalDate.now())
    }

    def "should return single record from repository for a vehicle"() {
        given:
        def expectedRecords = [new RoutRecord()]


        when:
        def actualRecords = manger.getRecordsByVehicle(this.vehicle, LocalDate.now(), LocalDate.now())

        then:
        1*repository.getRecordsByVehicle(vehicle, _, _) >> expectedRecords
        actualRecords == expectedRecords
    }

    def "should return records from repository of given period"() {
        given:
        RoutRecord record1 = new RoutRecord()
        record1.startingDate = LocalDate.of(2016, 5, 10)
        record1.endingDate = LocalDate.of(2016, 10, 10)

        RoutRecord record2 = new RoutRecord()
        record2.startingDate = LocalDate.of(2016, 6, 12)
        record2.endingDate = LocalDate.of(2016, 7, 10)

        RoutRecord record3 = new RoutRecord()
        record3.startingDate = LocalDate.of(2016, 9, 12)
        record3.endingDate = LocalDate.of(2016, 10, 10)

        def expectedRecords = [record1, record2]

        when:
        def actualRecords = manger.getRecordsByVehicle(vehicle, LocalDate.of(2016,1,1),  LocalDate.of(2016,9,1))

        then:
        1*repository.getRecordsByVehicle(vehicle, _, _) >> expectedRecords
        expectedRecords == actualRecords
    }
}
