package edu.cnm.deepdive.mobilepunch.model.entities.abstraction;

import java.util.UUID;

public class UuidSetter {

  public static void setIdsFromUuid(UuidHaver haver) {
    if (haver != null) {
      haver.setId1(haver.getUuid().getMostSignificantBits());
      haver.setId2(haver.getUuid().getLeastSignificantBits());
    }
  }

  public static void setUuidFromIds(UuidHaver haver) {
    if (haver != null) {
      haver.setUuid(new UUID(haver.getId1(), haver.getId2()));
    }
  }

  public static void setNewRandomUuid(UuidHaver haver) {
    UUID uuid = UUID.randomUUID();
    haver.setUuid(uuid);
    setIdsFromUuid(haver);
  }


}
