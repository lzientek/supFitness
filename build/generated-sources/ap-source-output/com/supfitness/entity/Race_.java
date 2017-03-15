package com.supfitness.entity;

import com.supfitness.entity.Account;
import com.supfitness.entity.Track;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-18T00:29:23")
@StaticMetamodel(Race.class)
public class Race_ { 

    public static volatile SingularAttribute<Race, Long> id;
    public static volatile SingularAttribute<Race, Date> creationDate;
    public static volatile SingularAttribute<Race, Account> user;
    public static volatile ListAttribute<Race, Track> tracks;

}