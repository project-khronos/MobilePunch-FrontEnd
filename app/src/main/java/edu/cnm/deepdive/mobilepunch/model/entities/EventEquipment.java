package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * The type Event equipment.
 */
@Entity(primaryKeys = {"eventId1", "eventId2"}, foreignKeys = {
    @ForeignKey(entity = EventEntity.class, parentColumns = {"event_id1",
        "event_id2"}, childColumns = {"eventId1", "eventId2"}),
    @ForeignKey(entity = EquipmentEntity.class, parentColumns = {"equipment_id1",
        "equipment_id2"}, childColumns = {"equipmentId1", "equipmentId2"})
}, indices = @Index(value = {"eventId1", "eventId2", "equipmentId1", "equipmentId2"}, unique = true)
)
public class EventEquipment {

  private long eventId1;
  private long eventId2;
  private long equipmentId1;
  private long equipmentId2;

  /**
   * Instantiates a new Event equipment.
   */
  public EventEquipment() {
  }

  /**
   * Instantiates a new Event equipment.
   *
   * @param event the event
   * @param equipment the equipment
   */
  public EventEquipment(EventEntity event, EquipmentEntity equipment) {
    eventId1 = event.getId1();
    eventId2 = event.getId2();
    equipmentId1 = equipment.getId1();
    equipmentId2 = equipment.getId2();
  }

  /**
   * Gets event id 1.
   *
   * @return the event id 1
   */
  public long getEventId1() {
    return eventId1;
  }

  /**
   * Sets event id 1.
   *
   * @param eventId1 the event id 1
   */
  public void setEventId1(long eventId1) {
    this.eventId1 = eventId1;
  }

  /**
   * Gets event id 2.
   *
   * @return the event id 2
   */
  public long getEventId2() {
    return eventId2;
  }

  /**
   * Sets event id 2.
   *
   * @param eventId2 the event id 2
   */
  public void setEventId2(long eventId2) {
    this.eventId2 = eventId2;
  }

  /**
   * Gets equipment id 1.
   *
   * @return the equipment id 1
   */
  public long getEquipmentId1() {
    return equipmentId1;
  }

  /**
   * Sets equipment id 1.
   *
   * @param equipmentId1 the equipment id 1
   */
  public void setEquipmentId1(long equipmentId1) {
    this.equipmentId1 = equipmentId1;
  }

  /**
   * Gets equipment id 2.
   *
   * @return the equipment id 2
   */
  public long getEquipmentId2() {
    return equipmentId2;
  }

  /**
   * Sets equipment id 2.
   *
   * @param equipmentId2 the equipment id 2
   */
  public void setEquipmentId2(long equipmentId2) {
    this.equipmentId2 = equipmentId2;
  }

}
