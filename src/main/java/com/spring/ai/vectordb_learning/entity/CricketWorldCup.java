package com.spring.ai.vectordb_learning.entity;

import org.springframework.ai.vectorstore.HanaVectorEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table(name = "CRICKET_WORLD_CUP")
@Data
@Jacksonized
@NoArgsConstructor
public class CricketWorldCup extends HanaVectorEntity{
    @Column(name = "content")
    private String content;
}
