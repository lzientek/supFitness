package com.supfitness.entity;

import com.supfitness.entity.Race;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-18T00:29:23")
@StaticMetamodel(Track.class)
public class Track_ { 

    public static volatile SingularAttribute<Track, Race> race;
    public static volatile SingularAttribute<Track, Float> latitude;
    public static volatile SingularAttribute<Track, Long> id;
    public static volatile SingularAttribute<Track, Date> creationDate;
    public static volatile SingularAttribute<Track, Float> speed;
    public static volatile SingularAttribute<Track, Float> longitude;

}