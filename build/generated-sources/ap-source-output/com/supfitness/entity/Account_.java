package com.supfitness.entity;

import com.supfitness.entity.Race;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-18T00:29:23")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> firstName;
    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile CollectionAttribute<Account, Race> races;
    public static volatile SingularAttribute<Account, Integer> postalCode;
    public static volatile SingularAttribute<Account, Long> id;
    public static volatile SingularAttribute<Account, String> userName;
    public static volatile SingularAttribute<Account, String> email;

}