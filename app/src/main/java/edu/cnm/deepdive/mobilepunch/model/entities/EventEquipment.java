package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = EventEntity.class, parentColumns = {"event_id1", "event_id2"}, childColumns = {"eventId1", "eventId2"}),
        @ForeignKey(entity = EquipmentEntity.class, parentColumns = {"equipment_id1", "equipment_id2"}, childColumns = {"equipmentId1", "equipmentId2"})
}
)
public class EventEquipment {
    @PrimaryKey
    private long id;
    private long eventId1;
    private long eventId2;
    private long equipmentId1;
    private long equipmentId2;

    public EventEquipment() {
    }

    public EventEquipment(EventEntity event, EquipmentEntity equipment) {
        eventId1 = event.getId1();
        eventId2 = event.getId2();
        equipmentId1 = equipment.getId1();
        equipmentId2 = equipment.getId2();
    }

    public long getEventId1() {
        return eventId1;
    }

    public void setEventId1(long eventId1) {
        this.eventId1 = eventId1;
    }

    public long getEventId2() {
        return eventId2;
    }

    public void setEventId2(long eventId2) {
        this.eventId2 = eventId2;
    }

    public long getEquipmentId1() {
        return equipmentId1;
    }

    public void setEquipmentId1(long equipmentId1) {
        this.equipmentId1 = equipmentId1;
    }

    public long getEquipmentId2() {
        return equipmentId2;
    }

    public void setEquipmentId2(long equipmentId2) {
        this.equipmentId2 = equipmentId2;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
