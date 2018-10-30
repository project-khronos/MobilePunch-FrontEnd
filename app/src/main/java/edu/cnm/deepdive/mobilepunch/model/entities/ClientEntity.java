package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ClientEntity {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "client_id")
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
