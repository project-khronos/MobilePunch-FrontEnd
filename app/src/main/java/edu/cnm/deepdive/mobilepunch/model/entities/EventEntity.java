package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(
    primaryKeys = {"event_id1","event_id2"}
)
public class EventEntity {
@NonNull
@ColumnInfo(name = "event_id1")
private long id2;

@NonNull
@ColumnInfo(name = "event_id2")
private long id1;




  public long getId2() {
    return id2;
  }

  public void setId2(long id2) {
    this.id2 = id2;
  }

  public long getId1() {
    return id1;
  }

  public void setId1(long id1) {
    this.id1 = id1;
  }
}
