package com.apps.notes.repository;

import com.apps.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note,String> {

    @Query(value = "UPDATE NOTE " +
            "SET NOTE_TOPIC=:topic, NOTE_DATA =:noteData, " +
            "NOTE_MODIFIED_TIME=:time, NOTE_MODIFIED_BY=:changedBy " +
            "WHERE Id=:id",nativeQuery = true)
    Optional<String> updateNote(@Param("id")String id, @Param("noteData")String noteData,
                                @Param("topic")String topic, @Param("time")Date time, @Param("changedBy")String changedBy);
}
