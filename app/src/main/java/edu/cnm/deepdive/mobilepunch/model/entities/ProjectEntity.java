package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(
    primaryKeys = {"project_id1","project_id2"}
)
public class ProjectEntity {

  @ColumnInfo(name = "project_id1")
  private long id1;
  @ColumnInfo(name = "project_id2")
  private long id2;
  @ColumnInfo(name = "start_date")
  private long startDate;
  @ColumnInfo(name = "end_date")
  private long endDate;

  public long getId1() {
    return id1;
  }

  public void setId1(long id1) {
    this.id1 = id1;
  }

  public long getId2() {
    return id2;
  }

  public void setId2(long id2) {
    this.id2 = id2;
  }

  public long getStartDate() {
    return startDate;
  }

  public void setStartDate(long startDate) {
    this.startDate = startDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }
}
