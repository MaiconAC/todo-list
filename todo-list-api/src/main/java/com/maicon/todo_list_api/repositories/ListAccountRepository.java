package com.maicon.todo_list_api.repositories;

import com.maicon.todo_list_api.dtos.ListListIdsAndTitlesRecordDTO;
import com.maicon.todo_list_api.models.ListAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListAccountRepository extends JpaRepository<ListAccountModel, Integer> {

    @Query(value = "SELECT l.id_list, l.list_title FROM list_account la INNER JOIN list l ON l.id_list = la.id_list WHERE la.id_account = ?1",
            nativeQuery = true)
    List<ListListIdsAndTitlesRecordDTO> listListIdsAndTitlesByAccountId(int idAccount);
}
