package com.gametrader.gametraderpostservice.entity;

import com.gametrader.gametraderpostservice.model.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "title", nullable = false)
    private String title;

    //TODO:add images handling

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "localization", nullable = false)
    private String localization;

    @Column(name = "email_address", nullable = true)
    private String emailAddress;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;
}
