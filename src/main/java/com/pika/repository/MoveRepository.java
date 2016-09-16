package com.pika.repository;

import com.pika.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LU355846 on 9/16/2016.
 */

@Repository
public interface MoveRepository extends JpaRepository<Move,Integer> {
}
