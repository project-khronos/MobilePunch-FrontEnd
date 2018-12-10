package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidHaver;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The type Project entity.
 */
@Entity(
        primaryKeys = {"project_id1", "project_id2"},
        foreignKeys = @ForeignKey(entity = ClientEntity.class,
                parentColumns = {"client_id1", "client_id2"},
                childColumns = {"client_id1", "client_id2"})
)
public class ProjectEntity implements UuidHaver {

    @Ignore
    @Expose
    private UUID uuid;

    @ColumnInfo(name = "project_id1")
    private long id1;

    @ColumnInfo(name = "project_id2")
    private long id2;

    @ColumnInfo(name = "client_id1")
    private long clientId1;
    @ColumnInfo(name = "client_id2")
    private long clientId2;
    @Ignore
    @Expose
    private ClientEntity client;
    @Expose
    private String name;
    @Expose
    @ColumnInfo(name = "start_time")
    private Date startTime;
    @Expose
    @ColumnInfo(name = "end_time")
    private Date endTime;
    @Expose
    @ColumnInfo(name = "expected_end_time")
    private Date expectedEndTime;
    @Expose
    private String description;
    @Ignore
    @Expose
    private List<EventEntity> events;

    public long getClientId1() {
        return clientId1;
    }

    public void setClientId1(long clientId1) {
        this.clientId1 = clientId1;
    }

    public long getClientId2() {
        return clientId2;
    }

    public void setClientId2(long clientId2) {
        this.clientId2 = clientId2;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets id 1.
     *
     * @return the id 1
     */
    public long getId1() {
        return id1;
    }

    /**
     * Sets id 1.
     *
     * @param id1 the id 1
     */
    public void setId1(long id1) {
        this.id1 = id1;
    }

    /**
     * Gets id 2.
     *
     * @return the id 2
     */
    public long getId2() {
        return id2;
    }

    /**
     * Sets id 2.
     *
     * @param id2 the id 2
     */
    public void setId2(long id2) {
        this.id2 = id2;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets expected end time.
     *
     * @return the expected end time
     */
    public Date getExpectedEndTime() {
        return expectedEndTime;
    }

    /**
     * Sets expected end time.
     *
     * @param expectedEndTime the expected end time
     */
    public void setExpectedEndTime(Date expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<EventEntity> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClient(ClientEntity clients) {
        this.client = clients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", expectedEndTime=" + expectedEndTime +
                ", description='" + description + '\'' +
                ", events=" + events +
                ", clients=" + client +
                '}';
    }
}
