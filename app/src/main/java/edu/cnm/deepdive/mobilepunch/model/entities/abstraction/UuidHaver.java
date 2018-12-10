package edu.cnm.deepdive.mobilepunch.model.entities.abstraction;

import java.util.UUID;

/**
 * The interface Uuid haver.
 */
public interface UuidHaver {

  /**
   * Gets id 1.
   *
   * @return the id 1
   */
  long getId1();

  /**
   * Sets id 1.
   *
   * @param id1 the id 1
   */
  void setId1(long id1);

  /**
   * Gets id 2.
   *
   * @return the id 2
   */
  long getId2();

  /**
   * Sets id 2.
   *
   * @param id2 the id 2
   */
  void setId2(long id2);

  /**
   * Gets uuid.
   *
   * @return the uuid
   */
  UUID getUuid();

  /**
   * Sets uuid.
   *
   * @param uuid the uuid
   */
  void setUuid(UUID uuid);

}
