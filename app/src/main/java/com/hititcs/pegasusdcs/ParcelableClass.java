package com.hititcs.pegasusdcs;

import com.hititcs.pegasusdcs.domain.model.Arrival;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.domain.model.Departure;
import com.hititcs.pegasusdcs.domain.model.FlightSummary;
import com.hititcs.pegasusdcs.domain.model.Location;
import com.hititcs.pegasusdcs.domain.model.SegmentFigure;

import org.parceler.ParcelClass;
import org.parceler.ParcelClasses;

@ParcelClasses({
    @ParcelClass(DepartingFlight.class),
        @ParcelClass(Arrival.class),
        @ParcelClass(Departure.class),
        @ParcelClass(Location.class),
        @ParcelClass(SegmentFigure.class)
})
public class ParcelableClass {

  // empty. Domain model parcel generation
}
