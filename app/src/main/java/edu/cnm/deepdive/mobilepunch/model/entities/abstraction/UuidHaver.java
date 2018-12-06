package edu.cnm.deepdive.mobilepunch.model.entities.abstraction;

import java.util.UUID;

public interface UuidHaver {
    long getId1();

    void setId1(long id1);

    long getId2();

    void setId2(long id2);

    UUID getUuid();

    void setUuid(UUID uuid);

}
