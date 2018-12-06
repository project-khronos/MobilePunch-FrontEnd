package edu.cnm.deepdive.mobilepunch.model.entities.abstraction;

import java.util.UUID;

public class UuidSetter {

    public static void setIdsFromUuid(UuidHaver haver) {
        haver.setId1(haver.getUuid().getLeastSignificantBits());
        haver.setId2(haver.getUuid().getMostSignificantBits());
    }

    public static void setUuidFromIds(UuidHaver haver) {
        haver.setUuid(new UUID(haver.getId1(), haver.getId2()));
    }


}
